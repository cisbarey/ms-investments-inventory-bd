package mx.com.actinver.ms.exceptions;

public class BusinessException extends BusinessRuleException {
    public BusinessException(String exception, String resultCode) {
        super(exception, resultCode);
    }
}
