package mx.com.actinver.ms.beans.BD.repositories;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFundsRepository extends JpaRepository<DetailClientBean,String>{
	
	DetailClientBean findByIsin(String isin);
	
	List<DetailClientBean> findByRegionalExposure_Region(String region);
	
	List<DetailClientBean> findByFundLegalName(String fundLegalName);
	
	List<DetailClientBean> findByFirmName(String firmName);

	List<DetailClientBean> findByTicker(String ticker);
	List<DetailClientBean> findByTickerAndIsinIsIn(String ticker, List<String> isin);

	List<DetailClientBean> findByEquityStylebox(int stylebox);

	List<DetailClientBean> findByCategoryName(String categoryName);
	
	List<DetailClientBean> findAllByOrderByFundLegalNameAsc();
	
	List<DetailClientBean> findAllByOrderByFundLegalNameDesc();
	
	List<DetailClientBean> findByRatingOverall(int rating);
	
	List<DetailClientBean> findByCountryExposure_Country(String country);
	
	List<DetailClientBean> findAllByOrderByReturn1DayDesc();
	
	List<DetailClientBean> findAllByOrderByNetExpenseRatioAsc();
	
	List<DetailClientBean> findByIndexFund(String strategy);
} 
