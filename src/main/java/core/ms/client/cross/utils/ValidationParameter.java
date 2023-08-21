package core.ms.client.cross.utils;

public class ValidationParameter {
    private ValidationParameter() {

    }

    public static Long validation(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Numero invalido");
        }

    }
}
