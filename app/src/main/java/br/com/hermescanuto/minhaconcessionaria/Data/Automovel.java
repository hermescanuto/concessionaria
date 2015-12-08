package br.com.hermescanuto.minhaconcessionaria.Data;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by herme on 27/11/2015.
 */
public class Automovel extends SugarRecord<Automovel>  implements Serializable {

    private int  anoFabricacao;
    private int  anoModelo;
    private String fabricante = "Volkswagem";
    private String modelo;
    private String placa;



    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }



    @Override
    public String toString() {
        return "Automovel{" +
                "fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", anoModelo=" + anoModelo +
                '}';
    }


}
