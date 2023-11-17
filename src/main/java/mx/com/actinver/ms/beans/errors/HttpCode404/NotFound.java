package mx.com.actinver.ms.beans.errors.HttpCode404;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "Resource is not available")
public class NotFound implements Serializable {

    @Schema(example = "INVESTMENTS_INVENTORY-BD-S", description = "App Code")
    private String appCode;

    @Schema(example = "Not found", description = "Description")
    private String messages;

    private ResultNotFound result;

}