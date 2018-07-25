import java.awt.Point;

//////////////////////////////////////////////////////////////////////////////////////
//
//  This class is a Note book object which we will store in a linked list in Dash board
//
//////////////////////////////////////////////////////////////////////////////////////

public class NoteBook extends Note{
	
	//////////////////////////////////////////////////////////////////////////
	//INSTANCE VARIABLES
	private Point noteBookLocation;
	private static String noteDetails;
	private static String noteTitle;
	private static String noteBookTitle;
	
	//////////////////////////////////////////////////////////////////////////
	Note note = new Note();
	//create Notes
	//////////////////////////////////////////////////////////////////////////
	// Constructors
	public NoteBook(){
		super();
		noteBookLocation = NewNoteBook.getNoteBookLocation();
		noteDetails = "";
		noteTitle = "Note Title";
		noteBookTitle = "NoteBook Title";
	}
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
	
	//setters
	public void setLocation(Point newLocation){
		this.noteBookLocation = newLocation;
	}
	public void setNoteDetails(String newString){
		this.noteDetails = newString;
	}
	
	//getters
	public Point getLocation(){
		return this.noteBookLocation;
	}
	public String getNoteDetails(){
		return noteDetails;
	}

}
	
	
