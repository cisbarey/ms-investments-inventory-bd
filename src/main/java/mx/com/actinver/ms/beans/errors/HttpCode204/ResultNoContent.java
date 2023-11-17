package mx.com.actinver.ms.beans.errors.HttpCode204;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "The result code and type for No Content")
public class ResultNoContent implements Serializable {

    @Schema(example = "INVSTINV-1001", description = "Result Code")
    private String resultCode;

    @Schema(example = "ERROR", description = "Result Type")
    private String resultType;

}