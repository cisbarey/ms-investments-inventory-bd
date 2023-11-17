package mx.com.actinver.ms.helpers;

import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;

public interface IRegisterMetadataRequestHelper {

    RegisterMetadataRequestClientBean toRequest(RegisterMetadataRequestBean registerMetadataRequestBean);

}