package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Identificador de instrumento", example = "MX0SGO0000H6")
	private String isinInstruments;
	
	@Schema(description = "Razón social del instrumento", example = "Gob de Mexico UDIBONO 4% 03/11/50")
	private String name;
	
	@Schema(description = "Proporción que el instrumento ocupa en el Fondo o ETF.", example = "55.27311")
	private BigDecimal weighting;
	
	@Schema(description = "Rendimiento de los instrumentos del año a la fecha", example = "0")
	private BigDecimal performance;
	
	@Schema(description = "Moneda", example = "Mexican Peso")
	private String currency;
	
	@Schema(description = "Identificador de moneda", example = "MXN")
	private String currencyId;

	@Schema(description = "Ticker", example = "SU")
	private String ticker;

	@Schema(description = "HoldingYTDReturn", example = "17.22766")
	private BigDecimal holding;

}
