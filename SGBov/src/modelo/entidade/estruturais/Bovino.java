package modelo.entidade.estruturais;

import funct.FunctDate;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Bovino</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.bovino</b>.</p>
 * @author Leandro
 * @since  17/12/2020
 * @see    modelo.entidade.Entidade
 */
@Entity
@Table (schema = "sgbov", name = "bovino")
public class Bovino extends Entidade {
    @Column (name = "tipo")
    private String  tipo;
    @Column (name = "numero")
    private Integer numero;
    @Column (name = "sexo")
    private char    sexo;
    @Column (name = "peso")
    private Float   peso;
    @Column (name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date    nascimento;

    /**
     * Metodo construtor padrao da Classe.
     */
    public Bovino() {
        tipo       = "MATRIZ";
        numero     = 0;
        sexo       = 'F';
        peso       = 0.0f;
        nascimento = new Date();
    }
    
    /**
     * Metodo responsavel por retornar o Tipo do Bovino.
     * @return Tipo do Bovino.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo responsavel por definir o Tipo do Bovino.
     * @param tipo Tipo do Bovino.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo responsavel por retornar o Numero do Bovino.
     * @return Numero do Bovino.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Metodo responsavel por definir o Numero do Bovino.
     * @param numero Numero do Bovino.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Metodo responsavel por retornar o Sexo do Bovino.
     * @return Sexo do Bovino.
     */
    public char getSexo() {
        return sexo;
    }
    
    /**
     * Metodo responsavel por retornar se o Bovino e Macho.
     * @return Bovino e Macho.
     */
    public boolean isMacho() {
        return sexo == 'M';
    }
    
    /**
     * Metodo responsavel por retornar se o Bovino e Femea.
     * @return Bovino e Femea.
     */
    public boolean isFemea() {
        return sexo == 'F';
    }

    /**
     * Metodo responsavel por definir o Sexo do Bovino.
     * @param sexo Sexo do Bovino.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Metodo responsavel por retornar o Peso do Bovino.
     * @return Peso do Bovino.
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * Metodo responsavel por retornar o Peso Formatado do Bovino.
     * @return Peso Formatado do Bovino.
     */
    public String getPesoFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(peso);
    } 
    
    /**
     * Metodo responsavel por definir o Peso do Bovino.
     * @param peso Peso do Bovino.
     */
    public void setPeso(Float peso) {
        this.peso = peso > 0.0f ? peso : 0.0f;
    }

    /**
     * Metodo responsavel por retornar a Data de Nascimento do Bovino.
     * @return Data de Nascimento do Bovino.
     */
    public Date getNascimento() {
        return nascimento;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Nascimento Formatada do Bovino.
     * @return Data de Nascimento Formatada do Bovino.
     */
    public String getDataNascimentoFormatada() {
        return new FunctDate().getFormattedDate(nascimento);
    }

    /**
     * Metodo responsavel por definir a Data de Nascimento do Bovino.
     * @param nascimento Data de Nascimento do Bovino.
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[6];
                 dados[0] = Long.toString(id);
                 dados[1] = tipo;
                 dados[2] = Integer.toString(numero);
                 dados[3] = Character.toString(sexo);
                 dados[4] = this.getDataNascimentoFormatada();
                 dados[5] = new DecimalFormat("#,##0.00").format(peso);
        return   dados;
    }

    @Override
    public String toString() {
        return id + " - " + numero + " (" + tipo + ")";
    }
}