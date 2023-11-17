package mx.com.actinver.ms.exceptions;

public class ServiceUnauthorizedException extends UnauthorizedException {
    public ServiceUnauthorizedException(String exception, String resultCode) {
        super(exception, resultCode);
    }
}
