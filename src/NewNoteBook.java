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
	
	//singleton instance
	private static NewNoteBook uniqueInstance;
	
	
	//static Vector<Note> vec = new Vector<Note>(4);
	
	private JPanel contentPane;
	private JTextField textFieldNoteTitle;
	
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
	private int noteIndex;
	
	private static int noteCounter;
	private JList pagesList;
	private JMenuItem mntmLoadClassicLayout;
	
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
	private NewNoteBook() {
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
		noteCounter++;

		noteCounter++;

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
		
		mntmLoadNotes = new JMenuItem("Load Modern Layout");
		
		
		mntmLoadNotes.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/notesmodern_24.png")));
		mnFile.add(mntmLoadNotes);
		
		mntmLoadClassicLayout = new JMenuItem("Load Classic Layout");
		
		//////////////////////////////////////////////////////////////////////////
		/*
		 * LOADING CLASSIC LAYOUT OF NOTES. USING SIZE OF VECTOR IN FOR LOOP CREATING 
		 * AND REMEMBER LOCATION OF NOTES
		 */
		//////////////////////////////////////////////////////////////////////////
		mntmLoadClassicLayout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int clayout = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to load the classic layout?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (clayout == JOptionPane.YES_OPTION) {
				      //JOptionPane.showMessageDialog(null, "classic layout clicked");
				    	System.out.println("This is the size of the notesLinkedList: " + notesLinkedList.getSize());
				    	for(int i = 0; i < notesLinkedList.getSize(); i++) {
				    		try{
								
				    			
								NewNote newNote = new NewNote();
								//newNote.setNoteLocation(notesLinkedList.getElementAt(i).getLocation());
								newNote.setLocation(notesLinkedList.getElementAt(i).getLocation());
								newNote.setVisible(true);
								//newNote.setLocationRelativeTo(null);
								
								
								newNote.setNoteTitle(notesLinkedList.getElementAt(i).getNoteTitle());
								newNote.setNoteDetailsClassic(notesLinkedList.getElementAt(i).getNoteDetails());
								//newNote.setLocation(notesLinkedList.getElementAt(i).getLocation());
							
								
					
							} catch(Exception c){
								JOptionPane.showMessageDialog(null, c);
							}
				    	}
				    }
			}
		});

		mntmLoadClassicLayout.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/note_24.png")));
		mnFile.add(mntmLoadClassicLayout);
		
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
		btnDeleteNote.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteNoteEvent();
			}
		});
		
		btnDeleteNote.setOpaque(false);
		btnDeleteNote.setContentAreaFilled(false);
		btnDeleteNote.setBorderPainted(false);
		//btnDeleteNote.setFocusPainted(false);
		btnDeleteNote.setIcon(new ImageIcon(NewNoteBook.class.getResource("/resources/trashicon_32.png")));
		
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
		textFieldNoteTitle = new JTextField();
		textFieldNoteTitle.setBackground(new Color(135, 206, 235));
		textFieldNoteTitle.setToolTipText("Enter Note Title");
		textFieldNoteTitle.setColumns(10);
		
		
		
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
						.addComponent(textFieldNoteTitle, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
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
						.addComponent(textFieldNoteTitle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
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
		
		pagesList = new JList();
						
		
		pagesScrollPane.setViewportView(pagesList);
		
		textAreaNote1 = new JTextArea();
		
		textAreaNote1.setLineWrap(true);
		textAreaNote1.setWrapStyleWord(true);
		textAreaNote1.setBackground(Color.YELLOW);
		textAreaNote1.setForeground(Color.BLACK);
		note_1ScrollPane.setViewportView(textAreaNote1);
		contentPane.setLayout(gl_contentPane);
		
		//textAreaNote1.setText(vec.get(0).getNoteDetails());
		textAreaNote1.setText(notesLinkedList.getElementAt(0).getNoteDetails());
		textFieldNoteTitle.setText(notesLinkedList.getElementAt(0).getNoteTitle());
		
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
		
		
		
		//////////////////////////////////////////////////////////////////////////
		/*
		 * Mouse Listener for J list Selection
		 */
		//////////////////////////////////////////////////////////////////////////
		pagesList.addMouseListener(new MouseAdapter() {
			@Override
			/*
			public void mouseClicked(MouseEvent e) {
				
			}*/
			public void mouseReleased(MouseEvent e) {
				noteIndex = pagesList.getSelectedIndex();
				//textAreaNote1.setText(vec.get(i).getNoteDetails());
				textAreaNote1.setText(notesLinkedList.getElementAt(noteIndex).getNoteDetails());
				textFieldNoteTitle.setText(notesLinkedList.getElementAt(noteIndex).getNoteTitle());
			}
		});
		//////////////////////////////////////////////////////////////////////////
		/*
		 * key listener for note title and text area notes
		 */
		//////////////////////////////////////////////////////////////////////////
		textFieldNoteTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noteIndex = pagesList.getSelectedIndex();
				notesLinkedList.getElementAt(noteIndex).setNoteTitle(textFieldNoteTitle.getText());
			}
		});
		textAreaNote1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				noteIndex = pagesList.getSelectedIndex();
				notesLinkedList.getElementAt(noteIndex).setNoteDetails(textAreaNote1.getText());
			}
		});
	}   
	//////////////////////////////////////////////////////////////////////////
	// END OF INITITALIZING COMPONENTS
	//////////////////////////////////////////////////////////////////////////
	

	
	
	//////////////////////////////////////////////////////////////////////////
	//
	// SPECIFIC EVENT HANDLING FOR THE 3 BUTTONS ON NOTEBOOK PAGE
	//
	// NEW & SETTINGS & DELETE
	//
	//////////////////////////////////////////////////////////////////////////
	private void createNewNoteEvent() {
		// TODO Auto-generated method stub
		noteCounter++;
		Note genericNote = new Note();
		genericNote.setNoteTitle("New page" + noteCounter);
		genericNote.setNoteDetails("This is new note details " + noteCounter);
		//vec.add(genericNote);
		notesLinkedList.addElement(genericNote);
		
		
	}
	private void deleteNoteEvent() {
		// TODO Auto-generated method stub
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "Are you sure you want to delete this page?", "Exit Program Message Box",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		    	//JOptionPane.showMessageDialog(null, "Deleting Note");
		    	//Code here to delete note
		    	noteCounter--;
		    	noteIndex = pagesList.getSelectedIndex();
		    	notesLinkedList.removeElementAt(noteIndex);
		    	
		    }
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
	public static void setNoteLocation(Point newNoteLocation, String selectedNoteTitle) {
		System.out.println("Searching vector for note title");
		for (int i=0; i < notesLinkedList.getSize(); i++) {
			if (selectedNoteTitle == notesLinkedList.getElementAt(i).getNoteTitle()) {
				System.out.println("MATCH");
				int newselectedindex = i;
				notesLinkedList.getElementAt(newselectedindex).setLocation(newNoteLocation);
				System.out.println("Location of Vector note: " + notesLinkedList.getElementAt(newselectedindex).getLocation());
			}
			// else if for two matching titles scenario
			//if no matching titles
			else{
				System.out.println("NO MATCH");
			}
		}
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
	
	
	//SINGLETON DESIGN PATTERN
	public static NewNoteBook getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new NewNoteBook();
		}
		return uniqueInstance;
	}
}


