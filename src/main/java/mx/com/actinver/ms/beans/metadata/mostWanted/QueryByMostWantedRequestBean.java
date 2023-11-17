package mx.com.actinver.ms.beans.metadata.mostWanted;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Schema(name = "Ejemplo de peticion de los instrumentos mas buscados")
public class QueryByMostWantedRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "is required")
    @Schema(description = "Identificador unico del fondo", example = "MX52AC240016")
    private String searchType;

    private List<String> isins;

    private Integer maxResults;

}