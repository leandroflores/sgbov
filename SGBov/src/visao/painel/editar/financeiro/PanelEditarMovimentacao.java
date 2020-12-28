package visao.painel.editar.financeiro;

import controlador.visao.painel.editar.financeiro.ControllerPanelEditarMovimentacao;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.entidade.financeiro.Movimentacao;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.PanelEditar;

/**
 * <p>Classe de Visao <b>PanelEditarMovimentacao</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewEditarMovimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.editar.financeiro.ControllerPanelEditarMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.editar.PanelEditar
 */
public final class PanelEditarMovimentacao extends PanelEditar {
    private final Movimentacao movimentacao;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Movimentacao.
     * @param movimentacao_ Movimentacao.
     */
    public PanelEditarMovimentacao(ViewEditar view, Movimentacao movimentacao_) {
        super(view);
        movimentacao = movimentacao_;
        controller   = new ControllerPanelEditarMovimentacao(this);
        setProperties();
        addComponents();
        setValues();
        getController().setReady();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(5, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Identificador: "));
        add(this.createTextFieldNoEditable("identificador", "", 5));
        
        add(createRightLabel("Tipo*: "));
        add(createComboBox("tipo", new String[]{"RECEITA", "DESPESA"}, 50));
        
        add(createRightLabel("Descrição*: "));
        add(createTextField("descricao", "", 30));
        
        add(createRightLabel("Valor*: "));
        add(createPriceTextField("valor", 0.0f, 30));
        
        add(createRightLabel("Data Pagamento*: "));
        add(createDateTextField("data_pagamento", new Date()));
    }
    
    @Override
    public void setValues() {
        getTextFieldIdentificador().setText(Long.toString(movimentacao.getId()));
        getComboBoxTipo().setSelectedItem(movimentacao.getTipo());
        getTextFieldDescricao().setText(movimentacao.getDescricao());
        getTextFieldValor().setText(new DecimalFormat("R$ #,##0.00").format(movimentacao.getValor()));
        getTextFieldDataPagamento().setText(new FunctDate().getFormattedDate(movimentacao.getPagamento()));
        
        getComboBoxTipo().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Identificador.
     * @return Text Field Identificador.
     */
    public JTextField getTextFieldIdentificador() {
        return getTextField("identificador");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Descricao.
     * @return Text Field Descricao.
     */
    public JTextField getTextFieldDescricao() {
        return getTextField("descricao");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Valor.
     * @return Text Field Valor.
     */
    public JTextField getTextFieldValor() {
        return getTextField("valor");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Data Pagamento.
     * @return Text Field Data Pagamento.
     */
    public JTextField getTextFieldDataPagamento() {
        return getTextField("data_pagamento");
    }
}