package mx.com.actinver.ms.beans.errors.HttpCode412;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "The request to the service contains invalid data")
public class InvalidInputParams implements Serializable {

    @Schema(example = "INVESTMENTS_INVENTORY-BD-S", description = "App Code")
    private String appCode;

    @Schema(example = "Invalid input params", description = "Description")
    private String messages;

    private ResultInvalidInputParams result;

}