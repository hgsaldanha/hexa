/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.Game;
import engine.core.GameController;
import engine.itens.Item;
import engine.itens.Obstaculo;
import game.app.Hexa;
import java.util.Random;

/**
 *
 * @author alunoruy
 */
public class Bola extends Item {
    private Jogador jogador;

    private Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    public Bola(int x, int y) {
        super("bola.gif", x, y);
        setDeslocamento(1);
    }
    
    @Override
    public void animar() {
        Item item = null;
        //Item poste = null;
        moverPara(new Random().nextInt(Hexa.getInstance().getAreaDeChute()) + ((Game.LARGURA_TELA - Hexa.getInstance().getAreaDeChute()) / 2), Game.ALTURA_TELA, Hexa.getInstance().getVelocidadeBola());
        while(getY() < Game.ALTURA_TELA && item == null){
            item = GameController.getInstance().getColisaoItem(this);
            pausar(5);
        }
        
        if (item != null) {
            if (item instanceof Goleiro) {
                System.out.println("defesa");
                Hexa.getInstance().setVelocidadeBola(-1);
            } else if (item instanceof Poste) {
                System.out.println("trave");
            } else {
                System.out.println("colisao");
            }
        }
        
        getJogador().setVisible(false);
        setVisible(false);

        Hexa.getInstance().getJogadores().atualizaContagem(-1); //1 jogador a menos
    }
   
}
