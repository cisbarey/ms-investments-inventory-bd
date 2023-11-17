package mx.com.actinver.ms.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryHorizonResponseBean;
import mx.com.actinver.ms.clients.IQueryHorizonClient;
import mx.com.actinver.ms.helpers.IQueryHorizonHelper;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class QueryHorizonServiceTest {

	@InjectMocks
	private QueryHorizonService queryHorizonService;

	@Mock
	private IQueryHorizonHelper queryHelper;

	@Mock
	private IQueryHorizonClient queryClient;
	
	private String isin;
	private QueryHorizonResponseBean responseBean = new QueryHorizonResponseBean();
	private QueryHorizonResponseClientBean responseClientBean = new QueryHorizonResponseClientBean();
	private HorizonClientBean requestClientBean = new HorizonClientBean();
	private Map<String,String> headers = new HashMap<>();
	
	
	 @BeforeEach
	    public void before() {
		 
		 try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/queryHorizon/response.json")))) {
				Gson object = new Gson();
				responseBean = object.fromJson(bufferedReader, QueryHorizonResponseBean.class);
			} catch (IOException e) {
				log.error("Message: {}", e.getMessage());
			}
		 
		 headers.put("LEN", "SPA");
		 isin = "10014215";
	 }

	@Test
	void testRegisterHorizon() {

		when(queryHelper.toRequest(isin)).thenReturn(requestClientBean);
		when(queryClient.getClient(requestClientBean, headers)).thenReturn(responseClientBean);
		when(queryHelper.toResponse(responseClientBean)).thenReturn(responseBean);
		
		QueryHorizonResponseBean responseBeanTest = queryHorizonService.getService(isin, headers);
		assertNotNull(responseBean);
		assertEquals(responseBean.getType(), responseBeanTest.getType());	
		
	}

}