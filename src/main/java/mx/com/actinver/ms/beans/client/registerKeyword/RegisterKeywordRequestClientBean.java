package mx.com.actinver.ms.beans.client.registerKeyword;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.com.actinver.ms.beans.registerKeyword.RelatedKeyword;

@Data
@Schema(name = "Ejemplo de petición para el registro de una palabra clave")
public class RegisterKeywordRequestClientBean implements Serializable {

    @NotNull
    @Schema(example = "Apple", description = "Estatus del registro")
    private String keyword;

    @NotNull
    @Schema(description = "Palabras relacionadas")
    private List<RelatedKeyword> related;

    @NotNull
    @Schema(example = "Fernando", description = "Usuario que creo la keyword")
    private String creationUser;

    @NotNull
    @Schema(example = "01/03/2023", description = "Fecha de registro de la keyword")
    private String creationDate;

}