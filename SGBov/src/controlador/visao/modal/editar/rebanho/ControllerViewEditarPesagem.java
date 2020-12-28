package controlador.visao.modal.editar.rebanho;

import controlador.visao.modal.editar.ControllerViewEditar;
import modelo.dao.rebanho.DaoPesagem;
import modelo.entidade.rebanho.Pesagem;
import visao.modal.editar.rebanho.ViewEditarPesagem;
import visao.modal.mensagem.ViewMensagem;
import visao.painel.editar.rebanho.PanelEditarPesagem;

/**
 * <p>Classe de Controle <b>ControllerViewEditarPesagem</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarPesagem.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.entidade.rebanho.Pesagem
 * @see    visao.modal.editar.rebanho.ViewEditarPesagem
 */
public class ControllerViewEditarPesagem extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Pesagem.
     */
    public ControllerViewEditarPesagem(ViewEditarPesagem view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar a Data da Pesagem.
     * @return Data da Pesagem e valida.
     */
    public boolean checkData() {
        return checkData(getPanel().getTextFieldData(), "Data Inválida!");
    }
    
    /**
     * Metodo responsavel por validar o Valor da Pesagem.
     * @return Valor da Pesagem e valido.
     */
    public boolean checkValor() {
        return checkValor(getPanel().getTextFieldPeso(), "Peso Inválido!");
    }
    
    @Override
    public boolean check() {
        return checkData()
            && checkValor();
    }
    
    @Override
    public void salvar() {
        Pesagem pesagem = getView().getPesagem();
                pesagem.setDataPesagem(getData(getPanel().getTextFieldData()));
                pesagem.setValor(getFloat(getPanel().getTextFieldPeso()));
        new DaoPesagem().update(pesagem);
        new ViewMensagem(getView(), "Pesagem atualizada com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelEditarPesagem getPanel() {
        return (PanelEditarPesagem) getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarPesagem getView() {
        return (ViewEditarPesagem) view;
    }
}