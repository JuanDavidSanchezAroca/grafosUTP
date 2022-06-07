package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import javafx.util.Pair;
import modelo.Nodo;

public class PanelGrafo extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Pair<Nodo, List<Nodo>>> grafo;

	public PanelGrafo() {
		this.grafo = new ArrayList<Pair<Nodo, List<Nodo>>>();
		this.setPreferredSize(new Dimension(1000, 1000));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		grafo.stream().forEach(x -> {
			g2d.setColor(Color.BLACK);
			g2d.drawString(String.valueOf(x.getKey().getNumero()), (int) x.getKey().getCordenadaX() + 7,
					(int) x.getKey().getCordenadaY() + 20);
			g2d.drawOval((int) x.getKey().getCordenadaX(), (int) x.getKey().getCordenadaY(), 30, 30);

			for (Nodo pair : x.getValue()) {
				g2d.setStroke(new BasicStroke(2));
				int x0 = (int) x.getKey().getCordenadaX() + 5;
				int x1 = (int) pair.getCordenadaX() + 5;
				int y0 = (int) x.getKey().getCordenadaY() + 20;
				int y1 = (int) pair.getCordenadaY() + 20;

				double alfa = Math.atan2(y1 - y0, x1 - x0);
				g2d.drawLine(x0, y0, x1, y1);
				int k = 5;
				int xa = (int) (x1 - k * Math.cos(alfa + 1));
				int ya = (int) (y1 - k * Math.sin(alfa + 1));
				g.drawLine(xa, ya, x1, y1);
				xa = (int) (x1 - k * Math.cos(alfa - 1));
				ya = (int) (y1 - k * Math.sin(alfa - 1));
				g2d.drawLine(xa, ya, x1, y1);
				g2d.drawString(String.valueOf(pair.getPeso()),((x0+x1)/2),((y0+y1)/2));
			}
			g2d.setStroke(new BasicStroke(1));

		});
	}

	public void circulo(List<Pair<Nodo, List<Nodo>>> grafo) {
		this.grafo = grafo;
		this.repaint();
	}

}
