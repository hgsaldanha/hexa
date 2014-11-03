/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import engine.itens.Item;
import game.app.Cronometro;

/**
 *
 * @author elane
 */
public class Placar extends Item {
    private int gols = 0;
    private Cronometro cronometro;

    public Placar(int x, int y) {
        super("placar.png",x,y);
        cronometro = new Cronometro();
    }
    
    public void gol() {
        gols++;
    }

    public int getGols() {
        return gols;
    }

    @Override
    public void animar() {
        //JLabel placar = new JLabel("00:00",JLabel.CENTER);
        //placar.setAlignmentX(0);
        //placar.setAlignmentY(0);
        
        cronometro.start();
        while (!GameController.getInstance().isFimJogo()) {
            //placar.setText(cronometro.getTempo());
            pausar(1000);
        }
    }
    
    
}
