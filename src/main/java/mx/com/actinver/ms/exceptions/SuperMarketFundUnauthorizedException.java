package mx.com.actinver.ms.exceptions;

import mx.com.actinver.ms.enums.TypeDatabaseException;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

public class SuperMarketFundUnauthorizedException extends UnauthorizedException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2972426750687415358L;
	private static final String REP = "xXx";
	
	public SuperMarketFundUnauthorizedException(String exception, String resultCode) {
        super(exception, resultCode);
    }
	
	public SuperMarketFundUnauthorizedException(String exception, ErrorExceptions error) {
        super(exception, error.getResultCode());
    }
	
	public SuperMarketFundUnauthorizedException(TypeDatabaseException type, String element ) {        
		super(type.getMessage().replace(SuperMarketFundUnauthorizedException.REP, element), type.getError().getResultCode());
    }
}
