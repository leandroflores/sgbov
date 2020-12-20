package visao.modal.novo;

import controlador.visao.modal.novo.ControllerViewNovo;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewNovo</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Novo</b> do SGBov.</p>
 * @author Leandro
 * @since  19/12/2020
 * @see    controlador.visao.modal.novo.ControllerViewNovo
 * @see    visao.modal.ViewModal
 */
public abstract class ViewNovo extends ViewModal {
    protected final ViewModal view;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta.
     */
    public ViewNovo(ViewModal view) {
        super(view);
        this.view = view;
    }
    
    @Override
    public void addHeader() {
        super.addHeader();
        getContentPane().add(createLabel("Os campos com (*) sao obrigatorios!"));
    }
    
    /**
     * Metodo responsavel por Limpar os Componentes da View Novo.
     */
    public abstract void clear();
    
    @Override
    public void addFooter() {
        JPanel footer = new JPanel();
               footer.setLayout(new FlowLayout(FlowLayout.CENTER));
               footer.add(createButton("inserir", " Inserir ", "sim"));
               footer.add(createButton("limpar",  " Limpar  ", "limpar"));
               footer.add(createButton("voltar",  " Voltar  ", "voltar"));
        getContentPane().add(footer);
    }
    
    /**
     * Metodo responsavel por retornar o Button Inserir.
     * @return Button Inserir.
     */
    public JButton getButtonInserir() {
        return getButton("inserir");
    }
    
    /**
     * Metodo responsavel por retornar o Button Limpar.
     * @return Button Limpar.
     */
    public JButton getButtonLimpar() {
        return getButton("limpar");
    }
    
    /**
     * Metodo responsavel por retornar o Button Voltar.
     * @return Button Voltar.
     */
    public JButton getButtonVoltar() {
        return getButton("voltar");
    }
    
    /**
     * Metodo responsavel por retornar o Controller da View Novo.
     * @return Controller da View Novo.
     */
    public ControllerViewNovo getController() {
        return (ControllerViewNovo) controller;
    }
    
    /**
     * Metodo responsavel por retornar a View.
     * @return View.
     */
    public ViewModal getView() {
        return view;
    }
}