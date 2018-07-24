import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class NewNoteBook extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNoteBookTitle;

	//private variables
	private Color bgColor = new Color(135, 206, 235); //default background color
	private Color noteColor = new Color(255, 255, 224); //default note color
	private int pages;
	private Point noteBookLocation;
	private String noteBookTitle;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewNoteBook frame = new NewNoteBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewNoteBook() {
		setTitle("Notebook");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//prompts the user if they want to close the note book
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Are you sure you want to exit this Notebook?", "Exit Program Message Box",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			      dispose();
			    }
			  }
			});
		
		setBounds(100, 100, 460, 600);
		contentPane = new JPanel();
		contentPane.setBackground(bgColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnDeleteNote = new JButton("Delete Note");
		btnDeleteNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPreferences = new JButton("Preferences");
		
		JButton btnNewNote = new JButton("New Note");
		textFieldNoteBookTitle = new JTextField();
		textFieldNoteBookTitle.setBackground(new Color(135, 206, 235));
		textFieldNoteBookTitle.setToolTipText("Enter Notebook Title");
		textFieldNoteBookTitle.setColumns(10);
		
		JTextArea textAreaNotes = new JTextArea();
		textAreaNotes.setBackground(noteColor);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textAreaNotes, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
						.addComponent(textFieldNoteBookTitle, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewNote, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPreferences, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteNote, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldNoteBookTitle, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewNote, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPreferences, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteNote, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addComponent(textAreaNotes, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	/*
	 * Setters for note book
	 */
	public void setBGColor(Color newBGColor){
		this.bgColor = newBGColor;
	}
	public void setNoteColor(Color newNoteColor){
		this.noteColor = newNoteColor;
	}
	public void setNoteBookLocation(Point newLocation){
		this.noteBookLocation = newLocation;
	}
	public void setNoteBookTitle(String newNoteBookTitle){
		this.noteBookTitle = newNoteBookTitle;
	}
	
	/*
	 * Getters for note book used for linked list
	 */
	public Color getBGColor(){
		return this.bgColor;
	}
	public Color getNoteColor(){
		return this.noteColor;
	}
	public Point getNoteBookLocation(){
		return this.noteBookLocation;
	}
	public String getNoteBookTitle(){
		return this.noteBookTitle;
	}
	
}
