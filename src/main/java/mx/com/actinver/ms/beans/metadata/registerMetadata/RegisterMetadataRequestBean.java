package mx.com.actinver.ms.beans.metadata.registerMetadata;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de petición para el registro de la metadata")
public class RegisterMetadataRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Schema(description = "LLave de identificación")
    private String key;

    @NotNull
    @Schema(description = "Tipo de busqueda", example = "MOST_WANTED, BY_SECTOR, BY_TYPE, ETC")
    private String searchType;
    
    @Schema(description = "Identificador unico del usuario", example = "97225015")
    private String customerId;

}