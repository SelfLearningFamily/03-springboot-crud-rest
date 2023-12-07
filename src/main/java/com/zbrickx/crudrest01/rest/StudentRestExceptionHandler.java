package com.zbrickx.crudrest01.rest;

import com.zbrickx.crudrest01.response.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
        StudentErrorResponse ser = new StudentErrorResponse();
        ser.setMessage(exe.getMessage());
        ser.setStatus(HttpStatus.NOT_FOUND.value());
        ser.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(ser,HttpStatus.NOT_FOUND);
    }

    // not very good practice to handle multiple exception in one method. But for now consider it as an outer
    //barrier to make our system more robust
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
        StudentErrorResponse ser = new StudentErrorResponse();
        ser.setMessage(exe.getMessage());
        ser.setStatus(HttpStatus.BAD_REQUEST.value());
        ser.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(ser,HttpStatus.BAD_REQUEST);
    }
}
