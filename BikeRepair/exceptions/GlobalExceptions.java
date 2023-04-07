package BikeRepair.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> HandleMethodArgsNotValidException (MethodArgumentNotValidException ex)
    {
        Map<String,String> errors= new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
          String fieldname =  ((FieldError)error).getField();
        String message =  error.getDefaultMessage();
        errors.put(fieldname,message);
        });

        return  new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
    }
}
