package mx.com.actinver.ms.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;
import mx.com.actinver.ms.clients.IQueryKeywordClient;
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
class QueryKeywordServiceTest {

	@InjectMocks
	private QueryKeywordService queryKeywordService;

	@Mock
	private IQueryKeywordClient queryKeywordClient;

	@Test
	public void test() {
		// Arrange
		String keyword = "PC";
		QueryKeywordResponseBean expectedResponse = new QueryKeywordResponseBean();
		when(queryKeywordClient.queryKeyword(keyword)).thenReturn(expectedResponse);

		// Act
		QueryKeywordResponseBean actualResponse = queryKeywordService.queryKeyword(keyword);

		// Assert
		assertEquals(expectedResponse, actualResponse);
	}

}