package dao;

import Model.FichaAvaliacao;
import exceptions.CampoVazioException;
import exceptions.CpfInvalidoException;
import exceptions.DataConsultaException;

import java.time.LocalDate;
import java.util.List;

public interface FichaAvaliacaoDAO {

    public boolean salvarFicha(FichaAvaliacao fichaAvaliacao);

    public FichaAvaliacao buscarByCpf(String cpf);

    public List<FichaAvaliacao> listarPorNomeDr(String nomeDoProfissional);

    public List<FichaAvaliacao> listarPorEspecializacao(String especializacao);

    public List<FichaAvaliacao> listarPorGraduacao(String graduacao);

    public List<FichaAvaliacao> listarPorData(LocalDate inicio, LocalDate fim);

    public List<FichaAvaliacao> listarFichas();

    public boolean removeByCpf(String cpf);

    public boolean validarFicha(FichaAvaliacao fichaAvaliacao) throws CpfInvalidoException, DataConsultaException, CampoVazioException;
}
