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

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Helpers.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

//////////////////////////////////////////////////////////////////////////
//
// 	This is the Dash board class. this is the main class of the program.
//
//////////////////////////////////////////////////////////////////////////
public class Dashboard extends Note {

	private JFrame frmDashboard;

	Random rand = new Random();
	
	//linked list to store Note Object 
	private static DefaultListModel<Note> notesLinkedList = new DefaultListModel<Note>();
	private static LinkedList<NoteBook> noteBookLinkedList = new LinkedList<NoteBook>();
	
	//testing linked list implementation
	private static LinkedList<String> test = new LinkedList<String>();
	
	
	private JButton btnNewNoteBook;
	private JButton btnSDICalculator;
	private final ButtonGroup btgCopyStyle = new ButtonGroup();
	private JMenu mnFile;
	private JMenuItem mntmClose;
	private JMenu mnOptions;
	private JMenu mnHelp;
	private JButton btnNewNote;
	private JButton btnModernLayout;
	private JMenuItem mntmLoadNotes;
	private JMenuItem mntmLoadClassicLayout;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmAbout;
    private static JList noteListView;
    private JMenu mnCopyTools;
    private JRadioButtonMenuItem rdbtnmntmOneclickCopy;
    private JRadioButtonMenuItem rdbtnmntmOnhoverCopy;
    private final ButtonGroup buttonGroup = new ButtonGroup();

	private JButton mbNewButton;
   
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
		createEvents();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initComponents();
	}
	
	
	//called from the new Note class to add note object to linked list
	public static void addTestObject(){
		test.add(0, "");
		System.out.println(test.toString());
	}
	
	public static void setTestObject(String note){
		test.set(0,note);
		System.out.println(test.toString());
	}

	
	private void createEvents() {
		/*
		 * action listener for new note button
		 */
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
		
		/*
		 * action listener for new note book button
		 * 
		 */
		btnNewNoteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
							/*NewNoteBook newNoteBook = new NewNoteBook();
							newNoteBook.setVisible(true);
							newNoteBook.setLocationRelativeTo(null);*/
					NewNoteBook.getInstance().setVisible(true);
						
						} catch(Exception g){
							JOptionPane.showMessageDialog(null, g);
						}
			}
		});


		
	} //END create events
	
	/*
	 * Initialize components method for UI
	 */
	public void initComponents(){
		frmDashboard = new JFrame();
		frmDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/resources/iconmonkey_small.png")));
		frmDashboard.getContentPane().setBackground(new Color(135, 206, 235));
		frmDashboard.setBackground(Color.WHITE);
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setBounds(100, 100, 402, 329);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//NEW BUTTON
		btnNewNote = new JButton("");
		btnNewNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int randInt = rand.nextInt(3);
				NewNote.setNoteNumber(randInt);
				addTestObject();
			}
		});
		
		btnNewNote.setOpaque(false);
		btnNewNote.setContentAreaFilled(false);
		btnNewNote.setBorderPainted(false);
		//btnNewNote.setFocusPainted(false);
		btnNewNote.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/stickyicon_64.png")));
		
		
		JButton btnOption = new JButton("");
		btnOption.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/optionsicon_32.png")));
		btnOption.setOpaque(false);
		btnOption.setContentAreaFilled(false);
		btnOption.setBorderPainted(false);
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		btnNewNoteBook = new JButton("");
		btnNewNoteBook.setOpaque(false);
		btnNewNoteBook.setContentAreaFilled(false);
		btnNewNoteBook.setBorderPainted(false);
		//btnNewNoteBook.setFocusPainted(false);
		btnNewNoteBook.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/notepadicon_64.png")));

		
		btnSDICalculator = new JButton("");
		btnSDICalculator.setOpaque(false);
		btnSDICalculator.setContentAreaFilled(false);
		btnSDICalculator.setBorderPainted(false);
		//btnSDICalculator.setFocusPainted(false);
		btnSDICalculator.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/calculatoricon_64.png")));
		
		JLabel lblNewNoteBook = new JLabel("New Notebook");
		
		JLabel lblNewNote = new JLabel("New Note");
		
		JLabel lblSdiCalculator = new JLabel("SDI Calculator");
		
		btnModernLayout = new JButton("");
		btnModernLayout.setOpaque(false);
		btnModernLayout.setContentAreaFilled(false);
		btnModernLayout.setBorderPainted(false);
		btnModernLayout.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/modernicon_32.png")));
		
		
		
		
		/*
		 * START GROUP LAYOUT
		 */
		GroupLayout groupLayout = new GroupLayout(frmDashboard.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewNoteBook, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnSDICalculator, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewNoteBook)
								.addComponent(lblSdiCalculator))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewNote))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewNote, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModernLayout, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
					.addComponent(btnOption, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnOption)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewNoteBook)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewNoteBook, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewNote)))
								.addComponent(btnNewNote)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(47)
									.addComponent(btnModernLayout)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSDICalculator, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSdiCalculator)
					.addGap(44))
		);
		frmDashboard.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmDashboard.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmLoadNotes = new JMenuItem("Load Notes");
		mntmLoadNotes.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/replay_24.png")));
		mnFile.add(mntmLoadNotes);
		
		mntmClose = new JMenuItem("Close");
		mntmClose.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/closeicon_24.png")));
		mnFile.add(mntmClose);
		
		mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		mntmLoadClassicLayout = new JMenuItem("Load Classic Layout");
		mntmLoadClassicLayout.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/replay_24.png")));
		mnOptions.add(mntmLoadClassicLayout);
		
		mntmNewMenuItem_1 = new JMenuItem("Load Modern Layout");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/notesmodern_24.png")));
		mnOptions.add(mntmNewMenuItem_1);
		
		mnCopyTools = new JMenu("Copy Tools");
		mnCopyTools.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/copy_24.png")));
		mnOptions.add(mnCopyTools);
		
		rdbtnmntmOneclickCopy = new JRadioButtonMenuItem("One-Click Copy");
		buttonGroup.add(rdbtnmntmOneclickCopy);
		rdbtnmntmOneclickCopy.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/mouseclick_24.png")));
		mnCopyTools.add(rdbtnmntmOneclickCopy);
		
		rdbtnmntmOnhoverCopy = new JRadioButtonMenuItem("On-Hover Copy");
		buttonGroup.add(rdbtnmntmOnhoverCopy);
		rdbtnmntmOnhoverCopy.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/lightning_24.png")));
		mnCopyTools.add(rdbtnmntmOnhoverCopy);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(Dashboard.class.getResource("/resources/help_24.png")));
		mnHelp.add(mntmAbout);
	} //end initialize components
}
