package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funds")
public class DetailClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ISIN_FUND")
	private String isin;

	@Column(name = "FUND_NAME")
	private String fundLegalName;

	@Column(name = "WLD_CATEGORY")
	private String globalCategoryName;

	@Column(name = "MX_CATEGORY")
	private String categoryName;

	@Column(name = "SERIE_KEY")
	private String ticker;

	@Column(name = "OPERATOR")
	private String firmName;

	@Column(name = "COMMISION")
	private BigDecimal netExpenseRatio;

	@Column(name = "STRATEGY_TYPE")
	private String indexFund;

	@Column(name = "MINIMUM_AMOUNT")
	private BigDecimal minimumInitial;

	// AAB-BondNet + AAB-PreferredNet

	@Column(name = "DEBTS_PERCENTAGE")
	private BigDecimal debtsPercentage;

	// AAB-StockNet + AAB-ConvertibleNet

	@Column(name = "SHARES_PERCENTAGE")
	private BigDecimal sharesPercentage;

	@Column(name = "CASH_PERCENTAGE")
	private BigDecimal cashNet;

	@Column(name = "OTHER_PERCENTAGE")
	private BigDecimal otherNet;

	@Column(name = "EFECTIVE_DURATION")
	private BigDecimal effectiveDuration;

	@Column(name = "STYLEBOX")
	private int equityStylebox;

	@Column(name = "LAST_PRICE")
	private BigDecimal dayEndNav;

	@OneToMany(mappedBy = "detailClientBean", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<CountryExposureClientBean> countryExposure;

	@OneToMany(mappedBy = "detailClientBean", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<SectorExposureClientBean> sectors;

	@OneToMany(mappedBy = "detailClientBean", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<RegionalExposureClientBean> regionalExposure;

	@Column(name = "CATEGORY_PERFORM_1D")
	private BigDecimal categoryReturn1Day;

	@Column(name = "CATEGORY_PERFORM_1W")
	private BigDecimal categoryReturn1Week;

	@Column(name = "CATEGORY_PERFORM_1M")
	private BigDecimal categoryReturn1Mth;

	@Column(name = "CATEGORY_PERFORM_3M")
	private BigDecimal categoryReturn3Mth;

	@Column(name = "CATEGORY_PERFORM_6M")
	private BigDecimal categoryReturn6Mth;

	@Column(name = "CATEGORY_PERFORM_CURRENT_Y")
	private BigDecimal categoryReturnYTD;

	@Column(name = "CATEGORY_PERFORM_1Y")
	private BigDecimal categoryReturn1Yr;

	@Column(name = "CATEGORY_PERFORM_3Y")
	private BigDecimal categoryReturn3Yr;

	@Column(name = "CATEGORY_PERFORM_5Y")
	private BigDecimal categoryReturn5Yr;

	@Column(name = "CATEGORY_PERFORM_10Y")
	private BigDecimal categoryReturn10Yr;

	@Column(name = "CATEGORY_PERFORM_15Y")
	private BigDecimal categoryReturn15Yr;

	@Column(name = "CATEGORY_PERFORM_TOTAL")
	private BigDecimal categoryReturnTotal;

	@Column(name = "ANNUAL_PERFORM_1D")
	private BigDecimal return1Day;

	@Column(name = "ANNUAL_PERFORM_1W")
	private BigDecimal return1Week;

	@Column(name = "ANNUAL_PERFORM_1M")
	private BigDecimal return1Mth;

	@Column(name = "ANNUAL_PERFORM_3M")
	private BigDecimal return3Mth;

	@Column(name = "ANNUAL_PERFORM_6M")
	private BigDecimal return6Mth;

	@Column(name = "ANNUAL_PERFORM_CURRENT_Y")
	private BigDecimal returnYTD;

	@Column(name = "ANNUAL_PERFORM_1Y")
	private BigDecimal return1Yr;

	@Column(name = "ANNUAL_PERFORM_3Y")
	private BigDecimal return3Yr;

	@Column(name = "ANNUAL_PERFORM_5Y")
	private BigDecimal return5Yr;

	@Column(name = "ANNUAL_PERFORM_10Y")
	private BigDecimal return10Yr;

	@Column(name = "ANNUAL_PERFORM_15Y")
	private BigDecimal return15Yr;

	@Column(name = "ANNUAL_PERFORM_TOTAL")
	private BigDecimal returnSinceInception;

	@Column(name = "CUMULATIVE_PERFORM_3Y")
	private BigDecimal cumulativeReturn3Yr;

	@Column(name = "CUMULATIVE_PERFORM_5Y")
	private BigDecimal cumulativeReturn5Yr;

	@Column(name = "CUMULATIVE_PERFORM_10Y")
	private BigDecimal cumulativeReturn10Yr;

	@Column(name = "CUMULATIVE_PERFORM_15Y")
	private BigDecimal cumulativeReturn15Yr;

	@Column(name = "CUMULATIVE_PERFORM_TOTAL")
	private BigDecimal cumulativeReturnSinceInception;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_2Y")
	private BigDecimal categoryCumulativeReturn2Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_3Y")
	private BigDecimal categoryCumulativeReturn3Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_5Y")
	private BigDecimal categoryCumulativeReturn5Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_10Y")
	private BigDecimal categoryCumulativeReturn10Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_15Y")
	private BigDecimal categoryCumulativeReturn15Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_TOTAL")
	private BigDecimal categoryCumulativeReturnTotal;

	@OneToMany(mappedBy = "detailClientBean", cascade = { CascadeType.ALL })
	private List<InstrumentsExposureClientBean> instruments;

	@Column(name = "RATING")
	private int ratingOverall;
	
	@Column(name = "FUND_TYPE")
	private String fundType;

	@Column(name = "CREATION_DATE")
	private String creationDate;

	@Column(name = "CREATION_USER")
	private String creationUser;

	@Column(name = "INCEPTION_DATE")
	private String inceptionDate;
	
	@Column(name = "OPERATED_MEX")
	private BigDecimal operatedMex;
	
	@Column(name = "FIXED_INCOME_STYLEBOX")
	private int fixedIncomeStylebox;

	@Column(name = "TOTAL_MARKET_VALUE_NET")
	private BigInteger totalMarketValueNet;

	@Column(name = "VOLATILITY")
	private BigDecimal volatibility;

	@Column(name = "CATEGORY_YEAR_1")
	private BigDecimal categoryYear1;
	@Column(name = "CATEGORY_YEAR_2")
	private BigDecimal categoryYear2;
	@Column(name = "CATEGORY_YEAR_3")
	private BigDecimal categoryYear3;
	@Column(name = "CATEGORY_YEAR_4")
	private BigDecimal categoryYear4;
	@Column(name = "CATEGORY_YEAR_5")
	private BigDecimal categoryYear5;
	@Column(name = "CATEGORY_YEAR_6")
	private BigDecimal categoryYear6;
	@Column(name = "CATEGORY_YEAR_7")
	private BigDecimal categoryYear7;
	@Column(name = "CATEGORY_YEAR_8")
	private BigDecimal categoryYear8;
	@Column(name = "CATEGORY_YEAR_9")
	private BigDecimal categoryYear9;
	@Column(name = "CATEGORY_YEAR_10")
	private BigDecimal categoryYear10;

	//@Column(name = "CATEGORY_CUMULATIVE_PERFORM_TOTAL")
	//private BigDecimal categoryCumulativeSinceInception;

	@Column(name = "YEAR_1")
	private BigDecimal year1;
	@Column(name = "YEAR_2")
	private BigDecimal year2;
	@Column(name = "YEAR_3")
	private BigDecimal year3;
	@Column(name = "YEAR_4")
	private BigDecimal year4;
	@Column(name = "YEAR_5")
	private BigDecimal year5;
	@Column(name = "YEAR_6")
	private BigDecimal year6;
	@Column(name = "YEAR_7")
	private BigDecimal year7;
	@Column(name = "YEAR_8")
	private BigDecimal year8;
	@Column(name = "YEAR_9")
	private BigDecimal year9;
	@Column(name = "YEAR_10")
	private BigDecimal year10;
	@Column(name = "FUND_NET_ASSETS")
	public String fundNetAssets;

}