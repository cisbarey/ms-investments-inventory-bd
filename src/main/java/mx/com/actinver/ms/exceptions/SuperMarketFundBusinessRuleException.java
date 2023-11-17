package mx.com.actinver.ms.exceptions;

import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

public class SuperMarketFundBusinessRuleException extends BusinessRuleException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2972426750687415358L;
	private static final String REP = "xXx";

	public SuperMarketFundBusinessRuleException(String exception, String resultCode) {
        super(exception, resultCode);
    }
	
	public SuperMarketFundBusinessRuleException(String exception, ErrorExceptions error) {
        super(exception, error.getResultCode());
    }
	
	public SuperMarketFundBusinessRuleException(TypeDatabaseException type, String element ) {        
		super(type.getMessage().replace(SuperMarketFundBusinessRuleException.REP, element), type.getError().getResultCode());
    }
	
	
}
