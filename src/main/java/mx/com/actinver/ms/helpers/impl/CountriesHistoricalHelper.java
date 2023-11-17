package mx.com.actinver.ms.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.CountryClientBean;
import mx.com.actinver.ms.beans.BD.entities.CountryHistoricalClientBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class CountriesHistoricalHelper implements IEntityHelper<CountryClientBean, CountryHistoricalClientBean> {

	@Override
	public List<CountryHistoricalClientBean> toEntityAll(List<CountryClientBean> clientBean) {
		List<CountryHistoricalClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				CountryHistoricalClientBean bean = new CountryHistoricalClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setCountry(clientBean.get(i).getCountry());
				bean.setValue(clientBean.get(i).getValue());
				bean.setCreationDate(clientBean.get(i).getCreationDate());
				bean.setCreationUser(clientBean.get(i).getCreationUser());
				beans.add(bean);
			}
			return beans;
		}
		return new ArrayList<>();
	}

	@Override
	public CountryClientBean toBean(CountryHistoricalClientBean clientBean) {
		
		CountryClientBean bean = new CountryClientBean();
		return bean;
	}

	@Override
	public CountryHistoricalClientBean toEntity(CountryClientBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), CountryHistoricalClientBean.class);

	}


}
