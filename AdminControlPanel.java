/**
 * Rodney Villareal
 * CS 356 Project 2
 * AdminControlPanel class that creates the admin control
 * panel user interface.  Also implements the singleton
 * pattern. Was not able to fully implement.
 */

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AdminControlPanel implements ActionListener {
	private static AdminControlPanel instance = null;
	private JFrame jfrm;
	private JTextField userIdText;
	private JTextField groupIdText;
	private JTree jtree;
	private DefaultMutableTreeNode jroot;
	private Group root = new Group("root");
	private List<Component> users = new ArrayList<Component>();
	private List<Component> groups = new ArrayList<Component>();

	private AdminControlPanel() {
		jfrm = new JFrame("Mini Twitter - Admin Control Panel");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(500, 350);
		jfrm.setLayout(new GridLayout(1, 2));
		jfrm.setLocationRelativeTo(null);
		jfrm.setResizable(false);
		
		root.setId("root");
		
		JPanel jpnLeft = new JPanel();
		jpnLeft.setLayout(new BorderLayout());
			jroot = new DefaultMutableTreeNode(root.getId()); 
			jtree = new JTree(jroot);
			JScrollPane jScrollPane = new JScrollPane(jtree);
			jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jpnLeft.add(jScrollPane);
		jfrm.add(jpnLeft);
		
		JPanel jpnRight = new JPanel();
		jpnRight.setLayout(new GridLayout(2,1));
		jfrm.add(jpnRight);
		
		JPanel jpnTop = new JPanel();
		jpnTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		jpnRight.add(jpnTop);		
		userIdText = new JTextField(10);
			userIdText.setEditable(true);
			userIdText.addActionListener(this);
		JButton jbtn1 = new JButton("Add User");
			jbtn1.setPreferredSize(new Dimension(105, 30));
			jbtn1.addActionListener(this);
		groupIdText = new JTextField(10);
			groupIdText.setEditable(true);
			groupIdText.addActionListener(this);
		JButton jbtn2 = new JButton("Add Group");
			jbtn2.setPreferredSize(new Dimension(105, 30));
			jbtn2.addActionListener(this);
		JButton jbtn3 = new JButton("Open User View");
			jbtn3.setPreferredSize(new Dimension(215, 30));
			jbtn3.addActionListener(this);
		jpnTop.add(userIdText);
		jpnTop.add(jbtn1);
		jpnTop.add(groupIdText);
		jpnTop.add(jbtn2);
		jpnTop.add(jbtn3);
		
		JPanel jpnBottom = new JPanel();
		jpnBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		jpnRight.add(jpnBottom);
		JButton jbtn4 = new JButton("User Total");
			jbtn4.setPreferredSize(new Dimension(105, 30));
			jbtn4.addActionListener(this);
		JButton jbtn5 = new JButton("Group Total");
			jbtn5.setPreferredSize(new Dimension(105, 30));
			jbtn5.addActionListener(this);
		JButton jbtn6 = new JButton("Message Total");
			jbtn6.setPreferredSize(new Dimension(105, 30));
			jbtn6.addActionListener(this);
		JButton jbtn7 = new JButton("Positive %");
			jbtn7.setPreferredSize(new Dimension(105, 30));
			jbtn7.addActionListener(this);
		jpnBottom.add(jbtn4);
		jpnBottom.add(jbtn5);
		jpnBottom.add(jbtn6);
		jpnBottom.add(jbtn7);

		jfrm.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Visitor visitor = new Statistic();
		if(ae.getActionCommand().contains("Add User")) {
			DefaultTreeModel model = (DefaultTreeModel)jtree.getModel();
			jroot = (DefaultMutableTreeNode)model.getRoot();
			jroot.add(new DefaultMutableTreeNode(userIdText.getText()));
			model.reload(jroot);
			userIdText.setText("");
			
			Component aUser = new User(userIdText.getText());
			aUser.setId(userIdText.getText());
			users.add(aUser);
			root.add(aUser);
		}
		if(ae.getActionCommand().contains("Add Group")) {
			DefaultTreeModel model = (DefaultTreeModel)jtree.getModel();
			jroot = (DefaultMutableTreeNode)model.getRoot();
			DefaultMutableTreeNode temp = new DefaultMutableTreeNode(groupIdText.getText());
			jroot.add(temp);
			temp.add(new DefaultMutableTreeNode("sample"));
			model.reload(jroot);
			groupIdText.setText("");
			
			Component aGroup = new Group(groupIdText.getText());
			groups.add(aGroup);
			root.add(aGroup);
		}  
		if(ae.getActionCommand().contains("Open User View")) {
			new UserView(new User("Rodney"));
		}
		if(ae.getActionCommand().contains("User Total"))
			JOptionPane.showMessageDialog(jfrm,
										"User total: " + visitor.getSum(new User()),
										"User Total",
										JOptionPane.INFORMATION_MESSAGE);
		if(ae.getActionCommand().contains("Group Total"))
			JOptionPane.showMessageDialog(jfrm,
										"Group total: " + visitor.getSum(new Group()),
										"Group Total",
										JOptionPane.INFORMATION_MESSAGE);
		if(ae.getActionCommand().contains("Message Total"))
			JOptionPane.showMessageDialog(jfrm,
										"Message total: " + visitor.getSum(new Messages()),
										"Message Total",
										JOptionPane.INFORMATION_MESSAGE);
		if(ae.getActionCommand().contains("Positive %"))
			JOptionPane.showMessageDialog(jfrm,
										"Positive percentage: ",
										"Positive Percentage",
										JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static AdminControlPanel getInstance() {
		if(instance == null)
			instance = new AdminControlPanel();
		return instance;
	}
}
