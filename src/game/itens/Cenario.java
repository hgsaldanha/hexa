/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import engine.core.GameController;
import engine.itens.Item;

/**
 *
 * @author elane
 */
public class Cenario extends Item{
 
    public Cenario() {
        super("estadio.png", 0, -1420);
        setDeslocamento(1);
    }
    
    @Override
    public void animar() {
     
        if(!GameController.getInstance().isFimJogo()){ //Se o jogo ainda não chegou ao fim
            GameController.getInstance().setFimJogo(true);
        }
        
    } 
}
