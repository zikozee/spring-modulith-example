package com.zee.modulith.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : Ezekiel Eromosei
 * @code @created : 18 May, 2024
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> fieldErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return new ResponseEntity<>(getErrorsMap(fieldErrors), new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }

    private Map<String, List<String>> getErrorsMap(List<String> fieldErrors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", fieldErrors);
        return errorResponse;
    }

    @ExceptionHandler(ModulithException.class)
    public ResponseEntity<Response> handleModulithException(ModulithException ex) {
        return new ResponseEntity<>(new Response(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
