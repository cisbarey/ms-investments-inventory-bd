package mx.com.actinver.ms.helpers.impl;

import mx.com.actinver.ms.beans.BD.entities.*;
import mx.com.actinver.ms.beans.query.*;
import mx.com.actinver.ms.helpers.IQueryByRegionHelper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryByRegionHelper implements IQueryByRegionHelper {

	@Override
	public QueryByRegionRequestClientBean toRequest(QueryByRegionRequestBean requestBean) {
		QueryByRegionRequestClientBean requestClientBean = new QueryByRegionRequestClientBean();
		requestClientBean.setRegion(requestBean.getRegion());
		return requestClientBean;
	}

	@Override
	public QueryByRegionResponseBean toResponse(QueryByRegionResponseClientBean responseClientBean, QueryByRegionRequestBean requestBean) {
		QueryByRegionResponseBean responseBean = new QueryByRegionResponseBean();
		responseBean.setDetail(toDetailClientBean(responseClientBean.getDetail(), requestBean));
		return responseBean;
	}


	public List<DetailBean> toDetailClientBean(List<DetailClientBean> clientBean, QueryByRegionRequestBean requestBean) {
		List<DetailBean> beans = new ArrayList<>();
		if (clientBean != null && !clientBean.isEmpty()) {
			for(int i = 0; i < clientBean.size(); i ++) {
				DetailBean bean = new DetailBean();
				bean.setIsin(clientBean.get(i).getIsin());
				bean.setFundLegalName(clientBean.get(i).getFundLegalName());
				bean.setGlobalCategoryName(clientBean.get(i).getGlobalCategoryName());
				bean.setCategoryName(clientBean.get(i).getCategoryName());
				bean.setTicker(clientBean.get(i).getTicker());
				bean.setFirmName(clientBean.get(i).getFirmName());
				bean.setNetExpenseRatio(clientBean.get(i).getNetExpenseRatio());
				bean.setIndexFund(clientBean.get(i).getIndexFund());
				bean.setMinimumInitial(clientBean.get(i).getMinimumInitial());
				bean.setDebtsPercentage(clientBean.get(i).getDebtsPercentage());
				bean.setSharesPercentage(clientBean.get(i).getSharesPercentage());
				bean.setCashNet(clientBean.get(i).getCashNet());
				bean.setOtherNet(clientBean.get(i).getOtherNet());
				bean.setEffectiveDuration(clientBean.get(i).getEffectiveDuration());
				bean.setEquityStylebox(clientBean.get(i).getEquityStylebox());
				bean.setDayEndNav(clientBean.get(i).getDayEndNav());
				bean.setSectors(toListSectorBean(clientBean.get(i).getSectors()));
				bean.setCountryExposure(toListCountryExposure(clientBean.get(i).getCountryExposure()));
				bean.setRegionalExposure(toListRegionalExposure(clientBean.get(i).getRegionalExposure(), requestBean));
				bean.setCategoryReturn1Day(clientBean.get(i).getCategoryReturn1Day());
				bean.setCategoryReturn1Week(clientBean.get(i).getCategoryReturn1Week());
				bean.setCategoryReturn1Mth(clientBean.get(i).getCategoryReturn1Mth());
				bean.setCategoryReturn3Mth(clientBean.get(i).getCategoryReturn3Mth());
				bean.setCategoryReturn6Mth(clientBean.get(i).getCategoryReturn6Mth());
				bean.setCategoryReturnYTD(clientBean.get(i).getCategoryReturnYTD());
				bean.setCategoryReturn1Yr(clientBean.get(i).getCategoryReturn1Yr());
				bean.setCategoryReturn3Yr(clientBean.get(i).getCategoryReturn3Yr());
				bean.setCategoryReturn5Yr(clientBean.get(i).getCategoryReturn5Yr());
				bean.setCategoryReturn10Yr(clientBean.get(i).getCategoryReturn10Yr());
				bean.setCategoryReturn15Yr(clientBean.get(i).getCategoryReturn15Yr());
				bean.setCategoryReturnTotal(clientBean.get(i).getCategoryReturnTotal());
				bean.setReturn1Day(clientBean.get(i).getReturn1Day());
				bean.setReturn1Week(clientBean.get(i).getReturn1Week());
				bean.setReturn1Mth(clientBean.get(i).getReturn1Mth());
				bean.setReturn3Mth(clientBean.get(i).getReturn3Mth());
				bean.setReturn6Mth(clientBean.get(i).getReturn6Mth());
				bean.setReturnYTD(clientBean.get(i).getReturnYTD());
				bean.setReturn1Yr(clientBean.get(i).getReturn1Yr());
				bean.setReturn3Yr(clientBean.get(i).getReturn3Yr());
				bean.setReturn5Yr(clientBean.get(i).getReturn5Yr());
				bean.setReturn10Yr(clientBean.get(i).getReturn10Yr());
				bean.setReturn15Yr(clientBean.get(i).getReturn15Yr());
				bean.setReturnSinceInception(clientBean.get(i).getReturnSinceInception());
				bean.setCumulativeReturn3Yr(clientBean.get(i).getCumulativeReturn3Yr());
				bean.setCumulativeReturn5Yr(clientBean.get(i).getCumulativeReturn5Yr());
				bean.setCumulativeReturn10Yr(clientBean.get(i).getCumulativeReturn10Yr());
				bean.setCumulativeReturn15Yr(clientBean.get(i).getCumulativeReturn5Yr());
				bean.setCumulativeReturnSinceInception(clientBean.get(i).getCumulativeReturnSinceInception());
				bean.setCategoryCumulativeReturn2Yr(clientBean.get(i).getCategoryCumulativeReturn2Yr());
				bean.setCategoryCumulativeReturn3Yr(clientBean.get(i).getCategoryCumulativeReturn3Yr());
				bean.setCategoryCumulativeReturn5Yr(clientBean.get(i).getCategoryCumulativeReturn5Yr());
				bean.setCategoryCumulativeReturn10Yr(clientBean.get(i).getCategoryCumulativeReturn10Yr());
				bean.setCategoryCumulativeReturn15Yr(clientBean.get(i).getCategoryCumulativeReturn15Yr());
				bean.setCategoryCumulativeReturnTotal(clientBean.get(i).getCategoryCumulativeReturnTotal());
				bean.setInstruments(toListInstruments(clientBean.get(i).getInstruments()));
				bean.setRatingOverall(clientBean.get(i).getRatingOverall());
				bean.setFundType(clientBean.get(i).getFundType());
				bean.setInceptionDate(clientBean.get(i).getInceptionDate());
				bean.setOperatedMex(clientBean.get(i).getOperatedMex());
				bean.setFixedIncomeStylebox(clientBean.get(i).getFixedIncomeStylebox());

				bean.setTotalMarketValueNet(clientBean.get(i).getTotalMarketValueNet());
				bean.setVolatibility(clientBean.get(i).getVolatibility());
				bean.setCategoryYear1(clientBean.get(i).getCategoryYear1());
				bean.setCategoryYear2(clientBean.get(i).getCategoryYear2());
				bean.setCategoryYear3(clientBean.get(i).getCategoryYear3());
				bean.setCategoryYear4(clientBean.get(i).getCategoryYear4());
				bean.setCategoryYear5(clientBean.get(i).getCategoryYear5());
				bean.setCategoryYear6(clientBean.get(i).getCategoryYear6());
				bean.setCategoryYear7(clientBean.get(i).getCategoryYear7());
				bean.setCategoryYear8(clientBean.get(i).getCategoryYear8());
				bean.setCategoryYear9(clientBean.get(i).getCategoryYear9());
				bean.setCategoryYear10(clientBean.get(i).getCategoryYear10());

				bean.setYear1(clientBean.get(i).getYear1());
				bean.setYear2(clientBean.get(i).getYear2());
				bean.setYear3(clientBean.get(i).getYear3());
				bean.setYear4(clientBean.get(i).getYear4());
				bean.setYear5(clientBean.get(i).getYear5());
				bean.setYear6(clientBean.get(i).getYear6());
				bean.setYear7(clientBean.get(i).getYear7());
				bean.setYear8(clientBean.get(i).getYear8());
				bean.setYear9(clientBean.get(i).getYear9());
				bean.setYear10(clientBean.get(i).getYear10());
				bean.setFundNetAssets(clientBean.get(i).getFundNetAssets());

				beans.add(bean);
			}
			return beans;
		}
		return new ArrayList<>();
		
	}

	public List<SectorBean> toListSectorBean(List<SectorExposureClientBean> listClientBean) {

		if (listClientBean != null && !listClientBean.isEmpty()) {
			return listClientBean.stream().map(this::toSectorBean).collect(Collectors.toList());
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

	public List<RegionalExposureBean> toListRegionalExposure(List<RegionalExposureClientBean> listClientBean, QueryByRegionRequestBean requestBean) {
		List<RegionalExposureBean> beans = new ArrayList<>();
		if (listClientBean != null && !listClientBean.isEmpty()) {
			for(int i = 0; i < listClientBean.size(); i ++) {
				RegionalExposureBean regionalExposureBean = new RegionalExposureBean();
				if((listClientBean.get(i).getRegion()).equals(requestBean.getRegion())) {
					regionalExposureBean.setRegion(listClientBean.get(i).getRegion());
					regionalExposureBean.setValue(listClientBean.get(i).getValue());
					beans.add(regionalExposureBean);
				}
			}
		}
		return beans;
	}

	public RegionalExposureBean toRegionalExposure(RegionalExposureClientBean clientBean) {

		RegionalExposureBean bean = new RegionalExposureBean();
		bean.setRegion(clientBean.getRegion());
		bean.setValue(clientBean.getValue());
		return bean;
	}

	public List<InstrumentsBean> toListInstruments(List<InstrumentsExposureClientBean> listClientBean) {

		if (listClientBean != null && !listClientBean.isEmpty()) {
			return listClientBean.stream().map(this::toInstruments).collect(Collectors.toList());
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
