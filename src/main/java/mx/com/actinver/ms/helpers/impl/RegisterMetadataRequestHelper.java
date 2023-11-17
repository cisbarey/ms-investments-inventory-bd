package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;
import mx.com.actinver.ms.helpers.IRegisterMetadataRequestHelper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class RegisterMetadataRequestHelper implements IRegisterMetadataRequestHelper {

    @Override
    public RegisterMetadataRequestClientBean toRequest(RegisterMetadataRequestBean registerMetadataRequestBean) {

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        RegisterMetadataRequestClientBean registerMetadataRequestClientBean = new RegisterMetadataRequestClientBean();

        registerMetadataRequestClientBean.setKey(registerMetadataRequestBean.getKey());
        registerMetadataRequestClientBean.setSearchType(registerMetadataRequestBean.getSearchType());
        registerMetadataRequestClientBean.setCreationUser(registerMetadataRequestBean.getCustomerId() != null ? registerMetadataRequestBean.getCustomerId() : "MICROSERVICE");
        registerMetadataRequestClientBean.setCreationDate(fechaFormateada);

        return registerMetadataRequestClientBean;

    }

}