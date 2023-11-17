package mx.com.actinver.ms.helpers.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.SectorClientBean;
import mx.com.actinver.ms.beans.insert.SectorBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class SectorHelper implements IEntityHelper<SectorBean, SectorClientBean> {
	
	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public List<SectorClientBean> toEntityAll(List<SectorBean> clientBean) {

		List<SectorClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				SectorClientBean bean = new SectorClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setName(clientBean.get(i).getName());
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
	public SectorBean toBean(SectorClientBean clientBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(clientBean), SectorBean.class);
	}

	@Override
	public SectorClientBean toEntity(SectorBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), SectorClientBean.class);

	}


}
