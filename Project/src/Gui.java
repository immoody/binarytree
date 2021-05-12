import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;

public class Gui {

	private JFrame frame;
	private JTextArea textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		textPane = new JTextArea();
		
	
		frame.getContentPane().add(textPane, "name_247169914846735");
		BinarySearchTree x = new BinarySearchTree();
		x.insert(5);
		x.insert(3);
		x.insert(12);
		x.insert(7);
		x.insert(6);
		x.insert(8);
		x.insert(8);
		x.print2D(textPane);
	}

}
