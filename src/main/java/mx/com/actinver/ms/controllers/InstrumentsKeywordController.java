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
import mx.com.actinver.ms.beans.deleteKeyword.DeleteKeywordResponseBean;
import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentRequestBean;
import mx.com.actinver.ms.beans.deleteMostRecent.DeleteMostRecentResponseBean;
import mx.com.actinver.ms.beans.errors.HttpCode204.NoContent;
import mx.com.actinver.ms.beans.errors.HttpCode401.AuthenticationFailed;
import mx.com.actinver.ms.beans.errors.HttpCode404.NotFound;
import mx.com.actinver.ms.beans.errors.HttpCode412.InvalidInputParams;
import mx.com.actinver.ms.beans.insert.InstrumentsBean;
import mx.com.actinver.ms.beans.insert.SectorBean;
import mx.com.actinver.ms.beans.insert.*;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentRequestBean;
import mx.com.actinver.ms.beans.metadata.mostRecent.QueryByMostRecentResponseBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedRequestBean;
import mx.com.actinver.ms.beans.metadata.mostWanted.QueryByMostWantedResponseBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;
import mx.com.actinver.ms.beans.query.*;
import mx.com.actinver.ms.beans.queryKeyword.QueryKeywordResponseBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordRequestBean;
import mx.com.actinver.ms.beans.registerKeyword.RegisterKeywordResponseBean;
import mx.com.actinver.ms.beans.sectors.QuerySectorsResponseBean;
import mx.com.actinver.ms.services.*;
import mx.com.actinver.ms.utilities.IResponseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${application.channel}${application.moduleOperation.investmentsInventoryInstruments}")
@Tag(name = "ms-investments-inventory-bd", description = "the user API")
@ApiResponses(value = {
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
public class InstrumentsKeywordController {

    @Autowired
    private IRegisterKeywordService registerKeywordService;

    @Autowired
    private IQueryKeywordService queryKeywordService;

    @Autowired
    private IDeleteKeywordService deleteKeywordService;

    @Autowired
    private IResponseUtilities responseUtil;

    @Autowired
    private IQueryByRegionService queryByRegionService;

    @Autowired
    private IInsertFundService insertFundService;

    @Autowired
    private IInsertRegionService insertRegionService;

    @Autowired
    private IInsertCountryService insertCountryService;

    @Autowired
    private IInsertInstrumentService insertInstrumentService;

    @Autowired
    private IInsertSectorService insertSectorService;

    @Autowired
    private IQueryByTickerService byTickerService;

    @Autowired
    private IRegisterHorizonService horizonService;

    @Autowired
    private IQueryHorizonService queryHorizonService;

    @Autowired
    private IQueryByMostRecentService queryByMostRecentService;

    @Autowired
    private IQueryByMostWantedService queryByMostWantedService;

    @Autowired
    private IRegisterMetadataService registerMetadataService;

    @Autowired
    private IGetFundsService getFundsService;

    @Autowired
    private IQuerySectorsService querySectorsService;

    @Autowired
    private IRegisterLiquidityService liquidityService;

    @Autowired
    private IQueryLiquidityService queryliquidityService;

    @Autowired
    private IDeleteMostRecentService deleteMostRecentService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegisterKeywordResponseBean.class))
            })
    })
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
    @Operation(summary = "Registro de palabras clave", tags = {"Registering keyword"})
    @PostMapping(value = "keyword", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegisterKeywordResponseBean>> createRegister(@RequestBody @Valid RegisterKeywordRequestBean registerKeywordRequestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(registerKeywordService.registerKeyword(registerKeywordRequestBean), "Success registering keyword", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryKeywordResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta de palabras clave", tags = {"Query keyword"})
    @GetMapping(value = "{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryKeywordResponseBean>> queryKeyword(@PathVariable("keyword") String keyword) {
        return Mono.just(responseUtil.successResponseEntity(queryKeywordService.queryKeyword(keyword), "Success Query keyword", "INVSTINV-2000"));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryByRegionResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta de fondo por region", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "region", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryByRegionResponseBean>> queryByRegion(@RequestBody @Valid QueryByRegionRequestBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(queryByRegionService.getRegion(requestBean, headers), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FundBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/fund", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<FundBean>> createFunds(@RequestBody @Valid FundBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertFundService.create(requestBean), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegionBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/region", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegionBean>> createRegion(@RequestBody @Valid RegionBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertRegionService.create(requestBean), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CountryBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<CountryBean>> createCountry(@RequestBody @Valid CountryBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertCountryService.create(requestBean), "Success Insert Country", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InstrumentsBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/instrument", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<InstrumentsBean>> createInstrument(@RequestBody @Valid InstrumentsBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertInstrumentService.create(requestBean), "Success Insert Instrument", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SectorBean.class))
            })
    })
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
    @Operation(summary = "Carga de Sector", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/sector", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<SectorBean>> createSector(@RequestBody @Valid SectorBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertSectorService.create(requestBean), "Success Insert Sector", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Boolean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "backup/funds", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Boolean>> moveFunds() {
        return Mono.just(responseUtil.successResponseEntity(insertFundService.moveAll(), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = DeleteKeywordResponseBean.class))
            })
    })
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
    @Operation(summary = "Eliminación de palabras clave", tags = {"Query keyword"})
    @DeleteMapping(value = "{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<DeleteKeywordResponseBean>> deleteKeyword(@PathVariable("keyword") String keyword) {
        return Mono.just(responseUtil.successResponseEntity(deleteKeywordService.deleteKeyword(keyword), "Success delete keyword", "INVSTINV-2000"));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FundBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/funds", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<FundBean>> createAllFunds(@RequestBody @Valid List<FundBean> requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertFundService.createAll(requestBean), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegionBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/regions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegionBean>> createAllRegion(@RequestBody @Valid List<RegionBean> requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertRegionService.createAll(requestBean), "Success Query by Region", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CountryBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<CountryBean>> createAllCountry(@RequestBody @Valid List<CountryBean> requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertCountryService.createAll(requestBean), "Success Insert Country", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InstrumentsBean.class))
            })
    })
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
    @Operation(summary = "Carga de fondos", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/instruments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<InstrumentsBean>> createAllInstrument(@RequestBody @Valid List<InstrumentsBean> requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertInstrumentService.createAll(requestBean), "Success Insert Instrument", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = SectorBean.class))
            })
    })
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
    @Operation(summary = "Carga de Sector", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "load/sectors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<SectorBean>> createAllSector(@RequestBody @Valid List<SectorBean> requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(insertSectorService.createAll(requestBean), "Success Insert Sector", "INVSTINV-2000"));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryByTickerResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta los instrumentos de inversión por numero de serie del fondo", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "ticker", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryByTickerResponseBean>> getFundsByTicker(@RequestBody @Valid QueryByTickerRequestBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(byTickerService.getFundsByTicker(requestBean, headers), "Success Query by Ticker", "INVSTINV-2000"));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegisterHorizonResponseBean.class))
            })
    })
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
    @Operation(summary = "Alta de horizonte de fondos.", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "horizon", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegisterHorizonResponseBean>> getRegisterHorizon(@RequestBody @Valid RegisterHorizonRequestBean requestBean, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(horizonService.getService(requestBean, headers), "Success register horizon", "INVSTINV-2000"));

    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryHorizonResponseBean.class))
            })
    })
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
    @Operation(summary = "Operación que realiza la consulta del horizonte del fondo.", tags = {"ms-investments-inventory-bd"})
    @GetMapping(value = "horizon", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryHorizonResponseBean>> getQueryHorizon(@RequestParam(name = "isin") String isin, @RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(queryHorizonService.getService(isin, headers), "Success query horizon", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryByMostRecentResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta los instrumentos buscados recientemente", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/metadata/mostrecent", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryByMostRecentResponseBean>> getInstrumentRecent(@RequestBody @Valid QueryByMostRecentRequestBean queryByMostRecentRequestBean) {
        return Mono.just(responseUtil.successResponseEntity(queryByMostRecentService.queryMostRecent(queryByMostRecentRequestBean), "Success Query by most recent instrument", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryByMostWantedResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta los instrumentos más buscados", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/metadata/mostwanted", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryByMostWantedResponseBean>> getInstrumentMostWanted(@RequestBody @Valid QueryByMostWantedRequestBean searchType) {
        return Mono.just(responseUtil.successResponseEntity(queryByMostWantedService.queryMostWanted(searchType), "Success Query by most wanted instrument", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegisterMetadataResponseBean.class))
            })
    })
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
    @Operation(summary = "Operación que registra los instrumentos mas recientes y los mas buscados", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/metadata", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegisterMetadataResponseBean>> registerMetadata(@RequestBody @Valid RegisterMetadataRequestBean requestBean) {
        return Mono.just(responseUtil.successResponseEntity(registerMetadataService.registerMetadata(requestBean), "Success Register metadata", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = GetFundsResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta los instrumentos de inversión por tipo de fondo, pais y plazo", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/getFunds", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<GetFundsResponseBean>> query(@RequestBody @Valid GetFundsRequestBean customQueryRequest, @RequestHeader Map<String, String> headers) {

        return Mono
                .just(responseUtil.successResponseEntity(
                        getFundsService.getFunds(customQueryRequest, headers),
                        "Success Custom Query", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QuerySectorsResponseBean.class))
            })
    })
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
    @Operation(summary = "Consulta el listado de sectores", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "/sectors", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QuerySectorsResponseBean>> getSectors(@RequestHeader Map<String, String> headers) {
        return Mono.just(responseUtil.successResponseEntity(querySectorsService.getService(headers), "Success Query Sectors", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegisterLiquidityResponseBean.class))
            })
    })
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
    @Operation(summary = "Alta de liquidez de los fondos.", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "liquidity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<RegisterLiquidityResponseBean>> getRegisterLiquidity(@RequestBody @Valid RegisterLiquidityRequestBean requestBean) {
        return Mono.just(responseUtil.successResponseEntity(liquidityService.getService(requestBean), "Success register liquidity", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = QueryLiquidityResponseBean.class))
            })
    })
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
    @Operation(summary = "Operación que realiza la consulta de la liquidez del fondo.", tags = {"ms-investments-inventory-bd"})
    @GetMapping(value = "liquidity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<QueryLiquidityResponseBean>> getQueryLiquidity(@RequestParam(name = "isin") String isin) {
        return Mono.just(responseUtil.successResponseEntity(queryliquidityService.getService(isin), "Success query liquidity", "INVSTINV-2000"));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = DeleteMostRecentResponseBean.class))
            })
    })
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
    @Operation(summary = "Operación que realiza la eliminacion de un registro.", tags = {"ms-investments-inventory-bd"})
    @PostMapping(value = "metadata/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<DeleteMostRecentResponseBean>> deteleMostRecent(@RequestBody DeleteMostRecentRequestBean deleteMostRecentRequestBean) {
        return Mono.just(responseUtil.successResponseEntity(deleteMostRecentService.deteleMostRecent(deleteMostRecentRequestBean), "Success", "INVSTINV-2000"));
    }
}