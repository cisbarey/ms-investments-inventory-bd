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
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonRequestBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonResponseBean;
import mx.com.actinver.ms.clients.IRegisterHorizonClient;
import mx.com.actinver.ms.helpers.IRegisterHorizonHelper;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class RegisterHorizonServiceTest {

	@InjectMocks
	private RegisterHorizonService registerHorizonService;

	@Mock
	private IRegisterHorizonHelper horizonHelper;

	@Mock
	private IRegisterHorizonClient horizonClient;
	
	private RegisterHorizonRequestBean requestBean = new RegisterHorizonRequestBean();
	private RegisterHorizonResponseBean responseBean = new RegisterHorizonResponseBean();
	private RegisterHorizonResponseClientBean responseClientBean = new RegisterHorizonResponseClientBean();
	private HorizonClientBean requestClientBean = new HorizonClientBean();
	private Map<String,String> headers = new HashMap<>();
	
	
	 @BeforeEach
	    public void before() {
		 
		 try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/registerHorizon/request.json")))) {
				Gson object = new Gson();
				requestBean = object.fromJson(bufferedReader, RegisterHorizonRequestBean.class);
			} catch (IOException e) {
				log.error("Message: {}", e.getMessage());
			}
		 
		 try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/registerHorizon/response.json")))) {
				Gson object = new Gson();
				responseBean = object.fromJson(bufferedReader, RegisterHorizonResponseBean.class);
			} catch (IOException e) {
				log.error("Message: {}", e.getMessage());
			}
		 
		 headers.put("LEN", "SPA");
	 }

	@Test
	void testRegisterHorizon() {

		when(horizonHelper.toRequest(requestBean)).thenReturn(requestClientBean);
		when(horizonClient.getClient(requestClientBean, headers)).thenReturn(responseClientBean);
		when(horizonHelper.toResponse(responseClientBean)).thenReturn(responseBean);
		
		RegisterHorizonResponseBean responseBeanTest = registerHorizonService.getService(requestBean, headers);
		assertNotNull(responseBean);
		assertEquals(responseBean.getMessage(), responseBeanTest.getMessage());	
		
	}

}