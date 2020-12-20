package controlador.visao.modal.excluir.estruturais;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.estruturais.DaoBovino;
import visao.modal.excluir.estruturais.ViewExcluirBovino;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirBovino.</p>
 * @author Leandro
 * @since  20/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.estruturais.DaoBovino
 * @see    visao.modal.excluir.estruturais.ViewExcluirBovino
 */
public class ControllerViewExcluirBovino extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Bovino.
     */
    public ControllerViewExcluirBovino(ViewExcluirBovino view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        new DaoBovino().delete(getView().getBovino().getId());
        new ViewMensagem(getView(), "Bovino removido com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirBovino getView() {
        return (ViewExcluirBovino) view;
    }
}