package core.ms.client.cross.utils;


import core.ms.client.exceptions.BusinessException;

public class ValidationParameter {

    private ValidationParameter() {}

    public static Long validate(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            throw new BusinessException("Parâmetro Inválido");
        }
    }
}
