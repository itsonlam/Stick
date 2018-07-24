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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class Dashboard extends Note {

	private JFrame frmDashboard;

	//linked list to store Note Object 
	private LinkedList<Note> notesLinkedList = new LinkedList<Note>();
	private LinkedList<NoteBook> noteBookLinkedList = new LinkedList<NoteBook>();
	private JButton btnNewNoteBook;
	private JButton btnSDICalculator;
	private final ButtonGroup btgLayout = new ButtonGroup();
   
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
		initComponents();

	}
	
	public void initComponents(){
		frmDashboard = new JFrame();
		frmDashboard.setResizable(false);
		frmDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/resources/iconmonkey_small.png")));
		frmDashboard.getContentPane().setBackground(new Color(135, 206, 235));
		frmDashboard.setBackground(Color.WHITE);
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setBounds(100, 100, 402, 329);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		//NEW BUTTON
		JButton btnNewNote = new JButton("");
		btnNewNote.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/stickyicon_64.png")));
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
		
		JButton btnOption = new JButton("");
		btnOption.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/optionsicon_32.png")));
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		btnNewNoteBook = new JButton("");
		btnNewNoteBook.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/notepadicon_64.png")));
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
		
		btnSDICalculator = new JButton("");
		btnSDICalculator.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/calculatoricon_64.png")));
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rdbtnModernLayout = new JRadioButton("Modern Layout");
		btgLayout.add(rdbtnModernLayout);
		rdbtnModernLayout.setBackground(new Color(135, 206, 235));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Classic Layout");
		btgLayout.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBackground(new Color(135, 206, 235));
		
		JLabel lblNewNoteBook = new JLabel("New Notebook");
		
		JLabel lblNewNote = new JLabel("New Note");
		
		JLabel lblSdiCalculator = new JLabel("SDI Calculator");
		
		JButton btnHelp = new JButton("");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Version: 1.12\nCreated by: An Lam & Dobien Cortez");
			}
		});
		btnHelp.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/helpicon_32.png")));
		GroupLayout groupLayout = new GroupLayout(frmDashboard.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSdiCalculator))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSDICalculator, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(btnNewNoteBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewNoteBook)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewNote)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtnModernLayout, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnOption, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewNote, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))))
					.addGap(14))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(348, Short.MAX_VALUE)
					.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnOption)
									.addGap(215))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnNewNote, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnNewNoteBook, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewNoteBook, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewNote)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(rdbtnNewRadioButton)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnModernLayout)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnLoad)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSDICalculator, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblSdiCalculator)
									.addGap(24)))
							.addGap(33))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		frmDashboard.getContentPane().setLayout(groupLayout);
	}
}
