package mx.com.actinver.ms.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.queryFavorites.FavoritesBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesRequestBean;
import mx.com.actinver.ms.beans.queryFavorites.QueryFavoritesResponseBean;
import mx.com.actinver.ms.clients.IQueryFavoritesClient;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class QueryFavoritesServiceTest {

    @Mock
    private IQueryFavoritesClient queryFavoritesClient;
    @InjectMocks
    private QueryFavoritesService queryFavoritesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterMetadata() {
        // Arrange
        QueryFavoritesRequestBean requestBean = new QueryFavoritesRequestBean();
        List<String> contractNumbers = new ArrayList<String>();
        contractNumbers.add("12345");
        requestBean.setContractNumbers(contractNumbers);
        QueryFavoritesResponseBean expectedResponseBean = new QueryFavoritesResponseBean();
        FavoritesBean favoritesBean = new FavoritesBean();
        favoritesBean.setSerie("B-1");
        favoritesBean.setIssuer("ACT2023");
        expectedResponseBean.setFavorites(Arrays.asList(favoritesBean));
        Mockito.when(queryFavoritesClient.queryFavorites(requestBean)).thenReturn(expectedResponseBean);

        // Act
        QueryFavoritesResponseBean actualResponseBean = queryFavoritesService.queryFavorites(requestBean);

        // Assert
        assertNotNull(actualResponseBean);
        assertEquals(expectedResponseBean, actualResponseBean);
    }

}