package org.pbe.exerciciocpf;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.InvalidParameterException;

@RestController
public class CPFChecker {

    @GetMapping("/api/verificador/{cpf}")
    public ResponseEntity<String> check_in_uri(@PathVariable String cpf) {
        return validate(cpf);
    }

    @GetMapping("/api/verificador")
    public ResponseEntity<String> check_in_query(@RequestParam String cpf) {
        return validate(cpf);
    }

    @PostMapping("/api/verificador")
    public ResponseEntity<String> check_in_body(@RequestParam String cpf) {
        return validate(cpf);
    }

    private ResponseEntity<String> validate(String cpf) {
        try {
            new CPF(cpf);
            return ResponseEntity.ok().body("OK");
        } catch (InvalidParameterException e) {
            return ResponseEntity.badRequest().body("INVÁLIDO");
        }
    }
}
