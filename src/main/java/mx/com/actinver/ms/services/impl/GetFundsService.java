package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.GetFundsRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.GetFundsResponseClientBean;
import mx.com.actinver.ms.beans.query.GetFundsRequestBean;
import mx.com.actinver.ms.beans.query.GetFundsResponseBean;
import mx.com.actinver.ms.clients.IGetFundsClient;
import mx.com.actinver.ms.helpers.IGetFundsHelper;
import mx.com.actinver.ms.services.IGetFundsService;

@Component
public class GetFundsService implements IGetFundsService {

	@Autowired
    private IGetFundsClient getFundsClient;
	
	@Autowired
	private IGetFundsHelper getFundsHelper;

	@Override
	public GetFundsResponseBean getFunds(GetFundsRequestBean requestBean,Map<String,String> headers) {

		GetFundsRequestClientBean customQueryRequestClientBean = getFundsHelper.toRequest(requestBean);
		GetFundsResponseClientBean customQueryResponseClientBean = getFundsClient.getFunds(customQueryRequestClientBean, headers);
		
		return getFundsHelper.toResponse(customQueryResponseClientBean);
	}
	
}
