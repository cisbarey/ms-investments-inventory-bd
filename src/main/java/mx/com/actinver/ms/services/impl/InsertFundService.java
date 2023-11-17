package mx.com.actinver.ms.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.actinver.ms.beans.BD.entities.CountryClientBean;
import mx.com.actinver.ms.beans.BD.entities.CountryHistoricalClientBean;
import mx.com.actinver.ms.beans.BD.entities.FundsClientBean;
import mx.com.actinver.ms.beans.BD.entities.FundsHistoricalClientBean;
import mx.com.actinver.ms.beans.BD.entities.InstrumentsClientBean;
import mx.com.actinver.ms.beans.BD.entities.InstrumentsHistoricalClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegionHistoricalClientBean;
import mx.com.actinver.ms.beans.BD.entities.SectorClientBean;
import mx.com.actinver.ms.beans.BD.entities.SectorHistoricalClientBean;
import mx.com.actinver.ms.beans.BD.repositories.ICountries;
import mx.com.actinver.ms.beans.BD.repositories.ICountriesHistorical;
import mx.com.actinver.ms.beans.BD.repositories.IFunds;
import mx.com.actinver.ms.beans.BD.repositories.IFundsHistorical;
import mx.com.actinver.ms.beans.BD.repositories.IRegions;
import mx.com.actinver.ms.beans.BD.repositories.IRegionsHistorical;
import mx.com.actinver.ms.beans.BD.repositories.ISectors;
import mx.com.actinver.ms.beans.BD.repositories.ISectorsHistorical;
import mx.com.actinver.ms.beans.BD.repositories.Iinstruments;
import mx.com.actinver.ms.beans.BD.repositories.IinstrumentsHistorical;
import mx.com.actinver.ms.beans.insert.FundBean;
import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.helpers.impl.CountriesHistoricalHelper;
import mx.com.actinver.ms.helpers.impl.FundHelper;
import mx.com.actinver.ms.helpers.impl.FundHistoricalHelper;
import mx.com.actinver.ms.helpers.impl.InstrumentsHistoricalHelper;
import mx.com.actinver.ms.helpers.impl.RegionsHistoricalHelper;
import mx.com.actinver.ms.helpers.impl.SectorsHistoricalHelper;
import mx.com.actinver.ms.services.IInsertFundService;


@Service
public class InsertFundService implements IInsertFundService {

	@Autowired
	private EntityManager em;
	
	
	//Repositorios para insertar registros en las primeras tablas
	@Autowired
	private IFunds funds;
	
	@Autowired
	private ICountries countries;
	
	@Autowired
	private IRegions regions;
	
	@Autowired
	private Iinstruments instruments;
	
	@Autowired
	private ISectors sectors;
	
	
	//Repositorios para insertar registros en historicos
	@Autowired
	private IFundsHistorical fundsHistorical;
	
	@Autowired
	private ICountriesHistorical countriesHistorical;
	
	@Autowired
	private IRegionsHistorical regionsHistorical;
	
	@Autowired
	private IinstrumentsHistorical instrumentsHistorical;
	
	@Autowired
	private ISectorsHistorical sectorsHistorical;
	
	@Autowired
	private FundHelper fundHelper;
	
	//Helpers de insercion
	
	@Autowired
	private FundHistoricalHelper fundHistoricalHelper;
	
	@Autowired
	private CountriesHistoricalHelper countriesHistoricalHelper;
	
	@Autowired
	private RegionsHistoricalHelper regionsHistoricalHelper;
	
	@Autowired
	private InstrumentsHistoricalHelper instrumentsHistoricalHelper;
	
	@Autowired
	private SectorsHistoricalHelper sectorsHistoricalHelper;

	@Override
	public Boolean moveAll() {
		//Extrae informacion de las tablas transaccionales
		List<FundsClientBean> fundsClientBeans = funds.findAll();
		List<CountryClientBean> countryClientBeans = countries.findAll();
		List<RegionClientBean> regionClientBeans = regions.findAll();
		List<InstrumentsClientBean> instrumentsClientBeans = instruments.findAll();
		List<SectorClientBean> sectorClientBeans = sectors.findAll();
		if (!fundsClientBeans.isEmpty() || 
			!countryClientBeans.isEmpty() || 
			!regionClientBeans.isEmpty() || 
			!instrumentsClientBeans.isEmpty() ||
			!sectorClientBeans.isEmpty()) {
			//Elimina tablas de historicos
			countriesHistorical.deleteAll();
			regionsHistorical.deleteAll();
			instrumentsHistorical.deleteAll();
			sectorsHistorical.deleteAll();
			fundsHistorical.deleteAll();
			
			List<FundsHistoricalClientBean> fundsHistoricalClientBeans = fundsHistorical.findAll();
			List<CountryHistoricalClientBean> countryHistoricalClientBeans = countriesHistorical.findAll();
			List<RegionHistoricalClientBean> regionHistoricalClientBeans = regionsHistorical.findAll();
			List<InstrumentsHistoricalClientBean> instrumentsHistoricalClientBeans = instrumentsHistorical.findAll();
			List<SectorHistoricalClientBean> sectorHistoricalClientBeans = sectorsHistorical.findAll();
			
			if (fundsHistoricalClientBeans.isEmpty() || 
				countryHistoricalClientBeans.isEmpty() || 
				regionHistoricalClientBeans.isEmpty() || 
				instrumentsHistoricalClientBeans.isEmpty() ||
				sectorHistoricalClientBeans.isEmpty()) {
				//Guarda todos los registros en las tablas de historicos
				fundsHistorical.saveAll(fundHistoricalHelper.toEntityAll(fundsClientBeans));
				countriesHistorical.saveAll(countriesHistoricalHelper.toEntityAll(countryClientBeans));
				regionsHistorical.saveAll(regionsHistoricalHelper.toEntityAll(regionClientBeans));
				instrumentsHistorical.saveAll(instrumentsHistoricalHelper.toEntityAll(instrumentsClientBeans));
				sectorsHistorical.saveAll(sectorsHistoricalHelper.toEntityAll(sectorClientBeans));
				
				//Elimina todo de las tablas transaccionales
				countries.deleteAll();
				regions.deleteAll();
				instruments.deleteAll();
				sectors.deleteAll();
				funds.deleteAll();
				return true;
			}
			return false;
					
			
		}
		return false;
	}

	@Override
	public FundBean create(FundBean requestBean) {
		if (requestBean.getIsin() == null)
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.ID_NULL, this.getTableName(em, FundsClientBean.class));
		FundsClientBean entity = funds.save(fundHelper.toEntity(requestBean));
		return fundHelper.toBean(entity);
	}

	@Override
	public Boolean deleteAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FundBean createAll(List<FundBean> requestBean) {
		if (requestBean.isEmpty())
			throw new SuperMarketFundBusinessRuleException(TypeDatabaseException.NULL_ELEMENT, this.getTableName(em, FundsClientBean.class));
		List<FundsClientBean> entity = funds.saveAll(fundHelper.toEntityAll(requestBean));
		return fundHelper.toBean(entity.get(0));
	}


}