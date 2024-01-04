package walletservice.wallet.controlleradvice;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import walletservice.wallet.controlleradvice.exception.ExceptionResponse;
import walletservice.wallet.controlleradvice.exception.ServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

@ControllerAdvice
public class WalletExceptionHandler {
    private static final String LOCALE = "exceptions_fa_IR.properties";

    @PostConstruct
    public void init() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(LOCALE);
        InputStreamReader in = new InputStreamReader(inputStream,"utf8");
        properties.load(in);
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handler(ServiceException serviceException){
        return ExceptionResponse.builder()
                .timeStamp(new Date())
                .errorCode(55)
                .message("error-system-exception")
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ExceptionResponse handler(IllegalArgumentException illegalArgumentException){
        return ExceptionResponse.builder()
                .timeStamp(new Date())
                .errorCode(55)
                .message("the-entries-are-incorrect")
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlers(MethodArgumentNotValidException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimeStamp(new Date());
        exceptionResponse.setErrorCode(55);

        FieldError fieldError = exception.getBindingResult().getFieldError();
        String message = "error in field : " + fieldError.getField() + " " + fieldError.getDefaultMessage();
        exceptionResponse.setMessage(message);
        return exceptionResponse;
    }
}
