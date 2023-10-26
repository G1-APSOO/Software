package componentesDeTelas;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFormattedTextField;

public class RoundJFormattedTextField extends JFormattedTextField {
	
	private Shape formato;
	private int arco;
	
    public RoundJFormattedTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
        arco = 35;
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arco, arco);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arco, arco);
    }
    public boolean contains(int x, int y) {
         if (formato == null || !formato.getBounds().equals(getBounds())) {
             formato = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, arco, arco);
         }
         return formato.contains(x, y);
    }

}
