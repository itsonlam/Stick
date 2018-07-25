import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Window;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

//////////////////////////////////////////////////////////////////////////
//
// 	This is the new note class. When in classic notes mode, users can 
//	use this to create new notes. Notes will be stored in a linked list
// 	and load upon restart of dash board.
//
////////////////////////////////////////////////////////////////////////////

public class NewNote extends JFrame{
	
	//note attributes cannot be changed from outside
	// default color of note
	private Color color = new Color(102, 205, 170);
	private static Point noteLocation;
	private static String noteTitle;
	private static String s;
	private static int noteNumber;
	/**
	 * Launch the application.
	 */
	public static String contents;
	private JTextArea textAreaNote;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewNote frame = new NewNote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//creating linked list for contents of all Notes
		/*
		LinkedList<String> linked list = new LinkedList<String>();
		linkedlist.add(NewNote.contents);
		System.out.println(linkedlist.toString());
		*/ //DEPRACATED. testing file reader and writer
		}
	
	
	/**
	 * Create the frame.
	 */
	public NewNote() {
		initComponents();
	}
	
	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewNote.class.getResource("/resources/iconmonkey_small.png")));
		setTitle("Note");
		//prompt to close frame
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to delete this note?", "Exit Program Message Box",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			    }
			  }
			});

		setBounds(100, 100, 331, 291);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 90, 679, 375);
		getContentPane().add(scrollPane);
		
		textAreaNote = new JTextArea();
		textAreaNote.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				//implement method to save to linked list
				Dashboard.setTestObject(textAreaNote.getText());
				System.out.println(noteNumber);
				//Dashboard.testHashMap();
				//implement a way to update the linked list rather than adding new node
			}
		});
		textAreaNote.setBackground(new Color(135, 206, 235));
		textAreaNote.setWrapStyleWord(true);
		textAreaNote.setWrapStyleWord(true);
		scrollPane.setViewportView(textAreaNote);
	}


	/*SETTERS
	*
	**
	able to change color from outside this class */
	
	public void setColor(Color newColor){
		this.color = newColor;
	}
	//set location used when reload of notes
	public void setLocation(Point newlocation){
		this.noteLocation = newlocation;
	}
	public void setNoteTitle(String newTitle){
		//this.noteTitle = newTitle;
		//cannot change note title from outside
	}
	public static void setNoteNumber(int number){
		noteNumber = number;
	}
	
	/*
	 * GETTERS able to get colors, location and title of notes for linked list
	 */
	
	public Color getNoteColor(){
		return this.color;
	}
	public static Point getNoteLocation(){
		return noteLocation;
	}
	public static String getNoteTitle(){
		return noteTitle;
	}
	public static String getTextArea(){
		return s;
	}
	public static int getNoteNumber(){
		return noteNumber;
	}
	
}
