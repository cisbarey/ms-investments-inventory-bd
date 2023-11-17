package mx.com.actinver.ms.clients.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.Metadata;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.BD.repositories.IMetadataRepository;
import mx.com.actinver.ms.beans.BD.repositories.ISectorsRepository;
import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;
import mx.com.actinver.ms.clients.IRegisterMetadataClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundBusinessRuleException;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class RegisterMetadataClient extends HttpHeadersConfig implements IRegisterMetadataClient {

    @Autowired
    private IMetadataRepository metadataRepository;

    @Autowired
    private IFundsRepository fundsRepository;

    @Autowired
    private ISectorsRepository sectorRepository;

    @Override
    public RegisterMetadataResponseBean registrationMetadata(RegisterMetadataRequestClientBean registerMetadataRequestClientBean) {

        List<DetailClientBean> detailClient = fundsRepository.findAll();

        if (registerMetadataRequestClientBean.getSearchType().equals("BY_FUND")) {

            detailClient = detailClient
                    .stream()
                    .filter(fund -> registerMetadataRequestClientBean.getKey().contains(fund.getIsin()))
                    .collect(Collectors.toList());

            if (detailClient == null || detailClient.isEmpty()) {
                throw new SuperMarketFundNotFoundException("Not found isin.", ErrorExceptions.NOT_FOUND);
            }

        } else if (registerMetadataRequestClientBean.getSearchType().equals("BY_SECTOR")) {

            List<String> sectors = sectorRepository.getDistinctSector();

            sectors = sectors
                    .stream()
                    .filter(sector -> registerMetadataRequestClientBean.getKey().contains(sector))
                    .collect(Collectors.toList());

            if (sectors == null || sectors.isEmpty()) {
                throw new SuperMarketFundNotFoundException("Not found sector.", ErrorExceptions.NOT_FOUND);
            }

        } else if (registerMetadataRequestClientBean.getSearchType().equals("BY_TYPE")) {

        	detailClient = detailClient
                    .stream()
                    .filter(fund -> registerMetadataRequestClientBean.getKey().contains(fund.getCategoryName())
                            || registerMetadataRequestClientBean.getKey().contains(fund.getGlobalCategoryName()))
                    .collect(Collectors.toList());

            if (detailClient == null || detailClient.isEmpty()) {
                throw new SuperMarketFundNotFoundException("Not found type.", ErrorExceptions.NOT_FOUND);
            }

        } else if (registerMetadataRequestClientBean.getSearchType().equals("BY_FIRMNAME")) {

            detailClient = detailClient
                    .stream()
                    .filter(fund -> registerMetadataRequestClientBean.getKey().contains(fund.getFirmName()))
                    .collect(Collectors.toList());

            if (detailClient == null || detailClient.isEmpty()) {
                throw new SuperMarketFundNotFoundException("Not found firmname.", ErrorExceptions.NOT_FOUND);
            }

        }

        RegisterMetadataResponseBean registerMetadataResponseBean = new RegisterMetadataResponseBean();

        try {
            Metadata metadata = new Metadata();

            metadata.setKey(registerMetadataRequestClientBean.getKey());
            metadata.setCreationUser(registerMetadataRequestClientBean.getCreationUser());
            metadata.setSearchType(registerMetadataRequestClientBean.getSearchType());
            metadata.setCreationDate(registerMetadataRequestClientBean.getCreationDate());

            metadataRepository.save(metadata);

            registerMetadataResponseBean.setMessage("Metadata successfully registered.");
            registerMetadataResponseBean.setType("SUCCESS");

            return registerMetadataResponseBean;

        } catch (Exception e) {
            throw new SuperMarketFundBusinessRuleException("Invalid input params.", ErrorExceptions.PRECONDITION_FAILED);
        }

    }

}