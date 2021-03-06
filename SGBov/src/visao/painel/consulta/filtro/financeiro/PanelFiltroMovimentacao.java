package visao.painel.consulta.filtro.financeiro;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    protected void addComponents() {
        add(getFirstFilter());
        add(getSecondFilter());
    }
    
    /**
     * Metodo responsavel por retornar o Primeiro Filtro.
     * @return Primeiro Filtro.
     */
    private JPanel getFirstFilter() {
        JPanel panel = new JPanel();
               panel.setPreferredSize(new Dimension(900, 40));
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(createLabel("Tipo: ", 100));
               panel.add(createComboBox("tipo", ControllerMovimentacao.TIPOS, 30));
               getComboBoxTipo().setPreferredSize(new Dimension(125, 30));
               panel.add(createLabel("Data Pagamento*: ", 140));
               panel.add(createDateTextField("inicio", new Date()));
               panel.add(createDateTextField("final",  new Date()));
        return panel;
    }
    
    /**
     * Metodo responsavel por retornar o Segundo Filtro.
     * @return Segundo Filtro.
     */
    private JPanel getSecondFilter() {
        JPanel panel = new JPanel();
               panel.setPreferredSize(new Dimension(900, 40));
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(createLabel("Descrição: ", 100));
               panel.add(createTextField("descricao", "", 30));
               panel.add(createLabel("", 15));
               panel.add(createButtonAtualizar());
        return panel;
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
}