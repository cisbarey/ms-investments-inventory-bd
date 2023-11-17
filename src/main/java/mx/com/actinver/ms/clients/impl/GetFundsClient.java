package mx.com.actinver.ms.clients.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.*;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.BD.repositories.IHorizonRepository;
import mx.com.actinver.ms.beans.BD.repositories.ILiquidityRepository;
import mx.com.actinver.ms.clients.IGetFundsClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import mx.com.actinver.ms.helpers.impl.DetailFundsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GetFundsClient extends HttpHeadersConfig implements IGetFundsClient {

	@Autowired
    private IFundsRepository fundsRepository;
	
	@Autowired
	private IHorizonRepository horizonRepository;
	
	@Autowired
	private ILiquidityRepository liquidityRepository;

	@Autowired
	private DetailFundsHelper detailFundsHelper;

	@Override
	public GetFundsResponseClientBean getFunds(GetFundsRequestClientBean requestClientBean,Map<String,String> headers) {
		GetFundsResponseClientBean responseClientBean = new GetFundsResponseClientBean();
		
		//Recupera funds
		List<DetailClientBean> detailClient= fundsRepository.findAll();
		log.info("Searched with total {}", detailClient.size());
		
		//Filter by isins
		if(requestClientBean.getIsins() != null && !requestClientBean.getIsins().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getIsins().contains(fund.getIsin()))
					.collect(Collectors.toList());
		}

		//Filter by fundType
		if(requestClientBean.getFundTypes() != null && !requestClientBean.getFundTypes().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getFundTypes().contains(fund.getFundType()))
					.collect(Collectors.toList());
		}
		
		//Filter by firmNames
		if (requestClientBean.getFirmNames() != null && !requestClientBean.getFirmNames().isEmpty()) {
		    detailClient = detailClient
		            .stream()
		            .filter(fund -> {
		                for (String firmName : requestClientBean.getFirmNames()) {
		                    if (fund.getFirmName().toLowerCase().contains(firmName.toLowerCase())) {
		                        return true;
		                    }
		                }
		                return false;
		            })
		            .collect(Collectors.toList());
		}
		
		//Filter by fundLegalName
		if (requestClientBean.getFundLegalNames() != null && !requestClientBean.getFundLegalNames().isEmpty()) {
		    detailClient = detailClient
		            .stream()
		            .filter(fund -> {
		                for (String legalName : requestClientBean.getFundLegalNames()) {
		                    if (fund.getFundLegalName().toLowerCase().contains(legalName.toLowerCase())) {
		                        return true;
		                    }
		                }
		                return false;
		            })
		            .collect(Collectors.toList());
		}
		
		//Filter by tickers
		if (requestClientBean.getTickers() != null && !requestClientBean.getTickers().isEmpty()) {
		    detailClient = detailClient
		            .stream()
		            .filter(fund -> {
		                for (String ticker : requestClientBean.getTickers()) {
		                    if (fund.getTicker().toLowerCase().contains(ticker.toLowerCase())) {
		                        return true;
		                    }
		                }
		                return false;
		            })
		            .collect(Collectors.toList());
		}

		//Fillter by wldCategory 
		if(requestClientBean.getWldCategories() != null && !requestClientBean.getWldCategories().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getWldCategories().contains(fund.getCategoryName()))
					.collect(Collectors.toList());
			
		}
		
		//Fillter by anualPermor1Y
		if(requestClientBean.getAnualPerform1Y()!= null) {
			if(requestClientBean.getAnualPerform1Y().getMin()!=null) {
				detailClient = detailClient
				.stream()
				.filter(fund -> fund.getReturn1Yr().compareTo(requestClientBean.getAnualPerform1Y().getMin())>=0)
				.collect(Collectors.toList());
			}
			if(requestClientBean.getAnualPerform1Y().getMax()!=null) {
				detailClient = detailClient
				.stream()
				.filter(fund -> fund.getReturn1Yr().compareTo(requestClientBean.getAnualPerform1Y().getMax())<=0)
				.collect(Collectors.toList());
			}
			
		}
		//Fillter by commision
		if(requestClientBean.getCommision()!= null) {
			if(requestClientBean.getCommision().getMin()!=null) {
				detailClient = detailClient
				.stream()
				.filter(fund -> fund.getNetExpenseRatio().compareTo(requestClientBean.getCommision().getMin())>=0)
				.collect(Collectors.toList());
			}
			if(requestClientBean.getCommision().getMax()!=null) {
				detailClient = detailClient
				.stream()
				.filter(fund -> fund.getNetExpenseRatio().compareTo(requestClientBean.getCommision().getMax())<=0)
				.collect(Collectors.toList());
			}
			
		}
		
		//Fillter by mxCategory
		if(requestClientBean.getMxCategories() != null && !requestClientBean.getMxCategories().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getMxCategories().contains(fund.getCategoryName())
							|| requestClientBean.getMxCategories().contains(fund.getGlobalCategoryName()))
					.collect(Collectors.toList());
		}
		
		//Fillter by horizonType
		if(requestClientBean.getHorizonTypes()!= null) {
			List<HorizonClientBean> horizons =  horizonRepository.findByTypes(requestClientBean.getHorizonTypes());
			
			List<String> isinsHorizons = horizons
						.stream()
						//.filter(horizon -> requestClientBean.getHorizonType().contains(horizon.getType()))
						.map(horizon -> horizon.getIsin())
						.collect(Collectors.toList());
			
			if(isinsHorizons != null && !isinsHorizons.isEmpty()) {
				detailClient = detailClient
						.stream()
						.filter(fund -> isinsHorizons.contains(fund.getIsin()))
						.collect(Collectors.toList());
			}else {
				detailClient.clear();
			}
			
			
		}
		
		//Fillter by liquidity
		if(requestClientBean.getLiquidities()!= null && !requestClientBean.getLiquidities().isEmpty()) {
			
			List<LiquidityClientBean> liquidities = liquidityRepository.findByTypes(requestClientBean.getLiquidities());
			
			List<String> isinsLiquidities = liquidities
					.stream()
					.map(liquidity -> liquidity.getIsin())
					.collect(Collectors.toList());
			
			if(isinsLiquidities != null && !isinsLiquidities.isEmpty()) {
				detailClient = detailClient
						.stream()
						.filter(fund -> isinsLiquidities.contains(fund.getIsin()))
						.collect(Collectors.toList());
			}else {
				detailClient.clear();
			}
		}
		
		//Fillter by strategy
		if(requestClientBean.getStrategies()!= null && !requestClientBean.getStrategies().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getStrategies().contains(fund.getIndexFund()))
					.collect(Collectors.toList());
		}
		
		//Fillter by sectors
		if(requestClientBean.getSectors()!= null && !requestClientBean.getSectors().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> containsAny(requestClientBean.getSectors(),
								fund.getSectors()
								.stream()
								.map(s->s.getName())
								.collect(Collectors.toList())))
					.collect(Collectors.toList());
		}
		
		//Fillter by countries
		if(requestClientBean.getCountries()!= null && !requestClientBean.getCountries().isEmpty()) {			
			detailClient = detailClient
					.stream()
//					.filter(fund -> requestClientBean.getCountries().contains(
//								fund.getCountryExposure()
//								.stream()
//								.map(c->c.getCountry())
//								.collect(Collectors.toList())))
					.filter(fund -> containsAny(
								requestClientBean.getCountries(),
								fund.getCountryExposure().stream().map(c->c.getCountry()).collect(Collectors.toList())))
					.collect(Collectors.toList());
		}
		
		//Fillter by regions
		if(requestClientBean.getRegions()!= null && !requestClientBean.getRegions().isEmpty()) {			
			detailClient = detailClient
					.stream()
					.filter(fund -> containsAny(requestClientBean.getRegions(),
								fund.getRegionalExposure()
								.stream()
								.map(r->r.getRegion())
								.collect(Collectors.toList())))
					.collect(Collectors.toList());
		}
		
		//Fillter by stability
		/**
		 * TODO definir stability column/table
		 */
		if(requestClientBean.getStabilities()!= null && !requestClientBean.getStabilities().isEmpty()) {			
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getStabilities().contains(fund.getCategoryName()))
					.collect(Collectors.toList());
		}
		
		//Fillter by raiting
		if(requestClientBean.getRaitings()!= null && !requestClientBean.getRaitings().isEmpty()) {			
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getRaitings().contains(fund.getRatingOverall()))
					.collect(Collectors.toList());
		}
		
		//Fillter by stybox
		if(requestClientBean.getStyleboxes()!= null && !requestClientBean.getStyleboxes().isEmpty()) {			
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getStyleboxes().contains(fund.getEquityStylebox()))
					.collect(Collectors.toList());
		}
		
		//Fillter by operator
		if(requestClientBean.getOperators()!= null && !requestClientBean.getOperators().isEmpty()) {			
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getOperators().contains(fund.getFirmName() ))
					.collect(Collectors.toList());
		}

		//Fillter by equityStylebox
		if(requestClientBean.getEquityStylebox()!= null && !requestClientBean.getEquityStylebox().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getEquityStylebox().contains(fund.getEquityStylebox()))
					.collect(Collectors.toList());
		}

		//Fillter by fixedIncomeStylebox
		if(requestClientBean.getFixedIncomeStylebox()!= null && !requestClientBean.getFixedIncomeStylebox().isEmpty()) {
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getFixedIncomeStylebox().contains(fund.getFixedIncomeStylebox()))
					.collect(Collectors.toList());
		}

		if(requestClientBean.getVolatility() != null && !requestClientBean.getVolatility().isEmpty()){
			detailClient = detailClient
					.stream()
					.filter(fund -> requestClientBean.getVolatility().stream().anyMatch(volatility -> detailFundsHelper.checkVolatility(fund, volatility)))
					.collect(Collectors.toList());
		}



		if(detailClient == null || detailClient.isEmpty()) {
			throw new SuperMarketFundNotFoundException("Not found.",ErrorExceptions.NOT_FOUND);
		}
		
		responseClientBean.setDetail(detailClient);

		
		return responseClientBean;
	}
	
	private boolean containsAny(List<String> target, List<String> source) {
		for(String s: source) {
			if(target.contains(s))
				return true;
		}
		return false;
	}
	
}
