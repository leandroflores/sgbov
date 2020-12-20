package visao.modal.mensagem;

import controlador.visao.modal.mensagem.ControllerViewErro;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import visao.View;
import visao.estilo.ViewStyle;
import visao.modal.ViewModal;

/**
 * <p>Classe de Visao <b>ViewErro</b>.</p>
 * <p>Classe responsavel por definir a <b>Interface de Erro</b> do Sistema.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    controlador.visao.modal.mensagem.ControllerViewErro
 * @see    visao.View
 * @see    visao.modal.ViewModal
 */
public final class ViewErro extends ViewModal {
    private final String mensagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewErro(View view, String message) {
        super(view);
        mensagem   = message;
        controller = new ControllerViewErro(this);
        setDefaultProperties();
        initComponents();
    }
    
    /**
     * Metodo construtor alternativo da Classe.
     * @param view View Modal do Sistema.
     * @param message Mensagem a ser exibida.
     */
    public ViewErro(ViewModal view, String message) {
        super(view);
        mensagem      = message;
        controller = new ControllerViewErro(this);
        setDefaultProperties();
        initComponents();
    }

    /**
     * Metodo responsavel por definir as Propriedades Padroes da View Erro.
     */
    protected void setDefaultProperties() {
        setTitle(ViewStyle.SISTEMA + "Erro");
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
        getContentPane().add(createLabelImage("icones/erro"));
    }
    
    @Override
    public void addComponents() {
        getContentPane().add(getVerticalSpace(10));
        getContentPane().add(createLabel(mensagem));
        getContentPane().add(getVerticalSpace(10));
    }
    
    @Override
    public void addFooter() {
        getContentPane().add(createButton("ok", "   Ok   ", "sim"));
    }

    /**
     * Metodo responsavel por retornar o Botao Ok.
     * @return Botao Ok.
     */
    public JButton getButtonOk() {
        return getButton("ok");
    }
}