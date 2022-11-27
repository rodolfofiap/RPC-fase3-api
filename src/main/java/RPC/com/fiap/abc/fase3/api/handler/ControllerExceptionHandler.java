package RPC.com.fiap.abc.fase3.api.handler;

import RPC.com.fiap.abc.fase3.api.handler.exception.MaxAssistsExcepition;
import RPC.com.fiap.abc.fase3.api.handler.exception.MinimumAssistisRequiredExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimumAssistisRequiredExceptions.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistsRequired(MinimumAssistisRequiredExceptions exception){

        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MaxAssistsExcepition.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistsRequired(MaxAssistsExcepition exception){

        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorMessageResponse> getErrorMessageResponseResponseEntity(String message, String description, HttpStatus statusCode ) {
        ErrorMessageResponse error = new ErrorMessageResponse();
        error.setMessage(message);
        error.setDescription(description);
        error.setTimestamp(new Date());
        error.setStatusCode(statusCode.value());

        return new ResponseEntity<ErrorMessageResponse>(error, statusCode);
    }


}
