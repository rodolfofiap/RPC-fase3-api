package RPC.com.fiap.abc.fase3.api.controller;


import RPC.com.fiap.abc.fase3.api.model.Assistance;
import RPC.com.fiap.abc.fase3.api.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private final AssistanceService service;

    @Autowired
    public AssistanceController(AssistanceService service){
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Assistance>> getAssists(){
        List<Assistance> list = service.getAssistanceList();
        return ResponseEntity.ok(list);
    }

}
