package br.com.hermescanuto.minhaconcessionaria.Data;

import java.lang.Override;import java.lang.String; /**
 * Created by herme on 27/11/2015.
 */
public class GrupoConcessionaria {

    private int id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "GrupoConcessionaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
