package RPC.com.fiap.abc.fase3.api.handler.exception;

import lombok.Getter;

@Getter
public class MaxAssistsExcepition extends RuntimeException {
    private String description;

    public MaxAssistsExcepition(String message, String description){

        super(message);
        this.description = description;
    }
}
