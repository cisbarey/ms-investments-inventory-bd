package mx.com.actinver.ms.helpers.impl;

import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonRequestBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonResponseBean;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.IRegisterHorizonHelper;

@Component
public class RegisterHorizonHelper implements IRegisterHorizonHelper {

	@Override
	public HorizonClientBean toRequest(RegisterHorizonRequestBean requestBean) {
		HorizonClientBean requestClientBean = new HorizonClientBean();
		if(requestBean.getIsin() == null || requestBean.getIsin().trim().equals(""))
			throw new SuperMarketFundBusinessRuleException("isin is required",ErrorExceptions.INVALID_PARAMS);
		if(requestBean.getType() == null || requestBean.getType().trim().equals(""))
			throw new SuperMarketFundBusinessRuleException("type is required",ErrorExceptions.INVALID_PARAMS);
		requestClientBean.setIsin(requestBean.getIsin());
		requestClientBean.setType(requestBean.getType());
		requestClientBean.setCreationDate(requestBean.getCreationDate());
		requestClientBean.setCreationUser(requestBean.getCreationUser());
		return requestClientBean;
	}

	@Override
	public RegisterHorizonResponseBean toResponse(RegisterHorizonResponseClientBean responseClientBean) {
		RegisterHorizonResponseBean responseBean = new RegisterHorizonResponseBean();
		responseBean.setMessage(responseClientBean.getMessage());
		return responseBean;
	}

	

}
