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
public class SectorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Porcentaje del fondo invertido en industria", example = "Basic Materials") 
    private String name;
	
	@Schema(description = "Valor", example = "1.32037") 
    private BigDecimal value;
}
