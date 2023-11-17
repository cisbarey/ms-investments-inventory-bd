package mx.com.actinver.ms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;
import mx.com.actinver.ms.clients.IRegisterKeywordClient;
import mx.com.actinver.ms.helpers.IRegisterKeywordRequestHelper;
import mx.com.actinver.ms.services.IRegisterKeywordService;

@Service
public class RegisterKeywordService implements IRegisterKeywordService {

    @Autowired
    private IRegisterKeywordClient registerKeywordClient;

    @Autowired
    private IRegisterKeywordRequestHelper registerKeywordRequestHelper;

    @Override
    public RegisterKeywordResponseBean registerKeyword(RegisterKeywordRequestBean registerKeywordRequestBean) {
        RegisterKeywordRequestClientBean relatedKeywordRequestClientBean = registerKeywordRequestHelper.toRequest(registerKeywordRequestBean);
        RegisterKeywordResponseBean registerKeywordResponseBean = registerKeywordClient.registrationKeyword(relatedKeywordRequestClientBean);
        return registerKeywordResponseBean;
    }

}