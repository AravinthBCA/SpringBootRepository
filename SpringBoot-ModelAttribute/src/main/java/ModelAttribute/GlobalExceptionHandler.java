package ModelAttribute;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	private String handleNullPointerException(){
		return "nullpointerexception";
	}
	
	@ExceptionHandler(value = Exception.class)
	private String handleAnyException(){
		return "exception";
	}
	
}
