package br.com.hermescanuto.minhaconcessionaria.Data;

import java.io.Serializable;import java.lang.Override;import java.lang.String;

/**
 * Created by herme on 27/11/2015.
 */
public class Concessionaria implements Serializable {

    private GrupoConcessionaria grupoConcessionaria;
    private int id;
    private String nome;

    private String ddd;
    private String telefone;
    private String email;


    public GrupoConcessionaria getGrupoConcessionaria() {
        return grupoConcessionaria;
    }

    public void setGrupoConcessionaria(GrupoConcessionaria grupoConcessionaria) {
        this.grupoConcessionaria = grupoConcessionaria;
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

    @Override
    public String toString() {
        return "Concessionaria{" +
                "grupoConcessionaria=" + grupoConcessionaria.toString() +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
