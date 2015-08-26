/**
 * Rodney Villareal
 * CS 356 Project 2
 * UserView class that creates the user interface
 * for each twitter user.  Was not fully implemented.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserView implements ActionListener{
	private JFrame jfrm;
	private User user;
	
	UserView(User user) {
		this.user = user;
		
		jfrm = new JFrame(this.user.getId() + "'s Mini Twitter");
		jfrm.setSize(400, 350);
		jfrm.setLayout(new GridLayout(2, 1));
		jfrm.setLocationRelativeTo(null);
		jfrm.setResizable(true);
		
		JPanel jpn = new JPanel();
		jpn.setLayout(new FlowLayout());
		jfrm.add(jpn);
		
		JTextField userId = new JTextField(15);
			userId.addActionListener(this);
		JButton jbtn1 = new JButton("Follow User");
			jbtn1.addActionListener(this);
		JPanel jpn1 = new JPanel();
			jpn1.setLayout(new BorderLayout());
			JTextArea follows = new JTextArea();
			follows.setEditable(false);
			follows.setColumns(25);
			follows.setRows(6);
			follows.setVisible(true);
	        JScrollPane jScrollPane = new JScrollPane(follows);
	        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jpn1.add(jScrollPane);
		jpn.add(userId);
		jpn.add(jbtn1);
		jpn.add(jpn1);
		
		JPanel jpn2 = new JPanel();
		jpn2.setLayout(new FlowLayout());
		jfrm.add(jpn2);
		
		JTextField message = new JTextField(15);
			message.addActionListener(this);
		JButton jbtn2 = new JButton("Post Tweet");
			jbtn2.addActionListener(this);
		JPanel jpn3 = new JPanel();
			jpn3.setLayout(new BorderLayout());
			JTextArea newsFeed = new JTextArea();
			newsFeed.setEditable(false);
			newsFeed.setColumns(25);
			newsFeed.setRows(6);
			newsFeed.setVisible(true);
	        JScrollPane jScrollPane2 = new JScrollPane(newsFeed);
	        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jpn3.add(jScrollPane2);
		jpn2.add(message);
		jpn2.add(jbtn2);
		jpn2.add(jpn3);
		
		jfrm.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Follow User")) {
			
		}
		if(ae.getActionCommand().equals("Post Tweet")) {
			
		}
	}
}
