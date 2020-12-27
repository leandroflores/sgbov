package visao.painel.consulta.filtro.estruturais;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import visao.modal.consulta.estruturais.ViewConsultaPesagem;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroPesagem</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro da Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  21/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroPesagem extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Pesagem.
     */
    public PanelFiltroPesagem(ViewConsultaPesagem view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Data Pesagem*: ", 130));
        add(createDateTextField("inicio", new Date()));
        add(createDateTextField("final",  new Date()));
        add(createLabel("Bovino: ", 70));
        add(createCheckBox("bovino", "", false));
        add(createLabel("Número: ", 70));
        add(createSpinnerEditable("numero"));
        add(createButtonAtualizar());
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
     * Metodo responsavel por retornar o Check Box Bovino.
     * @return Check Box Bovino.
     */
    public JCheckBox getCheckBoxBovino() {
        return getCheckBox("bovino");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
}