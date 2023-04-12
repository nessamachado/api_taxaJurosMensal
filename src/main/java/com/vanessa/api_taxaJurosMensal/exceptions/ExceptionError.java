package com.vanessa.api_taxaJurosMensal.exceptions;

public class ExceptionError {

    private String error;

    ExceptionError(String error) {
        this.error = error;
    }

    public String getError(){
        return error;
    }
}
