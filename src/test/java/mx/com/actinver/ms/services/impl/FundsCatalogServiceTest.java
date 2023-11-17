package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.BD.entities.BusinessFunds;
import mx.com.actinver.ms.beans.BD.repositories.IBusinessCatalogRepository;
import mx.com.actinver.ms.beans.BD.entities.BusinessCatalog;
import mx.com.actinver.ms.beans.BD.entities.FundsCatalog;
import mx.com.actinver.ms.beans.catalog.BusinessBean;
import mx.com.actinver.ms.beans.catalog.BusinessFundBean;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FundsCatalogServiceTest {

    private static final long BUSINESS_ID_01 = 703;
    private static final long BUSINESS_ID_02 = 704;

    @InjectMocks
    private FundsCatalogService fundsCatalogService;

    @Mock
    private IBusinessCatalogRepository businessCatalogRepository;

    @Test
    public void testGetFundsCatalogByBusinessId() {
        BusinessCatalog businessCatalog1 = new BusinessCatalog();
        businessCatalog1.setBusinessId(BUSINESS_ID_01);

        FundsCatalog fund1 = new FundsCatalog();
        fund1.setIsin("ISIN1");
        FundsCatalog fund2 = new FundsCatalog();
        fund2.setIsin("ISIN2");

        BusinessFunds businessFund1 = new BusinessFunds();
        businessFund1.setFundsCatalog(fund1);
        BusinessFunds businessFund2 = new BusinessFunds();
        businessFund2.setFundsCatalog(fund2);

        businessCatalog1.setBusinessFunds(Arrays.asList(businessFund1, businessFund2));

        BusinessCatalog businessCatalog2 = new BusinessCatalog();
        businessCatalog2.setBusinessId(BUSINESS_ID_02);
        businessCatalog2.setBusinessFunds(Arrays.asList(businessFund1, businessFund2));

        when(businessCatalogRepository.findAll()).thenReturn(Arrays.asList(businessCatalog1, businessCatalog2));

        BusinessBean result = fundsCatalogService.getFundsCatalogByBusinessId();

        List<BusinessFundBean> businessFunds = result.getBusiness();
        assertEquals(2, businessFunds.size());

        BusinessFundBean fundBean1 = businessFunds.get(0);
        assertEquals(BUSINESS_ID_01, fundBean1.getBusinessId());
        assertEquals(Arrays.asList("ISIN1", "ISIN2"), fundBean1.getIsin());

        BusinessFundBean fundBean2 = businessFunds.get(1);
        assertEquals(BUSINESS_ID_02, fundBean2.getBusinessId());
        assertEquals(Arrays.asList("ISIN1", "ISIN2"), fundBean2.getIsin());
    }
}
