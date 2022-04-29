package se.magnus.util.http;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class HttpErrorInfo {
    private final ZonedDateTime timestamp;
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;

    public HttpErrorInfo() {
        this.timestamp = null;
        this.httpStatus = null;
        this.path = null;
        this.message = null;
    }

    public HttpErrorInfo(HttpStatus httpStatus, String path, String message) {
        this.timestamp = ZonedDateTime.now();
        this.httpStatus = httpStatus;
        this.path = path;
        this.message = message;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getPath() {
        return this.path;
    }

    public int getStatus() {
        return this.httpStatus.value();
    }

    public String getError() {
        return this.httpStatus.getReasonPhrase();
    }

    public String getMessage() {
        return this.message;
    }

}
