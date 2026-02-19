package org.pbe.exerciciocpf;
import org.springframework.web.bind.annotation.*;
import java.security.InvalidParameterException;

@RestController
public class CPFChecker {

    @GetMapping("/api/verificador/{cpf}")
    public String check_in_uri(@PathVariable String cpf) {
        try {
            CPF check = new CPF(cpf);
                    return "OK";
        } catch (InvalidParameterException e) {
            return "INVALIDO";
        }
    }
    @GetMapping("/api/verificador")
    public String check_in_query(@RequestParam String cpf) {
        return null;
    }

    @PostMapping("/api/verificador")
    public String check_in_body(@RequestParam String cpf) {
        return null;
    }
}