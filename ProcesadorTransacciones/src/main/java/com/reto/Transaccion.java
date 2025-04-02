package com.reto;
public class Transaccion {
    private int id;
    private String tipo;
    private double monto;

    public Transaccion(int id, String tipo, double monto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
