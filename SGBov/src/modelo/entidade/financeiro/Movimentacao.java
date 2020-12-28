package modelo.entidade.financeiro;

import funct.FunctDate;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Movimentacao</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.movimentacao</b>.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    modelo.entidade.Entidade
 */
@Entity
@Table (schema = "sgbov", name = "movimentacao")
public class Movimentacao extends Entidade {
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "descricao")
    private String descricao;
    @Column (name = "valor")
    private Float  valor;
    @Column (name = "data_pagamento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   pagamento;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Movimentacao() {
        tipo      = "";
        descricao = "";
        valor     = 0.0f;
        pagamento = new FunctDate().getCurrentDate();
    }
    
    /**
     * Metodo responsavel por retornar o Tipo da Movimentacao.
     * @return Tipo da Movimentacao.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo responsavel por definir o Tipo da Movimentacao.
     * @param tipo Tipo da Movimentacao.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo responsavel por retornar a Descricao da Movimentacao.
     * @return Descricao da Movimentacao.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo responsavel por definir a Descricao da Movimentacao.
     * @param descricao Descricao da Movimentacao.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo responsavel por retornar o Valor da Movimentacao.
     * @return Valor da Movimentacao.
     */
    public Float getValor() {
        return valor;
    }

    /**
     * Metodo responsavel por retornar o Valor Formatado da Movimentacao.
     * @return Valor Formatado da Movimentacao.
     */
    public String getValorFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(valor);
    }
    
    /**
     * Metodo responsavel por definir o Valor da Movimentacao.
     * @param valor Valor da Movimentacao.
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * Metodo responsavel por retornar a Data de Pagamento da Movimentacao.
     * @return Data de Pagamento da Movimentacao.
     */
    public Date getPagamento() {
        return pagamento;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Pagamento Formatada da Movimentacao.
     * @return Data de Pagamento Formatada da Movimentacao.
     */
    public String getDataPagamentoFormatada() {
        return new FunctDate().getFormattedDate(pagamento);
    }

    /**
     * Metodo responsavel por definir a Data de Pagamento da Movimentacao.
     * @param pagamento Data de Pagamento da Movimentacao.
     */
    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }
    
    @Override
    public String[] getDadosPesquisa() {
        String[] dados    = new String[3];
                 dados[0] = Long.toString(id);
                 dados[1] = tipo;
                 dados[2] = descricao;
                 dados[3] = getDataPagamentoFormatada();
        return   dados;
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[5];
                 dados[0] = Long.toString(id);
                 dados[1] = tipo;
                 dados[2] = descricao;
                 dados[3] = getDataPagamentoFormatada();
                 dados[4] = getValorFormatado();
        return   dados;
    }
    
    @Override
    public String toString() {
        return id + " - " + descricao + " = " + getValorFormatado();
    }
}