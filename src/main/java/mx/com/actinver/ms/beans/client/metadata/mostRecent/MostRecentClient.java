package mx.com.actinver.ms.beans.client.metadata.mostRecent;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de respuesta de las busquedas mas recientes")
public class MostRecentClient implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "LLave")
    private String key;

	@Schema(description = "Fecha de creacion")
	private String creationDate;

}