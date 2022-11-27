package RPC.com.fiap.abc.fase3.api.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderLocationDto {

    private Double latitude;
    private Double longitude;
    private Date datetime;
}
