package com.vanessa.api_taxaJurosMensal.service;

import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.repositorie.TaxaJurosMensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public TaxaJurosMensalResponse insert (TaxaJurosMensalDTO taxaJurosMensalDTO){
        TaxaJurosMensalEntity taxaJurosMensalEntity = taxaJurosMensalMapper.createDtoToEntity(taxaJurosMensalDTO);
        rep.save(taxaJurosMensalEntity);
        TaxaJurosMensalDTO taxaJurosMensalDTO1 = taxaJurosMensalMapper.createEntityToDto(taxaJurosMensalEntity);
        return taxaJurosMensalMapper.createDtoToResponse(taxaJurosMensalDTO1);
    }

    public TaxaJurosMensalResponse update(TaxaJurosMensalDTO taxaJurosMensalDTO, Long id){
        TaxaJurosMensalEntity taxaJurosMensalEntity = rep.findById(id).orElse(null);
        taxaJurosMensalEntity.setMes(taxaJurosMensalDTO.getMes());
        taxaJurosMensalEntity.setModalidade(taxaJurosMensalDTO.getModalidade());
        taxaJurosMensalEntity.setPosicao(taxaJurosMensalDTO.getPosicao());
        taxaJurosMensalEntity.setInstituicaoFinanceira(taxaJurosMensalDTO.getInstituicaoFinanceira());
        taxaJurosMensalEntity.setTaxaJurosAoMes(taxaJurosMensalDTO.getTaxaJurosAoMes());
        taxaJurosMensalEntity.setTaxaJurosAoAno(taxaJurosMensalDTO.getTaxaJurosAoAno());
        taxaJurosMensalEntity.setCnpj8(taxaJurosMensalDTO.getCnpj8());
        taxaJurosMensalEntity.setAnoMes(taxaJurosMensalDTO.getAnoMes());
        rep.save(taxaJurosMensalEntity);
        TaxaJurosMensalDTO taxaJurosMensalDTO1 = taxaJurosMensalMapper.createEntityToDto(taxaJurosMensalEntity);
        TaxaJurosMensalResponse taxaJurosMensalResponse  =  taxaJurosMensalMapper.createDtoToResponse(taxaJurosMensalDTO1);
        return taxaJurosMensalResponse;
    }

    public void delete (Long id){
        rep.deleteById(id);
    }

    public List<TaxaJurosMensalResponse> listarPorPagina(Pageable pageable) {
        Page<TaxaJurosMensalEntity> taxaJurosMensalEntityPage = rep.findAll(pageable);
        List<TaxaJurosMensalDTO> taxaJurosMensalDTOList = taxaJurosMensalMapper.createEntityToDtoList(taxaJurosMensalEntityPage.toList());
        List<TaxaJurosMensalResponse> taxaJurosMensalResponseList = taxaJurosMensalMapper.createDtoToResponseList(taxaJurosMensalDTOList);
        return taxaJurosMensalResponseList;
    }

    public List<TaxaJurosMensalResponse> listarAnoMes(String anoMes) {
        List<TaxaJurosMensalEntity> taxaJurosMensalEntityList = rep.findByAnoMes(anoMes);
        List<TaxaJurosMensalDTO> taxaJurosMensalDTOList = taxaJurosMensalMapper.createEntityToDtoList(taxaJurosMensalEntityList);
        List<TaxaJurosMensalResponse> taxaJurosMensalResponseList = taxaJurosMensalMapper.createDtoToResponseList(taxaJurosMensalDTOList);
        return taxaJurosMensalResponseList;
    }

}
