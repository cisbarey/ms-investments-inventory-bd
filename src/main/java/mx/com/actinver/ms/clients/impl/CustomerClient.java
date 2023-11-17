package mx.com.actinver.ms.clients.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ICustomerRepository;
import mx.com.actinver.ms.beans.client.customer.CustomerFindClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerInsertClientRequestBean;
import mx.com.actinver.ms.beans.client.customer.CustomerUpdateClientRequestBean;
import mx.com.actinver.ms.clients.ICustomerClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
public class CustomerClient extends HttpHeadersConfig implements ICustomerClient {

	
	@Autowired
    private ICustomerRepository customerRepository;

	@Override
	public CustomerClientBean insertCustomer(CustomerInsertClientRequestBean customerBean, Map<String,String> headers) {
		try {
			CustomerClientBean newCustomer = new CustomerClientBean();
			newCustomer.setId(customerBean.getCustomerId());
			newCustomer.setVideoPreference(customerBean.getVideoPreference());
			newCustomer = customerRepository.save(newCustomer);
			return newCustomer;
		}catch(Exception ex) {
			throw new SuperMarketFundBusinessRuleException(
					ex.getMessage(),
					ErrorExceptions.PRECONDITION_FAILED);
		}
	}

	@Override
	public List<CustomerClientBean> findCustomer(CustomerFindClientRequestBean customerBean,
			Map<String, String> headers) {
		try {
			List<CustomerClientBean> customers = customerRepository.findAllById(customerBean.getCustomerIds());
			if(customers.isEmpty())
				throw new SuperMarketFundNotFoundException(
						"Not found.",
						ErrorExceptions.NOT_FOUND);
			return customers;
		}catch(Exception ex) {
			throw new SuperMarketFundBusinessRuleException(
					ex.getMessage(),
					ErrorExceptions.PRECONDITION_FAILED);
		}
		
	}

	@Override
	public CustomerClientBean getCustomer(CustomerGetClientRequestBean customerBean, Map<String, String> headers) {
		Optional<CustomerClientBean> customerOp = customerRepository.findById(customerBean.getCustomerId());
		if(customerOp.isPresent())
			return customerOp.get(); 
		else {
			throw new SuperMarketFundNotFoundException(
					"Not found.",
					ErrorExceptions.NOT_FOUND);
		}
	}

	@Override
	public CustomerClientBean updateCustomer(CustomerUpdateClientRequestBean customerBean,
			Map<String, String> headers) {
		Optional<CustomerClientBean> customerOp = customerRepository.findById(customerBean.getCustomerId());
		
		if(!customerOp.isPresent())
			throw new SuperMarketFundNotFoundException(
					"Not found.",
					ErrorExceptions.NOT_FOUND);
		
		CustomerClientBean customerUpdate = customerOp.get();
		customerUpdate.setVideoPreference(customerBean.getVideoPreference());
		
		return customerUpdate;
	}	
}
