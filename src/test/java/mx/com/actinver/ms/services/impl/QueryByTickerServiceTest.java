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
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByTickerRequestBean;
import mx.com.actinver.ms.beans.query.QueryByTickerResponseBean;
import mx.com.actinver.ms.clients.IQueryByTickerClient;
import mx.com.actinver.ms.helpers.IQueryByTickerHelper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@Slf4j
class QueryByTickerServiceTest{
	
	@InjectMocks
	private QueryByTickerService service;
	
    @Mock
    private IQueryByTickerClient TickerClient;

    @Mock
    private IQueryByTickerHelper TickerHelper;
    
    private QueryByTickerRequestBean
    requestBean = new QueryByTickerRequestBean(); 
    private QueryByTickerResponseBean responseBean = new QueryByTickerResponseBean();
    private QueryByTickerRequestClientBean requestClientBean = new QueryByTickerRequestClientBean();
    private QueryByTickerResponseClientBean responseClientBean = new QueryByTickerResponseClientBean();
    private Map<String,String> headers = new HashMap<>();
    
    
    @BeforeEach
	public void before() {
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/queryByTicker/request.json")))) {
			Gson object = new Gson();
			requestBean = object.fromJson(bufferedReader, QueryByTickerRequestBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/queryByTicker/response.json")))) {
			Gson object = new Gson();
			responseBean = object.fromJson(bufferedReader, QueryByTickerResponseBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}

		headers.put("language", "SPA");

	}
    
	@Test
	void test() {
		
		when(TickerHelper.toRequest(requestBean)).thenReturn(requestClientBean);
		when(TickerClient.getClient(requestClientBean,headers)).thenReturn(responseClientBean);
		when(TickerHelper.toResponse(responseClientBean)).thenReturn(responseBean);
		
		QueryByTickerResponseBean responseTes = service.getFundsByTicker(requestBean, headers);
		Assertions.assertNotNull(responseTes);
		Assertions.assertEquals(responseTes,responseBean);
		
	}

}