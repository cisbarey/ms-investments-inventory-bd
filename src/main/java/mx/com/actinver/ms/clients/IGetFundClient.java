package mx.com.actinver.ms.clients;

import mx.com.actinver.ms.beans.BD.entities.DetailClientBean;

public interface IGetFundClient {

	DetailClientBean getFund(String isin);

}

