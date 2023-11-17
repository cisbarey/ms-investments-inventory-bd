package mx.com.actinver.ms.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.HorizonClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterHorizonResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonRequestBean;
import mx.com.actinver.ms.beans.query.RegisterHorizonResponseBean;
import mx.com.actinver.ms.clients.IRegisterHorizonClient;
import mx.com.actinver.ms.helpers.IRegisterHorizonHelper;
import mx.com.actinver.ms.services.IRegisterHorizonService;


@Service
public class RegisterHorizonService implements IRegisterHorizonService {

    @Autowired
    private IRegisterHorizonClient horizonClient;

    @Autowired
    private IRegisterHorizonHelper horizonHelper;

	@Override
	public RegisterHorizonResponseBean getService(RegisterHorizonRequestBean requestBean, Map<String, String> headers) {
		
		HorizonClientBean requestClientBean = horizonHelper.toRequest(requestBean);
		RegisterHorizonResponseClientBean responseClientBean=  horizonClient.getClient(requestClientBean, headers);
		
		return horizonHelper.toResponse(responseClientBean);
	}

}