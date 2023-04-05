package com.vanessa.api_taxaJurosMensal.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "taxaJurosMensal")
public class TaxaJurosMensalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mes;
    private String modalidade;
    private int posicao;
    private String instituicaoFinanceira;
    private int taxaJurosAoMes;
    private int taxaJurosAoAno;
    private String cnpj8;
    private String anoMes;

}
