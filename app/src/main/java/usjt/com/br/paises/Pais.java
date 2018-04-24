package usjt.com.br.paises;

import android.graphics.Bitmap;

/**
 * Marcelo Victor da Silva
 * RA: 816119006
 * ADSMCA3
 */

public class Pais {


    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private String area;
    private String bandeira;
    private Bitmap bandeiraBitMap;
    private double gini;
    private String idiomas;
    private String moedas;
    private String dominios;
    private String fusos;
    private String fronteiras;
    private double latitude;
    private double longitude;

    public Pais(){
    }

    public Pais(String nome , String regiao , String bandeira, String capital){
        this.nome = nome;
        this.bandeira = bandeira;
        this.regiao = regiao;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Bitmap getBandeiraBitMap() {
        return bandeiraBitMap;
    }

    public void setBandeiraBitMap(Bitmap bandeiraBitMap) {
        this.bandeiraBitMap = bandeiraBitMap;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getMoedas() {
        return moedas;
    }

    public void setMoedas(String moedas) {
        this.moedas = moedas;
    }

    public String getDominios() {
        return dominios;
    }

    public void setDominios(String dominios) {
        this.dominios = dominios;
    }

    public String getFusos() {
        return fusos;
    }

    public void setFusos(String fusos) {
        this.fusos = fusos;
    }

    public String getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(String fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
