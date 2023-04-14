package com.vanessa.api_taxaJurosMensal.service;

import com.vanessa.api_taxaJurosMensal.model.dto.TaxaJurosMensalDTO;
import com.vanessa.api_taxaJurosMensal.model.entities.TaxaJurosMensalEntity;
import com.vanessa.api_taxaJurosMensal.model.mapper.TaxaJurosMensalMapper;
import com.vanessa.api_taxaJurosMensal.model.response.TaxaJurosMensalResponse;
import com.vanessa.api_taxaJurosMensal.repositorie.TaxaJurosMensalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@SpringBootTest
class TaxaJurosMensalServiceTest {

    public static final Long ID = 1L;
    public static final String MES = "Nov-2022";
    public static final String MODALIDADE = "FINANCIAMENTO IMOBILIARIO";
    public static final int POSICAO = 4;
    public static final String INSTITUICAO_FINANCEIRA = "BCO. BRADESCO";
    public static final int TAXA_JUROS_AO_MES = 0;
    public static final int TAXA_JUROS_AO_ANO = 7;
    public static final String CNPJ_8 = "60746948";
    public static final String ANO_MES = "2022-11";

    @InjectMocks
    private TaxaJurosMensalService service;

    @Mock
    private TaxaJurosMensalRepository repository;

    @Mock
    private TaxaJurosMensalMapper mapper;

    private TaxaJurosMensalEntity taxaEntity;
    private TaxaJurosMensalDTO taxaDTO;
    private TaxaJurosMensalResponse taxaResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTaxa();
    }

    @Test
    void quandoBuscarTodosMeRetorneUmaListaDeUsuario() {
        when(repository.findAll()).thenReturn(List.of(taxaEntity));
        when(mapper.createEntityToDtoList(any())).thenReturn(List.of(taxaDTO));
        when(mapper.createDtoToResponseList(any())).thenReturn(List.of(taxaResponse));

        List<TaxaJurosMensalResponse> retorno = service.encontrarTodos();

        assertNotNull(retorno);
        assertEquals(1, retorno.size());
        assertEquals(TaxaJurosMensalResponse.class, retorno.get(0).getClass());
    }

    @Test
    void quandoFizerABuscaPorIDMeRetorneUmaInstanciaDeTaxaResponse() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(taxaEntity));
        when(mapper.createEntityToDto(any(TaxaJurosMensalEntity.class))).thenReturn(taxaDTO);
        when(mapper.createDtoToResponse(any(TaxaJurosMensalDTO.class))).thenReturn(taxaResponse);

        TaxaJurosMensalResponse retorno = service.encontrarPorId(ID);

        assertNotNull(retorno);
        assertEquals(taxaResponse.getId(), retorno.getId());
    }

    @Test
    void quandoCriarEntaoRetorneSucesso() {
        when(repository.save(any(TaxaJurosMensalEntity.class))).thenReturn(taxaEntity);
        when(mapper.createDtoToEntity(any(TaxaJurosMensalDTO.class))).thenReturn(taxaEntity);
        when(mapper.createEntityToDto(any(TaxaJurosMensalEntity.class))).thenReturn(taxaDTO);
        when(mapper.createDtoToResponse(any(TaxaJurosMensalDTO.class))).thenReturn(taxaResponse);

        TaxaJurosMensalResponse retorno = service.insert(taxaDTO);

        assertNotNull(retorno);
        assertEquals(TaxaJurosMensalResponse.class, retorno.getClass());
    }

    @Test
    void quandoAlterarEntaoRetorneSucesso() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(taxaEntity));
        when(repository.save(any(TaxaJurosMensalEntity.class))).thenReturn((taxaEntity));
        when(mapper.createDtoToEntity(any(TaxaJurosMensalDTO.class))).thenReturn(taxaEntity);
        when(mapper.createEntityToDto(any(TaxaJurosMensalEntity.class))).thenReturn(taxaDTO);
        when(mapper.createDtoToResponse(any(TaxaJurosMensalDTO.class))).thenReturn(taxaResponse);

        TaxaJurosMensalResponse retorno = service.update(taxaDTO, ID);

        assertNotNull(retorno);
        assertEquals(TaxaJurosMensalResponse.class, retorno.getClass());
    }

    @Test
    void excluidoComSucesso() {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(taxaEntity));
        when(mapper.createEntityToDto(any(TaxaJurosMensalEntity.class))).thenReturn(taxaDTO);
        when(mapper.createDtoToResponse(any(TaxaJurosMensalDTO.class))).thenReturn(taxaResponse);
        doNothing().when(repository).deleteById(anyLong());

        service.delete(ID);

        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void listarPorPagina() {
    }

    @Test
    void quandoConultarAnoMesEntaoRetorneSucesso() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(taxaEntity));
        when(mapper.createEntityToDto(any(TaxaJurosMensalEntity.class))).thenReturn(taxaDTO);
        when(mapper.createDtoToResponse(any(TaxaJurosMensalDTO.class))).thenReturn(taxaResponse);

        List<TaxaJurosMensalResponse> retorno = service.listarAnoMes(ANO_MES);

        assertNotNull(retorno);
        //assertEquals(taxaResponse.getClass(), retorno.getClass());
    }

    private void startTaxa(){
        taxaEntity = new TaxaJurosMensalEntity(ID, MES, MODALIDADE, POSICAO, INSTITUICAO_FINANCEIRA, TAXA_JUROS_AO_MES, TAXA_JUROS_AO_ANO, CNPJ_8, ANO_MES);
        taxaDTO = new TaxaJurosMensalDTO(ID, MES, MODALIDADE, POSICAO, INSTITUICAO_FINANCEIRA, TAXA_JUROS_AO_MES, TAXA_JUROS_AO_ANO, CNPJ_8, ANO_MES);
        taxaResponse = new TaxaJurosMensalResponse(ID, MES, MODALIDADE, POSICAO, INSTITUICAO_FINANCEIRA, TAXA_JUROS_AO_MES, TAXA_JUROS_AO_ANO, CNPJ_8, ANO_MES);
    }
}