package modelo.entidade.administrativo;

import funct.FunctDate;
import java.text.DecimalFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import modelo.entidade.Entidade;

/**
 * <p>Classe de Modelo <b>Funcionario</b>.</p>
 * <p>Classe responsavel por representar os objetos da tabela <b>sgbov.funcionario</b>.</p>
 * @author Leandro
 * @since  26/12/2020
 * @see    modelo.entidade.Entidade
 */
@Entity
@Table (schema = "sgbov", name = "funcionario")
public class Funcionario extends Entidade {
    @Column (name = "cpf")
    private String cpf;
    @Column (name = "nome")
    private String nome;
    @Column (name = "telefone")
    private String telefone;
    @Column (name = "salario")
    private Float  salario;
    @Column (name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date   nascimento;
    
    /**
     * Metodo construtor padrao da Classe.
     */
    public Funcionario() {
        cpf        = "";
        nome       = "";
        telefone   = "";
        salario    = 0.0f;
        nascimento = new FunctDate().getCurrentDate();
    }
    
    /**
     * Metodo responsavel por retornar o CPF do Funcionario.
     * @return CPF do Funcionario.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Metodo responsavel por definir o CPF do Funcionario.
     * @param cpf CPF do Funcionario.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Metodo responsavel por retornar o Nome do Funcionario.
     * @return Nome do Funcionario.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo responsavel por definir o Nome do Funcionario.
     * @param nome Nome do Funcionario.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo responsavel por retornar o Telefone do Funcionario.
     * @return Telefone do Funcionario.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Metodo responsavel por definir o Telefone do Funcionario.
     * @param telefone Telefone do Funcionario.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    /**
     * Metodo responsavel por retornar o Salario do Funcionario.
     * @return Salario do Funcionario.
     */
    public Float getSalario() {
        return salario;
    }

    /**
     * Metodo responsavel por retornar o Salario Formatado do Funcionario.
     * @return Salario Formatado do Funcionario.
     */
    public String getSalarioFormatado() {
        return new DecimalFormat("R$ #,##0.00").format(salario);
    }
    
    /**
     * Metodo responsavel por definir o Salario do Funcionario.
     * @param salario Salario do Funcionario.
     */
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    /**
     * Metodo responsavel por retornar a Data de Nascimento do Funcionario.
     * @return Data de Nascimento do Funcionario.
     */
    public Date getNascimento() {
        return nascimento;
    }
    
    /**
     * Metodo responsavel por retornar a Data de Nascimento Formatada do Funcionario.
     * @return Data de Nascimento Formatada do Funcionario.
     */
    public String getDataNascimentoFormatada() {
        return new FunctDate().getFormattedDate(nascimento);
    }

    /**
     * Metodo responsavel por definir a Data de Nascimento do Funcionario.
     * @param nascimento Data de Nascimento do Funcionario.
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    @Override
    public String[] getDadosPesquisa() {
        String[] dados    = new String[3];
                 dados[0] = Long.toString(id);
                 dados[1] = cpf;
                 dados[2] = nome;
        return   dados;
    }
    
    @Override
    public String[] getDados() {
        String[] dados    = new String[5];
                 dados[0] = Long.toString(id);
                 dados[1] = cpf;
                 dados[2] = nome;
                 dados[3] = getDataNascimentoFormatada();
                 dados[4] = getSalarioFormatado();
        return   dados;
    }
    
    @Override
    public String toString() {
        return id + " - " + nome + " (" + cpf + ")";
    }
}