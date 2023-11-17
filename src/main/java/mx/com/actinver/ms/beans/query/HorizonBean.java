package mx.com.actinver.ms.beans.query;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HorizonBean implements Serializable {

	private static final long serialVersionUID = -5580198374070208490L;
	
	@Schema(description = "Plazo de inversión del instrumento", example = "Largo plazo")
	private String type;
}
