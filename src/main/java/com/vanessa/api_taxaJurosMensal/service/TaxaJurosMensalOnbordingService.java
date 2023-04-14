package com.vanessa.api_taxaJurosMensal.service;

import com.vanessa.api_taxaJurosMensal.feignTaxaJurosMensal.ClientTaxaJurosMensal;
import com.vanessa.api_taxaJurosMensal.model.dto.RootDTO;
import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.repositorie.TaxaJurosMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaJurosMensalOnbordingService {

    @Autowired
    private ClientTaxaJurosMensal clientTaxaJurosMensal;

    @Autowired
    private TaxaJurosMensalRepository rep;

    @Autowired
    private TaxaJurosMensalMapper taxaMapper;

    public RootDTO buscarApi(){
        return clientTaxaJurosMensal.getALLTaxasJurosMensal();
    }

    public List<TaxaJurosMensalDTO> onbording(RootDTO rootDTO){
        List<TaxaJurosMensalDTO> list = rootDTO.getValue();
        List<TaxaJurosMensalEntity> taxaJurosMensalEntity = taxaMapper.createDtoToEntityList(list);
        List<TaxaJurosMensalEntity> retorno = rep.saveAll(taxaJurosMensalEntity);
        List<TaxaJurosMensalDTO> dto = taxaMapper.createEntityToDtoList(retorno);

        return dto;

    }

    public List<TaxaJurosMensalDTO> salvar(){
        List<TaxaJurosMensalDTO> retorno = onbording(buscarApi());

        return retorno;
    }
}
