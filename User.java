/**
 * Rodney Villareal
 * CS 356 Project 2
 * User class that implements Component for the composite
 * pattern, Observer and Observable for the observer pattern.
 * This is the main class for each twitter user.
 */

import java.util.*;

public class User implements Component, Observer, Observable {
	private static int userTotal = 0;
	private static int messageTotal = 0;
	private String id;
	private List<Component> followers = new ArrayList<Component>();
	private List<Component> followings = new ArrayList<Component>();
	private List<String> newsFeed = new ArrayList<String>();
	
	public User(){}
	public User(String id) {
		this.id = id;
		userTotal++;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void add(Component component) {
		attach(component);
	}
	@Override
	public void attach(Component observer) {
		if(followers.contains(observer)) {
		} else {
			followers.add(observer);
		}
		notify(observer);
	}
	@Override
	public void notify(Component observer) {
		System.out.println("Updated.");
		update(observer.getId());
	}
	public void update(String user) {
		System.out.println("You are follow " + user);
	}
	public void follow(Component following) {
		if(followings.contains(following)) {
		} else {
			followings.add(following);
		}
		notify(following);
	}
	public void tweet(String message) {
		newsFeed.add(message);
		messageTotal++;
		setMessageTotal(messageTotal);		
	}
	private void setMessageTotal(int total) {
		Messages.setMessageTotal(total);
	}
	public List<Component> getFollowings() {
		return followings;
	}
	public List<String> getNewsFeed() {
		return newsFeed;
	}
	public int getUserTotal() {
		return userTotal;
	}
	public int getMessageTotal() {
		return messageTotal;
	}
}
