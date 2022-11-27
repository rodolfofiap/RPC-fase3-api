package RPC.com.fiap.abc.fase3.api.application.impl;

import RPC.com.fiap.abc.fase3.api.application.OrderApplication;
import RPC.com.fiap.abc.fase3.api.application.dto.OrderDto;
import RPC.com.fiap.abc.fase3.api.application.dto.OrderLocationDto;
import RPC.com.fiap.abc.fase3.api.model.Order;
import RPC.com.fiap.abc.fase3.api.model.OrderLocation;
import RPC.com.fiap.abc.fase3.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService){
        this.orderService = orderService;

    }
    @Override
    public void createOrder(OrderDto orderDto) throws Exception {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
       order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStart()));
       order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEnd()));

       this.orderService.saveOrder(order, orderDto.getAssists());

    }

    private OrderLocation getOrderLocationFromOrderLocationDto(OrderLocationDto orderLocationDto){
        OrderLocation orderLocation = new OrderLocation();
        orderLocation.setLatitude(orderLocationDto.getLatitude());
        orderLocation.setLongitude(orderLocationDto.getLongitude());
        orderLocation.setDate(orderLocationDto.getDatetime());
        return orderLocation;

    }
}
