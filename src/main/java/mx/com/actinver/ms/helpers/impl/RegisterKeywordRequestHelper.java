package mx.com.actinver.ms.helpers.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.client.registerKeyword.RegisterKeywordRequestClientBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;
import mx.com.actinver.ms.helpers.IRegisterKeywordRequestHelper;

@Component
public class RegisterKeywordRequestHelper implements IRegisterKeywordRequestHelper {

    @Override
    public RegisterKeywordRequestClientBean toRequest(RegisterKeywordRequestBean registerKeywordRequestBean) {

        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        RegisterKeywordRequestClientBean registerKeywordRequestClientBean = new RegisterKeywordRequestClientBean();

        registerKeywordRequestClientBean.setKeyword(registerKeywordRequestBean.getKeyword());
        registerKeywordRequestClientBean.setRelated(registerKeywordRequestBean.getRelated());
        registerKeywordRequestClientBean.setCreationUser(registerKeywordRequestBean.getCreationUser());
        registerKeywordRequestClientBean.setCreationDate(fechaFormateada);

        return registerKeywordRequestClientBean;
    }

}
