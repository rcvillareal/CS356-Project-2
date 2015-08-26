/**
 * Rodney Villareal
 * CS 356 Project 2
 * Observable interface for the observer pattern
 * with attach and notify methods. User class
 * implements this.
 */

public interface Observable {
	public void attach(Component observer);
	public void notify(Component observer);
}
