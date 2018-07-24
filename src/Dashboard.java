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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class Dashboard extends Note {

	private JFrame frmDashboard;

	//linked list to store Note Object 
	private LinkedList<Note> notesLinkedList = new LinkedList<Note>();
	private LinkedList<NoteBook> noteBookLinkedList = new LinkedList<NoteBook>();
	private JTextField txtNewNotebook;
	private JButton btnNewNoteBook;
	private JTextField txtNewNote;
	private JButton btnSDICalculator;
	private JTextField txtSdiCalculator;
   
	/**
	 *
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frmDashboard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setResizable(false);
		frmDashboard.getContentPane().setBackground(new Color(135, 206, 235));
		frmDashboard.setBackground(Color.WHITE);
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setBounds(100, 100, 450, 300);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frmDashboard.getContentPane().setLayout(null);
		

		//NEW BUTTON
		JButton btnNewNote = new JButton("New Note");
		btnNewNote.addActionListener(new ActionListener() {
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
		
		
		btnNewNote.setBounds(109, 6, 89, 65);
		frmDashboard.getContentPane().add(btnNewNote);
		
		JButton btnOption = new JButton("Option");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnOption.setBounds(354, 11, 70, 55);
		frmDashboard.getContentPane().add(btnOption);
		
		txtNewNotebook = new JTextField();
		txtNewNotebook.setEditable(false);
		txtNewNotebook.setBackground(new Color(135, 206, 235));
		txtNewNotebook.setText("New Notebook");
		txtNewNotebook.setBounds(10, 84, 89, 20);
		frmDashboard.getContentPane().add(txtNewNotebook);
		txtNewNotebook.setColumns(10);
		txtNewNotebook.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		btnNewNoteBook = new JButton("New NoteBook");
		btnNewNoteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
							
							NewNoteBook newNoteBook = new NewNoteBook();
							newNoteBook.setVisible(true);
							newNoteBook.setLocationRelativeTo(null);
						
						} catch(Exception g){
							JOptionPane.showMessageDialog(null, g);
						}
			}
		});
		btnNewNoteBook.setBounds(10, 6, 89, 65);
		frmDashboard.getContentPane().add(btnNewNoteBook);
		
		txtNewNote = new JTextField();
		txtNewNote.setEditable(false);
		txtNewNote.setBackground(new Color(135, 206, 235));
		txtNewNote.setText("New Note");
		txtNewNote.setBounds(109, 84, 89, 20);
		frmDashboard.getContentPane().add(txtNewNote);
		txtNewNote.setColumns(10);
		txtNewNote.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		btnSDICalculator = new JButton("SDI Calculator");
		btnSDICalculator.setBounds(10, 115, 89, 55);
		frmDashboard.getContentPane().add(btnSDICalculator);
		
		txtSdiCalculator = new JTextField();
		txtSdiCalculator.setBackground(new Color(135, 206, 235));
		txtSdiCalculator.setEditable(false);
		txtSdiCalculator.setText("SDI Calculator");
		txtSdiCalculator.setBounds(10, 181, 89, 20);
		frmDashboard.getContentPane().add(txtSdiCalculator);
		txtSdiCalculator.setColumns(10);
		txtSdiCalculator.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JCheckBox chckbxClassicLayout = new JCheckBox("Classic Layout");
		chckbxClassicLayout.setBounds(204, 11, 97, 23);
		frmDashboard.getContentPane().add(chckbxClassicLayout);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(204, 53, 97, 23);
		frmDashboard.getContentPane().add(btnLoad);
		
	}
}
