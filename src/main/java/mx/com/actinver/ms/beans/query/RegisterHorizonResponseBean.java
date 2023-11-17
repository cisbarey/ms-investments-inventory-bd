package mx.com.actinver.ms.beans.query;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterHorizonResponseBean implements Serializable{

	private static final long serialVersionUID = 937039808425900484L;
	
	@Schema(description = "Mensaje de confirmación", example="Success")
	private String message;

}
