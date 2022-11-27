package RPC.com.fiap.abc.fase3.api.handler.exception;

import lombok.Getter;

@Getter
public class MinimumAssistisRequiredExceptions extends RuntimeException {
    private String description;

    public MinimumAssistisRequiredExceptions(String message, String description){

        super(message);
        this.description = description;
    }
}
