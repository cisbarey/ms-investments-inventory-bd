package mx.com.actinver.ms.beans.errors.HttpCode404;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "The result code and type for Not Found")
public class ResultNotFound implements Serializable {

    @Schema(example = "INVSTINV-3003", description = "Result Code")
    private String resultCode;

    @Schema(example = "ERROR", description = "Result Type")
    private String resultType;

}