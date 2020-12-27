package visao.modal.editar.administrativo;

import controlador.visao.modal.editar.administrativo.ControllerViewEditarFuncionario;
import java.awt.Dimension;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.modal.editar.ViewEditar;
import visao.painel.editar.administrativo.PanelEditarFuncionario;

/**
 * <p>Classe de Visao <b>ViewEditarFuncionario</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Edicao do Funcionario</b> do SGBov.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.editar.administrativo.ControllerViewEditarFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.editar.ViewEditar
 */
public final class ViewEditarFuncionario extends ViewEditar {
    private final Funcionario funcionario;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Funcionario.
     * @param funcionario_ Funcionario.
     */
    public ViewEditarFuncionario(ViewConsultaFuncionario view, Funcionario funcionario_) {
        super(view);
        funcionario = funcionario_;
        title       = "Editar Funcionário";
        controller  = new ControllerViewEditarFuncionario(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(525, 300));
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void addBody() {
        addPanel("panel_editar", new PanelEditarFuncionario(this, funcionario));
        getContentPane().add(getPanelEditar());
        getContentPane().add(getVerticalSpace(20));
    }
    
    @Override
    public void setValues() {
        getPanelEditar().setValues();
    }
    
    /**
     * Metodo responsavel por retornar o Funcionario.
     * @return Funcionario.
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    @Override
    public PanelEditarFuncionario getPanelEditar() {
        return (PanelEditarFuncionario) super.getPanelEditar();
    }
}