/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.itens;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alunoruy
 */
public class Placar2 extends JPanel{

    JLabel time1 = new JLabel();
    JLabel time2 = new JLabel();
    JLabel score1 = new JLabel();
    JLabel score2 = new JLabel();
    JLabel simbolo = new JLabel();
    JLabel tempo = new JLabel();
    Font fonte = new Font("Verdana", Font.BOLD, 16);
        
    public Placar2() {
        
        BufferedImage imgtime1;
         JLabel picLabel;
         BufferedImage imgtime2;
         JLabel picLabel2;
        
       
        
        
        time1.setText("Brasil");
        time1.setFont(fonte);
        time2.setText("Alemanha");
        time2.setFont(fonte);
        score1.setText("0");
        score1.setFont(fonte);
        score2.setText("0");
        score2.setFont(fonte);
        simbolo.setText("X");
        simbolo.setFont(fonte);
       // tempo = new Cronometro();
        tempo.setText("01:02");
        
        this.add(tempo);
        try {
            imgtime1 = ImageIO.read(new File("C:/Users/alunoruy.ACADEMICO/Desktop/Nave/Nave/Nave/src/resource/brasil.jpg"));
            picLabel = new JLabel(new ImageIcon(imgtime1));
            picLabel.setSize(10, 10);
            this.add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(Placar2.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.add(time1);
        this.add(score1);
        this.add(simbolo);
        this.add(score2);
        this.add(time2);
        try {
            imgtime2 = ImageIO.read(new File("C:/Users/alunoruy.ACADEMICO/Desktop/Nave/Nave/Nave/src/resource/alemanha.jpg"));
            picLabel2 = new JLabel(new ImageIcon(imgtime2));
            picLabel2.setSize(3, 3);
            this.add(picLabel2);
        } catch (IOException ex) {
            Logger.getLogger(Placar2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
}
