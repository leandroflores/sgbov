package modelo.controlador.rebanho;

import modelo.controlador.ControllerEntidade;

/**
 * <p>Classe de Controle <b>ControllerBovino</b>.</p>
 * <p>Classe responsavel por ser o <b>Controlador</b> da Classe de Entidade <b>Bovino</b>.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    modelo.controlador.ControllerEntidade
 * @see    modelo.entidade.estruturais.Bovino
 */
public class ControllerBovino extends ControllerEntidade {
    public static final String[] TIPOS  = {"Selecione", "BEZERRO", "NOVILHO", "MATRIZ", "TOURO"};
    public static final String[] SEXOS  = {"Selecione", "MACHO", "FÊMEA"};
}