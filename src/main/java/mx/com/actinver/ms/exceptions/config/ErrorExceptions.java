package mx.com.actinver.ms.exceptions.config;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum ErrorExceptions {

	NO_CONTENT(HttpStatus.PRECONDITION_FAILED, "INVSTINV-1001", "No content"),
	FAIL_AUTH(HttpStatus.UNAUTHORIZED, "INVSTINV-3001", "Authentication failed"),
	INVALID_PARAMS(HttpStatus.PRECONDITION_FAILED, "INVSTINV-3002", "Invalid input params"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "INVSTINV-3003", "Not found"),
	PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED, "INVSTINV-3002", "Invalid input params");

	HttpStatus status;
	String resultCode;
	String message;

}
