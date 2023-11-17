package mx.com.actinver.ms.services;

import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;

public interface IRegisterMetadataService {

    RegisterMetadataResponseBean registerMetadata(RegisterMetadataRequestBean registerMetadataRequestBean);

}