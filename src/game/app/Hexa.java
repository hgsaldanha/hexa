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
import game.itens.Bola;
import game.itens.Estadio;
import game.itens.Goleiro;
import game.itens.Placar;
import game.itens.Poste;
import game.itens.Trave;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author elane
 */
public class Hexa implements EventosDoTeclado,EventosDoRender{
    private static Hexa instance;
    private Placar placar;
    private Estadio estadio;
    private Goleiro goleiro;
    private Trave trave;
    private Poste poste_esquerdo, poste_direito;
    public Collection<Posicao> posicao;
    public PosicaoRender mapa;
    private Jogadores jogadores;
    private int velocidadeJogador = 15;
    private int velocidadeBola = 15;
    private int velocidadeGoleiro = 10;
    private int areaDeChute = 500;
    private int linhaDoGolY;
    private WindowRender window;

    
    public Hexa() {
        Game.ALTURA_TELA = 675;
        Game.LARGURA_TELA = 1200;
        
        estadio = new Estadio();
        placar = new Placar((Game.LARGURA_TELA-300)/2, 10);
        jogadores = new Jogadores();
        
        //hulk = new Hulk(mapa,25);
        goleiro = new Goleiro(Game.LARGURA_TELA/2,Game.ALTURA_TELA-120);
        linhaDoGolY = Game.ALTURA_TELA - 45;
        poste_direito = new Poste((Game.LARGURA_TELA-274)/2, linhaDoGolY);
        poste_esquerdo = new Poste((Game.LARGURA_TELA-274)/2+267, linhaDoGolY);
    }
    
    public static Hexa getInstance() {
        if (instance == null)
            instance = new Hexa();
        return instance;
    }
    
    public void iniciar() {
        window = new WindowRender(this, this);
        estadio.iniciarAnimacao();
        //hulk.iniciarAnimacao();
        goleiro.iniciarAnimacao();
        //trave.iniciarAnimacao();
        poste_direito.iniciarAnimacao();
        poste_esquerdo.iniciarAnimacao();
        placar.iniciarAnimacao();
        
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
        if (getVelocidadeBola() >= 5)
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

    public int getAreaDeChute() {
        return areaDeChute;
    }

    public WindowRender getWindow() {
        return window;
    }
    
    public Trave getTrave() {
        return trave;
    }

    public int getLinhaDoGolY() {
        return linhaDoGolY;
    }
    
    public boolean isGol(Bola bola) {
        if (bola.getX() > (poste_direito.getX() + poste_direito.getWidth()) && bola.getX() < poste_esquerdo.getX())
            return true;
        return false;
    }
}
