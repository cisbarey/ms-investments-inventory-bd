package mx.com.actinver.ms.beans.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class RegisterLiquidityResponseBean implements Serializable {

    private static final long serialVersionUID = 937039808425900484L;

    @Schema(description = "Mensaje de confirmación", example = "Success")
    private String message;

}