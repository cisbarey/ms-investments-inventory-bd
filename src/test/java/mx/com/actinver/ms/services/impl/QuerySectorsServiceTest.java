package mx.com.actinver.ms.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
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
import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;
import mx.com.actinver.ms.clients.IQuerySectorsClient;
import mx.com.actinver.ms.helpers.IQuerySectorsHelper;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class QuerySectorsServiceTest {

	@InjectMocks
	private QuerySectorsService service;
	
    @Mock
    private IQuerySectorsClient sectorClient;

    @Mock
    private IQuerySectorsHelper sectorHelper;
    

    private QuerySectorsResponseBean responseBean = new QuerySectorsResponseBean();
    private Map<String,String> headers = new HashMap<>();
    private List<String> sectors;
    
    
    @BeforeEach
	public void before() {
		
		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/querySectors/response.json")))) {
			Gson object = new Gson();
			responseBean = object.fromJson(bufferedReader, QuerySectorsResponseBean.class);
		} catch (IOException e) {
			log.error("Message: {}", e.getMessage());
		}

		headers.put("language", "SPA");

	}
    
	@Test
	void test() {
		
		when(sectorClient.getClient(headers)).thenReturn(sectors);
		when(sectorHelper.toResponse(sectors)).thenReturn(responseBean);
		
		QuerySectorsResponseBean responseTes = service.getService(headers);
		assertNotNull(responseTes);
		assertEquals(responseTes,responseBean);
		
	}

}