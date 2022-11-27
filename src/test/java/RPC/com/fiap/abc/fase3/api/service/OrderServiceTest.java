package RPC.com.fiap.abc.fase3.api.service;

import RPC.com.fiap.abc.fase3.api.handler.exception.MaxAssistsExcepition;
import RPC.com.fiap.abc.fase3.api.handler.exception.MinimumAssistisRequiredExceptions;
import RPC.com.fiap.abc.fase3.api.model.Assistance;
import RPC.com.fiap.abc.fase3.api.model.Order;
import RPC.com.fiap.abc.fase3.api.repository.AssistanceRepository;
import RPC.com.fiap.abc.fase3.api.repository.OrderRepository;
import RPC.com.fiap.abc.fase3.api.service.impl.OrderServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private AssistanceRepository assistanceRepository;

    private OrderService orderService;

    @BeforeEach
    public void init() {

        orderService = new OrderServiceImpl(orderRepository, assistanceRepository);
        when(assistanceRepository.findById(any())).thenReturn(Optional.of(new Assistance(1L, "Teste", "Decricao do Teste:")));
    }
    @Test
    public void order_service_not_null(){

        Assertions.assertNotNull(orderService);
    }

    @Test
    public void create_order_minimum(){
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        Assertions.assertThrows(MinimumAssistisRequiredExceptions.class, () -> orderService.saveOrder(newOrder, List.of()));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_max() {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        Assertions.assertThrows(MaxAssistsExcepition.class, () -> orderService.saveOrder(newOrder, generate_mocks_ids(20)));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_success() throws Exception{
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        orderService.saveOrder(newOrder, generate_mocks_ids(5));
        verify(orderRepository, times(1)).save(newOrder);

    }

    private List<Long> generate_mocks_ids(int number) {

        ArrayList<Long> arrayList = new ArrayList<>();
        for (int x = 0; x < number; x++) {
            arrayList.add(Integer.toUnsignedLong(x));

        }
        return arrayList;
    }

}
