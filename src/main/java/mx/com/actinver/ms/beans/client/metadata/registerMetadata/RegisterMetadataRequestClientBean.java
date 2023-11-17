package mx.com.actinver.ms.beans.client.metadata.registerMetadata;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de petición para el registro de la metadata")
public class RegisterMetadataRequestClientBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "LLave de identificación")
    private String key;

    @Schema(description = "Tipo de busqueda", example = "MOST_WANTED, BY_SECTOR, BY_TYPE, ETC")
    private String searchType;

    @NotNull
    @Schema(example = "Fernando", description = "Usuario que creo la keyword")
    private String creationUser;

    @NotNull
    @Schema(example = "01/03/2023", description = "Fecha de registro de la keyword")
    private String creationDate;

}