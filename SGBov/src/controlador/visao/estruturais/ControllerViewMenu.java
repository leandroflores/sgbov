package controlador.visao.estruturais;

import controlador.visao.ControllerView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.modal.consulta.estruturais.ViewConsultaBovino;
import visao.modal.consulta.estruturais.ViewConsultaPesagem;
import visao.modal.sistema.ViewSistemaSair;
import visao.modal.sistema.ViewSistemaSobre;

/**
 * <p>Classe de Controle <b>ControllerViewMenu</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewMenu.</p>
 * @author Leandro
 * @since  18/12/2020
 * @see    controlador.visao.ControllerView
 * @see    visao.estruturais.menu.ViewMenu
 */
public class ControllerViewMenu extends ControllerView {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Menu.
     */
    public ControllerViewMenu(ViewMenu view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getMenuItemRebanho().equals(event.getSource()))
            new ViewConsultaBovino(getView()).setVisible(true);
        else if (getView().getMenuItemPesagem().equals(event.getSource()))
            new ViewConsultaPesagem(getView()).setVisible(true);
        else if (getView().getMenuItemFuncionario().equals(event.getSource()))
            new ViewConsultaFuncionario(getView()).setVisible(true);
        else if (getView().getMenuItemSobre().equals(event.getSource()))
            new ViewSistemaSobre(getView()).setVisible(true);
        else if (getView().getMenuItemSair().equals(event.getSource()))
            new ViewSistemaSair(getView()).setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        if (ESC == event.getKeyCode())
            new ViewSistemaSair(getView()).setVisible(true);
    }
    
    @Override
    public ViewMenu getView() {
        return (ViewMenu) view;
    }
}