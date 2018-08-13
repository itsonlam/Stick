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
import java.awt.Component;

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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

//////////////////////////////////////////////////////////////////////////
//
// 	This is the new note class. When in classic notes mode, users can 
//	use this to create new notes. Notes will be stored in a linked list
// 	and load upon restart of dash board.
//
////////////////////////////////////////////////////////////////////////////

public class NewNote extends JFrame{
	
	
	private static NewNote uniqueNoteInstance;
	//note attributes cannot be changed from outside
	// default color of note
	private Color color = new Color(102, 205, 170);
	private static Point noteLocation;
	private String noteTitle;
	private String classicNoteDetails;
	private int noteNumber;
	/**
	 * Launch the application.
	 */
	public static String contents;
	private JTextArea textAreaNote;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewNote frame = new NewNote();
					//frame.setLocation(1960,168);
					frame.setLocation(getNoteLocation());
					//frame.setLocation(notesLinkedList.getLocation());
					//frame.setNoteLocation(noteLocation);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		}
	
	
	/**
	 * Create the frame.
	 */
	public NewNote() {
		
		initComponents();
		
		//////////////////////////////////////////////////////////////////////////
		/*
		 * COMPONENT LISTENER. WILL STORE NEW LOCATION OF COMPONENT TO REOPEN UPON
		 * LOADING. 
		 */
		//////////////////////////////////////////////////////////////////////////
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				noteLocation = textAreaNote.getLocationOnScreen();
				System.out.println(noteTitle);
				NewNoteBook.setNoteLocation(noteLocation, noteTitle);
				System.out.println("component moved to location: " + textAreaNote.getLocationOnScreen());
			}
		});
	}
	
	private void initComponents() {
		//setLocation(1939,274);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewNote.class.getResource("/resources/iconmonkey_small.png")));
		setTitle("this is the top title");
		//prompt to close frame
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to close this note?", "Exit Program Message Box",
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
		textAreaNote.setBackground(new Color(135, 206, 235));
		textAreaNote.setWrapStyleWord(true);
		textAreaNote.setLineWrap(true);
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
		setTitle(newTitle);
		this.noteTitle = newTitle;
	}
	public void setNoteDetailsClassic(String noteDetails) {
		classicNoteDetails = noteDetails;
		textAreaNote.setText(noteDetails);
	}
	public void setNoteLocation(Point passNoteLocation) {
		setLocation(passNoteLocation);
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
	public String getNoteTitle(){
		return noteTitle;
	}
	public int getNoteNumber(){
		return noteNumber;
	}
	
	public static NewNote getNoteInstance() {
		if (uniqueNoteInstance == null) {
			uniqueNoteInstance = new NewNote();
		}
		return uniqueNoteInstance;
	}
}
