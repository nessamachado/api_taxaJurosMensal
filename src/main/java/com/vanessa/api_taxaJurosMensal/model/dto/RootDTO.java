package com.vanessa.api_taxaJurosMensal.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RootDTO implements Serializable {

    @JsonProperty("@odata.context")
    private String odataContext;

    @JsonProperty("value")
    private List<TaxaJurosMensalDTO> value;
}
