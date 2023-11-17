package mx.com.actinver.ms.beans;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de respuesta del servicio de palabras clave")
public class MessageBean {
	
	 @Schema(example = "Success/Error", description = "Tipo de mensaje")
	    private String type;

	    @Schema(example = "Se elimino exitosamente la keyword", description = "Mensaje de exito de la eliminación")
	    private String message;

}
