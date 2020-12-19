package controlador.visao.modal.consulta;

import controlador.visao.modal.ControllerViewModal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import modelo.controlador.ControllerEntidade;
import visao.modal.consulta.ViewConsulta;

/**
 * <p>Classe de Controle <b>ControllerViewConsulta</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewConsulta.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.ControllerViewModal
 * @see    visao.modal.consulta.ViewConsulta
 */
public abstract class ControllerViewConsulta extends ControllerViewModal {

    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta.
     */
    public ControllerViewConsulta(ViewConsulta view) {
        super(view);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (getView().getButtonPesquisa().equals(event.getSource()))
            pesquisar();
        else if (getView().getButtonNovo().equals(event.getSource()))
            novo();
        else if (getView().getButtonEditar().equals(event.getSource()))
            editar();
        else if (getView().getButtonExcluir().equals(event.getSource()))
            excluir();
        else if (getView().getButtonVoltar().equals(event.getSource()))
            getView().dispose();
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);
        switch (event.getKeyCode()) {
            case F5:
            case ENTER:
                pesquisar();
                break;
            case F1:
                novo();
                break;
            case F2:
                editar();
                break;
            case F3:
                excluir();
                break;
            case F4:
                getView().dispose();
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo abstrato responsavel por realizar a pesquisa.
     */
    public abstract void pesquisar();
    
    /**
     * Metodo abstrato responsavel por exibir a View para Cadastro.
     */
    public abstract void novo();
    
    /**
     * Metodo abstrato responsavel por exibir a View para Editar.
     */
    public abstract void editar();
    
    /**
     * Metodo Abstrato responsavel por exibir a View para Remocao.
     */
    public abstract void excluir();
    
    /**
     * Metodo abstract responsavel por retornar o Controller da Entidade.
     * @return Controller da Entidade.
     */
    public abstract ControllerEntidade getController();
    
    @Override
    public ViewConsulta getView() {
        return (ViewConsulta) this.view;
    }
}