import java.awt.Point;

////////////////////////////////////////////////////////////////////////////////////
//
//    This class is a Note object which we will store in a linked list in Dash board
//
///////////////////////////////////////////////////////////////////////////////////

public class Note{
	
	private static Note uniqueInstance;
	//////////////////////////////////////////////////////////////////////////
	//INSTANCE VARIABLES
	private Point location;
	private String noteDetails;
	private String noteTitle;
	private String instanceName;
	private boolean instanceCreated = false;
	//////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////
	//CONSTRUCTORS
	public Note(){
		super();
	//	location = NewNote.getNoteLocation();
	//	noteDetails = NewNote.getTextArea();
		//noteTitle = NewNote.getNoteTitle();
	}
	public Note(String newNoteTitle, String newNoteDetails){
		noteTitle = newNoteTitle;
		noteDetails = newNoteDetails;
		//location = newLocation;
	}
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	 
	
	//setters
	public void setLocation(Point newLocation){
		this.location = newLocation;
	}
	public void setNoteDetails(String newString){
		this.noteDetails = newString;
	}
	public void setNoteTitle(String newTitle) {
		this.noteTitle = newTitle;
	}
	public void setInstanceName(String newInstanceName) {
		this.instanceName = newInstanceName;
	}
	public void setBooleanTrue() {
		instanceCreated = true;
	}
	public void setBooleanFalse() {
		instanceCreated = false;
	}
	
	//getters
	public Point getLocation(){
		return this.location;
	}
	public String getNoteDetails(){
		return noteDetails;
	}
	public String getNoteTitle(){
		return noteTitle;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public boolean getBoolean() {
		return instanceCreated;
	}

	
	

	
}
	
	
