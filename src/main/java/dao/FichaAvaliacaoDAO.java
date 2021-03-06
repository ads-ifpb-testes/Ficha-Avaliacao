package dao;

import Model.FichaAvaliacao;


import java.time.LocalDate;
import java.util.List;

import Exceptions.CampoVazioException;
import Exceptions.CpfInvalidoException;
import Exceptions.DataConsultaException;

public interface FichaAvaliacaoDAO {

    public boolean salvarFicha(FichaAvaliacao fichaAvaliacao);

    public FichaAvaliacao buscarByCpf(String cpf);

    public List<FichaAvaliacao> listarPorNomeDr(String nomeDoProfissional);
    
    public Float listarPorcetagemDiagnostico(String diagnostico);

    public List<FichaAvaliacao> listarPorEspecializacao(String especializacao);

    public List<FichaAvaliacao> listarPorGraduacao(String graduacao);

    public List<FichaAvaliacao> listarPorData(LocalDate inicio, LocalDate fim);

    public List<FichaAvaliacao> listarFichas();

    public boolean removeByCpf(String cpf);

    public boolean validarFicha(FichaAvaliacao fichaAvaliacao) throws CpfInvalidoException, DataConsultaException, CampoVazioException, CpfInvalidoException, DataConsultaException, CampoVazioException;
}
