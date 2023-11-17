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
public class RegionalExposureBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Región en el cual el fondo tiene exposición", example = "United States") 
    private String region;
	
	@Schema(description = "Porcentaje de la exposición del fondo en la región", example = "98.895917") 
    private BigDecimal value;
}
