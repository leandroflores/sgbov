package visao.painel.consulta.filtro.administrativo;

import controlador.visao.painel.consulta.filtro.ControllerPanelFiltro;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import visao.modal.consulta.administrativo.ViewConsultaFuncionario;
import visao.painel.consulta.filtro.PanelFiltro;

/**
 * <p>Classe de Visao <b>PanelFiltroFuncionario</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Filtro do Funcionario</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.painel.consulta.filtro.ControllerPanelFiltro
 * @see    modelo.entidade.administrativo.Funcionario
 * @see    visao.painel.consulta.filtro.PanelFiltro
 */
public final class PanelFiltroFuncionario extends PanelFiltro {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Funcionario.
     */
    public PanelFiltroFuncionario(ViewConsultaFuncionario view) {
        super(view);
        controller = new ControllerPanelFiltro(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("CPF: ",  100));
        add(createTextField("cpf", "", 15));
        add(createLabel("Nome: ", 100));
        add(createTextField("nome", "", 20));
        add(createButtonAtualizar());
    }
    
    /**
     * Metodo responsavel por retornar o Text Field CPF.
     * @return Text Field CPF.
     */
    public JTextField getTextFieldCPF() {
        return getTextField("cpf");
    }
    
    /**
     * Metodo responsavel por retornar o Text Field Nome.
     * @return Text Field Nome.
     */
    public JTextField getTextFieldNome() {
        return getTextField("nome");
    }
}