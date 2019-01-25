package dao;

public interface ProfissionalDAO {
	public boolean salvar(Profissional novoProfissional);
	public Profissional buscar(String nomeProfissional);
	public boolean remover(String nomeProfissional);
	public boolean editar(String nomeProfissional, Profissional profissinalEditado);
}
