package controlador.visao.painel.novo.rebanho;

import controlador.visao.painel.novo.ControllerPanelNovo;
import java.awt.event.ActionEvent;
import visao.painel.novo.rebanho.PanelNovoBovino;

/**
 * <p>Classe de Controle <b>ControllerPanelNovoBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador de Eventos</b> do PanelNovoBovino.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.painel.novo.ControllerPanelNovo
 * @see    modelo.entidade.estruturais.Bovino
 * @see    visao.painel.novo.rebanho.PanelNovoBovino
 */
public final class ControllerPanelNovoBovino extends ControllerPanelNovo {
    
    /**
     * Metodo construtor padrao da Classe.
     * @param panel Panel Novo Bovino.
     */
    public ControllerPanelNovoBovino(PanelNovoBovino panel) {
        super(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);
        if (getPanel().getComboBoxTipo().equals(event.getSource()))
            actionComboBox();
        else if (getPanel().getRadioButtonMacho().equals(event.getSource()))
            actionRadioButton(true);
        else if (getPanel().getRadioButtonFemea().equals(event.getSource()))
            actionRadioButton(false);
    }
    
    /**
     * Metodo responsavel por atualizar o Combo Box Tipo.
     */
    private void actionComboBox() {
        String tipo = getValue(getPanel().getComboBoxTipo());
        if (tipo.equalsIgnoreCase("MATRIZ"))
            actionRadioButton(false);
        else if (tipo.equalsIgnoreCase("TOURO"))
            actionRadioButton(true);
        allowRadioButton(!tipo.equals("MATRIZ") && !tipo.equals("TOURO"));
    }
    
    /**
     * Metodo responsavel por permitir a edicao dos Radios Buttons.
     * @param flag Flag.
     */
    private void allowRadioButton(boolean flag) {
        getPanel().getRadioButtonMacho().setEnabled(flag);
        getPanel().getRadioButtonFemea().setEnabled(flag);
    }
    
    /**
     * Metodo responsavel por atualizar o Radio Button Sexo.
     * @param flag Flag Macho.
     */
    private void actionRadioButton(boolean flag) {
        getPanel().getRadioButtonMacho().setSelected(flag);
        getPanel().getRadioButtonFemea().setSelected(!flag);
    }
    
    @Override
    public PanelNovoBovino getPanel() {
        return (PanelNovoBovino) panel;
    }
}