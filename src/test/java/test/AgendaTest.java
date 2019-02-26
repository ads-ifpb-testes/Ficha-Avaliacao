package test;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import Control.Agenda;
import Model.Consulta;
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
    	Assert.assertTrue(Agenda.agendarConsulta(new Consulta(profissionalDAO.buscar("Paulo"),LocalTime.of(8, 00),LocalTime.of(9, 30),DIA.QUARTA,LocalDate.of(2019, 5, 10))));
//    	CT-023
    	Assert.assertFalse(Agenda.agendarConsulta(new Consulta(profissionalDAO.buscar("Paulo"),LocalTime.of(8, 30),LocalTime.of(9, 15),DIA.QUARTA,LocalDate.of(2019, 5, 10))));
    	Assert.assertFalse(Agenda.agendarConsulta(new Consulta(profissionalDAO.buscar("Paulo"),LocalTime.of(7, 30),LocalTime.of(8, 30),DIA.QUARTA,LocalDate.of(2019, 5, 10))));
    	Assert.assertFalse(Agenda.agendarConsulta(new Consulta(profissionalDAO.buscar("Paulo"),LocalTime.of(9, 20),LocalTime.of(10, 00),DIA.QUARTA,LocalDate.of(2019, 5, 10))));
//    	CT-024
    	Assert.assertFalse(Agenda.agendarConsulta(new Consulta(profissionalDAO.buscar("Paulo"),LocalTime.of(10, 10),LocalTime.of(10, 50),DIA.SEGUNDA,LocalDate.of(2019, 5, 10))));
	}
}
