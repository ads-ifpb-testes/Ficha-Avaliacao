package test;

import Model.FichaAvaliacao;
import Model.Profissional;
import dao.FichaAvaliacaoDAO;
import dao.FichaAvaliacaoDAOImpl;
import dao.ProfissionalDAO;
import enumeration.DIA;
import exceptions.CampoVazioException;
import exceptions.CpfInvalidoException;
import exceptions.DataConsultaException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.when;

public class FichaTest {

    private FichaAvaliacaoDAOImpl fichaAvaliacaoDAO;
    private static List<FichaAvaliacao> fichasTeste;
    
    @Mock
    private ProfissionalDAO profissionalDAO;

    public FichaTest(){
    	MockitoAnnotations.initMocks(this);
        fichaAvaliacaoDAO = new FichaAvaliacaoDAOImpl();
    }
    
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
    }


    @Test
    public void salvarFicha() throws CampoVazioException, DataConsultaException, CpfInvalidoException {
//        Pacientes
        FichaAvaliacao valido = new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao fichaRepitida = new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao nomePacienteVazio = new FichaAvaliacao("","Paulo","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao nomeProfissionalVazio = new FichaAvaliacao("Raul","","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao cpfVazio = new FichaAvaliacao("Flavia","Alfonso","Pediatra","Imunologico","765.656.651-89",19,"Feminino","","","",LocalDate.now());
//    	CT-008
        Assert.assertTrue(fichaAvaliacaoDAO.salvarFicha(fichaAvaliacaoDAO.listarFichas().get(0)));
//      CT-009
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(fichaRepitida));
//      CT-010
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(nomePacienteVazio));
//      CT-010
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(nomeProfissionalVazio));
//      CT-010
        Assert.assertFalse(fichaAvaliacaoDAO.salvarFicha(cpfVazio));

    }

    @Test
    public void listarPorNomeProfissional(){
//        CT-004
        Assert.assertEquals("Operação Realizada com sucesso","Domingos",fichaAvaliacaoDAO.listarPorNomeDr(fichaAvaliacaoDAO.listarFichas().get(0).getNomeDoProfissional()));
//        CT-005
        Assert.assertEquals("Falha: Nome do Profissional inválido",6545,fichaAvaliacaoDAO.listarFichas().get(0).getNomeDoProfissional());

    }
    
    @Test
    public void validarFicha() throws CpfInvalidoException, DataConsultaException, CampoVazioException {
//    	CT-016
    	Assert.assertTrue(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(0)));
//    	CT-017
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(5)));
//    	CT-018
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(2)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(1)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(3)));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(fichasTeste.get(4)));
    }
    
    @Test
    public void agendarConsulta() {
//    	CT-022
    	when(profissionalDAO.buscar("Paulo")).thenReturn(new Profissional("Paulo","034.342.523-24","Medicina","Pediatra",DIA.QUARTA,LocalTime.of(07, 00),LocalTime.of(11, 00)));
    }

}
