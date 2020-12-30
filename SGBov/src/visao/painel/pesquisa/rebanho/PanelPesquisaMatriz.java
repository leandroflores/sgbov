package visao.painel.pesquisa.rebanho;

import controlador.visao.painel.pesquisa.rebanho.ControllerPanelPesquisaMatriz;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import visao.modal.pesquisa.rebanho.ViewPesquisaMatriz;
import visao.painel.pesquisa.PanelPesquisa;

/**
 * <p>Classe de Visao <b>PanelPesquisaMatriz</b>.</p> 
 * <p>Classe responsavel por definir o <b>Painel de Pesquisa de Matriz</b> do SGBov.</p>
 * @author Leandro
 * @since  29/12/2020
 * @see    controlador.visao.painel.pesquisa.rebanho.ControllerPanelPesquisaMatriz
 * @see    modelo.entidade.rebanho.Bovino
 * @see    visao.painel.pesquisa.PanelPesquisa
 */
public final class PanelPesquisaMatriz extends PanelPesquisa {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Pesquisa Matriz.
     */
    public PanelPesquisaMatriz(ViewPesquisaMatriz view) {
        super(view);
        controller = new ControllerPanelPesquisaMatriz(this);
        setProperties();
        addComponents();
    }
    
    @Override
    public void setProperties() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void addComponents() {
        add(createLabel("Número: ", 70));
        add(createSpinnerEditable("numero"));
        getSpinnerNumero().setValue(0);
        add(createLabel("Ativo: ", 70));
        add(createCheckBox("ativo", "", true));
        add(createButton("atualizar", "", "atualizar"));
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