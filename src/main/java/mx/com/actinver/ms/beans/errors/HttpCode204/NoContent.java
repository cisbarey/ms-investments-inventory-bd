package mx.com.actinver.ms.beans.errors.HttpCode204;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "The result of the execution has not returned information")
public class NoContent implements Serializable {

    @Schema(example = "INVESTMENTS_INVENTORY-BD-S", description = "App Code")
    private String appCode;

    @Schema(example = "No content", description = "Description")
    private String messages;

    private ResultNoContent result;

}