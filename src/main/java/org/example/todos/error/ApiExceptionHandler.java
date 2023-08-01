package org.example.todos.error;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.ws.http.HTTPException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleApiException(NotFoundException e , WebRequest request){
        ErrorDetails details = new ErrorDetails(e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(details,e.getStatus());
    }
}
