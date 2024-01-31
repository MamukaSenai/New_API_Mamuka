package com.mamuka.apimamuka.models;

public enum TipoModel {
    ADMIN("admin"),
    DESENVOLVEDOR("dev"),
    GESTOR("gestor");

    TipoModel(String tipo) {
        this.tipo = tipo;
    }

    private String tipo;

    public String getRole() {
        return tipo;
    }
}
