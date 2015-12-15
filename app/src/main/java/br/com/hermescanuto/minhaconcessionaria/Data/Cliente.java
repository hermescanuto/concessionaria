package br.com.hermescanuto.minhaconcessionaria.Data;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.List;

public class Cliente extends SugarRecord<Cliente>  {

    private String nome;
    private String ddd;
    private String telefone;
    private String email;
    private String cpf;

    @Ignore
    public long clienteID;


    public Cliente() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public long  getClienteId(){
        return this.clienteID;
    }

    public Cliente getCliente() {

        long numeroDeClientes = Cliente.count(Cliente.class, null, null);

        Cliente c = new Cliente();

        if (numeroDeClientes != 0) {
            List<Cliente> clientes = Cliente.listAll(Cliente.class);

            c.setNome(clientes.get(0).getNome());
            c.setEmail(clientes.get(0).getEmail());
            c.setCpf(clientes.get(0).getCpf());
            c.setDdd(clientes.get(0).getDdd());
            c.setTelefone(clientes.get(0).getTelefone());
            this.clienteID = clientes.get(0).id ;
        }
        return c;
    }

}
