package visao.painel.novo.financeiro;

import controlador.visao.painel.novo.financeiro.ControllerPanelNovoDespesa;
import funct.FunctDate;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JTextField;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.PanelNovo;

/**
 * <p>Classe de Visao <b>PanelNovoDespesa</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewNovoDespesa</b> do SGBov.</p>
 * @author Leandro
 * @since  28/12/2020
 * @see    controlador.visao.painel.novo.financeiro.ControllerPanelNovoDespesa
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.novo.PanelNovo
 */
public final class PanelNovoDespesa extends PanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo.
     */
    public PanelNovoDespesa(ViewNovo view) {
        super(view);
        controller = new ControllerPanelNovoDespesa(this);
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
        add(createRightLabel("Tipo: "));
        add(createTextFieldNoEditable("tipo", "DESPESA", 30));
        
        add(createRightLabel("Descrição*: "));
        add(createTextField("descricao", "", 30));
        
        add(createRightLabel("Valor*: "));
        add(createPriceTextField("valor", 0.0f, 30));
        
        add(createRightLabel("Data Pagamento*: "));
        add(createDateTextField("data_pagamento", new Date()));
    }
    
    @Override
    public void clear() {
        getComboBoxTipo().setText("DESPESA");
        getTextFieldDescricao().setText("");
        getTextFieldValor().setText(new DecimalFormat("R$ #,##0.00").format(0.0f));
        getTextFieldDataPagamento().setText(new FunctDate().getFormattedDate(new Date()));
        
        getTextFieldDescricao().requestFocus();
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Tipo.
     * @return Text Field Tipo.
     */
    public JTextField getComboBoxTipo() {
        return getTextField("tipo");
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