package modelo.entidade.estruturais;

import funct.FunctDate;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Pesagem</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.pesagem</b>.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    modelo.entidades.Entidade
 * @see    modelo.entidade.estruturais.Bovino
 */
@Entity
@Table (schema = "sgbov", name = "pesagem")
public class Pesagem extends Entidade {
    @JoinColumn (name = "id_bovino")
    @ManyToOne
    private Bovino bovino;
    @Column (name = "data_pesagem")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   dataPesagem;
    @Column (name = "valor")
    private Float  valor;

    /**
     * Metodo construtor padrao da Classe.
     */
    public Pesagem() {
        bovino      = null;
        dataPesagem = new Date();
        valor       = 0.0f;
    }
    
    /**
     * Metodo responsavel por retornar o Bovino da Pesagem.
     * @return Bovino da Pesagem.
     */
    public Bovino getBovino() {
        return bovino;
    }

    /**
     * Metodo responsavel por definir o Bovino da Pesagem.
     * @param bovino Bovino da Pesagem.
     */
    public void setBovino(Bovino bovino) {
        this.bovino = bovino;
    }
    
    /**
     * Metodo responsavel por retornar a Data da Pesagem.
     * @return Data da Pesagem.
     */
    public Date getDataPesagem() {
        return dataPesagem;
    }
    
    /**
     * Metodo responsavel por retornar a Data da Pesagem Formatada.
     * @return Data da Pesagem Formatada.
     */
    public String getDataPesagemFormatada() {
        return new FunctDate().getFormattedDate(dataPesagem);
    }

    /**
     * Metodo responsavel por definir a Data da Pesagem.
     * @param dataPesagem Data da Pesagem.
     */
    public void setDataPesagem(Date dataPesagem) {
        this.dataPesagem = dataPesagem;
    }
    
    /**
     * Metodo responsavel por retornar o Valor da Pesagem.
     * @return Valor da Pesagem.
     */
    public Float getValor() {
        return valor;
    }
    
    /**
     * Metodo responsavel por retornar o Valor Formatado da Pesagem.
     * @return Valor Formatado da Pesagem.
     */
    public String getValorFormatado() {
        return new DecimalFormat("#,##0.00").format(valor);
    }
    
    /**
     * Metodo responsavel por definir o Valor da Pesagem.
     * @param valor Valor da Pesagem.
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    /**
     * Metodo responsavel por retornar o Resumo da Pesagem.
     * @return Resumo da Pesagem.
     */
    public String getResumo() {
        return id + " - N: " + bovino.getNumero() + " = " + getValorFormatado();
    }
    
    @Override
    public String[] getDadosPesquisa() {
        return new String[0];
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[5];
                 dados[0] = Long.toString(id);
                 dados[1] = bovino.toString();
                 dados[2] = Character.toString(bovino.getSexo());
                 dados[3] = getDataPesagemFormatada();
                 dados[4] = getValorFormatado();
        return   dados;
    }

    @Override
    public String toString() {
        return id + " - " + bovino.toString() + " = " + valor + "(" + getDataCadastroFormatada() + ")";
    }
}