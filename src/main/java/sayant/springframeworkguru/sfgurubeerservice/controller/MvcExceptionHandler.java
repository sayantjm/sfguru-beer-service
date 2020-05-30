package sayant.springframeworkguru.sfgurubeerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sayantjm on 30/5/20
 */
@ControllerAdvice
public class MvcExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
