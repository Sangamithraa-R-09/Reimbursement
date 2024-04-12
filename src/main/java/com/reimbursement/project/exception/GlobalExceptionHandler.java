package com.reimbursement.project.exception;

import com.reimbursement.project.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ResponseDto> handleAlreadyExistsException(AlreadyExistException ex) {
        ResponseDto response = new ResponseDto();
        response.setHttpStatus(HttpStatus.CONFLICT);
        response.setMessage(ex.getMessage());
        response.setData(null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setHttpStatus(HttpStatus.NOT_FOUND);
        responseDto.setMessage(exception.getMessage());
        responseDto.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    @ExceptionHandler(InvalidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ResponseDto> handleInvalidException(InvalidException e){
        ResponseDto responseDto=new ResponseDto();
        responseDto.setHttpStatus(HttpStatus.FORBIDDEN);
        responseDto.setMessage(e.getMessage());
        responseDto.setData(null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseDto);
    }
}
