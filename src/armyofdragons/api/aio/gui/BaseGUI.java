package armyofdragons.api.aio.gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class BaseGUI extends JFrame implements Runnable {
	
	public BaseGUI(Image icon, String title, Dimension size) {
		this.setTitle(title);
		this.setSize(size);
		this.setIconImage(icon);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public BaseGUI(String title, Dimension size) {
		this(null, title, size);
	}
	
}
