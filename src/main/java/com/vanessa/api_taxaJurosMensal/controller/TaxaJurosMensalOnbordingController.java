package com.vanessa.api_taxaJurosMensal.controller;

import com.vanessa.api_taxaJurosMensal.model.dto.RootDTO;
import com.vanessa.api_taxaJurosMensal.service.TaxaJurosMensalOnbordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxaJurosMensal")
public class TaxaJurosMensalOnbordingController {

    @Autowired
    private TaxaJurosMensalOnbordingService taxaJurosMensalOnbordingService;

   @GetMapping("/buscarApi")
   public RootDTO taxaJuroMensalBuscarApi(){
       return taxaJurosMensalOnbordingService.buscarApi();
   }


}
