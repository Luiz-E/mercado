package com.luizedu.mercado.dao;

import java.time.LocalDate;

public class DataValidadeDAO {
    private LocalDate data;
    private boolean dataIncompleta;
    private String codigoBarra;

    public DataValidadeDAO(LocalDate data, boolean dataIncompleta, String codigoBarra) {
        this.data = data;
        this.dataIncompleta = dataIncompleta;
        this.codigoBarra = codigoBarra;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isDataIncompleta() {
        return dataIncompleta;
    }

    public void setDataIncompleta(boolean dataIncompleta) {
        this.dataIncompleta = dataIncompleta;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Override
    public String toString() {
        return "DataValidadeDAO{" +
                "data=" + data +
                ", dataIncompleta=" + dataIncompleta +
                ", codigoBarra='" + codigoBarra + '\'' +
                '}';
    }
}
