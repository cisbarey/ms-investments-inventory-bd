package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IRegions;
import mx.com.actinver.ms.beans.insert.RegionBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.helpers.impl.RegionHelper;
import mx.com.actinver.ms.services.IInsertRegionService;


@Service
public class InsertRegionService implements IInsertRegionService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private IRegions regions;
	
	@Autowired
	private RegionHelper fundHelper;

	@Override
	public RegionBean create(RegionBean requestBean) {
		if (requestBean.getIsin() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, RegionClientBean.class));
		RegionClientBean entity = regions.save(fundHelper.toEntity(requestBean));
		return fundHelper.toBean(entity);
	}

	@Override
	public RegionBean createAll(List<RegionBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, RegionClientBean.class));
		List<RegionClientBean> entity = regions.saveAll(fundHelper.toEntityAll(requestBean));
		return fundHelper.toBean(entity.get(0));
	}


}