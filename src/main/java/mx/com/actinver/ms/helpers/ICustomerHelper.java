package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerInsertClientRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerCreateRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;

public interface ICustomerHelper {

	CustomerInsertClientRequestBean toCreateRequest(CustomerCreateRequestBean requestBean);

	CustomerResponseBean toResponse(CustomerClientBean responseClientBean);
    
	CustomerGetClientRequestBean toGetRequest(CustomerGetRequestBean requestBean);
	
	
    
    

}
