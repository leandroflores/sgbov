package visao.modal.mensagem;

import controlador.visao.modal.mensagem.ControllerViewMensagem;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.estilo.ViewStyle;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewMensagem</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Mensagem</b> do Sistema.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.mensagem.ControllerViewMensagem
 * @see    visao.View
 * @see    visao.modal.ViewModal
 */
public final class ViewMensagem extends ViewModal {
    private final String mensagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewMensagem(View view, String message) {
        super(view);
        mensagem   = message;
        controller = new ControllerViewMensagem(this);
        setDefaultProperties();
        initComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Modal do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewMensagem(ViewModal view, String message) {
        super(view);
        mensagem   = message;
        controller = new ControllerViewMensagem(this);
        setDefaultProperties();
        initComponents();
    }

    /**
     * Metodo responsavel por definir as Propriedades Padroes da View Mensagem.
     */
    protected void setDefaultProperties() {
        setTitle(ViewStyle.SISTEMA + "Mensagem");
        setSize(mensagem.length() + 500, 160);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }
    
    @Override
    public void initComponents() {
        addHeader();
        addComponents();
        addFooter();
    }
    
    @Override
    public void addHeader() {
        getContentPane().add(getVerticalSpace(20));
        add(createLabelImage("icones/mensagem"));
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(getVerticalSpace(10));
        add(createLabel(mensagem));
        getContentPane().add(getVerticalSpace(10));
    }

    @Override
    public void addFooter() {
        add(createButton("ok", "   Ok   ", "sim"));
    }
    
    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return Botao Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}