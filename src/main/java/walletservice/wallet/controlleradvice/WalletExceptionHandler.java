package walletservice.wallet.controlleradvice;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import walletservice.wallet.controlleradvice.exception.ExceptionResponse;
import walletservice.wallet.controlleradvice.exception.ServiceException;

import java.util.Date;

@ControllerAdvice
public class WalletExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletExceptionHandler.class);
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handler(ServiceException serviceException){
        LOGGER.error("error in controller",serviceException);
        return ExceptionResponse.builder()
                .timeStamp(new Date())
                .errorCode(55)
                .message(serviceException.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handler(MethodArgumentNotValidException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimeStamp(new Date());
        exceptionResponse.setErrorCode(55);

        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message = "error in field : " + fieldError.getField() + " " + fieldError.getDefaultMessage();
        exceptionResponse.setMessage(message);
        return exceptionResponse;
    }

}
