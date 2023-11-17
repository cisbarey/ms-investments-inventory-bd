package mx.com.actinver.ms.beans.metadata.mostRecent;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Ejemplo de peticion de las busquedas mas recientes")
public class QueryByMostRecentRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Schema(description = "Tipo de busqueda")
    private String searchType;
	
	@Schema(description = "Numero de cliente")
	private String customerId;

	private List<String> isins;

}