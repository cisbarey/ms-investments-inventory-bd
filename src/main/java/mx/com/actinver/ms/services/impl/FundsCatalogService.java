package mx.com.actinver.ms.services.impl;

import mx.com.actinver.ms.beans.BD.repositories.IBusinessCatalogRepository;
import mx.com.actinver.ms.beans.catalog.BusinessBean;
import mx.com.actinver.ms.beans.catalog.BusinessFundBean;
import mx.com.actinver.ms.services.IFundsCatalogService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FundsCatalogService implements IFundsCatalogService {

    private final IBusinessCatalogRepository businessCatalogRepository;

    public FundsCatalogService(IBusinessCatalogRepository businessCatalogRepository) {
        this.businessCatalogRepository = businessCatalogRepository;
    }

    @Override
    public BusinessBean getFundsCatalogByBusinessId() {
        return BusinessBean.builder()
                .business(this.businessCatalogRepository.findAll().stream()
                        .map(businessCatalog -> BusinessFundBean.builder()
                                .businessId(businessCatalog.getBusinessId())
                                .isin(businessCatalog.getBusinessFunds().stream()
                                        .map(businessFund -> businessFund.getFundsCatalog().getIsin())
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
