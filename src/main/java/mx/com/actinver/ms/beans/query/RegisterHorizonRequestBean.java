package mx.com.actinver.ms.beans.query;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Bean que contiene datos del horizonte")
public class RegisterHorizonRequestBean implements Serializable {

	private static final long serialVersionUID = 5888235307556285548L;

	@Schema(description = "Identificador del instrumento de inversión.",example="MX51LA060070")
	private String isin;

	@Schema(description = "Tipo de horizonte.",example="CORTO PLAZO")
	private String type;

	@Schema(description = "Fecha de creación.",example = "22/03/2023")
	private String creationDate;

	@Schema(description = "Usuario quien ingreso la información.",example="API")
	private String creationUser;

	public RegisterHorizonRequestBean() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.creationDate = currentDate.format(formatter);

		this.creationUser = "API";
	}

}
