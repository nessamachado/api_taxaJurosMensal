package com.vanessa.api_taxaJurosMensal.controller;

import com.vanessa.api_taxaJurosMensal.model.dto.RootDTO;
import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.service.TaxaJurosMensalOnbordingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxaJurosMensal")
public class TaxaJurosMensalOnbordingController {

    @Autowired
    private TaxaJurosMensalOnbordingService taxaJurosMensalOnbordingService;

    private TaxaJurosMensalMapper taxaJurosMensalMapper;

   @GetMapping("/buscarApi")
   public RootDTO taxaJuroMensalBuscarApi(){
       return taxaJurosMensalOnbordingService.buscarApi();
   }

    @PostMapping("/onbording")
    public ResponseEntity<List<TaxaJurosMensalDTO>> taxaJurosSalvarBD(){
        List<TaxaJurosMensalDTO> retorno = taxaJurosMensalOnbordingService.salvar();
        //List<TaxaJurosMensalResponse> response = taxaJurosMensalMapper.createDtoToResponseList(retorno);

        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

}
