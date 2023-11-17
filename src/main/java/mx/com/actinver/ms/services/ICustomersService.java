package mx.com.actinver.ms.services;

import java.util.Map;

import mx.com.actinver.ms.beans.customers.CustomerCreateRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;

public interface ICustomersService {

	CustomerResponseBean insert(CustomerCreateRequestBean requestBean,Map<String,String> headers);
	
	CustomerResponseBean get(CustomerGetRequestBean requestBean,Map<String,String> headers);

}

