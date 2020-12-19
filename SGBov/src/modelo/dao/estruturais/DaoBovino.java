package modelo.dao.estruturais;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.dao.Dao;
import modelo.entidade.estruturais.Bovino;

/**
 * <p>Classe de Persistencia <b>DaoBovino</b>.</p>
 * <p>Classe responsavel por pela ligacao entre o BD e a Classe de Entidade <b>Bovino</b>.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    modelo.dao.Dao
 * @see    modelo.entidade.estruturais.Bovino
 */
public class DaoBovino extends Dao<Bovino> {
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public DaoBovino() {
        super(Bovino.class);
    }
    
    /**
     * Metodo responsavel por retornar o Proximo Numero disponivel.
     * @return Proximo Numero disponivel.
     */
    public Integer nextNumero() {
        String script = "SELECT MAX(e.numero) + 1 FROM " + name + " e WHERE e.ativo=true";
        try {
            return (Integer) MANAGER.createQuery(script).getSingleResult();
        }catch (Exception exception) {
            return 1;
        }
    }
    
    /**
     * Metodo responsavel por retornar o Bovino Ativo pelo Numero.
     * @param  numero Numero do Bovino.
     * @return Bovino Ativo pelo Numero.
     */
    public Bovino filterAtivo(Integer numero) {
        String script = "SELECT e FROM " + name + " e WHERE e.ativo=true AND e.numero =:numero";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("numero", numero);
        return super.get(query);
    }
    
    /**
     * Metodo responsavel por retornar a Lista de Bovinos pelos Parametros.
     * @param  tipo Tipo do Bovino.
     * @param  inicio Inicio do Bovino.
     * @param  fim Fim do Bovino.
     * @param  sexo Sexo do Bovino.
     * @param  numero Numero do Bovino.
     * @param  ativo Ativo do Bovino.
     * @return Lista de Bovinos filtrados.
     */
    public List<Bovino> filter(String tipo, Date inicio, Date fim, char sexo, Integer numero, boolean ativo) {
        String script = "SELECT e FROM " + name + " e WHERE e.tipo LIKE :tipo AND e.nascimento BETWEEN :inicio AND :fim AND e.sexo=:sexo AND e.numero=:numero AND e.ativo=:ativo ORDER BY e.id, e.numero";
        Query  query  = MANAGER.createQuery(script);
               query.setParameter("tipo",   "%" + tipo + "%");
               query.setParameter("inicio", inicio);
               query.setParameter("fim",    fim);
               query.setParameter("sexo",   sexo);
               query.setParameter("numero", numero);
               query.setParameter("ativo",  ativo);
               query.setMaxResults(MAX);
        return query.getResultList();
    }
}