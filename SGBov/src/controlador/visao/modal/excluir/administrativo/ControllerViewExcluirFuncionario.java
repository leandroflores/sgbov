package controlador.visao.modal.excluir.administrativo;

import controlador.visao.modal.excluir.ControllerViewExcluir;
import modelo.dao.administrativo.DaoFuncionario;
import visao.modal.excluir.administrativo.ViewExcluirFuncionario;
import visao.modal.mensagem.ViewMensagem;

/**
 * <p>Classe de Controle <b>ControllerViewExcluirFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewExcluirFuncionario.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.excluir.ControllerViewExcluir
 * @see    modelo.dao.administrativo.DaoFuncionario
 * @see    visao.modal.excluir.administrativo.ViewExcluirFuncionario
 */
public class ControllerViewExcluirFuncionario extends ControllerViewExcluir {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Excluir Funcionario.
     */
    public ControllerViewExcluirFuncionario(ViewExcluirFuncionario view) {
        super(view);
    }
    
    @Override
    public void excluir() {
        new DaoFuncionario().delete(getView().getFuncionario().getId());
        new ViewMensagem(getView(), "Funcionário removido com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public ViewExcluirFuncionario getView() {
        return (ViewExcluirFuncionario) view;
    }
}