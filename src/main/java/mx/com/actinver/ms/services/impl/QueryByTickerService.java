package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.QueryByTickerRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryByTickerRequestBean;
import mx.com.actinver.ms.beans.query.QueryByTickerResponseBean;
import mx.com.actinver.ms.clients.IQueryByTickerClient;
import mx.com.actinver.ms.helpers.IQueryByTickerHelper;
import mx.com.actinver.ms.services.IQueryByTickerService;


@Service
public class QueryByTickerService implements IQueryByTickerService {

    @Autowired
    private IQueryByTickerClient tickerClient;

    @Autowired
    private IQueryByTickerHelper tickerHelper;

	@Override
	public QueryByTickerResponseBean getFundsByTicker(QueryByTickerRequestBean requestBean,Map<String,String> headers) {

		QueryByTickerRequestClientBean requestClientBean = tickerHelper.toRequest(requestBean);
		QueryByTickerResponseClientBean responseClientBean = tickerClient.getClient(requestClientBean, headers);
		
		return tickerHelper.toResponse(responseClientBean);
	}

}