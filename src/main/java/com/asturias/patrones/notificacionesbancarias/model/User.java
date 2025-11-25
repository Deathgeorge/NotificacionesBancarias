package com.asturias.patrones.notificacionesbancarias.model;

import java.math.BigDecimal;

public class User {
    private String name;
    private BigDecimal documentAccount;
    private BigDecimal amount;

    public User(String name, BigDecimal documentAccount) {
        this.name = name;
        this.documentAccount = documentAccount;
        this.amount =  new BigDecimal(1000000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDocumentAccount() {
        return documentAccount;
    }

    public void setDocumentAccount(BigDecimal documentAccount) {
        this.documentAccount = documentAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
