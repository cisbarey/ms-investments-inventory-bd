package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.actinver.ms.helpers.validation.Volatility;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFundsRequestBean implements Serializable{

	private static final long serialVersionUID = 8641206718701777217L;

	@Schema(description = "Tipo de fondo")
    private List<String>  wldCategories;
	
	@Schema(description = "Rendimiento anual")
    private CustomQueryAnualPerform1YBean anualPerform1Y;
	
	@Schema(description = "Comision")
    private CustomQueryCommisionBean commision;
	
	@Schema(description = "Categoria")
    private List<String> mxCategories;
	
	@Schema(description = "Plazo de inversión del fondo | Corto, Mediano, Largo",example = "Mediano")
    private List<String>  horizonTypes;
	
	@Schema(description = "Tiempo de liquidación",example = "<<Pendiente>>")
    private List<String>  liquidities;
	
	@Schema(description = "Estrategia",example = "0")
    private List<String> strategies;
	
	@Schema(description = "Sectores",example = "Infraestructura")
    private List<String>  sectors;
	
	@Schema(description = "País donde opera el fondo",example = "Mexico")
    private List<String>  countries;
	
	@Schema(description = "Regiones en las que invierte el fondo",example = "Mercados Emergentes")
    private List<String>  regions;
	
	@Schema(description = "Tipo de riesgo esperado para el fondo",example = "Conservador")
    private List<String>  stabilities;	
	
	@Schema(description = "Puntuación vigente en Morningstar",example = "5")
    private List<Integer> raitings;
    
	@Schema(description = "Configuraciones de las características del fondos",example = "2")
	private List<Integer> styleboxes;
	
	@Schema(description = "Nombre de la operadora del fondo",example = "Actinver")
    private List<String>  operators;
	
	@Schema(description = "Clave del fondo")
    private List<String>  isins;
	
	@Schema(description = "Institución financiera")
    private List<String>  firmNames;
	
	@Schema(description = "Razón social del fondo")
    private List<String>  fundLegalNames;
	
	@Schema(description = "Número de serie del fondo del fondo")
    private List<String>  tickers;

	@Schema(description = "Tipos de fondos",example = "Actinver")
	private List<String>  fundTypes;
	
	@Schema(description = "Fondos mas operados por MEX",example = "OperatedMex")
	private List<String>  operatedMex;

	@Schema(description = "Fondos mas operados por MEX",example = "equityStylebox")
	private List<Integer> equityStylebox;

	@Schema(description = "Fondos mas operados por MEX",example = "fixedIncomeStylebox")
	private List<Integer> fixedIncomeStylebox;

	@Schema(description = "Volatibilidades", example = "Volatilities")
	@Volatility
	private List<String> volatility;
	
}