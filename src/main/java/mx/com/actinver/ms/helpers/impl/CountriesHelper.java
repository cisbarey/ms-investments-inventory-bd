package mx.com.actinver.ms.helpers.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.CountryClientBean;
import mx.com.actinver.ms.beans.insert.CountryBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class CountriesHelper implements IEntityHelper<CountryBean, CountryClientBean> {
	
	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public List<CountryClientBean> toEntityAll(List<CountryBean> clientBean) {

		List<CountryClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				CountryClientBean bean = new CountryClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setCountry(clientBean.get(i).getCountry());
				bean.setValue(clientBean.get(i).getValue());
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
	public CountryBean toBean(CountryClientBean clientBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(clientBean), CountryBean.class);
	}

	@Override
	public CountryClientBean toEntity(CountryBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), CountryClientBean.class);

	}


}
