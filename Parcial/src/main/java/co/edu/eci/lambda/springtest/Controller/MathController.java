package co.edu.eci.lambda.springtest.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eci.lambda.springtest.Service.FactorsService;
import co.edu.eci.lambda.springtest.Service.Primos;

@RestController
public class MathController {

    private final FactorsService factorsService;
    private final Primos primosService;

    public MathController(FactorsService factorsService, Primos primosService) {
        this.factorsService = factorsService;
        this.primosService = primosService;
    }

    @GetMapping("/factors")
    public ResponseEntity<Map<String, Object>> factors(@RequestParam(name = "value") int value) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("operation", "factors");
        body.put("input", value);
        body.put("output", factorsService.factorsAsCsv(value));
        return ResponseEntity.ok(body);
    }

    @GetMapping("/primes")
    public ResponseEntity<Map<String, Object>> primes(@RequestParam(name = "value") int value) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("operation", "primes");
        body.put("input", value);
        body.put("output", primosService.primesAsCsv(value));
        return ResponseEntity.ok(body);
    }
}