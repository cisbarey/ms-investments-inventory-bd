package mx.com.actinver.ms.clients.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.repositories.ISectorsRepository;
import mx.com.actinver.ms.clients.IQuerySectorsClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;

@Component
public class QuerySectorsClient extends HttpHeadersConfig implements IQuerySectorsClient {

	@Autowired
    private ISectorsRepository sectorRepository;

	@Override
	public List<String> getClient(Map<String,String> headers) {
		
		List<String> sectors = null;
		
		sectors = sectorRepository.getDistinctSector();
		
		return sectors;
	}
	
}
