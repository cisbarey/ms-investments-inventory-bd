package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.CountryClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ICountries;
import mx.com.actinver.ms.beans.insert.CountryBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.helpers.impl.CountriesHelper;
import mx.com.actinver.ms.services.IInsertCountryService;


@Service
public class InsertCountryService implements IInsertCountryService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private ICountries countries;
	
	@Autowired
	private CountriesHelper fundHelper;

	@Override
	public CountryBean create(CountryBean requestBean) {
		if (requestBean.getIsin() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, CountryClientBean.class));
		CountryClientBean entity = countries.save(fundHelper.toEntity(requestBean));
		return fundHelper.toBean(entity);
	}

	@Override
	public CountryBean createAll(List<CountryBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, CountryClientBean.class));
		List<CountryClientBean> entity = countries.saveAll(fundHelper.toEntityAll(requestBean));
		return fundHelper.toBean(entity.get(0));
	}


}