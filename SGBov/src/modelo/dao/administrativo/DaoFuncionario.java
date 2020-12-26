package modelo.dao.administrativo;

import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.administrativo.Funcionario;

/**
 * <p>Classe de Persistencia <b>DaoFuncionario</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Funcionario</b>.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.administrativo.Funcionario
 */
public class DaoFuncionario extends Dao<Funcionario> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoFuncionario() {
        super(Funcionario.class);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Funcionarios pelo CPF e Nome.
     * @param  cpf  CPF do Funcionario.
     * @param  nome Nome do Funcionario.
     * @return Lista de Funcionarios filtrados.
     */
    public List<Funcionario> filter(String cpf, String nome) {
        String script = "SELECT e FROM " + name + " e WHERE e.cpf LIKE :cpf AND e.nome LIKE :nome ORDER BY e.nome";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("cpf",  "%" + cpf  + "%");
               query.setParameter("nome", "%" + nome + "%");
               query.setMaxResults(MAX);
        return query.getResultList();
    }
}