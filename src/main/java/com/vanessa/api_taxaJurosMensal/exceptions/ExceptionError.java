package com.vanessa.api_taxaJurosMensal.exceptions;

import com.vanessa.api_taxaJurosMensal.Generated;

@Generated
public class ExceptionError {

    private String error;

    ExceptionError(String error) {
        this.error = error;
    }

    public String getError(){
        return error;
    }
}
