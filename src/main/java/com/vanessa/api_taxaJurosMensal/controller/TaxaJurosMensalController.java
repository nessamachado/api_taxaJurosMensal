package com.vanessa.api_taxaJurosMensal.controller;

import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.service.TaxaJurosMensalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TaxaJuros")
public class TaxaJurosMensalController {

    @Autowired
    private TaxaJurosMensalService taxaJurosMensalService;

    @Autowired
    private TaxaJurosMensalMapper taxaJurosMensalMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaxaJurosMensalResponse> buscarTodasTaxas(){
        return taxaJurosMensalService.encontrarTodos();
    }

}
