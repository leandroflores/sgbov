package visao.modal.novo.administrativo;

import controlador.visao.modal.novo.administrativo.ControllerViewNovoFuncionario;
import java.awt.Dimension;
import visao.modal.ViewModal;
import visao.modal.novo.ViewNovo;
import visao.painel.novo.administrativo.PanelNovoFuncionario;

/**
 * <p>Classe de Visao <b>ViewNovoFuncionario</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo Funcionario</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.novo.administrativo.ControllerViewNovoFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.novo.ViewNovo
 */
public final class ViewNovoFuncionario extends ViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View.
     */
    public ViewNovoFuncionario(ViewModal view) {
        super(view);
        title      = "Cadastro de Funcionário";
        controller = new ControllerViewNovoFuncionario(this);
        setProperties();
        addComponents();
        clear();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(520, 310));
    }
    
    @Override
    protected PanelNovoFuncionario createPanelNovo() {
        return new PanelNovoFuncionario(this);
    }
    
    @Override
    public PanelNovoFuncionario getPanelNovo() {
        return (PanelNovoFuncionario) super.getPanelNovo();
    }
}