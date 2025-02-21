package Demo_Rest.Excepton;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class VendorExceptionHandler {

    @ExceptionHandler(value = {VendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (VendorNotFoundException cloudVendorNotFoundException)
    {
        VendorException cloudVendorException = new VendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }
}

