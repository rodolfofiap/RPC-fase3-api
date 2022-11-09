package RPC.com.fiap.abc.fase3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping()
    public ResponseEntity<Object> status(){

        return ResponseEntity.ok().build();
    }

}
