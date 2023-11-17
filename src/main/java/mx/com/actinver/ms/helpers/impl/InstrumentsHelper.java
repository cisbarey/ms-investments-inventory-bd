package mx.com.actinver.ms.helpers.impl;

import com.google.gson.Gson;
import mx.com.actinver.ms.beans.BD.entities.InstrumentsClientBean;
import mx.com.actinver.ms.beans.insert.InstrumentsBean;
import mx.com.actinver.ms.helpers.IEntityHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InstrumentsHelper implements IEntityHelper<InstrumentsBean, InstrumentsClientBean> {
	
	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public List<InstrumentsClientBean> toEntityAll(List<InstrumentsBean> clientBean) {

		List<InstrumentsClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				InstrumentsClientBean bean = new InstrumentsClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setIsinInstruments(clientBean.get(i).getIsinInstruments());
				bean.setName(clientBean.get(i).getName());
				bean.setWeighting(clientBean.get(i).getWeighting());
				bean.setPerformance(clientBean.get(i).getPerformance());
				bean.setCurrency(clientBean.get(i).getCurrency());
				bean.setCurrencyId(clientBean.get(i).getCurrencyId());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				Date date = new Date(); 
				bean.setCreationDate(formatter.format(date));
				bean.setCreationUser(user);

				bean.setTicker(clientBean.get(i).getTicker());
				bean.setHolding(clientBean.get(i).getHolding());
				beans.add(bean);
			}
			return beans;
		}
		return new ArrayList<>();
	}

	@Override
	public InstrumentsBean toBean(InstrumentsClientBean clientBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(clientBean), InstrumentsBean.class);
	}

	@Override
	public InstrumentsClientBean toEntity(InstrumentsBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), InstrumentsClientBean.class);

	}


}
