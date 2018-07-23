import java.awt.Point;

//this class is a Note object which we will store in a linked list in Fram1

public class Note extends NewNote{
	//for the location of the current note
	private static Point location;
	//String of text from new note
	private static String noteDetails;
	

	
	public static void main(String[] args) {
		NewNote notes = new NewNote();
		noteDetails = notes.s;
		location = notes.getContentPane().getLocationOnScreen();
		
		
	}
	
	//setters
	public void setLocation(Point newLocation){
		this.location = newLocation;
	}
	public void setNoteDetails(String newString){
		this.noteDetails = newString;
	}
	
	//getters
	public Point getLocation(){
		return this.location;
	}
	public String getNoteDetails(){
		return noteDetails;
	}

}
	
	
