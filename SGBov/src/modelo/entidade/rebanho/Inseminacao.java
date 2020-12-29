package modelo.entidade.rebanho;

import funct.FunctDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import modelo.entidade.Entidade;
import modelo.entidade.financeiro.Movimentacao;

/**
 * <p>Classe de Modelo <b>Inseminacao</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.inseminacao</b>.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    modelo.entidades.Entidade
 */
@Entity
@Table (schema = "sgbov", name = "inseminacao")
public class Inseminacao extends Entidade {
    @Column (name = "ano")
    private Integer ano;
    @Column (name = "data_implante")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataImplante;
    @Column (name = "data_hormonio")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataHormonio;
    @Column (name = "data_inseminacao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInseminacao;
    @Column (name = "total")
    private Integer total;
    @Column (name = "prenhas")
    private Integer prenhas;
    @JoinColumn (name = "id_despesa")
    @ManyToOne
    private Movimentacao despesa;

    /**
     * Metodo construtor padrao da Classe.
     */
    public Inseminacao() {
        ano             = Integer.parseInt(new FunctDate().getYear(new Date()));
        dataImplante    = new Date();
        dataHormonio    = new Date();
        dataInseminacao = new Date();
        total           = 0;
        prenhas         = 0;
        despesa         = null;
    }
    
    /**
     * Metodo responsavel por retornar o Ano da Inseminacao.
     * @return Ano da Inseminacao.
     */
    public Integer getAno() {
        return ano;
    }
    
    /**
     * Metodo responsavel por definir o Ano da Inseminacao.
     * @param ano Ano da Inseminacao.
     */
    public void setAno(Integer ano) {
        this.ano = ano; 
    }
    
    /**
     * Metodo responsavel por retornar a Data de Implante.
     * @return Data de Implante.
     */
    public Date getDataImplante() {
        return dataImplante;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Implante Formatada.
     * @return Data de Implante Formatada.
     */
    public String getDataImplanteFormatada() {
        return new FunctDate().getFormattedDate(dataImplante);
    }

    /**
     * Metodo responsavel por definir a Data de Implante.
     * @param dataImplante Data de Implante.
     */
    public void setDataImplante(Date dataImplante) {
        this.dataImplante = dataImplante;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Hormonio.
     * @return Data de Hormonio.
     */
    public Date getDataHormonio() {
        return dataHormonio;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Hormonio Formatada.
     * @return Data de Hormonio Formatada.
     */
    public String getDataHormonioFormatada() {
        return new FunctDate().getFormattedDate(dataHormonio);
    }

    /**
     * Metodo responsavel por definir a Data de Hormonio.
     * @param dataHormonio Data de Hormonio.
     */
    public void setDataHormonio(Date dataHormonio) {
        this.dataHormonio = dataHormonio;
    }
    
    /**
     * Metodo responsavel por retornar a Data da Inseminacao.
     * @return Data da Inseminacao.
     */
    public Date getDataInseminacao() {
        return dataInseminacao;
    }
    
    /**
     * Metodo responsavel por retornar a Data da Inseminacao Formatada.
     * @return Data da Inseminacao Formatada.
     */
    public String getDataInseminacaoFormatada() {
        return new FunctDate().getFormattedDate(dataInseminacao);
    }

    /**
     * Metodo responsavel por definir a Data da Inseminacao.
     * @param dataInseminacao Data da Inseminacao.
     */
    public void setDataInseminacao(Date dataInseminacao) {
        this.dataInseminacao = dataInseminacao;
    }
    
    /**
     * Metodo responsavel por retornar o Total de Matrizes da Inseminacao.
     * @return Total de Matrizes da Inseminacao.
     */
    public Integer getTotal() {
        return total;
    }
    
    /**
     * Metodo responsavel por definir o Total de Matrizes da Inseminacao.
     * @param total Total de Matrizes da Inseminacao.
     */
    public void setTotal(Integer total) {
        this.total = total; 
    }
    
    /**
     * Metodo responsavel por retornar o Numero de Prenhas da Inseminacao.
     * @return Numero de Prenhas da Inseminacao.
     */
    public Integer getPrenhas() {
        return prenhas;
    }
    
    /**
     * Metodo responsavel por definir o Numero de Prenhas da Inseminacao.
     * @param prenhas Numero de Prenhas da Inseminacao.
     */
    public void setPrenhas(Integer prenhas) {
        this.prenhas = prenhas; 
    }
    
    /**
     * Metodo responsavel por retornar a Despesa da Inseminacao.
     * @return Despesa da Inseminacao.
     */
    public Movimentacao getDespesa() {
        return despesa;
    }

    /**
     * Metodo responsavel por definir a Despesa da Inseminacao.
     * @param despesa Despesa da Inseminacao.
     */
    public void setDespesa(Movimentacao despesa) {
        this.despesa = despesa;
    }
    
    /**
     * Metodo responsavel por retornar o Resumo da Inseminacao.
     * @return Resumo da Inseminacao.
     */
    public String getResumo() {
        return id + " - " + ano + " P0 = " + getDataImplanteFormatada() 
                                + " P1 = " + getDataHormonioFormatada()
                                + " P2 = " + getDataInseminacaoFormatada();
    }
    
    @Override
    public String[] getDadosPesquisa() {
        return new String[0];
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[5];
                 dados[0] = Long.toString(id);
                 dados[1] = Integer.toString(ano);
                 dados[2] = getDataImplanteFormatada();
                 dados[3] = getDataHormonioFormatada();
                 dados[4] = getDataInseminacaoFormatada();
        return   dados;
    }

    @Override
    public String toString() {
        return id + " - " + ano + " = " + "(" + getDataInseminacaoFormatada()+ ")";
    }
}