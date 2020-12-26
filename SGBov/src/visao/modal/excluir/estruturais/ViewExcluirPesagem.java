package visao.modal.excluir.estruturais;

import controlador.visao.modal.excluir.estruturais.ControllerViewExcluirPesagem;
import java.awt.Dimension;
import modelo.entidade.estruturais.Pesagem;
import visao.modal.consulta.estruturais.ViewConsultaPesagem;
import visao.modal.excluir.ViewExcluir;

/**
 * <p>Classe de Visao <b>ViewExluirPesagem</b>.</p>
 * <p>Classe responsavel por definir uma <b>Interface de Exclusao da Pesagem</b> do SGBov.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    controlador.visao.modal.excluir.estruturais.ControllerViewExcluirPesagem
 * @see    modelo.entidade.estruturais.Pesagem
 * @see    visao.modal.excluir.ViewExcluir
 */
public final class ViewExcluirPesagem extends ViewExcluir {
    private final Pesagem pesagem;
    
    /**
     * Metodo construtor padrao da Classe.
     * @param view View Consulta Pesagem.
     * @param pesagem_ Pesagem.
     */
    public ViewExcluirPesagem(ViewConsultaPesagem view, Pesagem pesagem_) {
        super(view);
        pesagem    = pesagem_;
        title      = "Excluir Pesagem";
        controller = new ControllerViewExcluirPesagem(this);
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
        super.addMessage(pesagem.getResumo());
    }
    
    /**
     * Metodo responsavel por retornar a Pesagem.
     * @return Pesagem.
     */
    public Pesagem getPesagem() {
        return pesagem;
    }
}