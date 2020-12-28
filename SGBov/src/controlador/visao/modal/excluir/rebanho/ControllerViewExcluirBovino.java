package controlador.visao.modal.excluir.rebanho;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.rebanho.DaoBovino;
import modelo.dao.rebanho.DaoPesagem;
import visao.modal.excluir.rebanho.ViewExcluirBovino;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirBovino.</p>
 * @author Leandro
 * @since  20/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.rebanho.DaoBovino
 * @see    modelo.dao.rebanho.DaoPesagem
 * @see    visao.modal.excluir.rebanho.ViewExcluirBovino
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
        new DaoPesagem().delete(getView().getBovino());
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