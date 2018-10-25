package com.akerice.erp.service.dataservice.impl;

import java.io.Serializable;
import java.util.List;

import com.akerice.erp.service.exception.BusinessServiceException;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;



public abstract class DataServiceImpl<T extends Serializable> 
{
	protected abstract Class<T> getDataClass();
	
	protected String endpoint;
	
	protected String charset = "UTF-8";
	
	protected Database database;
	
	protected abstract String getDBName();
	
	public DataServiceImpl(String endpoint) {
		super();
		this.endpoint = endpoint;
		
		if (null != endpoint) {
			CloudantClient client = ClientBuilder.account(endpoint).build();
			database = client.database(getDBName(), false);
			
		}
	
	}

	public List<T> getAll() throws BusinessServiceException {	
		try {
			return database.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(getDataClass());
		} catch (Exception e) {
			throw new BusinessServiceException(e, "I1000");
		}
	}
	
	public void push(T t) throws BusinessServiceException {
		try {
			database.save(t);
		} catch (Exception e) {
			throw new BusinessServiceException(e, "I1002");
		}
	}
	
	public T getByKey(String key)  throws BusinessServiceException {	
		try {
			return database.find(getDataClass(), key);
		} catch (Exception e) {
			throw new BusinessServiceException(e, "I1001");
		}
	}
	
}
