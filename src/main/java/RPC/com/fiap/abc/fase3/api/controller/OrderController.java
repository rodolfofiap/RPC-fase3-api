package RPC.com.fiap.abc.fase3.api.controller;

import RPC.com.fiap.abc.fase3.api.application.OrderApplication;
import RPC.com.fiap.abc.fase3.api.application.dto.OrderDto;
import RPC.com.fiap.abc.fase3.api.application.impl.OrderApplicationImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderApplication orderApplication;

    public OrderController(
            @Autowired OrderApplication orderApplication
    ){
        this.orderApplication = orderApplication;
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto) throws Exception {

        orderApplication.createOrder(orderDto);
        return  ResponseEntity.ok().build();

    }



}
