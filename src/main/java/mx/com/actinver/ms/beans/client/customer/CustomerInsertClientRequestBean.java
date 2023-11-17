package mx.com.actinver.ms.beans.client.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de peticion para creación de nuevo cliente")
public class CustomerInsertClientRequestBean {
	
	private String customerId;
	private Boolean videoPreference;

}
