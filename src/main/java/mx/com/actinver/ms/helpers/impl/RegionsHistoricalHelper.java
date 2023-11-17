package mx.com.actinver.ms.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegionHistoricalClientBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class RegionsHistoricalHelper implements IEntityHelper<RegionClientBean, RegionHistoricalClientBean> {

	@Override
	public List<RegionHistoricalClientBean> toEntityAll(List<RegionClientBean> clientBean) {
		List<RegionHistoricalClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				RegionHistoricalClientBean bean = new RegionHistoricalClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setRegion(clientBean.get(i).getRegion());
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
	public RegionClientBean toBean(RegionHistoricalClientBean clientBean) {
		
		RegionClientBean bean = new RegionClientBean();
		return bean;
	}

	@Override
	public RegionHistoricalClientBean toEntity(RegionClientBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), RegionHistoricalClientBean.class);

	}


}
