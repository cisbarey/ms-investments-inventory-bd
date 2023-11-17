package mx.com.actinver.ms.beans.metadata.mostWanted;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.com.actinver.ms.beans.client.metadata.mostWanted.KeyCount;

import java.io.Serializable;
import java.util.List;

@Data
@Schema(name = "Ejemplo de respuesta de los instrumentos mas buscados")
public class QueryByMostWantedResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Lista de instrumentos mas buscados")
    private List<KeyCount> mostWanted;

}