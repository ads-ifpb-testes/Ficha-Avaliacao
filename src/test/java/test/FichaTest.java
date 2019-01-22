package test;

import Exceptions.CampoVazioException;
import Exceptions.CpfInvalidoException;
import Exceptions.DataConsultaException;
import Model.FichaAvaliacao;
import Model.FichaAvaliacaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class FichaTest {

    @Mock
    private FichaAvaliacaoImpl fichaAvaliacaoDAO;


    public FichaTest(){
        MockitoAnnotations.initMocks(this);
        fichaAvaliacaoDAO = new FichaAvaliacaoImpl();
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
    public void salvarFicha(FichaAvaliacao fichaAvaliacao) throws CampoVazioException, DataConsultaException, CpfInvalidoException {

        Assert.assertTrue(fichaAvaliacaoDAO.validarFicha(fichaFake()));
        Assert.assertEquals(fichaAvaliacaoDAO.buscarByCpf("111-111-111-11"),null);
        Assert.assertTrue(fichaAvaliacaoDAO.salvarFicha(fichaFake()));
        System.out.println(fichaAvaliacaoDAO.listarFichas());
        Assert.assertTrue(fichaAvaliacaoDAO.listarFichas().contains(fichaFake()));


    }

}
