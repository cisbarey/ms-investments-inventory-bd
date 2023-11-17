package mx.com.actinver.ms.beans.queryKeyword;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de petición para el registro de una palabra clave")
public class QueryKeywordRequestBean implements Serializable {

    @NotNull
    @Schema(example = "Apple", description = "Estatus del registro")
    private String keyword;

}