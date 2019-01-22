package view;
import Model.FichaAvaliacao;
import Model.FichaAvaliacaoImpl;
import java.sql.SQLException;
import java.time.LocalDate;

public class app {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FichaAvaliacaoImpl dao = new FichaAvaliacaoImpl();

        FichaAvaliacao paciente1 = new FichaAvaliacao("Raul","Dra Ruthe","Fisioterapeuta","Traumato","111-111-111-11",19,"Masculino","Condomalacia Patelar","Dor constante","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao paciente2 = new FichaAvaliacao("Pedro","Dra Ruthe","Fisioterapeuta","Traumato","222-222-222-22",22,"Masculino","Rompimento do Tendão","Não Consegue andar","Melhoria no Andar",LocalDate.now());
        FichaAvaliacao paciente3 = new FichaAvaliacao("Rom","Dr Afonso","Fisioterapeuta","Traumato","333-333-333-33",22,"Masculino","Rompimento do Tendão","Não Consegue andar","Melhoria no Andar",LocalDate.now());


        System.out.println(dao.salvarFicha(paciente2));
        System.out.println(dao.salvarFicha(paciente1));
        System.out.println(dao.salvarFicha(paciente3));

//        System.out.println(dao.listarFichas());

//        System.out.println(dao.removeByCpf("111.111.111-11"));

//        System.out.println(dao.listarFichas());


//        System.out.println(dao.listarPorNomeDr("Dra Ruthe"));
//        System.out.println(dao.listarPorEspecializacao("Traumato"));
//        System.out.println(dao.listarPorGraduacao("Fisioterapeuta"));
//        System.out.println(dao.listarPorData(LocalDate.now(),LocalDate.now()));
    }
}

