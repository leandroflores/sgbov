package modelo.controlador.financeiro;

import modelo.controlador.ControllerEntidade;

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
}