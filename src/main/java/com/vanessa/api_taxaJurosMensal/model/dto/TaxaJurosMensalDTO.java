package com.vanessa.api_taxaJurosMensal.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vanessa.api_taxaJurosMensal.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Generated
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxaJurosMensalDTO implements Serializable {

    @JsonIgnore
    private Long id;
    @JsonProperty("Mes")
    private String mes;
    @JsonProperty("Modalidade")
    private String modalidade;
    @JsonProperty("Posicao")
    private int posicao;
    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;
    @JsonProperty("TaxaJurosAoMes")
    private int taxaJurosAoMes;
    @JsonProperty("TaxaJurosAoAno")
    private int taxaJurosAoAno;
    private String cnpj8;
    private String anoMes;
}
