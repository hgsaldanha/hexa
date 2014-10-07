/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.itens.Item;
import engine.itens.PosicaoRender;
import game.app.Hexa;


/**
 *
 * @author alunoruy
 */
public class Jogador extends Item{
    //private int DIRECAO;
    //private final int INTERVALO = 100;
    PosicaoRender pr;
    
    public Jogador(int x, int y) {
        super("goleiro.gif", x, y);
        setDeslocamento(1);
        iniciarAnimacao();
    }
    
    public Jogador(PosicaoRender pr, int p) {
       super("goleiro.gif",pr,p);
        //addImagem("goleiro_esquerda", "goleiro_esqueda.gif");
        //addImagem("goleiro_direita", "goleiro_direita.gif");
       this.pr = pr;
       setDeslocamento(1);
       iniciarAnimacao();
    }

    @Override
    public void animar() {
        moverPara(getX(), 355, Hexa.getInstance().getVelocidadeJogador());
        while (getY() < 350) {
            pausar(100);
        }
        chutar(new Bola(getX(),getY()));
    }
    
    public void chutar(Bola b) {
        b.setJogador(this);
        b.iniciarAnimacao();
    }
}
