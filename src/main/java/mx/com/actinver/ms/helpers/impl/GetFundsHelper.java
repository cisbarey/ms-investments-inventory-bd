package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.BD.entities.*;
import mx.com.actinver.ms.beans.query.*;
import mx.com.actinver.ms.enums.VolatilityLevel;
import mx.com.actinver.ms.helpers.IGetFundsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetFundsHelper implements IGetFundsHelper {

	@Autowired
	private DetailFundsHelper detailFundsHelper;

	@Override
	public GetFundsRequestClientBean toRequest( GetFundsRequestBean requestBean) {
		GetFundsRequestClientBean requestClientBean = new GetFundsRequestClientBean();
		
		
		requestClientBean.setIsins(requestBean.getIsins());
		requestClientBean.setFirmNames(requestBean.getFirmNames());
		requestClientBean.setFundLegalNames(requestBean.getFundLegalNames());
		requestClientBean.setTickers(requestBean.getTickers());
	
		
	    requestClientBean.setWldCategories(requestBean.getWldCategories());
	    requestClientBean.setAnualPerform1Y(toCustomQueryAnualPerform1YClientBean(requestBean.getAnualPerform1Y()));
	    requestClientBean.setCommision(toCustomQueryCommisionClientBean(requestBean.getCommision()));
	    requestClientBean.setMxCategories(requestBean.getMxCategories());
	    requestClientBean.setHorizonTypes(requestBean.getHorizonTypes());
	    requestClientBean.setLiquidities(requestBean.getLiquidities());
	    requestClientBean.setStrategies(requestBean.getStrategies());
	    requestClientBean.setSectors(requestBean.getSectors());
	    requestClientBean.setCountries(requestBean.getCountries());
	    requestClientBean.setRegions(requestBean.getRegions());
	    requestClientBean.setStabilities(requestBean.getStabilities());
	    requestClientBean.setRaitings(requestBean.getRaitings());
		requestClientBean.setStyleboxes(requestBean.getStyleboxes());
	    requestClientBean.setOperators(requestBean.getOperators());
		requestClientBean.setFundTypes(requestBean.getFundTypes());
		requestClientBean.setOperatedMex(requestBean.getOperatedMex());
		requestClientBean.setEquityStylebox(requestBean.getEquityStylebox());
		requestClientBean.setFixedIncomeStylebox(requestBean.getFixedIncomeStylebox());
		requestClientBean.setVolatility(requestBean.getVolatility());

		return requestClientBean;
	}

	@Override
	public GetFundsResponseBean toResponse(GetFundsResponseClientBean responseClientBean) {
		GetFundsResponseBean responseBean = new GetFundsResponseBean();
		responseBean.setDetail(toListDetail(responseClientBean.getDetail()));
		return responseBean;
	}
	
	
	private CustomQueryAnualPerform1YClientBean toCustomQueryAnualPerform1YClientBean(CustomQueryAnualPerform1YBean anualPerform) {
		if(anualPerform == null)
			return null;
		CustomQueryAnualPerform1YClientBean clientBean = new CustomQueryAnualPerform1YClientBean(anualPerform.getMin(),anualPerform.getMax());
		return clientBean;
	}
	
	private CustomQueryCommisionClientBean toCustomQueryCommisionClientBean(CustomQueryCommisionBean commision) {
		if(commision == null)
			return null;
		CustomQueryCommisionClientBean clientBean = new CustomQueryCommisionClientBean(commision.getMin(),commision.getMax());
		return clientBean;
	}
	
	
	/**
	 * Response PART
	 */
	
	public List<DetailBean> toListDetail(List<DetailClientBean> listDetailBean) {

		if (listDetailBean != null && !listDetailBean.isEmpty()) {
			return listDetailBean.stream().map(this::toDetailClientBean).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public DetailBean toDetailClientBean(DetailClientBean clientBean) {
		DetailBean bean = new DetailBean();
		bean.setIsin(clientBean.getIsin());
		bean.setFundLegalName(clientBean.getFundLegalName());
		bean.setGlobalCategoryName(clientBean.getGlobalCategoryName());
		bean.setCategoryName(clientBean.getCategoryName());
		bean.setTicker(clientBean.getTicker());
		bean.setFirmName(clientBean.getFirmName());
		bean.setNetExpenseRatio(clientBean.getNetExpenseRatio());
		bean.setIndexFund(clientBean.getIndexFund());
		bean.setMinimumInitial(clientBean.getMinimumInitial());
		bean.setDebtsPercentage(clientBean.getDebtsPercentage());
		bean.setSharesPercentage(clientBean.getSharesPercentage());
		bean.setCashNet(clientBean.getCashNet());
		bean.setOtherNet(clientBean.getOtherNet());
		bean.setEffectiveDuration(clientBean.getEffectiveDuration());
		bean.setEquityStylebox(clientBean.getEquityStylebox());
		bean.setDayEndNav(clientBean.getDayEndNav());
		bean.setSectors(toListSectorBean(clientBean.getSectors()));
		bean.setCountryExposure(toListCountryExposure(clientBean.getCountryExposure()));
		bean.setRegionalExposure(toListRegionalExposure(clientBean.getRegionalExposure()));
		bean.setCategoryReturn1Day(clientBean.getCategoryReturn1Day());
		bean.setCategoryReturn1Week(clientBean.getCategoryReturn1Week());
		bean.setCategoryReturn1Mth(clientBean.getCategoryReturn1Mth());
		bean.setCategoryReturn3Mth(clientBean.getCategoryReturn3Mth());
		bean.setCategoryReturn6Mth(clientBean.getCategoryReturn6Mth());
		bean.setCategoryReturnYTD(clientBean.getCategoryReturnYTD());
		bean.setCategoryReturn1Yr(clientBean.getCategoryReturn1Yr());
		bean.setCategoryReturn3Yr(clientBean.getCategoryReturn3Yr());
		bean.setCategoryReturn5Yr(clientBean.getCategoryReturn5Yr());
		bean.setCategoryReturn10Yr(clientBean.getCategoryReturn10Yr());
		bean.setCategoryReturn15Yr(clientBean.getCategoryReturn15Yr());
		bean.setCategoryReturnTotal(clientBean.getCategoryReturnTotal());
		bean.setReturn1Day(clientBean.getReturn1Day());
		bean.setReturn1Week(clientBean.getReturn1Week());
		bean.setReturn1Mth(clientBean.getReturn1Mth());
		bean.setReturn3Mth(clientBean.getReturn3Mth());
		bean.setReturn6Mth(clientBean.getReturn6Mth());
		bean.setReturnYTD(clientBean.getReturnYTD());
		bean.setReturn1Yr(clientBean.getReturn1Yr());
		bean.setReturn3Yr(clientBean.getReturn3Yr());
		bean.setReturn5Yr(clientBean.getReturn5Yr());
		bean.setReturn10Yr(clientBean.getReturn10Yr());
		bean.setReturn15Yr(clientBean.getReturn15Yr());
		bean.setReturnSinceInception(clientBean.getReturnSinceInception());
		bean.setCumulativeReturn3Yr(clientBean.getCumulativeReturn3Yr());
		bean.setCumulativeReturn5Yr(clientBean.getCumulativeReturn5Yr());
		bean.setCumulativeReturn10Yr(clientBean.getCumulativeReturn10Yr());
		bean.setCumulativeReturn15Yr(clientBean.getCumulativeReturn15Yr());
		bean.setCumulativeReturnSinceInception(clientBean.getCumulativeReturnSinceInception());
		bean.setCategoryCumulativeReturn2Yr(clientBean.getCategoryCumulativeReturn2Yr());
		bean.setCategoryCumulativeReturn3Yr(clientBean.getCategoryCumulativeReturn3Yr());
		bean.setCategoryCumulativeReturn5Yr(clientBean.getCategoryCumulativeReturn5Yr());
		bean.setCategoryCumulativeReturn10Yr(clientBean.getCategoryCumulativeReturn10Yr());
		bean.setCategoryCumulativeReturn15Yr(clientBean.getCategoryCumulativeReturn15Yr());
		bean.setCategoryCumulativeReturnTotal(clientBean.getCategoryCumulativeReturnTotal());
		bean.setInstruments(toListInstruments(clientBean.getInstruments()));
		bean.setRatingOverall(clientBean.getRatingOverall());
		bean.setFundType(clientBean.getFundType());
		bean.setInceptionDate(clientBean.getInceptionDate());
		bean.setOperatedMex(clientBean.getOperatedMex());
		bean.setFixedIncomeStylebox(clientBean.getFixedIncomeStylebox());

		bean.setTotalMarketValueNet(clientBean.getTotalMarketValueNet());
		bean.setVolatibility(clientBean.getVolatibility());

		VolatilityLevel volatilityLevel = detailFundsHelper.calculateVolatility(clientBean.getVolatibility());
		String risk = detailFundsHelper.calculateRisk(volatilityLevel);
		String horizon = detailFundsHelper.getHorizon(clientBean.getIsin());

		bean.setVolatilityDesc(volatilityLevel.getLevel());
		bean.setRisk(risk);
		bean.setHorizon(horizon);

		bean.setCategoryYear1(clientBean.getCategoryYear1());
		bean.setCategoryYear2(clientBean.getCategoryYear2());
		bean.setCategoryYear3(clientBean.getCategoryYear3());
		bean.setCategoryYear4(clientBean.getCategoryYear4());
		bean.setCategoryYear5(clientBean.getCategoryYear5());
		bean.setCategoryYear6(clientBean.getCategoryYear6());
		bean.setCategoryYear7(clientBean.getCategoryYear7());
		bean.setCategoryYear8(clientBean.getCategoryYear8());
		bean.setCategoryYear9(clientBean.getCategoryYear9());
		bean.setCategoryYear10(clientBean.getCategoryYear10());

		bean.setYear1(clientBean.getYear1());
		bean.setYear2(clientBean.getYear2());
		bean.setYear3(clientBean.getYear3());
		bean.setYear4(clientBean.getYear4());
		bean.setYear5(clientBean.getYear5());
		bean.setYear6(clientBean.getYear6());
		bean.setYear7(clientBean.getYear7());
		bean.setYear8(clientBean.getYear8());
		bean.setYear9(clientBean.getYear9());
		bean.setYear10(clientBean.getYear10());
		bean.setFundNetAssets(clientBean.getFundNetAssets());

		return bean;
	}

	public List<SectorBean> toListSectorBean(List<SectorExposureClientBean> list) {

		if (list != null && !list.isEmpty()) {
			return list.stream().map(this::toSectorBean).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public SectorBean toSectorBean(SectorExposureClientBean clientBean) {

		SectorBean bean = new SectorBean();

		bean.setName(clientBean.getName());
		bean.setValue(clientBean.getValue());

		return bean;
	}

	public List<CountryExposureBean> toListCountryExposure(List<CountryExposureClientBean> listClientBean) {

		if (listClientBean != null && !listClientBean.isEmpty()) {
			return listClientBean.stream().map(this::toCountryExposure).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public CountryExposureBean toCountryExposure(CountryExposureClientBean clientBean) {

		CountryExposureBean bean = new CountryExposureBean();

		bean.setCountry(clientBean.getCountry());
		bean.setValue(clientBean.getValue());

		return bean;
	}

	public List<RegionalExposureBean> toListRegionalExposure(List<RegionalExposureClientBean> listClientBean) {

		if (listClientBean != null && !listClientBean.isEmpty()) {
			return listClientBean.stream().map(this::toRegionalExposure).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public RegionalExposureBean toRegionalExposure(RegionalExposureClientBean clientBean) {

		RegionalExposureBean bean = new RegionalExposureBean();
		bean.setRegion(clientBean.getRegion());
		bean.setValue(clientBean.getValue());
		return bean;
	}

	public List<InstrumentsBean> toListInstruments(List<InstrumentsExposureClientBean> list) {

		if (list != null && !list.isEmpty()) {
			return list.stream().map(this::toInstruments).collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	public InstrumentsBean toInstruments(InstrumentsExposureClientBean clientBean) {

		InstrumentsBean bean = new InstrumentsBean();
		bean.setIsinInstruments(clientBean.getIsinInstruments());
		bean.setName(clientBean.getName());
		bean.setWeighting(clientBean.getWeighting());
		bean.setPerformance(clientBean.getPerformance());
		bean.setCurrency(clientBean.getCurrency());
		bean.setCurrencyId(clientBean.getCurrencyId());
		bean.setTicker(clientBean.getTicker());
		bean.setHolding(clientBean.getHolding());

		return bean;
	}

}
