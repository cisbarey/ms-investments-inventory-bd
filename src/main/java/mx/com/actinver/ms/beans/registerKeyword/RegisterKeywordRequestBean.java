package mx.com.actinver.ms.beans.registerKeyword;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de petición para el registro de una palabra clave")
public class RegisterKeywordRequestBean implements Serializable {

    @NotNull
    @Schema(example = "Apple", description = "Estatus del registro")
    private String keyword;

    @NotNull
    @Schema(description = "Palabras relacionadas")
    private List<RelatedKeyword> related;

    @NotNull
    @Schema(example = "Fernando", description = "Usuario que creo la keyword")
    private String creationUser;

}