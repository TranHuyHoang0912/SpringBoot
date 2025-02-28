package vn.daikajava.dto.response;

import org.springframework.http.HttpStatusCode;

public class ResponseError extends ResponseData{
    public ResponseError(String message, int status) {
        super(message, status);
    }
}
