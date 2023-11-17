package mx.com.actinver.ms.beans.queryKeyword;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de respuesta del servicio de palabras clave")
public class QueryKeywordResponseBean implements Serializable {

    @NotNull
    @Schema(example = "Apple", description = "Estatus del registro")
    private String keyword;

    @NotNull
    @Schema(description = "Palabras relacionadas")
    private List<QueryKeyword> related;

    @Schema(example = "Success/Error", description = "Tipo de mensaje")
    private String type;

    @Schema(example = "Se registro exitosamente la keyword", description = "Mensaje de exito del registro")
    private String message;

}