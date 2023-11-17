package mx.com.actinver.ms.clients.impl;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionRequestClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryByRegionResponseClientBean;
import mx.com.actinver.ms.beans.BD.entities.RegionClientBean;
import mx.com.actinver.ms.beans.BD.repositories.IFundsRepository;
import mx.com.actinver.ms.beans.BD.repositories.IRegions;
import mx.com.actinver.ms.clients.IQueryByRegionClient;
import mx.com.actinver.ms.config.HttpHeadersConfig;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class QueryByRegionClient extends HttpHeadersConfig implements IQueryByRegionClient {

    @Autowired
    private IFundsRepository fundsRepository;

    @Autowired
    private IRegions regionsRepository;

    @Override
    public QueryByRegionResponseClientBean getClient(QueryByRegionRequestClientBean requestClientBean, Map<String, String> headers) {

        QueryByRegionResponseClientBean responseClientBean = new QueryByRegionResponseClientBean();


        if (requestClientBean.getRegion() == null || requestClientBean.getRegion().isEmpty()) {
            List<DetailClientBean> detailClientAll = fundsRepository.findAll();
            responseClientBean.setDetail(detailClientAll);
            return responseClientBean;
        }

        List<RegionClientBean> regionRegister = regionsRepository.findAll();

        regionRegister = regionRegister
                .stream()
                .filter(region -> requestClientBean.getRegion().contains(region.getRegion()))
                .collect(Collectors.toList());

        if (regionRegister == null || regionRegister.isEmpty()) {
            throw new SuperMarketFundNotFoundException("Not found region.", ErrorExceptions.NOT_FOUND);
        }

        List<DetailClientBean> detailClient = fundsRepository.findByRegionalExposure_Region(requestClientBean.getRegion());
        if (detailClient == null) {
            throw new SuperMarketFundNotFoundException("Not found.", ErrorExceptions.NOT_FOUND);
        }

        responseClientBean.setDetail(detailClient);
        return responseClientBean;
    }

}
