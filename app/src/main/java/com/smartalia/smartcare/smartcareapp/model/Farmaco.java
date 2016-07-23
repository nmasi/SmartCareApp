package com.smartalia.smartcare.smartcareapp.model;

/**
 * Created by nicola on 07/07/16.
 */
public class Farmaco {
    private String nomeFarmaco;
    private String nomeAzienda;
    private String urlImg;
    private String descrizioneFarmaco;

    public Farmaco() {
    }

    public Farmaco(String nomeFarmaco, String nomeAzienda, String urlImg, String descrizioneFarmaco) {
        this.nomeFarmaco = nomeFarmaco;
        this.nomeAzienda = nomeAzienda;
        this.urlImg = urlImg;
        this.descrizioneFarmaco = descrizioneFarmaco;
    }

    public String getNomeFarmaco() {
        return nomeFarmaco;
    }

    public void setNomeFarmaco(String nomeFarmaco) {
        this.nomeFarmaco = nomeFarmaco;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDescrizioneFarmaco() {
        return descrizioneFarmaco;
    }

    public void setDescrizioneFarmaco(String descrizioneFarmaco) {
        this.descrizioneFarmaco = descrizioneFarmaco;
    }
}
