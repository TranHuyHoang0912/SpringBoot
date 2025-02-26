package vn.daikajava.dto.response;

import org.springframework.http.HttpStatusCode;

public class ResponseFaillure extends ResponseSuccess{
    public ResponseFaillure(HttpStatusCode status, String message) {
        super(status, message);
    }
}
