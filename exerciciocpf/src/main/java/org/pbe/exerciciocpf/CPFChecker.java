package org.pbe.exerciciocpf;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.InvalidParameterException;
import java.util.Random;

@RestController
public class CPFChecker {

    @GetMapping("/api/verificador/{cpf}")
    public ResponseEntity<String> check_in_uri(@PathVariable String cpf) {
       Random r = new Random();
       if (r.nextBoolean()){
           return ResponseEntity.ok().body("OK");
       }
        return ResponseEntity.badRequest().body("INVÁLIDO");




       //        try {
//            CPF check = new CPF(cpf);
//                    return ResponseEntity.ok().body("OK");
//        } catch (InvalidParameterException e) {
//            return ResponseEntity.badRequest().body("INVÁLIDO");
//        }
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