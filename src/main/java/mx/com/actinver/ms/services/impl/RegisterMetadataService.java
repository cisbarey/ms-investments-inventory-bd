package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;
import mx.com.actinver.ms.clients.IRegisterMetadataClient;
import mx.com.actinver.ms.helpers.IRegisterMetadataRequestHelper;
import mx.com.actinver.ms.services.IRegisterMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterMetadataService implements IRegisterMetadataService {

    @Autowired
    private IRegisterMetadataRequestHelper registerMetadataRequestHelper;

    @Autowired
    private IRegisterMetadataClient registerMetadataClient;

    @Override
    public RegisterMetadataResponseBean registerMetadata(RegisterMetadataRequestBean registerMetadataRequestBean) {
    	
        RegisterMetadataRequestClientBean requestClientBean = registerMetadataRequestHelper.toRequest(registerMetadataRequestBean);
        
        return registerMetadataClient.registrationMetadata(requestClientBean);
    }

}