package modelo.dao.estruturais;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.estruturais.Bovino;
import modelo.entidade.estruturais.Pesagem;

/**
 * <p>Classe de Persistencia <b>DaoPesagem</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Pesagem</b>.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.estruturais.Pesagem
 */
public class DaoPesagem extends Dao<Pesagem> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoPesagem() {
        super(Pesagem.class);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Pesagens pelo Bovino.
     * @param  bovino Bovino.
     * @return Lista de Pesagens pelo Bovino.
     */
    public List<Pesagem> filter(Bovino bovino) {
        String script = "SELECT e FROM " + name + " e WHERE e.bovino LIKE :bovino ORDER BY e.dataPesagem";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("bovino", bovino);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Pesagens pelo Periodo.
     * @param  inicio Data Inicio.
     * @param  fim Data Fim.
     * @return Lista de Pesagens pelo Periodo.
     */
    public List<Pesagem> filter(Date inicio, Date fim) {
        String script = "SELECT e FROM " + name + " e WHERE e.dataPesagem BETWEEN :inicio AND :fim ORDER BY e.dataPesagem";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("inicio", inicio);
               query.setParameter("fim", fim);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Pesagens pelo Numero e Periodo.
     * @param  numero Numero do Bovino.
     * @param  inicio Data Inicio.
     * @param  fim Data Fim.
     * @return Lista de Pesagens pelo Bovino e Periodo.
     */
    public List<Pesagem> filter(Integer numero, Date inicio, Date fim) {
        String script = "SELECT e FROM " + name + " e WHERE e.bovino.numero =:numero AND e.dataPesagem BETWEEN :inicio AND :fim ORDER BY e.dataPesagem";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("numero", numero);
               query.setParameter("inicio", inicio);
               query.setParameter("fim", fim);
        return query.getResultList();
    }
}