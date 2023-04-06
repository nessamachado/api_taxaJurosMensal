package com.vanessa.api_taxaJurosMensal.model.mapper;

import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaxaJurosMensalMapper {

    public TaxaJurosMensalEntity createDtoToEntity(TaxaJurosMensalDTO taxaJurosMensalDTO){
        TaxaJurosMensalEntity taxaJurosMensalEntity = new TaxaJurosMensalEntity();
        taxaJurosMensalEntity.setId(taxaJurosMensalDTO.getId());
        taxaJurosMensalEntity.setMes(taxaJurosMensalDTO.getMes());
        taxaJurosMensalEntity.setModalidade(taxaJurosMensalDTO.getModalidade());
        taxaJurosMensalEntity.setPosicao(taxaJurosMensalDTO.getPosicao());
        taxaJurosMensalEntity.setInstituicaoFinanceira(taxaJurosMensalDTO.getInstituicaoFinanceira());
        taxaJurosMensalEntity.setTaxaJurosAoMes(taxaJurosMensalDTO.getTaxaJurosAoMes());
        taxaJurosMensalEntity.setTaxaJurosAoAno(taxaJurosMensalDTO.getTaxaJurosAoAno());
        taxaJurosMensalEntity.setCnpj8(taxaJurosMensalDTO.getCnpj8());
        taxaJurosMensalEntity.setAnoMes(taxaJurosMensalDTO.getAnoMes());
        return taxaJurosMensalEntity;
    }

    public List<TaxaJurosMensalEntity> createDtoToEntityList(List<TaxaJurosMensalDTO> listDTO){
        List<TaxaJurosMensalEntity> listEntity = new ArrayList<>(listDTO.size());
        for (TaxaJurosMensalDTO taxa : listDTO){
            listEntity.add(createDtoToEntity(taxa));
        }
        return listEntity;
    }

    public TaxaJurosMensalDTO createEntityToDto(TaxaJurosMensalEntity taxaJurosEntity) {
        TaxaJurosMensalDTO taxaJurosDTO = new TaxaJurosMensalDTO();
        taxaJurosDTO.setId(taxaJurosEntity.getId());
        taxaJurosDTO.setMes(taxaJurosEntity.getMes());
        taxaJurosDTO.setModalidade(taxaJurosEntity.getModalidade());
        taxaJurosDTO.setPosicao(taxaJurosEntity.getPosicao());
        taxaJurosDTO.setInstituicaoFinanceira(taxaJurosEntity.getInstituicaoFinanceira());
        taxaJurosDTO.setTaxaJurosAoMes(taxaJurosEntity.getTaxaJurosAoMes());
        taxaJurosDTO.setTaxaJurosAoAno(taxaJurosEntity.getTaxaJurosAoAno());
        taxaJurosDTO.setCnpj8(taxaJurosEntity.getCnpj8());
        taxaJurosDTO.setAnoMes(taxaJurosEntity.getAnoMes());
        return taxaJurosDTO;
    }

    public List<TaxaJurosMensalDTO> createEntityToDtoList(List<TaxaJurosMensalEntity> listEntity){
        List<TaxaJurosMensalDTO> listDto = new ArrayList<>(listEntity.size());
        for (TaxaJurosMensalEntity taxa: listEntity){
            listDto.add(createEntityToDto(taxa));
        }
        return listDto;
    }

    public TaxaJurosMensalResponse createDtoToResponse(TaxaJurosMensalDTO taxaJurosDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(taxaJurosDTO, TaxaJurosMensalResponse.class);
    }

    public List<TaxaJurosMensalResponse> createDtoToResponseList(List<TaxaJurosMensalDTO> listDto) {
        List<TaxaJurosMensalResponse> taxaResponseList = new ArrayList<>(listDto.size());
        for (TaxaJurosMensalDTO taxas : listDto) {
            taxaResponseList.add(createDtoToResponse(taxas));
        }
        return taxaResponseList;
    }


}
