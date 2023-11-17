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
public class CustomQueryCommisionBean implements Serializable{

	private static final long serialVersionUID = -6513180956257376108L;
	
	@Schema(description = "Limite inferior para busqueda por comision",example = "1")
    private BigDecimal min;
	
	@Schema(description = "Limite superior para busqueda por comision",example = "20")
	private BigDecimal max;
}
