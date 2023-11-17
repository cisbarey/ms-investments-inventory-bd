package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryHorizonResponseBean;
import mx.com.actinver.ms.clients.IQueryHorizonClient;
import mx.com.actinver.ms.helpers.IQueryHorizonHelper;
import mx.com.actinver.ms.services.IQueryHorizonService;


@Service
public class QueryHorizonService implements IQueryHorizonService {

    @Autowired
    private IQueryHorizonClient horizonClient;

    @Autowired
    private IQueryHorizonHelper horizonHelper;

	@Override
	public QueryHorizonResponseBean getService(String isin, Map<String, String> headers) {
		
		HorizonClientBean requestClientBean = horizonHelper.toRequest(isin);
		QueryHorizonResponseClientBean responseClientBean = horizonClient.getClient(requestClientBean, headers);
		
		return horizonHelper.toResponse(responseClientBean);
	}

}