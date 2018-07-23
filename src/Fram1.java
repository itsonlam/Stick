import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.w3c.dom.Node;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Fram1 extends Note {

	private JFrame frame;

	//linked list to store Note Object 
	private LinkedList<Note> notesLinkedList = new LinkedList<Note>();
   
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fram1 window = new Fram1();
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
	public Fram1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		//NEW BUTTON
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					
				
					//JOptionPane.showMessageDialog(null, "New Button Pressed.");
					//implementation of new Note
					//frame.dispose();
					NewNote newNote = new NewNote();
					newNote.setVisible(true);
					newNote.setLocationRelativeTo(null);
				
					
					
					
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		
		//LOAD BUTTON
		btnNew.setBounds(52, 111, 89, 23);
		frame.getContentPane().add(btnNew);
		
	
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					JOptionPane.showMessageDialog(null, "Load Button Pressed.");
					//implementation of loading Note
					
					
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		//SAVE BUTTON
		btnLoad.setBounds(151, 111, 89, 23);
		frame.getContentPane().add(btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					JOptionPane.showMessageDialog(null, "Save Button Pressed.");
					//implementation of saving  notes
					
					
				} catch(Exception g){
					JOptionPane.showMessageDialog(null, g);
				}
			}
		});
		btnSave.setBounds(250, 111, 89, 23);
		frame.getContentPane().add(btnSave);
	}
}
