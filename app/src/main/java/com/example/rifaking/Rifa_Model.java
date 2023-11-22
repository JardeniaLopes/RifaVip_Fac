package com.example.rifaking;

import com.google.firebase.Timestamp;

import java.util.Date;

import kotlinx.coroutines.channels.ActorKt;

public class Rifa_Model {
    String nomeRifa;
    Date dataSorteio;
    float valor;
    int qtPontos;
    String premio;

    public String getNomeRifa() {
        return nomeRifa;
    }

    public void setNomeRifa(String nomeRifa) {
        this.nomeRifa = nomeRifa;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtPontos() {
        return qtPontos;
    }

    public void setQtPontos(int qtPontos) {
        this.qtPontos = qtPontos;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public Rifa_Model() {

    }
}
