package RPC.com.fiap.abc.fase3.api.service.impl;

import RPC.com.fiap.abc.fase3.api.handler.exception.MaxAssistsExcepition;
import RPC.com.fiap.abc.fase3.api.handler.exception.MinimumAssistisRequiredExceptions;
import RPC.com.fiap.abc.fase3.api.model.Assistance;
import RPC.com.fiap.abc.fase3.api.model.Order;
import RPC.com.fiap.abc.fase3.api.repository.AssistanceRepository;
import RPC.com.fiap.abc.fase3.api.repository.OrderRepository;
import RPC.com.fiap.abc.fase3.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private AssistanceRepository assistanceRepository;

    public OrderServiceImpl(

            @Autowired OrderRepository orderRepository,
            @Autowired AssistanceRepository assistanceRepository){
            this.orderRepository = orderRepository;
            this.assistanceRepository = assistanceRepository;


    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) throws Exception {

        ArrayList<Assistance> assistances = new ArrayList<>();
        arrayAssists.forEach( i -> {
            Assistance assistance = assistanceRepository.findById(i).orElseThrow();
            assistances.add(assistance);
        });
        order.setAssists(assistances);

        if(!order.hasMinAssists()){
            throw new MinimumAssistisRequiredExceptions("Invalid Assists","Ncessario no minimo uma assistencia");
        }else if (order.execeedsMaxAssists()) {
            throw new MaxAssistsExcepition("Invalid Assists","Numero max eh 15");
        }
        orderRepository.save(order);
        }


    @Override
    public List<Order> listOrderByOperator(Long operatorId) {
        return null;
    }
}
