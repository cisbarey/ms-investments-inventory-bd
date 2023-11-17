package mx.com.actinver.ms.beans.customers;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Nuevo cliente")
public class CustomerCreateRequestBean extends CustomerBean{
	
}
