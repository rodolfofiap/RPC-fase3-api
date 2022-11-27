package RPC.com.fiap.abc.fase3.api.service;

import RPC.com.fiap.abc.fase3.api.model.Order;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order, List<Long> arrayAssists) throws Exception;
    List<Order> listOrderByOperator(Long operatorId);
}
