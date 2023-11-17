package mx.com.actinver.ms.beans.query;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryExposureBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Pais en el cual el fondo tiene exposición", example = "Mexico") 
	private String country;
	
	@Schema(description = "Porcentaje de la exposición del fondo en el país", example = "80.84735")
	private BigDecimal value;
}
