package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import enumeration.DIA;

public class Profissional {

    private String nome;
    private String cpf;
    private String graduacao;
    private String especializacao;
    private DIA diaPresente; 
    private LocalTime inicioHoraPrensente;
    private LocalTime fimHoraPrensente;

    public Profissional(String nome, String cpf, String graduacao, String especializacao, DIA diaPresente, LocalTime inicioHoraPresente,LocalTime fimHoraPresente) {
        this.nome = nome;
        this.cpf = cpf;
        this.graduacao = graduacao;
        this.diaPresente = diaPresente;
        this.especializacao = especializacao;
        this.inicioHoraPrensente = inicioHoraPresente;
        this.fimHoraPrensente = fimHoraPresente;
    }

    public Profissional() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public DIA getDiaPresente() {
		return diaPresente;
	}

	public void setDiaPresente(DIA diaPresente) {
		this.diaPresente = diaPresente;
	}

	public LocalTime getInicioHoraPrensente() {
		return inicioHoraPrensente;
	}

	public void setInicioHoraPrensente(LocalTime inicioHoraPrensente) {
		this.inicioHoraPrensente = inicioHoraPrensente;
	}

	public LocalTime getFimHoraPrensente() {
		return fimHoraPrensente;
	}

	public void setFimHoraPrensente(LocalTime fimHoraPrensente) {
		this.fimHoraPrensente = fimHoraPrensente;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return cpf.equals(that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

	@Override
	public String toString() {
		return "Profissional [nome=" + nome + ", cpf=" + cpf + ", graduacao=" + graduacao + ", especializacao="
				+ especializacao + ", diaPresente=" + diaPresente + ", inicioHoraPrensente=" + inicioHoraPrensente
				+ ", fimHoraPrensente=" + fimHoraPrensente + "]";
	}


    
    

}
