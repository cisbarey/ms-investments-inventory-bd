package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Schema(name = "Bean que contiene datos de la liquidez")
public class RegisterLiquidityRequestBean implements Serializable {

    private static final long serialVersionUID = 5888235307556285548L;

    @Schema(description = "Identificador del instrumento de inversión.", example = "MX51LA060070")
    private String isin;

    @Schema(description = "Tipo de liquidez.", example = "24, 48 horas hábiles, Mensual, Trimestral, Anual, El mismo día")
    private String type;

    @Schema(description = "Fecha de creación.", example = "22/03/2023")
    private String creationDate;

    @Schema(description = "Usuario quien ingreso la información.", example = "API")
    private String creationUser;

    public RegisterLiquidityRequestBean() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.creationDate = currentDate.format(formatter);
        this.creationUser = "API";
    }

}
