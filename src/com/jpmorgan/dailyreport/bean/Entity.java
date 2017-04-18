/**
 * 
 */
package com.jpmorgan.dailyreport.bean;

/**
 * @author MANISHA
 *
 */
public class Entity {

	public String name;
	public String contact;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Entity(String name, String contact) {
		super();
		this.name = name;
		this.contact = contact;
	}
	
	
	
	
}
