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
    }


    @Test
    public void salvarFicha() throws CampoVazioException, DataConsultaException, CpfInvalidoException {

//        Pacientes
        FichaAvaliacao valido = new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao fichaRepitida = new FichaAvaliacao("José","Domingos","Fisioterapeuta","Traumato","111.111.111-11",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao nomePacienteVazio = new FichaAvaliacao("","Paulo","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao nomeProfissionalVazio = new FichaAvaliacao("Raul","","Fisioterapeuta","Traumato","225.154.152-02",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao cpfVazio = new FichaAvaliacao("Raul","Paulo","Fisioterapeuta","Traumato","",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());



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
    public void validarFicha() throws CpfInvalidoException, DataConsultaException, CampoVazioException {
//    	Ficha Campos preenchidos e incorretos
    	FichaAvaliacao carlos = new FichaAvaliacao("Carlos","Pedro","Fisioterapeuta","Traumato","153.181-78",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.of(1955, Month.DECEMBER, 10));
//    	Campo obrigatório omitido
    	FichaAvaliacao rian = new FichaAvaliacao("Rian","","Fisioterapeuta","Traumato","435.153.181-78",19,"Masculino","Condomalacia Patelar","Dor Constante","Melhoria no Andar",LocalDate.now());
    	FichaAvaliacao vazio = new FichaAvaliacao("","Alfonso","Pediatra","Imunologia","486.153.181-78",19,"Masculino","Gripe","","",LocalDate.now());
    	FichaAvaliacao rita = new FichaAvaliacao("Rita","Alfonso","Pediatra","Imunologico","",19,"Feminino","Gripe","","",LocalDate.now());
    	FichaAvaliacao flavia = new FichaAvaliacao("Flavia","Alfonso","Pediatra","Imunologico","765.656.651-89",19,"Feminino","","","",LocalDate.now());
//    	CT-016
    	FichaAvaliacao ficha = new FichaAvaliacao("João","Paulo","Fisioterapeuta","Traumato","112.112.112-12",22,"Masculino","Condomalacia Patelar","Não consegue andar","Piora no Andar",LocalDate.now());
    	Assert.assertTrue(fichaAvaliacaoDAO.validarFicha(ficha));
//    	CT-017
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(carlos));
//    	CT-018
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(rian));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(vazio));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(rita));
    	Assert.assertFalse(fichaAvaliacaoDAO.validarFicha(flavia));
    }

}
