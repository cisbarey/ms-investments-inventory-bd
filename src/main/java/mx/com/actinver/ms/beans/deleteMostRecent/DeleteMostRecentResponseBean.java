package mx.com.actinver.ms.beans.deleteMostRecent;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de respuesta del servicio")
public class DeleteMostRecentResponseBean implements Serializable {
	
	private static final long serialVersionUID = -8840697075631444957L;
	
	@Schema(example = "Success/Error", description = "Tipo de mensaje")
    private String type;

    @Schema(example = "Se elimino exitosamente la palabra clave", description = "Mensaje de exito de la eliminación")
    private String message;
	
}
