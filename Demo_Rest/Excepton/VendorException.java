package Demo_Rest.Excepton;

import org.springframework.http.HttpStatus;

public class VendorException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public VendorException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
