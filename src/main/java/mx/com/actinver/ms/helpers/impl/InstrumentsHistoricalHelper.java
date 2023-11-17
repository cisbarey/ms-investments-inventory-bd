package mx.com.actinver.ms.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.InstrumentsClientBean;
import mx.com.actinver.ms.beans.BD.entities.InstrumentsHistoricalClientBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class InstrumentsHistoricalHelper implements IEntityHelper<InstrumentsClientBean, InstrumentsHistoricalClientBean> {

	@Override
	public List<InstrumentsHistoricalClientBean> toEntityAll(List<InstrumentsClientBean> clientBean) {
		List<InstrumentsHistoricalClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				InstrumentsHistoricalClientBean bean = new InstrumentsHistoricalClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setIsinInstruments(clientBean.get(i).getIsinInstruments());
				bean.setName(clientBean.get(i).getName());
				bean.setWeighting(clientBean.get(i).getWeighting());
				bean.setPerformance(clientBean.get(i).getPerformance());
				bean.setCurrency(clientBean.get(i).getCurrency());
				bean.setCurrencyId(clientBean.get(i).getCurrencyId());
				bean.setCreationDate(clientBean.get(i).getCreationDate());
				bean.setCreationUser(clientBean.get(i).getCreationUser());
				beans.add(bean);
			}
			return beans;
		}
		return new ArrayList<>();
	}

	@Override
	public InstrumentsClientBean toBean(InstrumentsHistoricalClientBean clientBean) {
		
		InstrumentsClientBean bean = new InstrumentsClientBean();
		return bean;
	}

	@Override
	public InstrumentsHistoricalClientBean toEntity(InstrumentsClientBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), InstrumentsHistoricalClientBean.class);

	}


}
