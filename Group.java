/**
 * Rodney Villareal
 * CS 356 Project 2
 * Group class that implements the Component
 * interface for the composite pattern. This class
 * has a list of components for tree like properties.
 */

import java.util.*;

public class Group implements Component {
	private String groupId;
	private List<Component> component = new ArrayList<Component>();
	private static int groupTotal = 0;
	
	public Group(){}
	public Group(String groupId) {
		this.groupId = groupId;
		groupTotal++;
	}
	@Override
	public void setId(String id) {
		groupId = id;
	}
	@Override
	public String getId() {
		return groupId;
	}
	public void add(Component component) {
		if(this.component.contains(component)) {   //if already present do nothing
		} else {
			this.component.add(component);
		}
	}
	public int getGroupTotal() {
		return groupTotal;
	}
}
