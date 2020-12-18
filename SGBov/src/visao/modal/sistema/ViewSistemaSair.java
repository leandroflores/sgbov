package visao.modal.sistema;

import controlador.visao.modal.sistema.ControllerViewSistemaSair;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewSistemaSair</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Saida</b> do Sistema.</p>
 * @author  Leandro
 * @since   18/12/2020
 * @see     controlador.visao.modal.sistema.ControllerViewSistemaSair
 * @see     visao.estruturais.menu.ViewMenu
 * @see     visao.modal.ViewModal
 */
public final class ViewSistemaSair extends ViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     */
    public ViewSistemaSair(View view) {
        super(view);
        controller = new ControllerViewSistemaSair(this);
        title      = "Sair";
        setProperties();
        initComponents();
    }
    
    /**
     * Metodo responsavel por definir as Propriedados da View.
     */
    protected void setProperties() {
        updateTitle();
        setSize(650, 210);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void initComponents() {
        addHeader();
        addComponents();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(createLabelImage("sistema/sair"));
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(createLabel("Deseja realmente Sair do Sistema?"));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("sim", "  Sim  ", "sim"));
        getContentPane().add(createLabel("  "));
        getContentPane().add(createButton("nao", "  Não  ", "excluir"));
    }
    
    /**
     * Metodo responsavel por retornar o Button Sim.
     * @return Button Sim.
     */
    public JButton getButtonSim() {
        return getButton("sim");
    }

    /**
     * Metodo responsavel por retornar o Button Nao.
     * @return Button Nao.
     */
    public JButton getButtonNao() {
        return getButton("nao");
    }
}