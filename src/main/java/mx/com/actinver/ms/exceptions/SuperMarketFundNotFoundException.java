package mx.com.actinver.ms.exceptions;

import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

public class SuperMarketFundNotFoundException extends NotFoundException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2972426750687415358L;
	private static final String REP = "xXx";

	public SuperMarketFundNotFoundException(String exception, String resultCode) {
        super(exception, resultCode);
    }
	
	public SuperMarketFundNotFoundException(String exception, ErrorExceptions error) {
        super(exception, error.getResultCode());
    }
	
	public SuperMarketFundNotFoundException(TypeDatabaseException type, String element ) {        
		super(type.getMessage().replace(SuperMarketFundNotFoundException.REP, element), type.getError().getResultCode());
    }
}
