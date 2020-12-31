package visao.painel.base.rebanho.inseminacao;

import controlador.visao.painel.base.rebanho.inseminacao.ControllerPanelBaseMatriz;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import modelo.entidade.rebanho.inseminacao.Matriz;
import visao.painel.Panel;
import visao.painel.base.PanelBase;

/**
 * <p>Classe de Visao <b>PanelBaseMatriz</b>.</p> 
 * <p>Classe responsavel por definir o Painel Grafico da <b>ViewBaseMatriz</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.base.rebanho.inseminacao.ControllerPanelBaseMatriz
 * @see    modelo.entidade.rebanho.inseminacao.Matriz
 * @see    visao.painel.base.PanelBase
 */
public final class PanelBaseMatriz extends PanelBase {
    private final Matriz matriz;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Owner.
     * @param matriz_ Matriz.
     */
    public PanelBaseMatriz(Panel panel, Matriz matriz_) {
        super(panel);
        matriz     = matriz_;
        controller = new ControllerPanelBaseMatriz(this);
        setProperties();
        addComponents();
        setValues();
    }
    
    @Override
    protected void setProperties() {
        setMinimumSize(new Dimension(200, 100));
        setMaximumSize(new Dimension(200, 100));
        setLayout(new GridBagLayout());
    }
    
    @Override
    protected void addComponents() {
        add(createLabel("Bovino*: ", 75), createConstraints(1, 1, 0, 0));
        add(createTextFieldNoEditable("bovino", "", 20), createConstraints(4, 1, 1, 0));
        getTextField("bovino").setMinimumSize(new Dimension(125, 30));
        add(createButton("pesquisa", "", "pesquisa"), createConstraints(1, 1, 5, 0));
        
        add(createLabel(""), createConstraints(1, 1, 0, 2));
        add(createRightLabel("Implante: "), createConstraints(1, 1, 1, 2));
        add(createCheckBox("implante", "", false), createConstraints(1, 1, 2, 2));
        add(createRightLabel("Hormônio: "), createConstraints(1, 1, 3, 2));
        add(createCheckBox("hormonio", "", false), createConstraints(1, 1, 4, 2));
        add(createLabel(""), createConstraints(1, 1, 5, 2));
        
        add(createLabel(""), createConstraints(1, 1, 0, 3));
        add(createRightLabel("Inseminação: "), createConstraints(1, 1, 1, 3));
        add(createCheckBox("inseminacao", "", false), createConstraints(1, 1, 2, 3));
        add(createRightLabel("Prenha: "), createConstraints(1, 1, 3, 3));
        add(createCheckBox("prenha", "", false), createConstraints(1, 1, 4, 3));
        add(createLabel(""), createConstraints(1, 1, 5, 3));
    }
    
    @Override
    public void setValues() {
        getTextFieldBovino().setText(matriz.getNumeroBovino());
        getCheckBoxImplante().setSelected(matriz.isImplante());
        getCheckBoxHormonio().setSelected(matriz.isHormonio());
        getCheckBoxInseminacao().setSelected(matriz.isSemen());
        getCheckBoxPrenha().setSelected(matriz.isPrenha());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Bovino.
     * @return Text Field Bovino.
     */
    public JTextField getTextFieldBovino() {
        return getTextField("bovino");
    }
    
    /**
     * Metodo responsavel por retornar o Button Pesquisa.
     * @return Button Pesquisa.
     */
    public JButton getButtonPesquisa() {
        return getButton("pesquisa");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Implante.
     * @return Check Box Implante.
     */
    public JCheckBox getCheckBoxImplante() {
        return getCheckBox("implante");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Hormonio.
     * @return Check Box Hormonio.
     */
    public JCheckBox getCheckBoxHormonio() {
        return getCheckBox("hormonio");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Inseminacao.
     * @return Check Box Inseminacao.
     */
    public JCheckBox getCheckBoxInseminacao() {
        return getCheckBox("inseminacao");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Prenha.
     * @return Check Box Prenha.
     */
    public JCheckBox getCheckBoxPrenha() {
        return getCheckBox("prenha");
    }
}