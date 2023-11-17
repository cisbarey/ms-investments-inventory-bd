package mx.com.actinver.ms.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;
import mx.com.actinver.ms.clients.IRegisterKeywordClient;
import mx.com.actinver.ms.helpers.IRegisterKeywordRequestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class RegisterKeywordServiceTest {

	@InjectMocks
	private RegisterKeywordService registerKeywordService;

	@Mock
	private IRegisterKeywordRequestHelper registerKeywordRequestHelper;

	@Mock
	private IRegisterKeywordClient registerKeywordClient;
	
	private RegisterKeywordRequestBean registerKeywordRequestBean = new RegisterKeywordRequestBean();

	private RegisterKeywordRequestClientBean registerKeywordRequestClientBean = new RegisterKeywordRequestClientBean();
	
	 @BeforeEach
	    public void before() {
		 MockitoAnnotations.openMocks(this);
	 }

	@Test
	void test() {

		// Arrange
		RegisterKeywordRequestBean registerKeywordRequestBean = new RegisterKeywordRequestBean();
		RegisterKeywordRequestClientBean registerKeywordRequestClientBean = new RegisterKeywordRequestClientBean();
		RegisterKeywordResponseBean expectedResponse = new RegisterKeywordResponseBean();

		when(registerKeywordRequestHelper.toRequest(registerKeywordRequestBean)).thenReturn(registerKeywordRequestClientBean);
		when(registerKeywordClient.registrationKeyword(registerKeywordRequestClientBean)).thenReturn(expectedResponse);

		// Act
		RegisterKeywordResponseBean actualResponse = registerKeywordService.registerKeyword(registerKeywordRequestBean);

		// Assert
		verify(registerKeywordRequestHelper, times(1)).toRequest(registerKeywordRequestBean);
		verify(registerKeywordClient, times(1)).registrationKeyword(registerKeywordRequestClientBean);
		assertEquals(expectedResponse, actualResponse);
		
	}

}