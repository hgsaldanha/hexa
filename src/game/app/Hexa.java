/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.app;

import engine.core.Game;
import engine.core.GameController;
import engine.eventos.EventosDoRender;
import engine.eventos.EventosDoTeclado;
import engine.itens.Posicao;
import engine.itens.PosicaoRender;
import engine.renders.WindowRender;
import game.controladores.Jogadores;
import game.itens.Goleiro;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author elane
 */
public class Hexa implements EventosDoTeclado,EventosDoRender{
    private static Hexa instance;
    private Goleiro goleiro;
    public Collection<Posicao> posicao;
    public PosicaoRender mapa;
    private Jogadores jogadores;
    private int velocidadeJogador = 10;
    private int velocidadeBola = 10;
    private int velocidadeGoleiro = 10;
    //private Bola bola;

    
    public Hexa() {
        
        Game.ALTURA_TELA = 700;
        Game.LARGURA_TELA = 750;
        
        //mapa = new PosicaoRender(16, 15, 50);
        jogadores = new Jogadores();
        
        //hulk = new Hulk(mapa,25);
        goleiro = new Goleiro(Game.LARGURA_TELA/2,Game.ALTURA_TELA-90);
    }
    
    public static Hexa getInstance() {
        if (instance == null)
            instance = new Hexa();
        return instance;
    }
    
    public void iniciar() {
        //hulk.iniciarAnimacao();
        goleiro.iniciarAnimacao();
        
        WindowRender window = new WindowRender(this, this);
        window.setVisible(true);
        Game.gameInit();
        
        Thread th_jogadores = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    while (!GameController.getInstance().fimjogo) {
                        getJogadores().novoJogador(new Random().nextInt(Game.LARGURA_TELA/2)+Game.LARGURA_TELA/4);
                        Thread.sleep(3000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Erro ao criar jogador.");
                }
            }
        });
        
        th_jogadores.start();
        
    }

    public Jogadores getJogadores() {
        return jogadores;
    }
    
    @Override
    public void teclaPress(int keycode) {
        
    }

    @Override
    public void teclaDireita() {
        goleiro.direita();
    }

    @Override
    public void teclaEsquerda() {
        goleiro.esquerda();
    }

    @Override
    public void teclaCima() {
        goleiro.cima();
    }

    @Override
    public void teclaBaixo() {
        goleiro.baixo();
    }

    @Override
    public void teclaEspaco() {
        
    }

    @Override
    public void antesPintar() {
        
    }

    @Override
    public void depoisPintar() {
        
    }
    
    public int getVelocidadeBola() {
        return velocidadeBola;
    }

    public void setVelocidadeBola(int velocidadeBola) {
        this.velocidadeBola += velocidadeBola;
    }

    public int getVelocidadeJogador() {
        return velocidadeJogador;
    }

    public void setVelocidadeJogador(int velocidade) {
        this.velocidadeJogador = velocidade;
    }

    public int getVelocidadeGoleiro() {
        return velocidadeGoleiro;
    }

    public void setVelocidadeGoleiro(int velocidadeGoleiro) {
        this.velocidadeGoleiro = velocidadeGoleiro;
    }
    
    
}
