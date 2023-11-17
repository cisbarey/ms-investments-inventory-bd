package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "Este identificador único ayudará a relacionar los datos entre el Front y el Back", example = "MX52AC240016")
	private String isin;

	@Schema(description = "Es la razón social del Fondo de Inversión", example = "Fondo Actinver Patrimonial 2030 SA de CV F.I.R.V.")
	private String fundLegalName;

	@Schema(description = "Es la categoría del Fondo de acuerdo a su estrategia de inversión global", example = "Target Date")
	private String globalCategoryName;

	@Schema(description = "Es la categoría del Fondo de acuerdo a su estrategia de inversión en México", example = "Lifecycle")
	private String categoryName;

	@Schema(description = "Clave de Pizarra + Serie del fondo", example = "ACT2030 B-1")
	private String ticker;

	@Schema(description = "Es la institución financiera que crea y administra el Fondo de Inversión o ETF", example = "Operadora Actinver SA de CV")
	private String firmName;

	@Schema(description = "Porcentaje que cobra al cliente el Fondo de Inversión o ETF por la gestión del dinero", example = "1.46007")
	private BigDecimal netExpenseRatio;

	@Schema(description = "Tipo de estrategia la cual indica si es activa o pasiva", example = "false")
	private String indexFund;

	@Schema(description = "Son los títulos mínimos que puede comprar el cliente del Fondo de Inversión o ETF", example = "1")
	private BigDecimal minimumInitial;

	// AAB-BondNet + AAB-PreferredNet
	@Schema(description = "Porcentaje del fondo invertido en deuda", example = "10")
	private BigDecimal debtsPercentage;

	// AAB-StockNet + AAB-ConvertibleNet
	@Schema(description = "Porcentaje del fondo invertido en acciones", example = "0")
	private BigDecimal sharesPercentage;

	@Schema(description = "Porcentaje del fondo invertido en dinero", example = "39.8215")
	private BigDecimal cashNet;

	@Schema(description = "Porcentaje del fondo invertido en otros rubros", example = "4.86391")
	private BigDecimal otherNet;

	@Schema(description = "Medida de riesgo y de tiempo a los inversionistas", example = "19.02689")
	private BigDecimal effectiveDuration;

	@Schema(description = "StyleBox Morningstar", example = "2")
	private int equityStylebox;

	@Schema(description = "Indica cuánto cuesta el Fondo de Inversión al día de hoy", example = "236.004783")
	private BigDecimal dayEndNav;

	@Schema(description = "Sectors")
	private List<SectorBean> sectors;

	@Schema(description = "CECountryExposureClientBean")
	private List<CountryExposureBean> countryExposure;

	@Schema(description = "RERegionalExposureClientBean")
	private List<RegionalExposureBean> regionalExposure;

	@Schema(description = "Rendimiento a 1 día.", example = "-0.91880")
	private BigDecimal categoryReturn1Day;

	@Schema(description = "Rendimiento a 1 semana.", example = "-1.60370")
	private BigDecimal categoryReturn1Week;

	@Schema(description = "Rendimiento a 1 mes.", example = "-1.94257")
	private BigDecimal categoryReturn1Mth;

	@Schema(description = "Rendimiento a 3 meses.", example = "0.90306")
	private BigDecimal categoryReturn3Mth;

	@Schema(description = "Rendimiento a 6 meses.", example = "-1.95377")
	private BigDecimal categoryReturn6Mth;

	@Schema(description = "Rendimiento durante el año.", example = "0.05433")
	private BigDecimal categoryReturnYTD;

	@Schema(description = "Rendimiento a 1 año.", example = "-4.12699")
	private BigDecimal categoryReturn1Yr;

	@Schema(description = "Rendimiento a 3 años.", example = "3.27337")
	private BigDecimal categoryReturn3Yr;

	@Schema(description = "Rendimiento a 5 años.", example = "4.01211")
	private BigDecimal categoryReturn5Yr;

	@Schema(description = "Rendimiento a 10 años.", example = "4.10820")
	private BigDecimal categoryReturn10Yr;

	@Schema(description = "Rendimiento a 15 años.", example = "5.30159")
	private BigDecimal categoryReturn15Yr;

	@Schema(description = "Rendimiento desde la creación.", example = "30.30159")
	private BigDecimal categoryReturnTotal;

	@Schema(description = "Rendimiento anual a 1 día.", example = "0.29025")
	private BigDecimal return1Day;

	@Schema(description = "Rendimiento anual a 1 semana.", example = "-2.38970")
	private BigDecimal return1Week;

	@Schema(description = "Rendimiento anual a 1 mes.", example = "-1.05751")
	private BigDecimal return1Mth;

	@Schema(description = "Rendimiento anual a 3 meses.", example = "4.97863")
	private BigDecimal return3Mth;

	@Schema(description = "Rendimiento anual a 6 meses.", example = "-4.24602")
	private BigDecimal return6Mth;

	@Schema(description = "Rendimiento anual durante el año.", example = "-0.01861")
	private BigDecimal returnYTD;

	@Schema(description = "Rendimiento a 1 año", example = "-5.19884")
	private BigDecimal return1Yr;

	@Schema(description = "Rendimiento a 3 años", example = "-5.19884")
	private BigDecimal return3Yr;

	@Schema(description = "Rendimiento a 5 años", example = "-5.19884")
	private BigDecimal return5Yr;

	@Schema(description = "Rendimiento a 10 años", example = "-5.19884")
	private BigDecimal return10Yr;

	@Schema(description = "Rendimiento a 15 años", example = "-5.19884")
	private BigDecimal return15Yr;

	@Schema(description = "Rendimiento desde la creación", example = "-4.42348")
	private BigDecimal returnSinceInception;

	@Schema(description = "Rendimiento a 3 años", example = "6.00249")
	private BigDecimal cumulativeReturn3Yr;

	@Schema(description = "Rendimiento a 5 años", example = "-16.06143")
	private BigDecimal cumulativeReturn5Yr;

	@Schema(description = "Rendimiento a 10 años", example = "-15.71525")
	private BigDecimal cumulativeReturn10Yr;

	@Schema(description = "Rendimiento a 15 años", example = "23.57973")
	private BigDecimal cumulativeReturn15Yr;

	@Schema(description = "Rendimiento desde la creación.", example = "50.03456")
	private BigDecimal cumulativeReturnSinceInception;

	@Schema(description = "Rendimiento a 2 años", example = "12.88153")
	private BigDecimal categoryCumulativeReturn2Yr;

	@Schema(description = "Rendimiento a 3 años", example = "12.88153")
	private BigDecimal categoryCumulativeReturn3Yr;

	@Schema(description = "Rendimiento a 5 años", example = "21.99484")
	private BigDecimal categoryCumulativeReturn5Yr;

	@Schema(description = "Rendimiento a 10 años", example = "51.70742")
	private BigDecimal categoryCumulativeReturn10Yr;

	@Schema(description = "Rendimiento a 15 años", example = "51.70742")
	private BigDecimal categoryCumulativeReturn15Yr;

	@Schema(description = "Rendimiento desde la creación.", example = "32708345")
	private BigDecimal categoryCumulativeReturnTotal;

	@Schema(description = "Intrumentos.")
	private List<InstrumentsBean> instruments;
	
	@Schema(description = "Horizonte de vencimiento")
	private String horizon;

	@Schema(description = "Calificación que Morningstar otorga a los Fondos de Inversión o ETFs.", example = "5")
	private int ratingOverall;
	
	@Schema(description = "Tipo de estrategia la cual indica si es activa o pasiva", example = "false")
	private String fundType;

	@Schema(description = "Fecha de inicio del fondo", example = "15/07/2022")
	private String inceptionDate;
	
	@Schema(description = "Fondos mas operados por MEX", example = "OperatedMex")
	private BigDecimal operatedMex;
	
	@Schema(description = "Obtiene el dato de Deuda ", example = "1")
	private int fixedIncomeStylebox;

	@Schema(description = "Valor de mercado total neto", example = "3123213")
	private BigInteger totalMarketValueNet;

	@Schema(description = "Volatibilidad", example = "1")
	private BigDecimal volatibility;

	private String volatilityDesc;

	@Schema(description = "Riesgo", example = "1")
	private String risk;

	@Schema(description = "Categoria 1 año", example = "1")
	private BigDecimal categoryYear1;
	@Schema(description = "Categoria 2 año", example = "1")
	private BigDecimal categoryYear2;
	@Schema(description = "Categoria 3 año", example = "1")
	private BigDecimal categoryYear3;
	@Schema(description = "Categoria 4 año", example = "1")
	private BigDecimal categoryYear4;
	@Schema(description = "Categoria 5 año", example = "1")
	private BigDecimal categoryYear5;
	@Schema(description = "Categoria 6 año", example = "1")
	private BigDecimal categoryYear6;
	@Schema(description = "Categoria 7 año", example = "1")
	private BigDecimal categoryYear7;
	@Schema(description = "Categoria 8 año", example = "1")
	private BigDecimal categoryYear8;
	@Schema(description = "Categoria 9 año", example = "1")
	private BigDecimal categoryYear9;
	@Schema(description = "Categoria 10 año", example = "1")
	private BigDecimal categoryYear10;

	//@Schema(description = "Rendimiento acumulado categoria")
	//private BigDecimal categoryCumulativeSinceInception;

	@Schema(description = "1 año", example = "1")
	private BigDecimal year1;
	@Schema(description = "2 año", example = "1")
	private BigDecimal year2;
	@Schema(description = "3 año", example = "1")
	private BigDecimal year3;
	@Schema(description = "4 año", example = "1")
	private BigDecimal year4;
	@Schema(description = "5 año", example = "1")
	private BigDecimal year5;
	@Schema(description = "6 año", example = "1")
	private BigDecimal year6;
	@Schema(description = "7 año", example = "1")
	private BigDecimal year7;
	@Schema(description = "8 año", example = "1")
	private BigDecimal year8;
	@Schema(description = "9 año", example = "1")
	private BigDecimal year9;
	@Schema(description = "10 año", example = "1")
	private BigDecimal year10;
	@Schema(description = "Cantidad de dinero que tiene el fondo bajo administracion", example = "123124")
	private String fundNetAssets;
}