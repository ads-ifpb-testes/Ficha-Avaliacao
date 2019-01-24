package test;

import Exceptions.CampoVazioException;
import Exceptions.CpfInvalidoException;
import Exceptions.DataConsultaException;
import Model.FichaAvaliacao;
import dao.FichaAvaliacaoDAO;
import dao.FichaAvaliacaoDAOImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.when;

public class FichaTest {

    private FichaAvaliacaoDAOImpl fichaAvaliacaoDAO;
    private static List<FichaAvaliacao> fichas;


    public FichaTest(){
        fichaAvaliacaoDAO = new FichaAvaliacaoDAOImpl();
    }
    
    @Before
    public void adicionarFichas() {
//    	Ficha válida
    	fichaAvaliacaoDAO.salvarFicha(new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
//    	Ficha Campos preenchidos e incorretos
    	fichaAvaliacaoDAO.salvarFicha(new FichaAvaliacao("Carlos","Pedro","Fisioterapeuta","Traumato","153.181-78",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.of(1955, Month.DECEMBER, 10)));
//    	Campo obrigatório omitido
    	fichaAvaliacaoDAO.salvarFicha(new FichaAvaliacao("Rian","","Fisioterapeuta","Traumato","153.181-78",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
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
//    	CT-0
        Assert.assertTrue(fichaAvaliacaoDAO.salvarFicha(fichaFake()));
    }
    
    @Test
    public void validarFicha() throws CpfInvalidoException, DataConsultaException, CampoVazioException {
//    	CT-0
    	FichaAvaliacao ficha = new FichaAvaliacao("João","Paulo","Fisioterapeuta","Traumato","112.112.112-12",22,"Masculino","Condomalacia Patelar","Não consegue andar","Piora no Andar",LocalDate.now());
    	Assert.assertTrue(fichaAvaliacaoDAO.validarFicha(ficha));
//    	CT-0
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichaAvaliacaoDAO.listarFichas().get(1)));
//    	CT-0
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha());
    }

}
