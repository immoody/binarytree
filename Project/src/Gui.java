import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui {

	private JFrame frame;
	private JTextField InsertTextfield;
	private JButton InsertButton;
	private JTextField DeleteTextfield;
	private JButton DeleteButtonn;
	private JButton DisplayButton;
	private JTextArea textPane;
	private JTextArea BoardTextPane;

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
		 BinarySearchTree Binarytree = new BinarySearchTree();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel InsertLabel = new JLabel("Insert");
		InsertLabel.setForeground(Color.CYAN);
		springLayout.putConstraint(SpringLayout.WEST, InsertLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, InsertLabel, 66, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(InsertLabel);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setForeground(Color.CYAN);
		springLayout.putConstraint(SpringLayout.WEST, lblDelete, 0, SpringLayout.WEST, InsertLabel);
		frame.getContentPane().add(lblDelete);
		
		InsertTextfield = new JTextField();
		InsertTextfield.setBackground(Color.CYAN);
		springLayout.putConstraint(SpringLayout.WEST, InsertTextfield, 111, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, InsertTextfield, -389, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, InsertLabel, 0, SpringLayout.NORTH, InsertTextfield);
		springLayout.putConstraint(SpringLayout.EAST, InsertLabel, -6, SpringLayout.WEST, InsertTextfield);
		springLayout.putConstraint(SpringLayout.NORTH, InsertTextfield, 37, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, InsertTextfield, 66, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(InsertTextfield);
		InsertTextfield.setColumns(10);
		
		InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Binarytree.insert(Integer.parseInt(InsertTextfield.getText()));
				InsertTextfield.setText("");
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, InsertButton, 38, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, InsertButton, 11, SpringLayout.EAST, InsertTextfield);
		springLayout.putConstraint(SpringLayout.SOUTH, InsertButton, -311, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, InsertButton, -293, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(InsertButton);
		
		DeleteTextfield = new JTextField();
		DeleteTextfield.setBackground(Color.CYAN);
		springLayout.putConstraint(SpringLayout.NORTH, DeleteTextfield, 46, SpringLayout.SOUTH, InsertTextfield);
		springLayout.putConstraint(SpringLayout.SOUTH, DeleteTextfield, -237, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblDelete, 6, SpringLayout.NORTH, DeleteTextfield);
		springLayout.putConstraint(SpringLayout.EAST, lblDelete, -6, SpringLayout.WEST, DeleteTextfield);
		springLayout.putConstraint(SpringLayout.WEST, DeleteTextfield, 111, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, DeleteTextfield, 0, SpringLayout.EAST, InsertTextfield);
		DeleteTextfield.setColumns(10);
		frame.getContentPane().add(DeleteTextfield);
		
		DeleteButtonn = new JButton("Delete");
		DeleteButtonn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Binarytree.deleteKey(Integer.parseInt(DeleteTextfield.getText()));
				DeleteTextfield.setText("");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, DeleteButtonn, 46, SpringLayout.SOUTH, InsertButton);
		springLayout.putConstraint(SpringLayout.WEST, DeleteButtonn, 11, SpringLayout.EAST, DeleteTextfield);
		springLayout.putConstraint(SpringLayout.EAST, DeleteButtonn, 96, SpringLayout.EAST, DeleteTextfield);
		frame.getContentPane().add(DeleteButtonn);
		
		DisplayButton = new JButton("Display");
		DisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardTextPane.setText("");
				Binarytree.print2D(BoardTextPane);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, DisplayButton, 37, SpringLayout.SOUTH, DeleteTextfield);
		springLayout.putConstraint(SpringLayout.WEST, DisplayButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, DisplayButton, 120, SpringLayout.SOUTH, DeleteButtonn);
		springLayout.putConstraint(SpringLayout.EAST, DisplayButton, 0, SpringLayout.EAST, InsertTextfield);
		frame.getContentPane().add(DisplayButton);
		
		 BoardTextPane = new JTextArea();
		BoardTextPane.setBackground(Color.CYAN);
		springLayout.putConstraint(SpringLayout.NORTH, BoardTextPane, 0, SpringLayout.NORTH, InsertLabel);
		springLayout.putConstraint(SpringLayout.WEST, BoardTextPane, 24, SpringLayout.EAST, InsertButton);
		springLayout.putConstraint(SpringLayout.SOUTH, BoardTextPane, 0, SpringLayout.SOUTH, DisplayButton);
		springLayout.putConstraint(SpringLayout.EAST, BoardTextPane, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(BoardTextPane);
		
		
		
	}
}
