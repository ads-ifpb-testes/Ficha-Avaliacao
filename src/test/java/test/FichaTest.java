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
//      6- nome da especializacao vazio
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
//    CT-004
        Assert.assertNotNull(fichaAvaliacaoDAO.listarPorNomeDr("Domingos"));
//    CT-005
        Assert.assertNull(fichaAvaliacaoDAO.listarPorNomeDr("64544"));
    }

    @Test
    public void listarPorEspecializacao(){
//        CT-006
        Assert.assertNotNull(fichaAvaliacaoDAO.listarPorEspecializacao("Traumato"));
//        CT-007
        Assert.assertNull(fichaAvaliacaoDAO.listarPorEspecializacao(""));
//        CT-008
        Assert.assertNull(fichaAvaliacaoDAO.listarPorEspecializacao("84530233"));
    }

    @Test
    public void buscarPorData(){
//        CT-015
        Assert.assertNotNull(fichaAvaliacaoDAO.listarPorData(LocalDate.now(),LocalDate.now()));
//        CT-016
        Assert.assertNull(fichaAvaliacaoDAO.listarPorData(LocalDate.of(2019,01,28),LocalDate.of(2019,01,27)));
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

    @Test
    public void listarPorGraduacao(){
//      CT-012
        Assert.assertNotNull(fichaAvaliacaoDAO.listarPorGraduacao("Fisioterapeuta"));
//      CT-013
        Assert.assertNull(fichaAvaliacaoDAO.listarPorGraduacao(""));
//      CT-014
        Assert.assertNull(fichaAvaliacaoDAO.listarPorGraduacao("9243435"));
    }

    @Test
    public void buscarByCpf(){
//      CT-001
        Assert.assertNotNull(fichaAvaliacaoDAO.buscarByCpf("111.111.111-11"));
//      CT-002
        Assert.assertNull(fichaAvaliacaoDAO.buscarByCpf("000000000"));
//      CT-003
        Assert.assertNull(fichaAvaliacaoDAO.buscarByCpf("222.222.222-22"));
    }
<<<<<<< HEAD

    @Test
    public void removeByCpf(){

        Assert.assertTrue(fichaAvaliacaoDAO.removeByCpf("111.111.111-11"));

    }

=======
>>>>>>> b0f7b664badae468c85e2326aa851f581ba07103
}
