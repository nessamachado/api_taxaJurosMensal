package com.vanessa.api_taxaJurosMensal.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaxaJurosMensalResponse {

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
