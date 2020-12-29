package modelo.dao.rebanho;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.rebanho.Inseminacao;

/**
 * <p>Classe de Persistencia <b>DaoInseminacao</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Inseminacao</b>.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.rebanho.Inseminacao
 */
public class DaoInseminacao extends Dao<Inseminacao> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoInseminacao() {
        super(Inseminacao.class);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Inseminacoes pelo Periodo.
     * @param  inicio Data Inicio.
     * @param  fim Data Fim.
     * @return Lista de Inseminacoes pelo Periodo.
     */
    public List<Inseminacao> filter(Date inicio, Date fim) {
        String script = "SELECT e FROM " + name + " e WHERE e.dataImplante BETWEEN :inicio AND :fim ORDER BY e.dataImplante";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("inicio", inicio);
               query.setParameter("fim", fim);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Inseminacoes pelo Ano e Periodo.
     * @param  ano Ano da Inseminacao.
     * @param  inicio Data Inicio.
     * @param  fim Data Fim.
     * @return Lista de Inseminacoes pelo Ano e Periodo.
     */
    public List<Inseminacao> filter(Integer ano, Date inicio, Date fim) {
        String script = "SELECT e FROM " + name + " e WHERE e.ano =:ano AND e.dataImplante BETWEEN :inicio AND :fim ORDER BY e.dataImplante";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("ano", ano);
               query.setParameter("inicio", inicio);
               query.setParameter("fim", fim);
        return query.getResultList();
    }
}