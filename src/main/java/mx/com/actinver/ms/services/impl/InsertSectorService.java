package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.SectorClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ISectors;
import mx.com.actinver.ms.beans.insert.SectorBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.helpers.impl.SectorHelper;
import mx.com.actinver.ms.services.IInsertSectorService;


@Service
public class InsertSectorService implements IInsertSectorService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private ISectors sectors;
	
	@Autowired
	private SectorHelper fundHelper;

	@Override
	public SectorBean create(SectorBean requestBean) {
		if (requestBean.getIsin() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, SectorClientBean.class));
		SectorClientBean entity = sectors.save(fundHelper.toEntity(requestBean));
		return fundHelper.toBean(entity);
	}

	@Override
	public SectorBean createAll(List<SectorBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, SectorClientBean.class));
		List<SectorClientBean> entity = sectors.saveAll(fundHelper.toEntityAll(requestBean));
		return fundHelper.toBean(entity.get(0));
	}


}