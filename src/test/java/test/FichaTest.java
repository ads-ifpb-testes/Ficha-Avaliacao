package test;

import Model.FichaAvaliacao;
import Model.Profissional;
import dao.FichaAvaliacaoDAO;
import dao.FichaAvaliacaoDAOImpl;
import dao.ProfissionalDAO;
import enumeration.DIA;
import Exceptions.CampoVazioException;
import Exceptions.CpfInvalidoException;
import Exceptions.DataConsultaException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Control.Agenda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.when;

public class FichaTest {

    private FichaAvaliacaoDAOImpl fichaAvaliacaoDAO;
    private static List<FichaAvaliacao> fichasTeste;
    
    public FichaTest(){
    	MockitoAnnotations.initMocks(this);
        fichaAvaliacaoDAO = new FichaAvaliacaoDAOImpl();
    }
    @Mock
    private FichaAvaliacaoDAOImpl fichaDAO;
    
    @Mock
    private ProfissionalDAO profissionalDAO;    
    
    @Before
    public void adicionarFichas() {
//    	0- Ficha válida
    	fichasTeste.add(new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
//    	1- nome do paciente vazio
    	fichasTeste.add(new FichaAvaliacao("","Paulo","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
//    	2- nome profissional vazio
    	fichasTeste.add(new FichaAvaliacao("Raul","","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
//    	3- cpf vazio
    	fichasTeste.add(new FichaAvaliacao("Raul","Paulo","Fisioterapeuta","Traumato","",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
//    	4- diagnostico vazio
    	fichasTeste.add(new FichaAvaliacao("Flavia","Alfonso","Pediatra","Imunologico","765.656.651-89",19,"Feminino","","","",LocalDate.now()));
//    	5- campos preenchidos e CPF INVALIDO
        fichasTeste.add(new FichaAvaliacao("Carlos","Pedro","Fisioterapeuta","Traumato","153.181-78",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.of(1955, Month.DECEMBER, 10)));
//        6- nome da especializacao vazio
        fichasTeste.add(new FichaAvaliacao("José","Domingos","Fisioterapeuta","","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now()));
    }


    @Test
    public void salvarFicha() throws CampoVazioException, DataConsultaException, CpfInvalidoException {
//    	CT-009
        Assert.assertTrue(fichaAvaliacaoDAO.salvarFicha(fichasTeste.get(0)));
//      CT-010
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(fichasTeste.get(0)));
//      CT-011
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(fichasTeste.get(1)));
//      CT-011
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(fichasTeste.get(2)));
//      CT-01112
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(fichasTeste.get(3)));

    }

    @Test
    public void listarPorNomeProfissional(){
//        CT-004
        Assert.assertEquals("Operação Realizada com sucesso","Domingos",fichaAvaliacaoDAO.listarPorNomeDr(fichasTeste.get(0).getNomeDoProfissional()));
//        CT-005
        Assert.assertEquals("Falha: Nome do Profissional inválido",6545,fichaAvaliacaoDAO.listarFichas().get(0).getNomeDoProfissional());
    }

    @Test
    public void listarPorEspecializacao(){
//        CT-006
        Assert.assertEquals("Traumato",fichaAvaliacaoDAO.listarPorEspecializacao(fichasTeste.get(0).getEspecializacao()));
//        CT-007
        Assert.assertEquals("Falha: Campo obrigatório não preenchido","", fichaAvaliacaoDAO.listarPorEspecializacao(fichasTeste.get(6).getEspecializacao()));
//        CT-008
        Assert.assertEquals("Falha: Campo obrigatório inválido",8456, fichaAvaliacaoDAO.listarPorEspecializacao(fichasTeste.get(6).getEspecializacao()));
    }
    
    @Test
    public void validarFicha() throws CpfInvalidoException, DataConsultaException, CampoVazioException {
//    	CT-018
    	Assert.assertTrue(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(0)));
//    	CT-019
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(5)));
//    	CT-020
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(2)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(1)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(3)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(4)));
    }
    
    @Test
    public void listarPorcentagemDiagnosticoTeste() {
//    	CT-021
    	Assert.assertNotEquals(0f, fichaAvaliacaoDAO.listarPorcetagemDiagnostico("Traumato"));
//    	CT-022
    	Assert.assertEquals((Float) 0f,fichaAvaliacaoDAO.listarPorcetagemDiagnostico("Câncer de pele"));
//    	CT-023
//    	Assert.assertEquals(-1,fichaAvaliacaoDAO.listarPorcetagemDiagnostico(""));
    }
}
