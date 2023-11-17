package mx.com.actinver.ms.helpers.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;
import mx.com.actinver.ms.beans.BD.entities.QueryHorizonResponseClientBean;
import mx.com.actinver.ms.clients.IQueryHorizonClient;
import mx.com.actinver.ms.enums.RiskValue;
import mx.com.actinver.ms.enums.VolatilityLevel;
import mx.com.actinver.ms.exceptions.SuperMarketFundNotFoundException;
import mx.com.actinver.ms.exceptions.VolatilityLevelException;
import mx.com.actinver.ms.helpers.IQueryHorizonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;

@Component
@Slf4j
public class DetailFundsHelper {

    @Autowired
    private IQueryHorizonClient horizonClient;

    @Autowired
    private IQueryHorizonHelper horizonHelper;


    public VolatilityLevel calculateVolatility(BigDecimal volatility) {
        Double volatilityNumber = volatility.doubleValue();
        if (volatilityNumber >= 0.00d && volatilityNumber <= 3.00d) {
            return VolatilityLevel.LOW;
        } else if (volatilityNumber >= 3.01d && volatilityNumber <= 12.00d) {
            return VolatilityLevel.MEDIUM;
        } else if (volatilityNumber >= 12d) {
            return VolatilityLevel.HIGH;
        } else {
            throw new VolatilityLevelException("Volatility value " + volatilityNumber + " is not in the defined range");
        }
    }

    public String calculateRisk(VolatilityLevel volatility) {
        String risk;
        switch (volatility) {
            case LOW:
                risk = RiskValue.CONSERVATIVE.getRisk();
                break;
            case MEDIUM:
                risk = RiskValue.MODERATE.getRisk();
                break;
            case HIGH:
                risk = RiskValue.AGGRESSIVE.getRisk();
                break;
            default:
                throw new VolatilityLevelException("Volatility value " + volatility + " is not contemplated for calculate the risk value");
        }
        return risk;
    }

    public String getHorizon(String isin) {
        try {
            QueryHorizonResponseClientBean queryHorizonResponseClientBean = horizonClient.getClient(horizonHelper.toRequest(isin), new HashMap<>());
            return queryHorizonResponseClientBean.getType();
        } catch (SuperMarketFundNotFoundException exception) {
            log.info("Isin {} not found as horizon", isin);
            return null;
        }
    }

    public Boolean checkVolatility(DetailClientBean detailClientBean, String volatilityText) {
        Double volatility = detailClientBean.getVolatibility().doubleValue();
        if (volatility >= 0.00d && volatility <= 3.00d) {
            return VolatilityLevel.LOW.getLevel().equals(volatilityText);
        } else if (volatility >= 3.01d && volatility <= 12.00d) {
            return VolatilityLevel.MEDIUM.getLevel().equals(volatilityText);
        } else if (volatility >= 12d) {
            return VolatilityLevel.HIGH.getLevel().equals(volatilityText);
        } else {
            return false;
        }
    }
}
