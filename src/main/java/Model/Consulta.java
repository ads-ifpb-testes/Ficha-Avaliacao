package Model;

import java.time.LocalDate;
import java.time.LocalTime;

import enumeration.DIA;

public class Consulta {
	
	private Profissional medico;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private DIA diaConsulta;
	private LocalDate data;
	
	public Consulta() {}

	public Consulta(Profissional medico, LocalTime horaInicio, LocalTime horaFim, DIA diaConsulta, LocalDate data) {
		this.medico = medico;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.diaConsulta = diaConsulta;
		this.data = data;
	}

	public Profissional getMedico() {
		return medico;
	}

	public void setMedico(Profissional medico) {
		this.medico = medico;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public DIA getDiaConsulta() {
		return diaConsulta;
	}

	public void setDiaConsulta(DIA diaConsulta) {
		this.diaConsulta = diaConsulta;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Consulta [medico=" + medico + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", diaConsulta="
				+ diaConsulta + ", data=" + data + "]";
	}
	
	

	
}
