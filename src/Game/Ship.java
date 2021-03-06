
package Game;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Ship extends ControlledGameObject {

    ImageIcon ship = new ImageIcon("images/ship1_1.gif");
    ImageIcon ship2 = new ImageIcon("images/ship1_2.gif");
    ImageIcon ship3 = new ImageIcon("images/ship1_3.gif");
    ImageIcon bonusEnemy = new ImageIcon("images/bonusenemy1_3.gif");
    ImageIcon lifeCounterShip = new ImageIcon("images/ship1_1_life.gif");
    ImageIcon lifeCounterShip2 = new ImageIcon("images/ship1_2_life.gif");
    ImageIcon lifeCounterShip3 = new ImageIcon("images/ship1_3_life.gif");

    // Constructor for all ship objects
    public Ship(int xPosition, int yPosition, Color color, KeyboardController control) {
        super(xPosition, yPosition, color, control);
    }

    // Draw bonus enemy ship
    public void bonusDraw(Graphics g) {

        bonusEnemy.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    }

    // Disegna il contatore delle vite
    public void lifeDraw(Graphics g) {
    	if(GamePanel.level == 1) {
    		lifeCounterShip.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	} else if(GamePanel.level == 2) {
    		lifeCounterShip2.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	} else if(GamePanel.level == 3) {
    		lifeCounterShip3.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	}
    }

    // Disegna la navetta del giocatore
    @Override
    public void draw(Graphics g) {
    	if (GamePanel.level == 1) {
        	ship.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	}
    	if (GamePanel.level == 2) {
        	ship2.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	}
    	if (GamePanel.level == 3) {
        	ship3.paintIcon(null, g, this.getXPosition(), this.getYPosition());
    	}
    }

    // Gets the hit box for all ship objects
    @Override
    public Rectangle getBounds() {
        Rectangle shipHitbox = new Rectangle(this.getXPosition(), this.getYPosition(), 50, 50);
        return shipHitbox;
    }

    // Muove la navicella
    @Override
    public void move() {
        // Movimento a sinistra
        if (control.getKeyStatus(37)) {
            xPos -= 10;
        }
        // Movimento a destra
        if (control.getKeyStatus(39)) {
            xPos += 10;
        }
        
        // Move from edge to edge without stopping
        if (xPos > 800) {
            xPos = -50;
        }
        if (xPos < -50) {
            xPos = 800;
        }
    }
}
