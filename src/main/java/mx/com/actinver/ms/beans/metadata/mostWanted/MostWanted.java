package mx.com.actinver.ms.beans.metadata.mostWanted;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "Ejemplo de respuesta de los instrumentos mas buscados")
public class MostWanted implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Schema(description = "LLave")
    private String key;

	@Schema(description = "Numero de veces que se consulto cada instrumento")
	private long count;

}