package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.QueryByRegionRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByRegionRequestBean;
import mx.com.actinver.ms.beans.query.QueryByRegionResponseBean;
import mx.com.actinver.ms.clients.IQueryByRegionClient;
import mx.com.actinver.ms.helpers.IQueryByRegionHelper;
import mx.com.actinver.ms.services.IQueryByRegionService;


@Service
public class QueryByRegionService implements IQueryByRegionService {

    @Autowired
    private IQueryByRegionClient queryByRegionClient;

    @Autowired
    private IQueryByRegionHelper queryByRegionHelper;

	@Override
	public QueryByRegionResponseBean getRegion(QueryByRegionRequestBean requestBean, Map<String, String> headers) {
		QueryByRegionRequestClientBean requestClientBean = queryByRegionHelper.toRequest(requestBean);
		QueryByRegionResponseClientBean responseClientBean = queryByRegionClient.getClient(requestClientBean,headers);
		
		return queryByRegionHelper.toResponse(responseClientBean, requestBean);
	}

}