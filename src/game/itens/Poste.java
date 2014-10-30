/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.itens;

import engine.itens.Item;
import engine.itens.Obstaculo;

/**
 *
 * @author Herna
 */
public class Poste extends Item implements Obstaculo{
    public Poste(int x, int y) {
        super("poste.png",x,y);
    }
}
