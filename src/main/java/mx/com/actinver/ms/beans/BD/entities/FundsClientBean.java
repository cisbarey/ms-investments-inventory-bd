package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funds")
public class FundsClientBean implements Serializable {

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

	@Column(name = "MINIMUM_AMOUNT", columnDefinition="Number(6)")
	private BigDecimal minimumInitial;

	// AAB-BondNet + AAB-PreferredNet

	@Column(name = "DEBTS_PERCENTAGE", columnDefinition="Number(3,5)")
	private BigDecimal debtsPercentage;

	// AAB-StockNet + AAB-ConvertibleNet

	@Column(name = "SHARES_PERCENTAGE", columnDefinition="Number(3,5)")
	private BigDecimal sharesPercentage;

	@Column(name = "CASH_PERCENTAGE", columnDefinition="Number(3,5)")
	private BigDecimal cashNet;

	@Column(name = "OTHER_PERCENTAGE", columnDefinition="Number(3,5)")
	private BigDecimal otherNet;

	@Column(name = "EFECTIVE_DURATION", columnDefinition="Number(2,5)")
	private BigDecimal effectiveDuration;

	@Column(name = "STYLEBOX", columnDefinition="Number(1)")
	private int equityStylebox;

	@Column(name = "LAST_PRICE", columnDefinition="NUMBER(4,5)")
	private BigDecimal dayEndNav;

	@Column(name = "CATEGORY_PERFORM_1D", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn1Day;

	@Column(name = "CATEGORY_PERFORM_1W", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn1Week;

	@Column(name = "CATEGORY_PERFORM_1M", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn1Mth;

	@Column(name = "CATEGORY_PERFORM_3M", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn3Mth;

	@Column(name = "CATEGORY_PERFORM_6M", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn6Mth;

	@Column(name = "CATEGORY_PERFORM_CURRENT_Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturnYTD;

	@Column(name = "CATEGORY_PERFORM_1Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn1Yr;

	@Column(name = "CATEGORY_PERFORM_3Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn3Yr;

	@Column(name = "CATEGORY_PERFORM_5Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn5Yr;

	@Column(name = "CATEGORY_PERFORM_10Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn10Yr;

	@Column(name = "CATEGORY_PERFORM_15Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturn15Yr;

	@Column(name = "CATEGORY_PERFORM_TOTAL", columnDefinition="Number(2,5)")
	private BigDecimal categoryReturnTotal;

	@Column(name = "ANNUAL_PERFORM_1D", columnDefinition="Number(2,5)")
	private BigDecimal return1Day;

	@Column(name = "ANNUAL_PERFORM_1W", columnDefinition="Number(2,5)")
	private BigDecimal return1Week;

	@Column(name = "ANNUAL_PERFORM_1M", columnDefinition="Number(2,5)")
	private BigDecimal return1Mth;

	@Column(name = "ANNUAL_PERFORM_3M", columnDefinition="Number(2,5)")
	private BigDecimal return3Mth;

	@Column(name = "ANNUAL_PERFORM_6M", columnDefinition="Number(2,5)")
	private BigDecimal return6Mth;

	@Column(name = "ANNUAL_PERFORM_CURRENT_Y", columnDefinition="Number(2,5)")
	private BigDecimal returnYTD;

	@Column(name = "ANNUAL_PERFORM_1Y", columnDefinition="Number(2,5)")
	private BigDecimal return1Yr;

	@Column(name = "ANNUAL_PERFORM_3Y", columnDefinition="Number(2,5)")
	private BigDecimal return3Yr;

	@Column(name = "ANNUAL_PERFORM_5Y", columnDefinition="Number(2,5)")
	private BigDecimal return5Yr;

	@Column(name = "ANNUAL_PERFORM_10Y", columnDefinition="Number(2,5)")
	private BigDecimal return10Yr;

	@Column(name = "ANNUAL_PERFORM_15Y", columnDefinition="Number(2,5)")
	private BigDecimal return15Yr;

	@Column(name = "ANNUAL_PERFORM_TOTAL", columnDefinition="Number(2,5)")
	private BigDecimal returnSinceInception;

	@Column(name = "CUMULATIVE_PERFORM_3Y", columnDefinition="Number(2,5)")
	private BigDecimal cumulativeReturn3Yr;

	@Column(name = "CUMULATIVE_PERFORM_5Y", columnDefinition="Number(2,5)")
	private BigDecimal cumulativeReturn5Yr;

	@Column(name = "CUMULATIVE_PERFORM_10Y", columnDefinition="Number(2,5)")
	private BigDecimal cumulativeReturn10Yr;

	@Column(name = "CUMULATIVE_PERFORM_15Y", columnDefinition="Number(2,5)")
	private BigDecimal cumulativeReturn15Yr;

	@Column(name = "CUMULATIVE_PERFORM_TOTAL", columnDefinition="Number(2,5)")
	private BigDecimal cumulativeReturnSinceInception;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_2Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturn2Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_3Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturn3Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_5Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturn5Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_10Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturn10Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_15Y", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturn15Yr;

	@Column(name = "CATEGORY_CUMULATIVE_PERFORM_TOTAL", columnDefinition="Number(2,5)")
	private BigDecimal categoryCumulativeReturnTotal;

	@Column(name = "RATING", columnDefinition="NUMBER(1)")
	private int ratingOverall;

	@Column(name = "CREATION_DATE")
	private String creationDate;

	@Column(name = "CREATION_USER")
	private String creationUser;
	
	@Column(name = "FUND_TYPE")
	private String fundType;

	@Column(name = "INCEPTION_DATE")
	private String inceptionDate;
	
	@Column(name = "OPERATED_MEX")
	private Integer operatedMex;
	
	@Column(name = "FIXED_INCOME_STYLEBOX",columnDefinition="NUMBER(1)")
	private Integer fixedIncomeStylebox;

	@Column(name = "TOTAL_MARKET_VALUE_NET", columnDefinition="NUMBER(4,5)")
	private BigInteger totalMarketValueNet;

	@Column(name = "VOLATILITY", columnDefinition="NUMBER(4,5)")
	private BigDecimal volatibility;

	@Column(name = "CATEGORY_YEAR_1", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear1;
	@Column(name = "CATEGORY_YEAR_2", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear2;
	@Column(name = "CATEGORY_YEAR_3", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear3;
	@Column(name = "CATEGORY_YEAR_4", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear4;
	@Column(name = "CATEGORY_YEAR_5", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear5;
	@Column(name = "CATEGORY_YEAR_6", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear6;
	@Column(name = "CATEGORY_YEAR_7", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear7;
	@Column(name = "CATEGORY_YEAR_8", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear8;
	@Column(name = "CATEGORY_YEAR_9", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear9;
	@Column(name = "CATEGORY_YEAR_10", columnDefinition="NUMBER(4,5)")
	private BigDecimal categoryYear10;

	//@Column(name = "CATEGORY_CUMULATIVE_PERFORM_TOTAL", columnDefinition="NUMBER(4,5)")
	//private BigDecimal categoryCumulativeSinceInception;

	@Column(name = "YEAR_1", columnDefinition="NUMBER(4,5)")
	private BigDecimal year1;
	@Column(name = "YEAR_2", columnDefinition="NUMBER(4,5)")
	private BigDecimal year2;
	@Column(name = "YEAR_3", columnDefinition="NUMBER(4,5)")
	private BigDecimal year3;
	@Column(name = "YEAR_4", columnDefinition="NUMBER(4,5)")
	private BigDecimal year4;
	@Column(name = "YEAR_5", columnDefinition="NUMBER(4,5)")
	private BigDecimal year5;
	@Column(name = "YEAR_6", columnDefinition="NUMBER(4,5)")
	private BigDecimal year6;
	@Column(name = "YEAR_7", columnDefinition="NUMBER(4,5)")
	private BigDecimal year7;
	@Column(name = "YEAR_8", columnDefinition="NUMBER(4,5)")
	private BigDecimal year8;
	@Column(name = "YEAR_9", columnDefinition="NUMBER(4,5)")
	private BigDecimal year9;
	@Column(name = "YEAR_10", columnDefinition="NUMBER(4,5)")
	private BigDecimal year10;
	@Column(name = "FUND_NET_ASSETS")
	public String fundNetAssets;
	
	@PrePersist
	void preInsert() {
		if (this.creationDate == null) {
			   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			   Date date = new Date(); 
		       this.creationDate = formatter.format(date);
		       this.creationUser = "INVESTMENTSINVENTORY";
	       return;
	   }
	}

}
