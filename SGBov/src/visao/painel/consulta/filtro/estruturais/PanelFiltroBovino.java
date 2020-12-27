package visao.painel.consulta.filtro.estruturais;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import modelo.controlador.estruturais.ControllerBovino;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroBovino</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro do Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroBovino extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Bovino.
     */
    public PanelFiltroBovino(ViewConsultaBovino view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setMaximumSize(new Dimension(1000, 200));
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
               panel.setPreferredSize(new Dimension(1000, 40));
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(createLabel("Tipo: ", 100));
               panel.add(createComboBox("tipo", ControllerBovino.TIPOS, 150));
               panel.add(createLabel("Data Nasc.*: ", 100));
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
               panel.setPreferredSize(new Dimension(1000, 40));
               panel.setLayout(new FlowLayout(FlowLayout.CENTER));
               panel.add(createLabel("Sexo: ", 100));
               panel.add(createComboBox("sexo", new String[]{"M", "F"}, 90));
               panel.add(createLabel("Número: ", 100));
               panel.add(createSpinnerEditable("numero"));
               panel.add(createLabel("Ativo: ",  80));
               panel.add(createCheckBox("ativo", "", true));
               panel.add(createLabel("", 10));
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
     * Metodo responsavel por retornar o Combo Box Sexo.
     * @return Combo Box Sexo.
     */
    public JComboBox getComboBoxSexo() {
        return getComboBox("sexo");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Ativo.
     * @return Check Box Ativo.
     */
    public JCheckBox getCheckBoxAtivo() {
        return getCheckBox("ativo");
    }
}