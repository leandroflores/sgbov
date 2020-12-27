package controlador.visao.modal.novo.administrativo;

import controlador.visao.modal.novo.ControllerViewNovo;
import modelo.dao.administrativo.DaoFuncionario;
import modelo.entidade.administrativo.Funcionario;
import visao.modal.mensagem.ViewMensagem;
import visao.modal.novo.administrativo.ViewNovoFuncionario;
import visao.painel.novo.administrativo.PanelNovoFuncionario;

/**
 * <p>Classe de Controle <b>ControllerViewNovoFuncionario</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> da ViewNovoFuncionario.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.modal.novo.administrativo.ViewNovoFuncionario
 */
public class ControllerViewNovoFuncionario extends ControllerViewNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Novo Funcionario.
     */
    public ControllerViewNovoFuncionario(ViewNovoFuncionario view) {
        super(view);
    }
    
    /**
     * Metodo responsavel por validar o Nome do Funcionario.
     * @return Nome do Funcionario e valido.
     */
    public boolean checkNome() {
        return check(getPanelNovo().getTextFieldNome(), "Nome Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o CPF do Funcionario.
     * @return CPF do Funcionario e valido.
     */
    public boolean checkCPF() {
        return checkCPF(getPanelNovo().getTextFieldCPF(), "CPF Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o Telefone do Funcionario.
     * @return Telefone do Funcionario e valido.
     */
    public boolean checkTelefone() {
        return check(getPanelNovo().getTextFieldTelefone(), "Telefone Inválido!");
    }
    
    /**
     * Metodo responsavel por validar o Salario do Funcionario.
     * @return Salario do Funcionario e valido.
     */
    public boolean checkSalario() {
        return checkValor(getPanelNovo().getTextFieldSalario(), "Salário Inválido!");
    }
    
    /**
     * Metodo responsavel por validar a Data de Nascimento do Funcionario.
     * @return Data de Nascimento do Funcionario e valida.
     */
    public boolean checkDataNascimento() {
        return checkData(getPanelNovo().getTextFieldDataNascimento(), "Data Inválida!");
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
    public void inserir() {
        Funcionario funcionario = new Funcionario();
                    funcionario.setNome(getString(getPanelNovo().getTextFieldNome()).toUpperCase());
                    funcionario.setCpf(getString(getPanelNovo().getTextFieldCPF()));
                    funcionario.setTelefone(getString(getPanelNovo().getTextFieldTelefone()));
                    funcionario.setSalario(getFloat(getPanelNovo().getTextFieldSalario()));
                    funcionario.setNascimento(getData(getPanelNovo().getTextFieldDataNascimento()));
        new DaoFuncionario().insert(funcionario);
        new ViewMensagem(getView(), "Funcionário cadastrado com Sucesso!").setVisible(true);
        getView().getView().update();
        getView().dispose();
    }
    
    @Override
    public PanelNovoFuncionario getPanelNovo() {
        return getView().getPanelNovo();
    }
    
    @Override
    public ViewNovoFuncionario getView() {
        return (ViewNovoFuncionario) view;
    }
}