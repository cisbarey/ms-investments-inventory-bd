package mx.com.actinver.ms.beans.errors.HttpCode401;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(name = "Failed in the authentication process")
public class AuthenticationFailed implements Serializable {

    @Schema(example = "INVESTMENTS_INVENTORY-BD-S", description = "App Code")
    private String appCode;

    @Schema(example = "Authentication failed", description = "Description")
    private String messages;

    private ResultAuthenticationFailed result;

}