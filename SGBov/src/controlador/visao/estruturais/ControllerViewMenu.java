package controlador.visao.estruturais;

import controlador.visao.ControllerView;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import visao.estruturais.menu.ViewMenu;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.modal.consulta.rebanho.ViewConsultaBovino;
import visao.modal.consulta.rebanho.ViewConsultaPesagem;
import visao.modal.consulta.financeiro.ViewConsultaDespesa;
import visao.modal.consulta.financeiro.ViewConsultaMovimentacao;
import visao.modal.consulta.financeiro.ViewConsultaReceita;
import visao.modal.consulta.rebanho.ViewConsultaInseminacao;
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
        else if (getView().getMenuItemInseminacao().equals(event.getSource()))
            new ViewConsultaInseminacao(getView()).setVisible(true);
        else if (getView().getMenuItemFuncionario().equals(event.getSource()))
            new ViewConsultaFuncionario(getView()).setVisible(true);
        else if (getView().getMenuItemMovimentacoes().equals(event.getSource()))
            new ViewConsultaMovimentacao(getView()).setVisible(true);
        else if (getView().getMenuItemDespesas().equals(event.getSource()))
            new ViewConsultaDespesa(getView()).setVisible(true);
        else if (getView().getMenuItemReceitas().equals(event.getSource()))
            new ViewConsultaReceita(getView()).setVisible(true);
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