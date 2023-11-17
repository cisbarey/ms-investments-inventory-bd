package mx.com.actinver.ms.beans.customers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de respuesta para creación de nuevo cliente")
public class CustomerResponseBean {

	private CustomerBean cusrtomer;
}
