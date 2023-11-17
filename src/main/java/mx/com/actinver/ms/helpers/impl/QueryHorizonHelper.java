package mx.com.actinver.ms.helpers.impl;

import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryHorizonResponseBean;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.IQueryHorizonHelper;

@Component
public class QueryHorizonHelper implements IQueryHorizonHelper {

	@Override
	public HorizonClientBean toRequest(String  isin) {
		
		HorizonClientBean horizonClientBean = new HorizonClientBean();
		
		if(isin == null || isin.trim().equals(""))
			throw new SuperMarketFundBusinessRuleException("isin is required",ErrorExceptions.INVALID_PARAMS);
		horizonClientBean.setIsin(isin);
		
		return horizonClientBean;
	}

	@Override
	public QueryHorizonResponseBean toResponse(QueryHorizonResponseClientBean responseClientBean) {
		QueryHorizonResponseBean responseBean = new QueryHorizonResponseBean();
		responseBean.setType(responseClientBean.getType());
		return responseBean;
	}

	

}
