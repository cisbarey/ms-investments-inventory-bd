package mx.com.actinver.ms.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;
import mx.com.actinver.ms.clients.IDeleteKeywordClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class DeleteKeywordServiceTest {

	@InjectMocks
	private DeleteKeywordService deleteKeywordService;

	@Mock
	private IDeleteKeywordClient deleteKeywordClient;

	@Test
	public void test() {
		// Arrange
		String keyword = "PC";
		DeleteKeywordResponseBean expectedResponse = new DeleteKeywordResponseBean();
		when(deleteKeywordClient.deleteKeyword(keyword)).thenReturn(expectedResponse);

		// Act
		DeleteKeywordResponseBean actualResponse = deleteKeywordService.deleteKeyword(keyword);

		// Assert
		assertEquals(expectedResponse, actualResponse);
	}

}