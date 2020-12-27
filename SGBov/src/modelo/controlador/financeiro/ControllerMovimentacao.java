package modelo.controlador.financeiro;

import java.util.List;
import modelo.controlador.ControllerEntidade;
import modelo.entidade.financeiro.Movimentacao;

/**
 * <p>Classe de Controle <b>ControllerMovimentacao</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Entidade <b>Movimentacao</b>.</p>
 * @author Leandro
 * @since  27/12/2020
 * @see    modelo.controlador.ControllerEntidade
 * @see    modelo.entidade.financeiro.Movimentacao
 */
public class ControllerMovimentacao extends ControllerEntidade {
    public static final String[] TIPOS = {"Selecione", "RECEITA", "DESPESA"};
    
    /**
     * Metodo responsavel por retornar o Valor Total de uma Lista de Movimentacoes.
     * @param  list Lista de Movimentacoes.
     * @return Valor Total de uma Lista de Movimentacoes.
     */
    public Float getTotal(List<Movimentacao> list) {
        Float  total  = 0.0f;
        for (Movimentacao movimentacao : list)
               total += movimentacao.getValor();
        return total;
    }
}