package mx.com.actinver.ms.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;
import mx.com.actinver.ms.clients.IQuerySectorsClient;
import mx.com.actinver.ms.helpers.IQuerySectorsHelper;
import mx.com.actinver.ms.services.IQuerySectorsService;


@Service
public class QuerySectorsService implements IQuerySectorsService {

    @Autowired
    private IQuerySectorsClient sectorClient;

    @Autowired
    private IQuerySectorsHelper sectorsHelper;

	@Override
	public QuerySectorsResponseBean getService(Map<String,String> headers) {

		List<String> responseClientBean = sectorClient.getClient(headers);
		
		return sectorsHelper.toResponse(responseClientBean);
	}

}