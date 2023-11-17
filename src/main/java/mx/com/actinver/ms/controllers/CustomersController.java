package mx.com.actinver.ms.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.com.actinver.ms.beans.customers.CustomerCreateRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerGetRequestBean;
import mx.com.actinver.ms.beans.customers.CustomerResponseBean;
import mx.com.actinver.ms.beans.errors.HttpCode204.NoContent;
import mx.com.actinver.ms.beans.errors.HttpCode401.AuthenticationFailed;
import mx.com.actinver.ms.beans.errors.HttpCode404.NotFound;
import mx.com.actinver.ms.beans.errors.HttpCode412.InvalidInputParams;
import mx.com.actinver.ms.services.ICustomersService;
import mx.com.actinver.ms.utilities.IResponseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("${application.channel}${application.moduleOperation.customers}")
@Tag(name = "ms-investments-inventory-bd", description = "the user API")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CustomerResponseBean.class))
        }),
        @ApiResponse(responseCode = "204", description = "The result of the execution has not returned information", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NoContent.class))
        }),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(schema = @Schema(hidden = true))}),
        @ApiResponse(responseCode = "401", description = "Failed in the authentication process", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = AuthenticationFailed.class))
        }),
        @ApiResponse(responseCode = "404", description = "Resource is not available", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = NotFound.class))
        }),
        @ApiResponse(responseCode = "412", description = "Invalid input params", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InvalidInputParams.class))
        }), @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content(schema = @Schema(hidden = true))})
})
public class CustomersController {

    @Autowired
    private IResponseUtilities responseUtil;

    @Autowired
    private ICustomersService customersService;

    @Parameters(value = {
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Business", schema = @Schema(type = "string"), example = "802", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Channel", schema = @Schema(type = "string"), example = "901", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Latitude", schema = @Schema(type = "string"), example = "98.098", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Longitude", schema = @Schema(type = "string"), example = "17.5674", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Date-Request", schema = @Schema(type = "string"), example = "", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", schema = @Schema(type = "string"), example = "", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "Forwarded-For", schema = @Schema(type = "string"), example = "0.0.0.0", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-SessionId", schema = @Schema(type = "string"), example = "0.0.0.0")
    })
    @Operation(summary = "Inserta un cliente", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<CustomerResponseBean>> createDropRegister(@RequestBody @Valid CustomerCreateRequestBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(customersService.insert(requestBean, headers),
                "Successful Operation", "INVSTINV-2000"));
    }

    @Parameters(value = {
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Business", schema = @Schema(type = "string"), example = "802", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Channel", schema = @Schema(type = "string"), example = "901", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Latitude", schema = @Schema(type = "string"), example = "98.098", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Longitude", schema = @Schema(type = "string"), example = "17.5674", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-Date-Request", schema = @Schema(type = "string"), example = "", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", schema = @Schema(type = "string"), example = "", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "Forwarded-For", schema = @Schema(type = "string"), example = "0.0.0.0", required = true),
            @Parameter(in = ParameterIn.HEADER, name = "X-Actinver-SessionId", schema = @Schema(type = "string"), example = "0.0.0.0")
    })
    @Operation(summary = "Obtiene un cliente por identificador de cliente", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<CustomerResponseBean>> createDropRegister(@RequestBody @Valid CustomerGetRequestBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(customersService.get(requestBean, headers),
                "Successful Operation", "INVSTINV-2000"));
    }

}