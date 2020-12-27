package modelo.dao.financeiro;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.financeiro.Movimentacao;

/**
 * <p>Classe de Persistencia <b>DaoMovimentacao</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Movimentacao</b>.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.financeiro.Movimentacao
 */
public class DaoMovimentacao extends Dao<Movimentacao> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoMovimentacao() {
        super(Movimentacao.class);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Movimentacoes pelo Tipo.
     * @param  tipo Tipo.
     * @return Tipo da Movimentacao.
     */
    public List<Movimentacao> filter(String tipo) {
        String script = "SELECT e FROM " + name + " e WHERE e.tipo LIKE :tipo AND e.ativo=true ORDER BY e.tipo, e.dataPagamento";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("tipo", "%" + tipo + "%");
               query.setMaxResults(MAX);
        return query.getResultList();
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Movimentacoes pelos Parametros.
     * @param tipo Tipo da Movimentacao.
     * @param descricao Descricao da Movimentacao.
     * @param inicio Data de Inicio da Movimentacao.
     * @param fim Data de Fim da Movimentacao.
     * @return Lista de Movimentacoes filtradas.
     */
    public List<Movimentacao> filter(String tipo, String descricao, Date inicio, Date fim) {
        String script = "SELECT e FROM " + name + " e WHERE e.tipo LIKE :tipo AND e.descricao LIKE :descricao AND e.pagamento BETWEEN :inicio AND :fim AND e.ativo=true ORDER BY e.tipo, e.pagamento";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("tipo",      "%" + tipo      + "%");
               query.setParameter("descricao", "%" + descricao + "%");
               query.setParameter("inicio",    inicio);
               query.setParameter("fim",       fim);
               query.setMaxResults(MAX);
        return query.getResultList();
    }
}