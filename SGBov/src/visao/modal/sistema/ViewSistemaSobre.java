package visao.modal.sistema;

import controlador.visao.modal.sistema.ControllerViewSistemaSobre;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.estruturais.menu.ViewMenu;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewSistemaSobre</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Informacoes</b> do SGBov.</p>
 * @author Leandro
 * @since  18/12/2020
 * @see    controlador.visao.modal.sistema.ControllerViewSistemaSobre
 * @see    visao.estruturais.menu.ViewMenu
 * @see    visao.modal.ViewModal
 */
public final class ViewSistemaSobre extends ViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ViewSistemaSobre(ViewMenu view) {
        super(view);
        controller = new ControllerViewSistemaSobre(this);
        title      = "Sobre";
        initComponents();
    }
    
    /**
     * Metodo responsavel por definir as Propriedados da View.
     */
    protected void setProperties() {
        updateTitle();
        setSize(350, 300);
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
        getContentPane().add(createLabelImage("sistema/sobre"));
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(createLabel("SGBov - Sistema de Gerenciamento de Bovinos"));
        getContentPane().add(createLabel("Versao 1.0"));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("ok", "   Ok   ", "sim"));
    }

    /**
     * Metodo responsavel por retornar o Button Ok.
     * @return Button Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}