package mx.com.actinver.ms.beans.customers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(name = "Cliente")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBean {

	@Schema(description = "Identificador de cliente", example = "MX52AC240016")
	private String customerId;
	@Schema(description = "Indicador de video", example = "TRUE | FALSE")
	private Boolean videoPreference;

	
}
