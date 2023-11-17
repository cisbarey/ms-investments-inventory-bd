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
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByRegionRequestBean;
import mx.com.actinver.ms.beans.query.QueryByRegionResponseBean;
import mx.com.actinver.ms.clients.IQueryByRegionClient;
import mx.com.actinver.ms.helpers.IQueryByRegionHelper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@Slf4j
class QueryByRegionServiceTest {

	@InjectMocks
	private QueryByRegionService service;
	
    @Mock
    private IQueryByRegionClient queryByRegionClient;

    @Mock
    private IQueryByRegionHelper queryByRegionHelper;
    
    private QueryByRegionRequestBean requestBean = new QueryByRegionRequestBean(); 
    private QueryByRegionResponseBean responseBean = new QueryByRegionResponseBean();
    private QueryByRegionRequestClientBean requestClientBean = new QueryByRegionRequestClientBean();
    private QueryByRegionResponseClientBean responseClientBean = new QueryByRegionResponseClientBean();
    private Map<String,String> headers = new HashMap<>();
    
    
    @BeforeEach
	public void before() {
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/queryByRegion/request.json")))) {
			Gson object = new Gson();
			requestBean = object.fromJson(bufferedReader, QueryByRegionRequestBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/queryByRegion/response.json")))) {
			Gson object = new Gson();
			responseBean = object.fromJson(bufferedReader, QueryByRegionResponseBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}

		headers.put("language", "SPA");

	}
    
	@Test
	void test() {
		
		when(queryByRegionHelper.toRequest(requestBean)).thenReturn(requestClientBean);
		when(queryByRegionClient.getClient(requestClientBean,headers)).thenReturn(responseClientBean);
		when(queryByRegionHelper.toResponse(responseClientBean, requestBean)).thenReturn(responseBean);
		
		QueryByRegionResponseBean responseTes = service.getRegion(requestBean,headers);
		Assertions.assertNotNull(responseTes);
		Assertions.assertEquals(responseTes,responseBean);
		
		
	}


}
