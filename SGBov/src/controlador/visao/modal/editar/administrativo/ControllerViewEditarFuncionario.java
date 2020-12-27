package controlador.visao.modal.editar.administrativo;

import controlador.visao.modal.editar.ControllerViewEditar;
import modelo.dao.administrativo.DaoFuncionario;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.editar.administrativo.ViewEditarFuncionario;
import visao.modal.mensagem.ViewMensagem;
import visao.painel.editar.administrativo.PanelEditarFuncionario;

/**
 * <p>Classe de Controle <b>ControllerViewEditarFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewEditarFuncionario.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    controlador.visao.modal.editar.ControllerViewEditar
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.editar.administrativo.ViewEditarFuncionario
 */
public class ControllerViewEditarFuncionario extends ControllerViewEditar {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Editar Funcionario.
     */
    public ControllerViewEditarFuncionario(ViewEditarFuncionario view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar o Nome do Funcionario.
     * @return Nome do Funcionario e valido.
     */
    public boolean checkNome() {
        return check(getPanel().getTextFieldNome(), "Nome Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o CPF do Funcionario.
     * @return CPF do Funcionario e valido.
     */
    public boolean checkCPF() {
        return checkCPF(getPanel().getTextFieldCPF(), "CPF Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o Telefone do Funcionario.
     * @return Telefone do Funcionario e valido.
     */
    public boolean checkTelefone() {
        return check(getPanel().getTextFieldTelefone(), "Telefone Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o Salario do Funcionario.
     * @return Salario do Funcionario e valido.
     */
    public boolean checkSalario() {
        return checkValor(getPanel().getTextFieldSalario(), "Salário Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Nascimento do Funcionario.
     * @return Data de Nascimento do Funcionario e valida.
     */
    public boolean checkDataNascimento() {
        return checkData(getPanel().getTextFieldDataNascimento(), "Data Inválida!");
    }
    
    @Override
    public boolean check() {
        return checkNome()
            && checkCPF()
            && checkTelefone()
            && checkSalario()
            && checkDataNascimento();
    }
    
    @Override
    public void salvar() {
        Funcionario funcionario = getView().getFuncionario();
                    funcionario.setNome(getString(getPanel().getTextFieldNome()).toUpperCase());
                    funcionario.setCpf(getString(getPanel().getTextFieldCPF()));
                    funcionario.setTelefone(getString(getPanel().getTextFieldTelefone()));
                    funcionario.setSalario(getFloat(getPanel().getTextFieldSalario()));
                    funcionario.setNascimento(getData(getPanel().getTextFieldDataNascimento()));
        new DaoFuncionario().update(funcionario);
        new ViewMensagem(getView(), "Funcionário atualizado com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelEditarFuncionario getPanel() {
        return getView().getPanelEditar();
    }
    
    @Override
    public ViewEditarFuncionario getView() {
        return (ViewEditarFuncionario) view;
    }
}