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

public class NewNote extends JFrame{

	private JPanel contentPane;
	
	//note attributes cannot be changed from outside
	// default color of note
	private Color color = new Color(102, 205, 170);
	private Point noteLocation;
	private String noteTitle;
	private String s;
	
	/**
	 * Launch the application.
	 */
	
	
	
	public static String contents;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewNote.class.getResource("/resources/iconmonkey_small.png")));
		setTitle("Note");
		//prompt to close frame
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit this note?", "Exit Program Message Box",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			    }
			  }
			});
		
		
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		JTextArea textArea = new JTextArea();
		
		//key listener and saves text to test1
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				/*
				 * 
				 * deprecated. using linked list to store location and text when key is pressed
				BufferedWriter writer;
				
				try{
					writer = new BufferedWriter( new FileWriter("test1.txt", false));
					textArea.write(writer);
					writer.close();
					//JOptionPane.showMessageDialog(null, "File has been saved", "File Saved", JOptionPane.INFORMATION_MESSAGE);
					//true for rewrite, false for override
				}catch (IOException e) {
		            JOptionPane.showMessageDialog(null, "Error Occured");
		            e.printStackTrace();
		        }   */
				
				s = textArea.getText();
				System.out.println(s);
			}
		});
		textArea.setBackground(color);
		contentPane.add(textArea);
		
		
		//read string from input notes. add to linked list.
		
		//Scroll Pane as needed
		JScrollPane scrollbar1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(scrollbar1, BorderLayout.CENTER);
		//word wrap
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		
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
	
	/*
	 * GETTERS able to get colors, location and title of notes for linked list
	 */
	
	public Color getNoteColor(){
		return this.color;
	}
	public Point getNoteLocation(){
		return this.noteLocation;
	}
	public String getNoteTitle(){
		return noteTitle;
	}
	public String getTextArea(){
		return s;
	}
	
	
}
