package mx.com.actinver.ms.helpers.impl;

import com.google.gson.Gson;
import mx.com.actinver.ms.beans.BD.entities.FundsClientBean;
import mx.com.actinver.ms.beans.insert.FundBean;
import mx.com.actinver.ms.helpers.IEntityHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FundHelper implements IEntityHelper<FundBean, FundsClientBean> {

    @Value(value = "${BD.createUser}")
    private String user;

    @Override
    public List<FundsClientBean> toEntityAll(List<FundBean> clientBean) {
        List<FundsClientBean> beans = new ArrayList<>();
        if (clientBean != null && !clientBean.isEmpty()) {
            for (int i = 0; i < clientBean.size(); i++) {
                FundsClientBean bean = new FundsClientBean();
                bean.setIsin(clientBean.get(i).getIsin());
                bean.setFundLegalName(clientBean.get(i).getFundLegalName());
                bean.setGlobalCategoryName(clientBean.get(i).getGlobalCategoryName());
                bean.setCategoryName(clientBean.get(i).getCategoryName());
                bean.setTicker(clientBean.get(i).getTicker());
                bean.setFirmName(clientBean.get(i).getFirmName());
                bean.setNetExpenseRatio(clientBean.get(i).getNetExpenseRatio());
                bean.setIndexFund(clientBean.get(i).getIndexFund());
                bean.setMinimumInitial(clientBean.get(i).getMinimumInitial());
                bean.setDebtsPercentage(clientBean.get(i).getDebtsPercentage());
                bean.setSharesPercentage(clientBean.get(i).getSharesPercentage());
                bean.setCashNet(clientBean.get(i).getCashNet());
                bean.setOtherNet(clientBean.get(i).getOtherNet());
                bean.setEffectiveDuration(clientBean.get(i).getEffectiveDuration());
                bean.setEquityStylebox(clientBean.get(i).getEquityStylebox());
                bean.setDayEndNav(clientBean.get(i).getDayEndNav());
                bean.setCategoryReturn1Day(clientBean.get(i).getCategoryReturn1Day());
                bean.setCategoryReturn1Week(clientBean.get(i).getCategoryReturn1Week());
                bean.setCategoryReturn1Mth(clientBean.get(i).getCategoryReturn1Mth());
                bean.setCategoryReturn3Mth(clientBean.get(i).getCategoryReturn3Mth());
                bean.setCategoryReturn6Mth(clientBean.get(i).getCategoryReturn6Mth());
                bean.setCategoryReturnYTD(clientBean.get(i).getCategoryReturnYTD());
                bean.setCategoryReturn1Yr(clientBean.get(i).getCategoryReturn1Yr());
                bean.setCategoryReturn3Yr(clientBean.get(i).getCategoryReturn3Yr());
                bean.setCategoryReturn5Yr(clientBean.get(i).getCategoryReturn5Yr());
                bean.setCategoryReturn10Yr(clientBean.get(i).getCategoryReturn10Yr());
                bean.setCategoryReturn15Yr(clientBean.get(i).getCategoryReturn15Yr());
                bean.setCategoryReturnTotal(clientBean.get(i).getCategoryReturnTotal());
                bean.setReturn1Day(clientBean.get(i).getReturn1Day());
                bean.setReturn1Week(clientBean.get(i).getReturn1Week());
                bean.setReturn1Mth(clientBean.get(i).getReturn1Mth());
                bean.setReturn3Mth(clientBean.get(i).getReturn3Mth());
                bean.setReturn6Mth(clientBean.get(i).getReturn6Mth());
                bean.setReturnYTD(clientBean.get(i).getReturnYTD());
                bean.setReturn1Yr(clientBean.get(i).getReturn1Yr());
                bean.setReturn3Yr(clientBean.get(i).getReturn3Yr());
                bean.setReturn5Yr(clientBean.get(i).getReturn5Yr());
                bean.setReturn10Yr(clientBean.get(i).getReturn10Yr());
                bean.setReturn15Yr(clientBean.get(i).getReturn15Yr());
                bean.setReturnSinceInception(clientBean.get(i).getReturnSinceInception());
                bean.setCumulativeReturn3Yr(clientBean.get(i).getCumulativeReturn3Yr());
                bean.setCumulativeReturn5Yr(clientBean.get(i).getCumulativeReturn5Yr());
                bean.setCumulativeReturn10Yr(clientBean.get(i).getCumulativeReturn10Yr());
                bean.setCumulativeReturn15Yr(clientBean.get(i).getCumulativeReturn15Yr());
                bean.setCumulativeReturnSinceInception(clientBean.get(i).getCumulativeReturnSinceInception());
                bean.setCategoryCumulativeReturn2Yr(clientBean.get(i).getCategoryCumulativeReturn2Yr());
                bean.setCategoryCumulativeReturn3Yr(clientBean.get(i).getCategoryCumulativeReturn3Yr());
                bean.setCategoryCumulativeReturn5Yr(clientBean.get(i).getCategoryCumulativeReturn5Yr());
                bean.setCategoryCumulativeReturn10Yr(clientBean.get(i).getCategoryCumulativeReturn10Yr());
                bean.setCategoryCumulativeReturn15Yr(clientBean.get(i).getCategoryCumulativeReturn15Yr());
                bean.setCategoryCumulativeReturnTotal(clientBean.get(i).getCategoryCumulativeReturnTotal());
                bean.setRatingOverall(clientBean.get(i).getRatingOverall());
                bean.setFundType(clientBean.get(i).getFundType());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                bean.setCreationDate(formatter.format(date));
                bean.setCreationUser(user);
                if (clientBean.get(i).getOperatedMex() == null) {
                    bean.setOperatedMex(0);
                } else {
                    bean.setOperatedMex(clientBean.get(i).getOperatedMex());
                }
                if (clientBean.get(i).getFixedIncomeStylebox() == null) {
                    bean.setFixedIncomeStylebox(0);
                }
                bean.setFixedIncomeStylebox(clientBean.get(i).getFixedIncomeStylebox());
                try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateInception = inputFormat.parse(clientBean.get(i).getInceptionDate());
                    String outputDate = outputFormat.format(dateInception);
                    bean.setInceptionDate(outputDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                bean.setTotalMarketValueNet(clientBean.get(i).getTotalMarketValueNet());
                bean.setVolatibility(clientBean.get(i).getVolatibility());
                bean.setCategoryYear1(clientBean.get(i).getCategoryYear1());
                bean.setCategoryYear2(clientBean.get(i).getCategoryYear2());
                bean.setCategoryYear3(clientBean.get(i).getCategoryYear3());
                bean.setCategoryYear4(clientBean.get(i).getCategoryYear4());
                bean.setCategoryYear5(clientBean.get(i).getCategoryYear5());
                bean.setCategoryYear6(clientBean.get(i).getCategoryYear6());
                bean.setCategoryYear7(clientBean.get(i).getCategoryYear7());
                bean.setCategoryYear8(clientBean.get(i).getCategoryYear8());
                bean.setCategoryYear9(clientBean.get(i).getCategoryYear9());
                bean.setCategoryYear10(clientBean.get(i).getCategoryYear10());

                bean.setYear1(clientBean.get(i).getYear1());
                bean.setYear2(clientBean.get(i).getYear2());
                bean.setYear3(clientBean.get(i).getYear3());
                bean.setYear4(clientBean.get(i).getYear4());
                bean.setYear5(clientBean.get(i).getYear5());
                bean.setYear6(clientBean.get(i).getYear6());
                bean.setYear7(clientBean.get(i).getYear7());
                bean.setYear8(clientBean.get(i).getYear8());
                bean.setYear9(clientBean.get(i).getYear9());
                bean.setYear10(clientBean.get(i).getYear10());
                bean.setFundNetAssets(clientBean.get(i).getFundNetAssets());

                beans.add(bean);
            }
            return beans;
        }
        return new ArrayList<>();
    }

    @Override
    public FundBean toBean(FundsClientBean clientBean) {

        FundBean bean = new FundBean();
        bean.setIsin(clientBean.getIsin());
        bean.setFundLegalName(clientBean.getFundLegalName());
        bean.setGlobalCategoryName(clientBean.getGlobalCategoryName());
        bean.setCategoryName(clientBean.getCategoryName());
        bean.setTicker(clientBean.getTicker());
        bean.setFirmName(clientBean.getFirmName());
        bean.setNetExpenseRatio(clientBean.getNetExpenseRatio());
        bean.setIndexFund(clientBean.getIndexFund());
        bean.setMinimumInitial(clientBean.getMinimumInitial());
        bean.setDebtsPercentage(clientBean.getDebtsPercentage());
        bean.setSharesPercentage(clientBean.getSharesPercentage());
        bean.setCashNet(clientBean.getCashNet());
        bean.setOtherNet(clientBean.getOtherNet());
        bean.setEffectiveDuration(clientBean.getEffectiveDuration());
        bean.setEquityStylebox(clientBean.getEquityStylebox());
        bean.setDayEndNav(clientBean.getDayEndNav());
        bean.setCategoryReturn1Day(clientBean.getCategoryReturn1Day());
        bean.setCategoryReturn1Week(clientBean.getCategoryReturn1Week());
        bean.setCategoryReturn1Mth(clientBean.getCategoryReturn1Mth());
        bean.setCategoryReturn3Mth(clientBean.getCategoryReturn3Mth());
        bean.setCategoryReturn6Mth(clientBean.getCategoryReturn6Mth());
        bean.setCategoryReturnYTD(clientBean.getCategoryReturnYTD());
        bean.setCategoryReturn1Yr(clientBean.getCategoryReturn1Yr());
        bean.setCategoryReturn3Yr(clientBean.getCategoryReturn3Yr());
        bean.setCategoryReturn5Yr(clientBean.getCategoryReturn5Yr());
        bean.setCategoryReturn10Yr(clientBean.getCategoryReturn10Yr());
        bean.setCategoryReturn15Yr(clientBean.getCategoryReturn15Yr());
        bean.setCategoryReturnTotal(clientBean.getCategoryReturnTotal());
        bean.setReturn1Day(clientBean.getReturn1Day());
        bean.setReturn1Week(clientBean.getReturn1Week());
        bean.setReturn1Mth(clientBean.getReturn1Mth());
        bean.setReturn3Mth(clientBean.getReturn3Mth());
        bean.setReturn6Mth(clientBean.getReturn6Mth());
        bean.setReturnYTD(clientBean.getReturnYTD());
        bean.setReturn1Yr(clientBean.getReturn1Yr());
        bean.setReturn3Yr(clientBean.getReturn3Yr());
        bean.setReturn5Yr(clientBean.getReturn5Yr());
        bean.setReturn10Yr(clientBean.getReturn10Yr());
        bean.setReturn15Yr(clientBean.getReturn15Yr());
        bean.setReturnSinceInception(clientBean.getReturnSinceInception());
        bean.setCumulativeReturn3Yr(clientBean.getCumulativeReturn3Yr());
        bean.setCumulativeReturn5Yr(clientBean.getCumulativeReturn5Yr());
        bean.setCumulativeReturn10Yr(clientBean.getCumulativeReturn10Yr());
        bean.setCumulativeReturn15Yr(clientBean.getCumulativeReturn15Yr());
        bean.setCumulativeReturnSinceInception(clientBean.getCumulativeReturnSinceInception());
        bean.setCategoryCumulativeReturn2Yr(clientBean.getCategoryCumulativeReturn2Yr());
        bean.setCategoryCumulativeReturn3Yr(clientBean.getCategoryCumulativeReturn3Yr());
        bean.setCategoryCumulativeReturn5Yr(clientBean.getCategoryCumulativeReturn5Yr());
        bean.setCategoryCumulativeReturn10Yr(clientBean.getCategoryCumulativeReturn10Yr());
        bean.setCategoryCumulativeReturn15Yr(clientBean.getCategoryCumulativeReturn15Yr());
        bean.setCategoryCumulativeReturnTotal(clientBean.getCategoryCumulativeReturnTotal());
        bean.setRatingOverall(clientBean.getRatingOverall());
        bean.setFundType(clientBean.getFundType());
        bean.setInceptionDate(clientBean.getInceptionDate());
        if (clientBean.getOperatedMex() == null) {
            bean.setOperatedMex(0);
        } else {
            bean.setOperatedMex(clientBean.getOperatedMex());
        }
        if (clientBean.getFixedIncomeStylebox() == null) {
            bean.setFixedIncomeStylebox(0);
        }
        bean.setFixedIncomeStylebox(clientBean.getFixedIncomeStylebox());

        bean.setTotalMarketValueNet(clientBean.getTotalMarketValueNet());
        bean.setVolatibility(clientBean.getVolatibility());
        bean.setCategoryYear1(clientBean.getCategoryYear1());
        bean.setCategoryYear2(clientBean.getCategoryYear2());
        bean.setCategoryYear3(clientBean.getCategoryYear3());
        bean.setCategoryYear4(clientBean.getCategoryYear4());
        bean.setCategoryYear5(clientBean.getCategoryYear5());
        bean.setCategoryYear6(clientBean.getCategoryYear6());
        bean.setCategoryYear7(clientBean.getCategoryYear7());
        bean.setCategoryYear8(clientBean.getCategoryYear8());
        bean.setCategoryYear9(clientBean.getCategoryYear9());
        bean.setCategoryYear10(clientBean.getCategoryYear10());

        bean.setYear1(clientBean.getYear1());
        bean.setYear2(clientBean.getYear2());
        bean.setYear3(clientBean.getYear3());
        bean.setYear4(clientBean.getYear4());
        bean.setYear5(clientBean.getYear5());
        bean.setYear6(clientBean.getYear6());
        bean.setYear7(clientBean.getYear7());
        bean.setYear8(clientBean.getYear8());
        bean.setYear9(clientBean.getYear9());
        bean.setYear10(clientBean.getYear10());
        bean.setFundNetAssets(clientBean.getFundNetAssets());

        return bean;
    }

    @Override
    public FundsClientBean toEntity(FundBean requestBean) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(requestBean), FundsClientBean.class);

    }


}
