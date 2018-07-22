import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class NewNote extends JFrame {

	private JPanel contentPane;

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
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add(NewNote.contents);
		System.out.println(linkedlist.toString());
		*/ //DEPRACATED. testing file reader and writer
		
		
		}
	

	/**
	 * Create the frame.
	 */
	public NewNote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//JPanel panel = new JPanel();
		//panel.setLayout(new BorderLayout());  //give your JPanel a BorderLayout
		JTextArea textArea = new JTextArea();
		
		//JScrollPane scroll = new JScrollPane(textArea);
		//panel.add(scroll, BorderLayout.CENTER);
		
		//Key listener to save text to linked list or file
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				//JOptionPane.showMessageDialog(textArea, "stuff was typed");
				contents = textArea.getText();
				//System.out.print(contents);
			/*	try {
					File file = new File("test1.txt");
					FileWriter fileWriter = new FileWriter(file);
					PrintWriter printWriter = new PrintWriter(fileWriter);
					printWriter.print(contents);
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}    */
			}
		});
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textArea.setBackground(new Color(102, 205, 170));
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		//read string from input notes. add to linked list.
		
	}
}
