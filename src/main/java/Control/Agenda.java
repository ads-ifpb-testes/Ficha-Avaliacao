package Control;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Model.Consulta;
import Model.Profissional;
import enumeration.DIA;

public class Agenda {
	
	private static List<Consulta> consultasAgendadas = null;

	public static boolean agendarConsulta(Consulta novaConsulta) {
		if(consultasAgendadas!=null) {
			List<Consulta> consultasDoMedico = buscarConsultasDoMedico(novaConsulta.getMedico().getNome(), novaConsulta.getData());
			for(Consulta c : consultasDoMedico) {
				if(c.getHoraInicio().isBefore(novaConsulta.getHoraFim()) || c.getHoraFim().isAfter(novaConsulta.getHoraInicio()))
					return false;
			}
		}
		return consultasAgendadas.add(novaConsulta);
	}
	
	public static List<Consulta> buscarConsultasDoMedico(String nomeMedico,LocalDate data){
		List<Consulta> consultasDoMedico = new ArrayList<>();
		for(Consulta c : consultasAgendadas) {
			if(c.getMedico().getNome().equals(nomeMedico)) {
				if(c.getData().isEqual(data))
					consultasDoMedico.add(c);
			}
				
		}
		return consultasDoMedico;
	}
	
}
