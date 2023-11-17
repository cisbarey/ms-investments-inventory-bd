package mx.com.actinver.ms.beans.customers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Cliente a buscar")
public class CustomerGetRequestBean{
	
	@Schema(description = "Identificador de cliente", example = "MX52AC240016")
	private String customerId;
	
}
