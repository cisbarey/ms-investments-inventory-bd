package mx.com.actinver.ms.services.impl;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.LiquidityClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryLiquidityResponseClientBean;
import mx.com.actinver.ms.beans.query.QueryLiquidityResponseBean;
import mx.com.actinver.ms.clients.IQueryLiquidityClient;
import mx.com.actinver.ms.helpers.IQueryLiquidityHelper;
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
class QueryLiquidityServiceTest {

    @InjectMocks
    private QueryLiquidityService queryLiquidityService;

    @Mock
    private IQueryLiquidityHelper queryHelper;

    @Mock
    private IQueryLiquidityClient queryClient;

    private String isin;
    private QueryLiquidityResponseBean responseBean = new QueryLiquidityResponseBean();
    private QueryLiquidityResponseClientBean responseClientBean = new QueryLiquidityResponseClientBean();
    private LiquidityClientBean requestClientBean = new LiquidityClientBean();

    @BeforeEach
    public void before() {

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream("/queryLiquidity/response.json")))) {
            Gson object = new Gson();
            responseBean = object.fromJson(bufferedReader, QueryLiquidityResponseBean.class);
        } catch (IOException e) {
            log.error("Message: {}", e.getMessage());
        }

        isin = "10014215";
    }

    @Test
    void testRegisterLiquidity() {

        when(queryHelper.toRequest(isin)).thenReturn(requestClientBean);
        when(queryClient.getClient(requestClientBean)).thenReturn(responseClientBean);
        when(queryHelper.toResponse(responseClientBean)).thenReturn(responseBean);

        QueryLiquidityResponseBean responseBeanTest = queryLiquidityService.getService(isin);
        assertNotNull(responseBean);
        assertEquals(responseBean.getType(), responseBeanTest.getType());

    }

}