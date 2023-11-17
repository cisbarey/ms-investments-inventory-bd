package mx.com.actinver.ms.beans.insert;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoritesRequestBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Numero de contrato", example = "123456789")
	private String contractNumber;
	
	@Schema(description = "Emisora", example = "DIGITAL")
	private String issuer;
	
	@Schema(description = "Serie", example = "B-1")
	private String serie;
	
	@Schema(description = "Operaciona realizar", example = "I")
	private String operation;
	
	@Schema(description = "Lenguaje", example = "SPA")
	private String languaje;
	
}
