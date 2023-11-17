package mx.com.actinver.ms.services.impl;

import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.CustomerClientBean;
import mx.com.actinver.ms.beans.client.customer.CustomerGetClientRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;
import mx.com.actinver.ms.clients.ICustomerClient;
import mx.com.actinver.ms.helpers.ICustomerHelper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@Slf4j
class CustomerPreferenceGetServiceTest{
	
	@InjectMocks
	private CustomersService service;
	
    @Mock 
	private ICustomerClient customerClient;
	
    @Mock 
	private ICustomerHelper customerHelper;
    
    private CustomerGetRequestBean requestBean = new CustomerGetRequestBean(); 
    private CustomerResponseBean responseBean = new CustomerResponseBean();
    private CustomerGetClientRequestBean requestClientBean = new CustomerGetClientRequestBean();
    private CustomerClientBean responseClientBean = new CustomerClientBean();
    private Map<String,String> headers = new HashMap<>();
    
    
    @BeforeEach
	public void before() {
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/getCustomer/request.json")))) {
			Gson object = new Gson();
			requestBean = object.fromJson(bufferedReader, CustomerGetRequestBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/getCustomer/response.json")))) {
			Gson object = new Gson();
			responseBean = object.fromJson(bufferedReader, CustomerResponseBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}

		headers.put("language", "SPA");

	}
    
	@Test
	void test() {
		
		when(customerHelper.toGetRequest(requestBean)).thenReturn(requestClientBean);
		when(customerClient.getCustomer(requestClientBean,headers)).thenReturn(responseClientBean);
		when(customerHelper.toResponse(responseClientBean)).thenReturn(responseBean);
		
		CustomerResponseBean responseTes = service.get(requestBean, headers);
		Assertions.assertNotNull(responseTes);
		Assertions.assertEquals(responseTes,responseBean);
		
	}

}