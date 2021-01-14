package proiectpwtj.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLSyntaxErrorException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> objectValidation(MethodArgumentNotValidException exception){
        Map<String,Object> map = new HashMap<>();
        List<ObjectError> errorList = exception.getAllErrors();
        List<ErrorResponse> errorResponses = errorList.stream().map(err -> new ErrorResponse(err.getDefaultMessage())).collect(Collectors.toList());
        map.put("timestamp", LocalDateTime.now());
        map.put("errors", errorResponses);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity<Object> getElementsValidation(ObjectNotFoundException exception){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errors", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({SQLSyntaxErrorException.class})
    public ResponseEntity<Object> getAttractionsValidation(SQLSyntaxErrorException exception){
        Map<String,Object> body = new HashMap<>();
        String errorList2 = exception.getMessage();
       String errorResponses = errorList2.toString();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", errorResponses);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
