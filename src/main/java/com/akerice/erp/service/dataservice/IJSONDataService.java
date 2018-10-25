package com.akerice.erp.service.dataservice;

import java.io.Serializable;
import java.util.List;

import com.akerice.erp.service.exception.BusinessServiceException;

public interface IJSONDataService<M extends Serializable> {
	
	public List<M> getAll() throws BusinessServiceException;
	public void push(M m) throws BusinessServiceException;
	public M getByKey(String key) throws BusinessServiceException;
	
}
