/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;
import engine.itens.Obstaculo;
import game.app.Hexa;

/**
 *
 * @author alunoruy
 */
public class Goleiro extends Item implements Obstaculo{

    public static String IMAGEM_GOLEIRO_DIREITA = "IMAGEM_GOLEIRO_DIREITA";
    public static String IMAGEM_GOLEIRO_ESQUERDA = "IMAGEM_GOLEIRO_ESQUERDA";
    public static String IMAGEM_GOLEIRO_PARADO = "IMAGEM_GOLEIRO_PARADO";
    public static String IMAGEM_COMEMORACAO = "IMAGEM_COMEMORACAO";
    private double qtdeBolas;

    public Goleiro(int x, int y) {
        super("goleiro.png", x, y);
        this.addImagem(IMAGEM_GOLEIRO_DIREITA, "goleiro-direita.gif");
        this.addImagem(IMAGEM_GOLEIRO_ESQUERDA, "goleiro-esquerda.gif");
        this.addImagem(IMAGEM_GOLEIRO_PARADO, "goleiro.png");
        setDeslocamento(25);
    }

    @Override
    public void animar() {

    }

    public void addBolas(int p) {
        qtdeBolas += p;
    }

    public double getBolas() {
        return qtdeBolas;
    }

    public void diminuirPontos(int p) {
        qtdeBolas -= p;
    }

    public void direita() {
        moverPara(getX()+getDeslocamento(), getY(), Hexa.getInstance().getVelocidadeGoleiro());
    }

    public void esquerda() {
        moverPara(getX()-getDeslocamento(), getY(), Hexa.getInstance().getVelocidadeGoleiro());
    }

    public void cima() {
        
    }

    public void baixo() {
        
    }

}
