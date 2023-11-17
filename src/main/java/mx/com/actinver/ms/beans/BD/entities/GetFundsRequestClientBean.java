package mx.com.actinver.ms.beans.BD.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFundsRequestClientBean implements Serializable{

	private static final long serialVersionUID = -7163781080656882947L;

    private List<String>  isins;
    private List<String>  firmNames;
    private List<String>  fundLegalNames;
    private List<String>  tickers;

	private List<String> wldCategories;
    private CustomQueryAnualPerform1YClientBean anualPerform1Y;
    private CustomQueryCommisionClientBean commision;
    private List<String> mxCategories;
    private List<String> horizonTypes;
    private List<String> liquidities;
    private List<String> strategies;
    private List<String> sectors;
    private List<String> countries;
    private List<String> regions;
    private List<String> stabilities;
    private List<Integer> raitings;
	private List<Integer> styleboxes;
    private List<String> operators;
    private List<String>  fundTypes;
    private List<String>  operatedMex;
    private List<Integer> equityStylebox;
    private List<Integer> fixedIncomeStylebox;
    private List<String> volatility;
}