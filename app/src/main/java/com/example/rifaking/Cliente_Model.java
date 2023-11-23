package com.example.rifaking;

public class Cliente_Model {

    String nomeCliente;
    String telefoneCliente;
    String Endereco;
    String numeroDoPonto;
    boolean Pago;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getNumeroDoPonto() {
        return numeroDoPonto;
    }

    public void setNumeroDoPonto(String numeroDoPonto) {
        this.numeroDoPonto = numeroDoPonto;
    }

    public boolean isPago() {
        return Pago;
    }

    public void setPago(boolean pago) {
        Pago = pago;
    }
}
