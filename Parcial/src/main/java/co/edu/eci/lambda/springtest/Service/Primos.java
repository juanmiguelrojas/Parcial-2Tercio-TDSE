package co.edu.eci.lambda.springtest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Primos {

    private final FactorsService factorsService;

    public Primos(FactorsService factorsService) {
        this.factorsService = factorsService;
    }

    public List<Integer> primes(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("value must be a positive integer (>= 1)");
        }

        List<Integer> result = new ArrayList<>();

        // Fuerza bruta: explorar cada x desde 1 hasta n
        for (int x = 1; x <= n; x++) {
            if (x == 1) {
                result.add(1); // según enunciado: 1 es primo
                continue;
            }

            // primo si solo tiene 2 factores: 1 y él mismo
            if (factorsService.factors(x).size() == 2) {
                result.add(x);
            }
        }

        return result;
    }

    public String primesAsCsv(int n) {
        List<Integer> p = primes(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(p.get(i));
        }
        return sb.toString();
    }
}