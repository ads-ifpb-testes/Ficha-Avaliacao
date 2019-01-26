package test;

import static org.mockito.Mockito.when;
import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import Control.Agenda;
import Model.Profissional;
import dao.ProfissionalDAO;
import enumeration.DIA;

public class AgendaTest {
	
	private Agenda agenda;
	@Mock
	private ProfissionalDAO profissionalDAO;
	
	public AgendaTest() {
		agenda = new Agenda();
		MockitoAnnotations.initMocks(this);	
	}
	
	@Test
	public void agendarConsultaTest() {
//    	CT-022
    	when(profissionalDAO.buscar("Paulo")).thenReturn(new Profissional("Paulo","034.342.523-24","Medicina","Pediatra",DIA.QUARTA,LocalTime.of(07, 00),LocalTime.of(11, 00)));
    	Assert.assertTrue(agenda.agendarConsulta(profissionalDAO.buscar("Paulo"),LocalTime.of(8, 00),LocalTime.of(9, 30),DIA.QUARTA));
//    	CT-023
    	Assert.assertFalse(agenda.agendarConsulta(profissionalDAO.buscar("Paulo"),LocalTime.of(8, 30),LocalTime.of(9, 15),DIA.QUARTA));
    	Assert.assertFalse(agenda.agendarConsulta(profissionalDAO.buscar("Paulo"),LocalTime.of(7, 30),LocalTime.of(8, 30),DIA.QUARTA));
    	Assert.assertFalse(agenda.agendarConsulta(profissionalDAO.buscar("Paulo"),LocalTime.of(9, 20),LocalTime.of(10, 00),DIA.QUARTA));
//    	CT-024
    	Assert.assertFalse(agenda.agendarConsulta(profissionalDAO.buscar("Paulo"),LocalTime.of(10, 10),LocalTime.of(10, 50),DIA.SEGUNDA));
	}
}
