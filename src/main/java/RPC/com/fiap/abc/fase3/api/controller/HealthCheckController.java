package RPC.com.fiap.abc.fase3.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("version")
    public ResponseEntity<String> status() throws IOException {

        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yaml");
        properties.load(inputStream);

        return ResponseEntity.ok(properties.getProperty("build.name") + " - " + properties.getProperty("build.version"));
    }

}
