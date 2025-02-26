package vn.daikajava.dto.response;

import org.springframework.http.HttpStatusCode;

public class ResponseError extends ResponseSuccess{
    public ResponseError(HttpStatusCode status, String message) {
        super(status, message);
    }
}
