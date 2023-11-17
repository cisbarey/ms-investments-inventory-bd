package mx.com.actinver.ms.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentRequestBean;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;
import mx.com.actinver.ms.clients.IQueryByMostRecentClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class QueryByMostRecentServiceTest {

	@InjectMocks
	private QueryByMostRecentService queryByMostRecentService;

	@Mock
	private IQueryByMostRecentClient queryMostRecentClient;

	@Test
	public void test() {
		QueryByMostRecentRequestBean queryByMostRecentRequestBean = new QueryByMostRecentRequestBean();
		QueryByMostRecentResponseBean expectedResponse = new QueryByMostRecentResponseBean();
		
		queryByMostRecentRequestBean.setCustomerId("97225015");
		queryByMostRecentRequestBean.setSearchType("BY_SEARCH");
		queryByMostRecentRequestBean.setIsins(Arrays.asList("MX52ACTIN1", "MX52ACTIN2"));
		
		when(queryMostRecentClient.queryMostRecent(
				queryByMostRecentRequestBean.getCustomerId(),
				queryByMostRecentRequestBean.getSearchType(),
				queryByMostRecentRequestBean.getIsins())).thenReturn(expectedResponse);

		// Act
		QueryByMostRecentResponseBean actualResponse = queryByMostRecentService.queryMostRecent(queryByMostRecentRequestBean);

		// Assert
		assertEquals(expectedResponse, actualResponse);
	}

}