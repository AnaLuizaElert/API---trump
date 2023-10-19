package br.senai.sc.supertrunfofrutas.business.exception;

import org.springframework.validation.BindException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handleBaseException(BaseException e){
        ApiError apiError = new ApiError(e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception e){
        ApiError apiError = new ApiError(e.getClass().getSimpleName(), e.getMessage());
        return ResponseEntity.internalServerError().body(apiError);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> validacoesInvalidas(BindException ex) {

        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();

        if (fieldError != null) {
            ApiError apiError = new ApiError(ex.getClass().getSimpleName(), fieldError.getDefaultMessage());
            return ResponseEntity.badRequest().body(apiError);
        }

        return ResponseEntity.badRequest().body("Validation Error");
    }


    static record ApiError(String type, String error){}
}
