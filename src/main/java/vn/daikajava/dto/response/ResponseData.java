package vn.daikajava.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseData<T> {
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // PUT, PATCH, DELETE
    public ResponseData(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // GET, POST
    public ResponseData(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
