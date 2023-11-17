package mx.com.actinver.ms.clients.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByTickerResponseClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.clients.IQueryByTickerClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Component
public class QueryByTickerClient extends HttpHeadersConfig implements IQueryByTickerClient {

	@Autowired
    private IFundsRepository fundsRepository;

	@Override
	public QueryByTickerResponseClientBean getClient(QueryByTickerRequestClientBean requestClientBean,Map<String,String> headers) {
		QueryByTickerResponseClientBean responseClientBean = new QueryByTickerResponseClientBean();

		List<DetailClientBean> detailClient= fundsRepository.findByTickerAndIsinIsIn(requestClientBean.getTicker(),
				requestClientBean.getIsins());

		if(detailClient == null || detailClient.isEmpty()) {
			throw new SuperMarketFundNotFoundException("Not found.",ErrorExceptions.NOT_FOUND);
		}
		responseClientBean.setDetail(detailClient);
		return responseClientBean;
	}
	
}
