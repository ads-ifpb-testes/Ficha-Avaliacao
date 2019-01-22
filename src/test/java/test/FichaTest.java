package test;

import Exceptions.CampoVazioException;
import Exceptions.CpfInvalidoException;
import Exceptions.DataConsultaException;
import Model.FichaAvaliacao;
import dao.FichaAvaliacaoDAOImpl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class FichaTest {

    private FichaAvaliacaoDAOImpl fichaAvaliacaoDAO;


    public FichaTest(){
        fichaAvaliacaoDAO = new FichaAvaliacaoDAOImpl();
    }


    public FichaAvaliacao fichaFake(){
        FichaAvaliacao ficha = new FichaAvaliacao();
        ficha.setNome("Raul");
        ficha.setNomeDoProfissional("Dra Ruthe");
        ficha.setGraduacao("Fisioterapeuta");
        ficha.setEspecializacao("Traumato");
        ficha.setCpf("111-111-111-11");
        ficha.setIdade(19);
        ficha.setSexo("Masculino");
        ficha.setDiagnostico("Condomalacia Patelar");
        ficha.setQueixaPrincipal("Dor constante");
        ficha.setEvolucao("Melhoria no Andar");
        ficha.setDataConsulta(LocalDate.now());
        return ficha;
    }


    @Test
    public void salvarFicha() throws CampoVazioException, DataConsultaException, CpfInvalidoException {

        Assert.assertTrue(fichaAvaliacaoDAO.salvarFicha(fichaFake()));

    }

}
