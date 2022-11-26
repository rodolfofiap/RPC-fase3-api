package RPC.com.fiap.abc.fase3.api.service;

import RPC.com.fiap.abc.fase3.api.model.Assistance;
import RPC.com.fiap.abc.fase3.api.repository.AssistanceRepository;
import RPC.com.fiap.abc.fase3.api.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest
public class AssistanceServiceTeste {

    @Mock
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }

    @DisplayName("Listando assistencias disponiveis :: Sucesso")
    @Test
    public void list_success(){

        Assistance assistance1 = new Assistance();
        Assistance assistance3 = new Assistance();
        Assistance assistance2 = new Assistance();

        when(assistanceRepository.findAll()).thenReturn(List.of(assistance1, assistance2, assistance3));

        List<Assistance> values = assistanceService.getAssistanceList();

        Assertions.assertEquals(3, values.size());
        Assertions.assertSame(values.get(0), assistance1);
        Assertions.assertSame(values.get(1), assistance2);
    }

    @DisplayName("Listando assistencias indisponiveis :: Erro")
    @Test
    public void list_error(){
        when(assistanceRepository.findAll()).thenReturn(List.of());

        List<Assistance> values = assistanceService.getAssistanceList();
        Assertions.assertEquals(0, values.size());
    }

}
