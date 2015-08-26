/**
 * Rodney Villareal
 * CS 356 Project 2
 * Message class to keep message total and to
 * differentiate which method in the statistic class.
 */

public class Messages {
	private static int messageTotal = 0;
	public static void setMessageTotal(int total) {
		messageTotal = total;
	}
	public int getMessageTotal() {
		return messageTotal;
	}
}
