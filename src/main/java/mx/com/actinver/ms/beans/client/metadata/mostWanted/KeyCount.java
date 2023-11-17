package mx.com.actinver.ms.beans.client.metadata.mostWanted;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;

@Data
@AllArgsConstructor
@Schema(name = "Consulta de los mas buscados")
public class KeyCount {

    private String key;

    private Long count;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Información ligado al fondo")
    private DetailClientBean detail;

}