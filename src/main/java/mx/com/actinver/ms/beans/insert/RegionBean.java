package mx.com.actinver.ms.beans.insert;

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
public class RegionBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Este identificador único ayudará a relacionar los datos entre el Front y el Back", example = "MX52AC240016")
	private String isin;
	
	@Schema(description = "Región en el cual el fondo tiene exposición", example = "United States") 
    private String region;
	
	@Schema(description = "Porcentaje de la exposición del fondo en la región", example = "98.895917") 
    private BigDecimal value;
}
