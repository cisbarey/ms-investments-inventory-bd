package mx.com.actinver.ms.beans.errors.HttpCode412;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "The result code and type for Invalid InputParams")
public class ResultInvalidInputParams implements Serializable {

    @Schema(example = "INVSTINV-3002", description = "Result Code")
    private String resultCode;

    @Schema(example = "ERROR", description = "Result Type")
    private String resultType;

}