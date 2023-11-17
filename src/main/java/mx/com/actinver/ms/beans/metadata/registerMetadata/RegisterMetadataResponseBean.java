package mx.com.actinver.ms.beans.metadata.registerMetadata;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de respuesta del servicio de registro de metadata")
public class RegisterMetadataResponseBean implements Serializable {

    @Schema(example = "Success/Error", description = "Tipo de mensaje")
    private String type;

    @Schema(example = "Se registro exitosamente la keyword", description = "Mensaje de exito del registro")
    private String message;

}