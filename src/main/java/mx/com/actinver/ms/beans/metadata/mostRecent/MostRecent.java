package mx.com.actinver.ms.beans.metadata.mostRecent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;

import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de respuesta de las busquedas mas recientes")
public class MostRecent implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "Id")
	private String metadataId;
	
	@Schema(description = "LLave")
    private String key;

	@Schema(description = "Fecha de creacion")
	private String creationDate;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Schema(description = "Información ligado al fondo")
	private DetailClientBean detail;

}