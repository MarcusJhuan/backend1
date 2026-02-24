package org.pbe.exerciciocpf;

import java.security.InvalidParameterException;

public class CPF {
    private final String digits;

    public CPF(String cpf) {
        if (cpf == null) {
            throw new InvalidParameterException("CPF nulo");
        }
        // remove non-digit characters
        String cleaned = cpf.replaceAll("\\D", "");
        if (!isValid(cleaned)) {
            throw new InvalidParameterException("CPF inválido");
        }
        this.digits = cleaned;
    }

    public String getDigits() {
        return digits;
    }

    /**
     * Verifica se a string contém um CPF válido (apenas dígitos, 11 caracteres).
     */
    public static boolean isValid(String numeric) {
        if (numeric == null) {
            return false;
        }
        if (!numeric.matches("\\d{11}")) {
            return false;
        }
        // não deixa todos os dígitos iguais (ex: 00000000000, 11111111111 etc)
        boolean allSame = true;
        for (int i = 1; i < 11; i++) {
            if (numeric.charAt(i) != numeric.charAt(0)) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = numeric.charAt(i) - '0';
        }

        // primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }
        int firstCheck = (sum * 10) % 11;
        if (firstCheck == 10) {
            firstCheck = 0;
        }
        if (firstCheck != digits[9]) {
            return false;
        }

        // segundo dígito verificador
        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            int weight = 11 - i;
            int value = (i < 9) ? digits[i] : firstCheck;
            sum2 += value * weight;
        }
        int secondCheck = (sum2 * 10) % 11;
        if (secondCheck == 10) {
            secondCheck = 0;
        }
        return secondCheck == digits[10];
    }
}
