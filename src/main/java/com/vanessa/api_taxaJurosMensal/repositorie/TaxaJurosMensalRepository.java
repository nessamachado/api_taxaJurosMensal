package com.vanessa.api_taxaJurosMensal.repositorie;

import com.vanessa.api_taxaJurosMensal.Generated;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Generated
public interface TaxaJurosMensalRepository extends JpaRepository<TaxaJurosMensalEntity, Long> {

    List<TaxaJurosMensalEntity> findByAnoMes(String anoMes);

}
