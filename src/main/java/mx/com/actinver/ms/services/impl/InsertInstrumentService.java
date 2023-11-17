package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.InstrumentsClientBean;
import mx.com.actinver.ms.beans.BD.repositories.Iinstruments;
import mx.com.actinver.ms.beans.insert.InstrumentsBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.helpers.impl.InstrumentsHelper;
import mx.com.actinver.ms.services.IInsertInstrumentService;


@Service
public class InsertInstrumentService implements IInsertInstrumentService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private Iinstruments instruments;
	
	@Autowired
	private InstrumentsHelper fundHelper;

	@Override
	public InstrumentsBean create(InstrumentsBean requestBean) {
		if (requestBean.getIsin() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, InstrumentsClientBean.class));
		InstrumentsClientBean entity = instruments.save(fundHelper.toEntity(requestBean));
		return fundHelper.toBean(entity);
	}

	@Override
	public InstrumentsBean createAll(List<InstrumentsBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, InstrumentsClientBean.class));
		List<InstrumentsClientBean> entity = instruments.saveAll(fundHelper.toEntityAll(requestBean));
		return fundHelper.toBean(entity.get(0));
	}


}