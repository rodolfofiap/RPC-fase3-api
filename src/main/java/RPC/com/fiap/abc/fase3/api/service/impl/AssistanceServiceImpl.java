package RPC.com.fiap.abc.fase3.api.service.impl;

import RPC.com.fiap.abc.fase3.api.model.Assistance;
import RPC.com.fiap.abc.fase3.api.repository.AssistanceRepository;
import RPC.com.fiap.abc.fase3.api.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository repository;

    @Autowired
    public AssistanceServiceImpl(AssistanceRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Assistance> getAssistanceList() {return repository.findAll();}

}
