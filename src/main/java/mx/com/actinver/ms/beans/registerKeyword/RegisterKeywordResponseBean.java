package mx.com.actinver.ms.beans.registerKeyword;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de respuesta del servicio de palabras clave")
public class RegisterKeywordResponseBean implements Serializable {

    @Schema(example = "Success/Error", description = "Tipo de mensaje")
    private String type;

    @Schema(example = "Se registro exitosamente la keyword", description = "Mensaje de exito del registro")
    private String message;

}