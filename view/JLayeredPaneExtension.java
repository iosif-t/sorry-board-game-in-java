package view;

import java.awt.*;


import javax.swing.JLayeredPane;

public class JLayeredPaneExtension extends JLayeredPane {
	 Image image;
	 /**
	  * constructor
	  * @param img image
	  */
     public JLayeredPaneExtension(Image img) {
         image=img;
     }

    /**
     * post the component is now painted
     */
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(image, 0, 0, this);
     }

}
