/**
 * Rodney Villareal
 * CS 356 Project 2
 * Component interface for the composite
 * pattern. User class implements this.
 */

public interface Component{
	public void setId(String id);
	public String getId();
	public void add(Component component);
}
