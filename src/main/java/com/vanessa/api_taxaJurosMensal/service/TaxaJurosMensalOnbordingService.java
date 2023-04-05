package com.vanessa.api_taxaJurosMensal.service;

import com.vanessa.api_taxaJurosMensal.feignTaxaJurosMensal.ClientTaxaJurosMensal;
import com.vanessa.api_taxaJurosMensal.model.dto.RootDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxaJurosMensalOnbordingService {

    @Autowired
    private ClientTaxaJurosMensal clientTaxaJurosMensal;

    public RootDTO buscarApi(){
        return clientTaxaJurosMensal.getALLTaxasJurosMensal();
    }
}
