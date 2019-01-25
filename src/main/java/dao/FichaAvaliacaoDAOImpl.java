package dao;

import Model.FichaAvaliacao;
import exceptions.CampoVazioException;
import exceptions.CpfInvalidoException;
import exceptions.DataConsultaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FichaAvaliacaoDAOImpl implements FichaAvaliacaoDAO{

    private List<FichaAvaliacao> fichas;

    public FichaAvaliacaoDAOImpl(){
        fichas = new ArrayList<>();
    }

    public boolean salvarFicha(FichaAvaliacao fichaAvaliacao) {
        try {
            validarFicha(fichaAvaliacao);
            if (buscarByCpf(fichaAvaliacao.getCpf())== null){
                fichas.add(fichaAvaliacao);
                return true;
            }
        } catch (CampoVazioException | DataConsultaException | CpfInvalidoException e) {
            e.printStackTrace();
        }

        return false;

    }


    public FichaAvaliacao buscarByCpf(String cpf){
       if (fichas.isEmpty()){
           return null;
       }
        for (FichaAvaliacao ficha: fichas) {
            if (ficha.getCpf().equals(cpf)){
                return ficha;
            }
        }
        return null;
    }

    @Override
    public List<FichaAvaliacao> listarPorNomeDr(String nomeDoProfissional) {
        List<FichaAvaliacao> fichasPorProfissionais = new ArrayList<>();
        if (fichas.isEmpty()){
            return null;
        }
        for (FichaAvaliacao fichaAvaliacao: fichas){
            if (fichaAvaliacao.getNomeDoProfissional().equals(nomeDoProfissional)){
                fichasPorProfissionais.add(fichaAvaliacao);
            }
        }
        return fichasPorProfissionais;
    }

    @Override
    public List<FichaAvaliacao> listarPorEspecializacao(String especializacao) {
        List<FichaAvaliacao> fichasPorEspecializacao = new ArrayList<>();
        if (fichas.isEmpty()){
            return null;
        }
        for(FichaAvaliacao fichaAvaliacao: fichas){
            if (fichaAvaliacao.getEspecializacao().equals(especializacao)){
                fichasPorEspecializacao.add(fichaAvaliacao);
            }
        }
        return fichasPorEspecializacao;
    }

    @Override
    public List<FichaAvaliacao> listarPorGraduacao(String graduacao) {
        List<FichaAvaliacao> fichasPorGraduacao = new ArrayList<>();
        if (fichas.isEmpty()){
            return null;
        }
        for(FichaAvaliacao fichaAvaliacao: fichas){
            if (fichaAvaliacao.getGraduacao().equals(graduacao)){
                fichasPorGraduacao.add(fichaAvaliacao);
            }
        }
        return fichasPorGraduacao;
    }

    @Override
    public List<FichaAvaliacao> listarPorData(LocalDate inicio, LocalDate fim) {
        List<FichaAvaliacao> fichasPorData = new ArrayList<>();
        if (fichas.isEmpty()){
            return null;
        }
        for (FichaAvaliacao fichaAvaliacao: fichas){
            if (fichaAvaliacao.getDataConsulta().isAfter(inicio.plusDays(-1)) && fichaAvaliacao.getDataConsulta().isBefore(fim.plusDays(1))){
                fichasPorData.add(fichaAvaliacao);
            }
        }
        return fichasPorData;
    }

    public List<FichaAvaliacao> listarFichas(){
        return fichas;
    }

    public boolean removeByCpf(String cpf){
        if (fichas.isEmpty()){
            return false;
        }
        for (FichaAvaliacao ficha:fichas) {
            if (ficha.getCpf().equals(cpf)){
                return fichas.remove(ficha);
            }

        }
        return false;
    }

    public  boolean validarFicha(FichaAvaliacao fichaAvaliacao) throws CpfInvalidoException, DataConsultaException, CampoVazioException {
        if (fichaAvaliacao.getCpf().equals("   .   .   -  ") || fichaAvaliacao.getCpf() == null ||
                fichaAvaliacao.getCpf().equals("00000000000") ||
                fichaAvaliacao.getCpf().equals("11111111111") ||
                fichaAvaliacao.getCpf().equals("22222222222") ||
                fichaAvaliacao.getCpf().equals("33333333333") ||
                fichaAvaliacao.getCpf().equals("44444444444") ||
                fichaAvaliacao.getCpf().equals("55555555555") ||
                fichaAvaliacao.getCpf().equals("66666666666") ||
                fichaAvaliacao.getCpf().equals("77777777777") ||
                fichaAvaliacao.getCpf().equals("88888888888") ||
                fichaAvaliacao.getCpf().equals("99999999999") ||
                fichaAvaliacao.getCpf().length() < 14
        ){
            throw new CpfInvalidoException();
        }
        if (fichaAvaliacao.getCpf().equals(" ")){
            throw new CampoVazioException();
        }
        if (fichaAvaliacao.getNome() == null || fichaAvaliacao.getNome().equals("")){
            throw new CampoVazioException();
        }
        if (fichaAvaliacao.getDataConsulta().isAfter(LocalDate.now())){
            throw new DataConsultaException();
        }
        if (fichaAvaliacao.getDataConsulta().isBefore(LocalDate.now())){
            throw new DataConsultaException();
        }
        return false;
    }
}
