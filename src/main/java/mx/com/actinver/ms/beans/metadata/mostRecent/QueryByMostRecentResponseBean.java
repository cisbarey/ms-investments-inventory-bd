package mx.com.actinver.ms.beans.metadata.mostRecent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Schema(name = "Ejemplo de respuesta de las busquedas mas recientes")
public class QueryByMostRecentResponseBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Schema(description = "Lista de instrumentos mas recientes")
    private List<MostRecent> mostRecent;

}