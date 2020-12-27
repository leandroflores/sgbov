package controlador.visao.painel.editar.administrativo;

import controlador.visao.painel.editar.ControllerPanelEditar;
import visao.painel.editar.administrativo.PanelEditarFuncionario;

/**
 * <p>Classe de Controle <b>ControllerPanelEditarFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelEditarFuncionario.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.painel.editar.ControllerPanelEditar
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.painel.editar.administrativo.PanelEditarFuncionario
 */
public final class ControllerPanelEditarFuncionario extends ControllerPanelEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Editar Funcionario.
     */
    public ControllerPanelEditarFuncionario(PanelEditarFuncionario panel) {
        super(panel);
    }
    
    @Override
    public PanelEditarFuncionario getPanel() {
        return (PanelEditarFuncionario) panel;
    }
}