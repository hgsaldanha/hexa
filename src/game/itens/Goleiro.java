/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import engine.itens.ImagemItem;
import engine.itens.Item;
import game.info.Posicao;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alunoruy
 */
public class Goleiro extends Item{
    private int DIRECAO;
    private final int PARADO = 0;
    private final int ESQUERDA = 1;
    private final int DIREITA = 2;
    private final int DISTANCIA = 50;
    private final int INTERVALO = 100;
    private List<Posicao> posicao = new ArrayList<Posicao>();
    
    public Goleiro() {
        super("goleiro.gif", 350, 350);
       posicao.add(new Posicao(350,350));
       posicao.add(new Posicao(360,350));
       posicao.add(new Posicao(370,350));
       posicao.add(new Posicao(400,350));
       posicao.add(new Posicao(410,350));
       
        //addImagem("goleiro_esquerda", "goleiro_esqueda.gif");
        //addImagem("goleiro_direita", "goleiro_direita.gif");
        setDeslocamento(1);
    }
    
    public void toRight() {
        DIRECAO = DIREITA;
    }
    
    public void toLeft() {
        DIRECAO = ESQUERDA;
    }

    @Override
    public void animar() {
        while(!GameController.getInstance().isFimJogo()){ //Enquanto o jogo não chegou ao fim

            switch (DIRECAO) {
                case ESQUERDA:
                    /*if (!(getX() < 0)) //não pode sair pela esquerda
                        left();*/
                    deslocarReta(posicao.get(4).getX(), posicao.get(4).getY(), INTERVALO);
                    System.out.println("e");
                    break;
                case DIREITA:
                    /*if (!(getX() + getWidth() > 764)) //não pode sair pela direita
                        right();*/
                    deslocarReta(posicao.get(4).getX(),posicao.get(4).getY(), INTERVALO);
                    System.out.println("d");
                    break;
            }
            DIRECAO = PARADO;

            //Verifica se houve colisão com o inimigo
            /*if(GameController.getInstance().colisaoItem(Inimigo.class, this)){
                GameController.getInstance().setFimJogo(true);//Informa o fim do jogo
                GameController.getInstance().addItem(new ImagemItem("game-over.jpg"));
                setVisible(false);//Apaga a nave
            }
            */

            //pausar(50);
        }
    }
    
    
}
