package controlador.visao.painel.novo.administrativo;

import controlador.visao.painel.novo.ControllerPanelNovo;
import visao.painel.novo.administrativo.PanelNovoFuncionario;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoFuncionario.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.painel.novo.administrativo.PanelNovoFuncionario
 */
public final class ControllerPanelNovoFuncionario extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Funcionario.
     */
    public ControllerPanelNovoFuncionario(PanelNovoFuncionario panel) {
        super(panel);
    }
    
    @Override
    public PanelNovoFuncionario getPanel() {
        return (PanelNovoFuncionario) panel;
    }
}