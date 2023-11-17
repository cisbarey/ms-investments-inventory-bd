package mx.com.actinver.ms.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mx.com.actinver.ms.exceptions.config.ErrorExceptions;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum TypeDatabaseException {
	NOT_NEW("There is an element xXx saved",ErrorExceptions.PRECONDITION_FAILED),
	ID_NULL("id not must be null",ErrorExceptions.INVALID_PARAMS),
	ELEMENT_NOT_FOUND("There is not an element xXx saved",ErrorExceptions.NOT_FOUND),
	NULL_ELEMENT("the arry cant be null",ErrorExceptions.PRECONDITION_FAILED),
	INVALID_FORMAT("format for xXx no valid, dd/mm/yyyy",ErrorExceptions.INVALID_PARAMS);
	
	
	private String message;
	private ErrorExceptions error;
	
	
}
