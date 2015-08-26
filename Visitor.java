/**
 * Rodney Villareal
 * CS 356 Project 2
 * Visitor interface to implement the sum methods
 * for the User Total, Group Total, Message Total
 * and positive percentage buttons for the visitor
 * pattern.
 */

public interface Visitor {
    public int getSum(User user);
    public int getSum(Group group);
    public int getSum(Messages message);
//    public int getSum(Positive message);
}
