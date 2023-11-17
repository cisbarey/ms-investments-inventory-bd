package mx.com.actinver.ms.helpers.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;
import mx.com.actinver.ms.beans.insert.RegionBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class RegionHelper implements IEntityHelper<RegionBean, RegionClientBean> {
	
	@Value(value = "${BD.createUser}")
	private String user;

	@Override
	public List<RegionClientBean> toEntityAll(List<RegionBean> clientBean) {

		List<RegionClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				RegionClientBean bean = new RegionClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setRegion(clientBean.get(i).getRegion());
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
	public RegionBean toBean(RegionClientBean clientBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(clientBean), RegionBean.class);
	}

	@Override
	public RegionClientBean toEntity(RegionBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), RegionClientBean.class);

	}


}
