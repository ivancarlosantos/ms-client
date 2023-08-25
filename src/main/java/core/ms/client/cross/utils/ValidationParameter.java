package core.ms.client.cross.utils;

import core.ms.client.exceptions.BusinessException;

public class ValidationParameter{

    private ValidationParameter(){}

    public static Long validateParamLong(String value)  {
        try {
            return Long.parseLong(value);
        }catch (NumberFormatException ex){
            throw new BusinessException("");
        }
    }
}
