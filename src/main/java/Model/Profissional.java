package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Profissional {

    private String nome;
    private String cpf;
    private String graduacao;
    private String especializacao;
    private LocalDate dataPrensente;
    private LocalTime horaPrensente;

    public Profissional(String nome, String cpf, String graduacao, String especializacao, LocalDate dataPrensente, LocalTime horaPrensente) {
        this.nome = nome;
        this.cpf = cpf;
        this.graduacao = graduacao;
        this.especializacao = especializacao;
        this.dataPrensente = dataPrensente;
        this.horaPrensente = horaPrensente;
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

    public LocalDate getDataPrensente() {
        return dataPrensente;
    }

    public void setDataPrensente(LocalDate dataPrensente) {
        this.dataPrensente = dataPrensente;
    }

    public LocalTime getHoraPrensente() {
        return horaPrensente;
    }

    public void setHoraPrensente(LocalTime horaPrensente) {
        this.horaPrensente = horaPrensente;
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
        return "Profissional{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", graduacao='" + graduacao + '\'' +
                ", especializacao='" + especializacao + '\'' +
                ", dataPrensente=" + dataPrensente +
                ", horaPrensente=" + horaPrensente +
                '}';
    }

}
