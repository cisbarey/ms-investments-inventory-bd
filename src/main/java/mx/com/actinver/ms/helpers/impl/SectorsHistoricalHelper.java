package mx.com.actinver.ms.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.com.actinver.ms.beans.BD.entities.SectorClientBean;
import mx.com.actinver.ms.beans.BD.entities.SectorHistoricalClientBean;
import mx.com.actinver.ms.helpers.IEntityHelper;

@Component
public class SectorsHistoricalHelper implements IEntityHelper<SectorClientBean, SectorHistoricalClientBean> {

	@Override
	public List<SectorHistoricalClientBean> toEntityAll(List<SectorClientBean> clientBean) {
		List<SectorHistoricalClientBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				SectorHistoricalClientBean bean = new SectorHistoricalClientBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setName(clientBean.get(i).getName());
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
	public SectorClientBean toBean(SectorHistoricalClientBean clientBean) {
		
		SectorClientBean bean = new SectorClientBean();
		return bean;
	}

	@Override
	public SectorHistoricalClientBean toEntity(SectorClientBean requestBean) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(requestBean), SectorHistoricalClientBean.class);

	}


}
