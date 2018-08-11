import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

//////////////////////////////////////////////////////////////////////////
//
// 	This is the notebook class. it opens up the user's notebook and 
// 	displays the user's notebook title and list of notes. 
// 	users can easily switch from this layout to the classic lay out of notes
//
//////////////////////////////////////////////////////////////////////////


public class NewNoteBook extends JFrame {

	private static DefaultListModel<Note> notesLinkedList = new DefaultListModel<Note>();
	
	static Vector<Note> vec = new Vector<Note>(4);
	
	private JPanel contentPane;
	private JTextField textFieldNoteBookTitle;
	
	//private variables
	private Color bgColor = new Color(135, 206, 235); //default background color
	private Color noteColor = new Color(255, 255, 224); //default note color
	private int pages;
	private static Point noteBookLocation;
	private String noteBookTitle;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	private JMenuItem mntmQuit;
	private static JList noteList;
	private JMenuItem mntmLoadNotes;
	private JScrollPane pagesScrollPane;
	private JTextArea textAreaNote1;
	
	private static int noteCounter;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewNoteBook.class.getResource("/resources/iconmonkey_small.png")));		
		initComponents();
		createEvents();
	}
	
	/*	//////////////////////////////////////////////////////////////////////////
	 * TESTING LINKED LIST WILL NOT USE IN FINAL VERSION
	 */	//////////////////////////////////////////////////////////////////////////
	private static void initNoteModel(){
		notesLinkedList.addElement(new Note("Page title 1", "This is the first note"));
		notesLinkedList.addElement(new Note("Page title 2", "This is the second note"));
		
		Note thisIsNote1 = new Note(); 
		noteCounter++;
		Note thisIsNote2 = new Note();
		noteCounter++;
		
		thisIsNote1.setNoteDetails("This is details for note1");
		thisIsNote1.setNoteTitle("This is the first note");
		
		thisIsNote2.setNoteDetails("This is details for note2");
		thisIsNote2.setNoteTitle("This is the second note");
		
		vec.add(thisIsNote1);
		vec.add(thisIsNote2);
		//vec.add(new Note("Page title 1", "This is the first note"));
		//vec.add(new Note("Page title 2", "This is the second note"));
	}
	
	/*	//////////////////////////////////////////////////////////////////////////
	 * Events Here WILL CLEAN UP CODE FOR ALL EVENT AND LISTENERS HERE
	 */	//////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		mntmLoadNotes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println(notesLinkedList.toString());
				System.out.println("TEST");
				System.out.println("test in events");
			}
		});
	}
	
	//////////////////////////////////////////////////////////////////////////
	/*
	 * initializing components
	 */
	//////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		
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
		
		setBounds(100, 100, 573, 622);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmLoadNotes = new JMenuItem("Load Notes");
		
		
		mntmLoadNotes.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/replay_24.png")));
		mnFile.add(mntmLoadNotes);
		
		mntmQuit = new JMenuItem("Close");
		mntmQuit.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/closeicon_24.png")));
		mnFile.add(mntmQuit);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBackground(bgColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnDeleteNote = new JButton("");
		btnDeleteNote.setOpaque(false);
		btnDeleteNote.setContentAreaFilled(false);
		btnDeleteNote.setBorderPainted(false);
		//btnDeleteNote.setFocusPainted(false);
		btnDeleteNote.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/trashicon_32.png")));
		btnDeleteNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPreferences = new JButton("");
		btnPreferences.setOpaque(false);
		btnPreferences.setContentAreaFilled(false);
		btnPreferences.setBorderPainted(false);
		//btnPreferences.setFocusPainted(false);
		btnPreferences.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/optionsicon_32.png")));
		
		JButton btnNewNote = new JButton("");
		btnNewNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createNewNoteEvent();
			}

			
		});
		
		btnNewNote.setOpaque(false);
		btnNewNote.setContentAreaFilled(false);
		btnNewNote.setBorderPainted(false);
		//btnNewNote.setFocusPainted(false);
		btnNewNote.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/newnoteeicon_32.png")));
		textFieldNoteBookTitle = new JTextField();
		textFieldNoteBookTitle.setText("Notebook Title 1");
		textFieldNoteBookTitle.setBackground(new Color(135, 206, 235));
		textFieldNoteBookTitle.setToolTipText("Enter Notebook Title");
		textFieldNoteBookTitle.setColumns(10);
		
		
		initNoteModel();
		
		
		//////////////////////////////////////////////////////////////////////////
		/*
		 * GROUPED LAYOUT. DO NOT EDIT
		 */
		//////////////////////////////////////////////////////////////////////////
		pagesScrollPane = new JScrollPane();
		
		JScrollPane note_1ScrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(note_1ScrollPane, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(textFieldNoteBookTitle, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewNote, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPreferences, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteNote, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addComponent(pagesScrollPane, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldNoteBookTitle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnDeleteNote, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnPreferences, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewNote, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(note_1ScrollPane)
						.addComponent(pagesScrollPane, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
					.addGap(20))
		);
		
		JList pagesList = new JList();

		pagesList.addMouseListener(new MouseAdapter() {
			@Override
			/*
			public void mouseClicked(MouseEvent e) {
				
			}*/
			public void mouseReleased(MouseEvent e) {
				int i = pagesList.getSelectedIndex();
				textAreaNote1.setText(vec.get(i).getNoteDetails());
			}
		});
		
		pagesScrollPane.setViewportView(pagesList);
		
		textAreaNote1 = new JTextArea();
		textAreaNote1.setLineWrap(true);
		textAreaNote1.setWrapStyleWord(true);
		textAreaNote1.setBackground(Color.YELLOW);
		textAreaNote1.setForeground(Color.BLACK);
		note_1ScrollPane.setViewportView(textAreaNote1);
		contentPane.setLayout(gl_contentPane);
		
		textAreaNote1.setText(vec.get(0).getNoteDetails());
		
		/*
		 * adding linked list of notes to note list model
		 */
		pagesList.setModel(notesLinkedList);
		/*
		 * Render to display certain text only in list model in Note book
		 */
		pagesList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Note) {
                    ((JLabel) renderer).setText(((Note) value).getNoteTitle());
                }
                return renderer;
            }
        });
	}   
	//////////////////////////////////////////////////////////////////////////
	// END OF INITITALIZING COMPONENTS
	//////////////////////////////////////////////////////////////////////////
	

	
	private void createNewNoteEvent() {
		// TODO Auto-generated method stub
		noteCounter++;
		Note genericNote = new Note();
		genericNote.setNoteTitle("This is a new note Title" + noteCounter);
		genericNote.setNoteDetails("This is new note details" + noteCounter);
		vec.add(genericNote);
		
		
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	//SETTERS AND GETTERS BELOW
	//////////////////////////////////////////////////////////////////////////
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
	public static Point getNoteBookLocation(){
		return noteBookLocation;
	}
	public String getNoteBookTitle(){
		return this.noteBookTitle;
	}
}
