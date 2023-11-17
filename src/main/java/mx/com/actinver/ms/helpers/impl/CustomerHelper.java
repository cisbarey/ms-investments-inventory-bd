package mx.com.actinver.ms.helpers.impl;

import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerInsertClientRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerBean;
import mx.com.actinver.ms.beans.customers.CustomerCreateRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;
import mx.com.actinver.ms.helpers.ICustomerHelper;

@Component
public class CustomerHelper implements ICustomerHelper {

	@Override
	public CustomerInsertClientRequestBean toCreateRequest(CustomerCreateRequestBean requestBean) {
		CustomerInsertClientRequestBean clientBean = new CustomerInsertClientRequestBean();
		clientBean.setCustomerId(requestBean.getCustomerId());
		clientBean.setVideoPreference(requestBean.getVideoPreference());
		return clientBean;
	}

	@Override
	public CustomerResponseBean toResponse(CustomerClientBean responseClientBean) {
		CustomerResponseBean bean = new CustomerResponseBean();
		CustomerBean customer = new CustomerBean();
		
		customer.setCustomerId(responseClientBean.getId());
		customer.setVideoPreference(responseClientBean.getVideoPreference());
		bean.setCusrtomer(customer);
		return bean;
	}

	@Override
	public CustomerGetClientRequestBean toGetRequest(CustomerGetRequestBean requestBean) {
		CustomerGetClientRequestBean clientBean = new CustomerGetClientRequestBean();
		clientBean.setCustomerId(requestBean.getCustomerId());
		return clientBean;
	}

}
