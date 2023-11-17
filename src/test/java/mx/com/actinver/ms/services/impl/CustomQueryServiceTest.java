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
import mx.com.actinver.ms.beans.BD.entities.GetFundsRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.GetFundsResponseClientBean;
import mx.com.actinver.ms.beans.query.GetFundsRequestBean;
import mx.com.actinver.ms.beans.query.GetFundsResponseBean;
import mx.com.actinver.ms.clients.IGetFundsClient;
import mx.com.actinver.ms.helpers.IGetFundsHelper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@Slf4j
class GetFundsServiceTest{
	
	@InjectMocks
	private GetFundsService service;
	
    @Mock
    private IGetFundsClient client;

    @Mock
    private IGetFundsHelper helper;
    
    private GetFundsRequestBean
    requestBean = new GetFundsRequestBean(); 
    private GetFundsResponseBean responseBean = new GetFundsResponseBean();
    private GetFundsRequestClientBean requestClientBean = new GetFundsRequestClientBean();
    private GetFundsResponseClientBean responseClientBean = new GetFundsResponseClientBean();
    private Map<String,String> headers = new HashMap<>();
    
    
    @BeforeEach
	public void before() {
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/getFunds/request.json")))) {
			Gson object = new Gson();
			requestBean = object.fromJson(bufferedReader, GetFundsRequestBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/getFunds/response.json")))) {
			Gson object = new Gson();
			responseBean = object.fromJson(bufferedReader, GetFundsResponseBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}

		headers.put("language", "SPA");

	}
    
	@Test
	void test() {
		
		when(helper.toRequest(requestBean)).thenReturn(requestClientBean);
		when(client.getFunds(requestClientBean,headers)).thenReturn(responseClientBean);
		when(helper.toResponse(responseClientBean)).thenReturn(responseBean);
		
		GetFundsResponseBean responseTes = service.getFunds(requestBean, headers);
		Assertions.assertNotNull(responseTes);
		Assertions.assertEquals(responseTes,responseBean);
		
	}

}