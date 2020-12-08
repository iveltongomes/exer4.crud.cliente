
package model.bean;


public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String dataaniversario;

    public Cliente() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getdataaniversario() {
        return dataaniversario;
    }

    public void setdataaniversario(String dt_aniversario) {
        this.dataaniversario = dt_aniversario;
    }
    
    
    
}
