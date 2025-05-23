package dev.vicky.restAPI.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class CloudVendorExceptionHandler {


  @ExceptionHandler(value={CloudVendorNotFoundException.class})
  public ResponseEntity<Object> handlerCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){


    CloudVendorException cloudVendorException=new CloudVendorException(cloudVendorNotFoundException.getMessage(),cloudVendorNotFoundException.getCause(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(cloudVendorException,HttpStatus.NOT_FOUND);


  }

}
