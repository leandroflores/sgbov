package visao.painel.novo.financeiro;

import controlador.visao.painel.novo.financeiro.ControllerPanelNovoMovimentacao;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.controlador.financeiro.ControllerMovimentacao;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoMovimentacao</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoMovimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.novo.financeiro.ControllerPanelNovoMovimentacao
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoMovimentacao extends PanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoMovimentacao(ViewNovo view) {
        super(view);
        controller = new ControllerPanelNovoMovimentacao(this);
        setProperties();
        addComponents();
    }

    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(350, 300));
        setMaximumSize(new Dimension(350, 300));
        setLayout(new GridLayout(4, 2, 1, 1));
    }
    
    @Override
    protected void addComponents() {
        add(createRightLabel("Tipo*: "));
        add(createComboBox("tipo", ControllerMovimentacao.TIPOS, 50));
        
        add(createRightLabel("Descrição*: "));
        add(createTextField("descricao", "", 30));
        
        add(createRightLabel("Valor*: "));
        add(createPriceTextField("valor", 0.0f, 30));
        
        add(createRightLabel("Data Pagamento*: "));
        add(createDateTextField("data_pagamento", new Date()));
    }
    
    @Override
    public void clear() {
        getComboBoxTipo().setSelectedIndex(0);
        getTextFieldDescricao().setText("");
        getTextFieldValor().setText(new DecimalFormat("R$ #,##0.00").format(0.0f));
        getTextFieldDataPagamento().setText(new FunctDate().getFormattedDate(new Date()));
        
        getComboBoxTipo().requestFocus();
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