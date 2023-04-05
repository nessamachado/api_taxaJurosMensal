package com.vanessa.api_taxaJurosMensal.feignTaxaJurosMensal;

import com.vanessa.api_taxaJurosMensal.model.dto.RootDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "taxaJurosMensal", url = "https://olinda.bcb.gov.br/olinda/servico/taxaJuros/versao/v2/odata/TaxasJurosMensalPorMes?$top=50&$format=json" )
public interface ClientTaxaJurosMensal {

    @GetMapping
    RootDTO getALLTaxasJurosMensal();

}
