package mx.com.actinver.ms.beans.client.metadata.mostWanted;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Schema(name = "Ejemplo de respuesta de las busquedas mas recientes")
public class QueryByMostWantedClientRequestBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Schema(description = "Fecha de registro")
    private String date;

	@Schema(description = "Fecha 30 dias atras")
	private String date30DaysAgo;

	@Schema(description = "Tipo de busqueda", example = "BY_SECTOR, BY_TYPE, MOST_WANTED, ETC")
	private String searchType;

	private List<String> isins;

	private Integer maxResults;

}