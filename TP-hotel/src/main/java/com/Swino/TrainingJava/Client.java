package com.Swino.TrainingJava;

public class Client {
    private Long cliId;
    private String cliNom,cliPrenom,cliTelephone;

    public Client(Long cliId, String cliNom, String cliPrenom, String cliTelephone) {
        this.cliId = cliId;
        this.cliNom = cliNom;
        this.cliPrenom = cliPrenom;
        this.cliTelephone = cliTelephone;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNom() {
        return cliNom;
    }

    public void setCliNom(String cliNom) {
        this.cliNom = cliNom;
    }

    public String getCliPrenom() {
        return cliPrenom;
    }

    public void setCliPrenom(String cliPrenom) {
        this.cliPrenom = cliPrenom;
    }

    public String getCliTelephone() {
        return cliTelephone;
    }

    public void setCliTelephone(String cliTelephone) {
        this.cliTelephone = cliTelephone;
    }
}
