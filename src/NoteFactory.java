import javax.swing.DefaultListModel;
//////////////////////////////////////////////////////////////////////////
/*
 * THIS IS THE NOTEBOOK FACTORY CLASSES USED TO MAKE SINGLE INSTANCES OF NOTES
 * THIS CLASS WILL ITERATE THROUGH THE LIST MODEL 
 * AND CREATE ONLY A SINGLE INSTANCE OF EACH NOTE.
 */
//////////////////////////////////////////////////////////////////////////
public class NoteFactory {
	
	private static NewNote uniqueInstance1 = new NewNote();
	private static NewNote uniqueInstance2 = new NewNote();
	private static NewNote uniqueInstance3 = new NewNote();
	private static NewNote uniqueInstance4 = new NewNote();
	private static NewNote uniqueInstance5 = new NewNote();
	private static NewNote uniqueInstance6 = new NewNote();
	private static NewNote uniqueInstance7 = new NewNote();
	
	public NewNote makeNotes(int instanceIndex, DefaultListModel List, String noteText) {
		// iterate through List and create note instances

		if(instanceIndex == 0)
			return uniqueInstance1;
		else if(instanceIndex == 1) {
			return uniqueInstance2;
		}
		System.out.println("returning 3");
		return null;
	}
	
	
}
