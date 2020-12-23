package visao.painel.pesquisa.estruturais;

import controlador.visao.painel.pesquisa.estruturais.ControllerPanelPesquisaBovino;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import visao.modal.pesquisa.estruturais.ViewPesquisaBovino;
import visao.painel.pesquisa.PanelPesquisa;

/**
 * <p>Classe de Visao <b>PanelPesquisaBovino</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Pesquisa de Bovino</b> do SGBov.</p>
 * @author Leandro
 * @since  23/12/2020
 * @see    controlador.visao.painel.pesquisa.estruturais.ControllerPanelPesquisaBovino
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.painel.pesquisa.PanelPesquisa
 */
public final class PanelPesquisaBovino extends PanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Bovino.
     */
    public PanelPesquisaBovino(ViewPesquisaBovino view) {
        super(view);
        controller = new ControllerPanelPesquisaBovino(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Tipo: ", 70));
        add(createComboBox("tipo", getTipos(), 30));
        add(createLabel("Sexo: ", 70));
        add(createComboBox("sexo", getSexos(), 20));
        add(createLabel("Número: ", 70));
        add(createSpinnerEditable("numero"));
        add(createLabel("Ativo: ", 70));
        add(createCheckBox("ativo", "", true));
        add(createButton("atualizar", "", "atualizar"));
    }
    
    /**
     * Metodo responsavel por retornar os Tipos dos Bovinos.
     * @return Tipos dos Bovinos.
     */
    private String[] getTipos() {
        return new String[]{"BEZERRO", "NOVILHO", "MATRIZ", "TOURO"};
    }
    
    /**
     * Metodo responsavel por retornar os Sexos dos Bovinos.
     * @return Sexos dos Bovinos.
     */
    private String[] getSexos() {
        return new String[]{"M", "F"};
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Tipo.
     * @return Check Box Tipo.
     */
    public JComboBox getComboBoxTipo() {
        return getComboBox("tipo");
    }
    
    /**
     * Metodo responsavel por retornar o Combo Box Sexo.
     * @return Check Box Sexo.
     */
    public JComboBox getComboBoxSexo() {
        return getComboBox("sexo");
    }
    
    /**
     * Metodo responsavel por retornar o Spinner Numero.
     * @return Spinner Numero.
     */
    public JSpinner getSpinnerNumero() {
        return getSpinner("numero");
    }
    
    /**
     * Metodo responsavel por retornar o Check Box Ativo.
     * @return Check Box Ativo.
     */
    public JCheckBox getCheckBoxAtivo() {
        return getCheckBox("ativo");
    }
    
    /**
     * Metodo responsavel por retornar o Button Atualizar.
     * @return Button Atualizar.
     */
    public JButton getButtonAtualizar() {
        return getButton("atualizar");
    }
}