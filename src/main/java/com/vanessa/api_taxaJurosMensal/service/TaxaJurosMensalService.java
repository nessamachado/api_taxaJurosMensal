package com.vanessa.api_taxaJurosMensal.service;

import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.repositorie.TaxaJurosMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaJurosMensalService {

    @Autowired
    private TaxaJurosMensalRepository rep;

    @Autowired
    private TaxaJurosMensalMapper taxaJurosMensalMapper;

    public List<TaxaJurosMensalResponse> encontrarTodos() {
        List<TaxaJurosMensalEntity> taxaJurosMensalEntityList = rep.findAll();
        List<TaxaJurosMensalDTO> taxaJurosMensalDTOList = taxaJurosMensalMapper.createEntityToDtoList(taxaJurosMensalEntityList);
        List<TaxaJurosMensalResponse> taxaJurosMensalResponseList =taxaJurosMensalMapper.createDtoToResponseList(taxaJurosMensalDTOList);
        return taxaJurosMensalResponseList;
    }

    public TaxaJurosMensalResponse encontrarPorId(Long id){
        TaxaJurosMensalEntity taxaJurosMensalEntity = rep.findById(id).orElse(null);
        TaxaJurosMensalDTO taxaJurosMensalDTO = taxaJurosMensalMapper.createEntityToDto(taxaJurosMensalEntity);
        TaxaJurosMensalResponse taxaJurosMensalResponse = taxaJurosMensalMapper.createDtoToResponse(taxaJurosMensalDTO);
        return taxaJurosMensalResponse;
    }
}
