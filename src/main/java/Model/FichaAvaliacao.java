package Model;

import java.time.LocalDate;
import java.util.Objects;

public class FichaAvaliacao {
    private String nome;
    private String nomeDoProfissional;
    private String graduacao;
    private String especializacao;
    private String cpf;
    private int idade;
    private String sexo;
    private String diagnostico;
    private String queixaPrincipal;
    private String evolucao;
    private LocalDate dataConsulta;


    public FichaAvaliacao() {
    }

    public FichaAvaliacao(String nome, String nomeDoProfissional, String graduacao, String especializacao, String cpf, int idade, String sexo, String diagnostico, String queixaPrincipal, String evolucao, LocalDate dataConsulta) {
        this.nome = nome;
        this.nomeDoProfissional = nomeDoProfissional;
        this.graduacao = graduacao;
        this.especializacao = especializacao;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.diagnostico = diagnostico;
        this.queixaPrincipal = queixaPrincipal;
        this.evolucao = evolucao;
        this.dataConsulta = dataConsulta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDoProfissional() {
        return nomeDoProfissional;
    }

    public void setNomeDoProfissional(String nomeDoProfissional) {
        this.nomeDoProfissional = nomeDoProfissional;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FichaAvaliacao that = (FichaAvaliacao) o;
        return cpf.equals(that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "FichaAvaliacao[ Nome: " + nome + " Sexo: " + sexo + " Diagnostico Clinico: " + diagnostico +" ]";
    }
}
