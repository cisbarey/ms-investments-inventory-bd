package mx.com.actinver.ms.clients;

import java.util.List;
import java.util.Map;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.client.customer.CustomerFindClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerInsertClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerUpdateClientRequestBean;

public interface ICustomerClient {

	CustomerClientBean insertCustomer(CustomerInsertClientRequestBean customerBean, Map<String,String> headers);
	
	List<CustomerClientBean> findCustomer(CustomerFindClientRequestBean customerBean, Map<String,String> headers);
	
	CustomerClientBean getCustomer(CustomerGetClientRequestBean customerBean, Map<String,String> headers);
	
	CustomerClientBean updateCustomer(CustomerUpdateClientRequestBean customerBean, Map<String,String> headers);

}

