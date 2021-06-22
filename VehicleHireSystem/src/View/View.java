package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class View {

	protected JPanel panel;
	protected JFrame frame;
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public void setNextView(View newView) {
		this.frame.setVisible(false);
		newView.getFrame().setVisible(true);
	}
}
