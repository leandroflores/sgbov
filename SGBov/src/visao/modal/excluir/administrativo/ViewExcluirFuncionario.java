package visao.modal.excluir.administrativo;

import controlador.visao.modal.excluir.administrativo.ControllerViewExcluirFuncionario;
import java.awt.Dimension;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirFuncionario</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao do Funcionario</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.excluir.administrativo.ControllerViewExcluirFuncionario
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirFuncionario extends ViewExcluir {
    private final Funcionario funcionario;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Funcionario.
     * @param funcionario_ Funcionario.
     */
    public ViewExcluirFuncionario(ViewConsultaFuncionario view, Funcionario funcionario_) {
        super(view);
        funcionario = funcionario_;
        title       = "Excluir Funcionário";
        controller  = new ControllerViewExcluirFuncionario(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        super.setProperties();
        setSize(new Dimension(650, 165));
    }
    
    @Override
    public void addBody() {
        super.addMessage(funcionario.toString());
    }
    
    /**
     * Metodo responsavel por retornar o Funcionario.
     * @return Funcionario.
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }
}