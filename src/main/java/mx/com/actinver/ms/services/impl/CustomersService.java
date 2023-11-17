package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerInsertClientRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerCreateRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;
import mx.com.actinver.ms.clients.ICustomerClient;
import mx.com.actinver.ms.helpers.ICustomerHelper;
import mx.com.actinver.ms.services.ICustomersService;

@Component
public class CustomersService implements ICustomersService {

	@Autowired 
	private ICustomerClient customerClient;
	
	@Autowired 
	private ICustomerHelper customerHelper;
	
	@Override
	public CustomerResponseBean insert(CustomerCreateRequestBean requestBean, Map<String, String> headers) {
		CustomerInsertClientRequestBean customerBean = customerHelper.toCreateRequest(requestBean);
		CustomerClientBean responseClient = customerClient.insertCustomer(customerBean, headers);
		return customerHelper.toResponse(responseClient);
	}

	@Override
	public CustomerResponseBean get(CustomerGetRequestBean requestBean, Map<String, String> headers) {
		CustomerGetClientRequestBean customerBean = customerHelper.toGetRequest(requestBean);
		CustomerClientBean responseClient = customerClient.getCustomer(customerBean, headers);
		return customerHelper.toResponse(responseClient);
	}

}
