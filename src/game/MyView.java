package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

import java.awt.*;

/**
 * extended view
 */
public class MyView extends UserView {


    private Image background;


    public MyView(World world, int width, int height) {

        super(world, width, height);

        background = new ImageIcon("data/bg1.jpg").getImage();

        this.background = background.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
super.paintBackground(g);
        g.drawImage(((GameLevel)this.getWorld()).getBackgroundImage(), 0,0,this);

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Rockwell", Font.BOLD,15));
        g.setColor(Color.MAGENTA);

        g.drawString("Coins" + " " + (((GameLevel)this.getWorld()).getPlayer()).getCoinCount() + "/25", 100, 497);

        g.drawString("Health" + " " + (((GameLevel)this.getWorld()).getPlayer()).getHealthCount() + "/10", 200, 497);
    }

}


