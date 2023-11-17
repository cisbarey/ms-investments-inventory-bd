package mx.com.actinver.ms.services.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegisterLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityRequestBean;
import mx.com.actinver.ms.beans.query.RegisterLiquidityResponseBean;
import mx.com.actinver.ms.clients.IRegisterLiquidityClient;
import mx.com.actinver.ms.helpers.IRegisterLiquidityHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class RegisterLiquidityServiceTest {

    @InjectMocks
    private RegisterLiquidityService registerLiquidityService;

    @Mock
    private IRegisterLiquidityHelper LiquidityHelper;

    @Mock
    private IRegisterLiquidityClient LiquidityClient;

    private RegisterLiquidityRequestBean requestBean = new RegisterLiquidityRequestBean();
    private RegisterLiquidityResponseBean responseBean = new RegisterLiquidityResponseBean();
    private RegisterLiquidityResponseClientBean responseClientBean = new RegisterLiquidityResponseClientBean();
    private LiquidityClientBean requestClientBean = new LiquidityClientBean();

    @BeforeEach
    public void before() {

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/registerLiquidity/request.json")))) {
            Gson object = new Gson();
            requestBean = object.fromJson(bufferedReader, RegisterLiquidityRequestBean.class);
        } catch (IOException e) {
            log.error("Message: {}", e.getMessage());
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/registerLiquidity/response.json")))) {
            Gson object = new Gson();
            responseBean = object.fromJson(bufferedReader, RegisterLiquidityResponseBean.class);
        } catch (IOException e) {
            log.error("Message: {}", e.getMessage());
        }

    }

    @Test
    void testRegisterLiquidity() {

        when(LiquidityHelper.toRequest(requestBean)).thenReturn(requestClientBean);
        when(LiquidityClient.getClient(requestClientBean)).thenReturn(responseClientBean);
        when(LiquidityHelper.toResponse(responseClientBean)).thenReturn(responseBean);

        RegisterLiquidityResponseBean responseBeanTest = registerLiquidityService.getService(requestBean);
        assertNotNull(responseBean);
        assertEquals(responseBean.getMessage(), responseBeanTest.getMessage());

    }

}