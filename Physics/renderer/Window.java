package renderer;
import javax.swing.*;

/**
 * Window for Rendering Physics
 */
public class Window extends JFrame {

	GraphicsPanel panel;

	public Window() {
		panel = new GraphicsPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public GraphicsPanel getGraphicsPanel() {
		return panel;
	}

}
