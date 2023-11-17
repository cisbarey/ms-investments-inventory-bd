package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;

public interface IRegisterMetadataClient {

    RegisterMetadataResponseBean registrationMetadata(RegisterMetadataRequestClientBean registerMetadataRequestClientBean);

}

