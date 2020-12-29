package modelo.entidade.rebanho.inseminacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import modelo.entidade.Entidade;
import modelo.entidade.rebanho.Bovino;
import modelo.entidade.rebanho.Inseminacao;

/**
 * <p>Classe de Modelo <b>Matriz</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.matriz</b>.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    modelo.entidade.Entidade
 * @see    modelo.entidade.rebanho.Inseminacao
 * @see    modelo.entidade.rebanho.Bovino
 */
@Entity
@Table (schema = "sgbov", name = "matriz")
public class Matriz extends Entidade {
    @JoinColumn (name = "id_inseminacao")
    @ManyToOne
    private Inseminacao inseminacao;
    @JoinColumn (name = "id_bovino")
    @ManyToOne
    private Bovino  bovino;
    @Column (name = "implante")
    private Boolean implante;
    @Column (name = "hormonio")
    private Boolean hormonio;
    @Column (name = "inseminacao")
    private Boolean semen;
    @Column (name = "prenha")
    private Boolean prenha;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Matriz() {
        inseminacao = null;
        bovino      = null;
        implante    = null;
        hormonio    = null;
        semen       = null;
        prenha      = null;
    }
    
    /**
     * Metodo responsavel por retornar a Inseminacao da Matriz.
     * @return Inseminacao da Matriz.
     */
    public Inseminacao getInseminacao() {
        return inseminacao;
    }

    /**
     * Metodo responsavel por definir a Inseminacao da Matriz.
     * @param inseminacao Inseminacao da Matriz.
     */
    public void setInseminacao(Inseminacao inseminacao) {
        this.inseminacao = inseminacao;
    }
    
    /**
     * Metodo responsavel por retornar o Bovino da Matriz.
     * @return Bovino da Matriz.
     */
    public Bovino getBovino() {
        return bovino;
    }

    /**
     * Metodo responsavel por definir o Bovino da Matriz.
     * @param bovino Bovino da Matriz.
     */
    public void setBovino(Bovino bovino) {
        this.bovino = bovino;
    }

    /**
     * Metodo responsavel por retornar a Flag Implante da Matriz.
     * @return Flag Implante da Matriz.
     */
    public Boolean getImplante() {
        return implante;
    }

    /**
     * Metodo responsavel por definir a Flag Implante da Matriz.
     * @param implante Flag Implante da Matriz.
     */
    public void setImplante(Boolean implante) {
        this.implante = implante;
    }

    /**
     * Metodo responsavel por retornar a Flag Hormonio da Matriz.
     * @return Flag Hormonio da Matriz.
     */
    public Boolean getHormonio() {
        return hormonio;
    }

    /**
     * Metodo responsavel por definir a Flag Hormonio da Matriz.
     * @param hormonio Flag Hormonio da Matriz.
     */
    public void setHormonio(Boolean hormonio) {
        this.hormonio = hormonio;
    }

    /**
     * Metodo responsavel por retornar a Flag Semen da Matriz.
     * @return Flag Semen da Matriz.
     */
    public Boolean getSemen() {
        return semen;
    }

    /**
     * Metodo responsavel por definir a Flag Semen da Matriz.
     * @param semen Flag Semen da Matriz.
     */
    public void setSemen(Boolean semen) {
        this.semen = semen;
    }

    /**
     * Metodo responsavel por retornar a Flag Prenha da Matriz.
     * @return Flag Prenha da Matriz.
     */
    public Boolean getPrenha() {
        return prenha;
    }

    /**
     * Metodo responsavel por definir a Flag Prenha da Matriz.
     * @param prenha Flag Prenha da Matriz.
     */
    public void setPrenha(Boolean prenha) {
        this.prenha = prenha;
    }
    
    /**
     * Metodo responsavel por retornar o Resumo da Inseminacao.
     * @return Resumo da Inseminacao.
     */
    public String getResumo() {
        return "";
    }
    
    @Override
    public String[] getDadosPesquisa() {
        String[] dados    = new String[5];
                 dados[0] = Integer.toString(bovino.getNumero());
                 dados[1] = implante ? "Sim" : "Não";
                 dados[2] = hormonio ? "Sim" : "Não";
                 dados[3] = semen    ? "Sim" : "Não";
                 dados[4] = prenha   ? "Sim" : "Não";
        return   dados;
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[4];
                 dados[0] = Long.toString(id);
                 dados[1] = inseminacao.toString();
                 dados[2] = Integer.toString(bovino.getNumero());
                 dados[3] = inseminacao.getDataInseminacaoFormatada();
                 dados[4] = prenha ? "Prenha" : "Não Prenha";
        return   dados;
    }

    @Override
    public String toString() {
        return id + " - " + inseminacao.getDataInseminacaoFormatada() 
                  + " - " + bovino.getNumero();
    }
}