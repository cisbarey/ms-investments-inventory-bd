package mx.com.actinver.ms.exceptions;

public class UnavailableServiceException extends ServiceUnavailableException {
    public UnavailableServiceException(String exception, String resultCode) {
        super(exception, resultCode);
    }
}
