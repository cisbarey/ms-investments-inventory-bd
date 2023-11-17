package mx.com.actinver.ms.helpers.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.FavoritesClientBean;
import mx.com.actinver.ms.beans.insert.FavoritesRequestBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class FavoriteHelper implements IEntityHelper<FavoritesRequestBean, FavoritesClientBean> {
	
	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public List<FavoritesClientBean> toEntityAll(List<FavoritesRequestBean> clientBean) {

		List<FavoritesClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				FavoritesClientBean bean = new FavoritesClientBean();
				bean.setContractNumber(clientBean.get(i).getContractNumber());
				bean.setIssuer(clientBean.get(i).getIssuer());
				bean.setSerie(clientBean.get(i).getSerie());
				bean.setOperation(clientBean.get(i).getOperation());
				bean.setLanguage(clientBean.get(i).getLanguaje());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				Date date = new Date(); 
				bean.setCreationDate(formatter.format(date));
				bean.setCreationUser(user);
				beans.add(bean);
			}
			return beans;
		}
		return new ArrayList<>();
	}

	@Override
	public FavoritesRequestBean toBean(FavoritesClientBean clientBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(clientBean), FavoritesRequestBean.class);
	}

	@Override
	public FavoritesClientBean toEntity(FavoritesRequestBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), FavoritesClientBean.class);

	}


}
