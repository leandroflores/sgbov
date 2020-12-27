package visao.painel.consulta.filtro.financeiro;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import modelo.controlador.financeiro.ControllerMovimentacao;
import visao.modal.consulta.financeiro.ViewConsultaMovimentacao;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroMovimentacao</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro da Movimentacao</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.financeiro.Movimentacao
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroMovimentacao extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Movimentacao.
     */
    public PanelFiltroMovimentacao(ViewConsultaMovimentacao view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setMaximumSize(new Dimension(900, 200));
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Tipo: ", 100));
        add(createComboBox("tipo", ControllerMovimentacao.TIPOS, 30));
        getComboBoxTipo().setPreferredSize(new Dimension(125, 30));
        add(createLabel("Data Pagamento*: ", 140));
        add(createDateTextField("inicio", new Date()));
        add(createDateTextField("final",  new Date()));
        add(createLabel("Descrição: ", 100));
        add(createTextField("descricao", "", 10));
        add(createButton("atualizar", "", "atualizar"));
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Combo Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Inicio.
     * @return Text Field Inicio.
     */
    public JTextField getTextFieldInicio() {
        return getTextField("inicio");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Final.
     * @return Text Field Final.
     */
    public JTextField getTextFieldFinal() {
        return getTextField("final");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Descricao.
     * @return Text Field Descricao.
     */
    public JTextField getTextFieldDescricao() {
        return getTextField("descricao");
    }
    
    /**
     * Metodo responsavel por retornar o Button Atualizar.
     * @return Button Atualizar.
     */
    public JButton getButtonAtualizar() {
        return getButton("atualizar");
    }
}