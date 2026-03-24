package co.edu.eci.lambda.springtest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FactorsService {
    public List<Integer> factors(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("value must be a positive integer (>= 1)");
        }

        List<Integer> result = new ArrayList<>();
        result.add(1);

        if (n == 1) {
            return result;
        }
        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) {
                result.add(i);
            }
        }
        result.add(n);

        return result;
    }
    public String factorsAsCsv(int n) {
        List<Integer> factors = factors(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < factors.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(factors.get(i));
        }
        return sb.toString();
    }
}