package com.vanessa.api_taxaJurosMensal.controller;

import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.service.TaxaJurosMensalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/id/{id}")
    public TaxaJurosMensalResponse buscarPorId(@PathVariable("id") Long id){
        return taxaJurosMensalService.encontrarPorId(id);
    }

    @PostMapping("/salvar")
    public ResponseEntity<TaxaJurosMensalResponse> salvar(@RequestBody TaxaJurosMensalDTO taxaJurosMensalDTO){
        TaxaJurosMensalResponse taxaJurosMensalResponse = taxaJurosMensalService.insert(taxaJurosMensalDTO);
        return ResponseEntity.created(null).body(taxaJurosMensalResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaxaJurosMensalResponse> alterar(@RequestBody TaxaJurosMensalDTO taxaJurosMensalDTO, @PathVariable("id") Long id){
        TaxaJurosMensalResponse taxaJurosMensalResponse = taxaJurosMensalService.update(taxaJurosMensalDTO, id);
        return ResponseEntity.ok().body(taxaJurosMensalResponse);
    }

}
