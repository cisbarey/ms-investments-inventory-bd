package mx.com.actinver.ms.helpers.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;
import mx.com.actinver.ms.helpers.IFavoritesHelper;

@Component
public class FavoritesHelper implements IFavoritesHelper {

	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public FavoritesClientBean toBean(FavoritesRequestBean insertBean) {
		FavoritesClientBean bean = new FavoritesClientBean();
		bean.setContractNumber(insertBean.getContractNumber());
		bean.setIssuer(insertBean.getIssuer());
		bean.setSerie(insertBean.getSerie());
		bean.setOperation(insertBean.getOperation());
		bean.setLanguage(insertBean.getLanguaje());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		bean.setCreationDate(formatter.format(date));
		bean.setCreationUser(user);
		return bean;
	}

}
