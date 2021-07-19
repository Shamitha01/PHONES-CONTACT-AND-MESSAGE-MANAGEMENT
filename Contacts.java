package project;
import java.util.*;
public class Contacts {
private String name;
private String number;
private String email;
private ArrayList<Message> messages;

public Contacts(String name, String number, String email, ArrayList<Message> messages) {
	this.name = name;
	this.number = number;
	this.email = email;
	this.messages = messages;
}
//Since there will be no messages when we create new contacts
public Contacts(String name, String number, String email) {
	super();
	this.name = name;
	this.number = number;
	this.email = email;
	this.messages = new ArrayList<>();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public ArrayList<Message> getMessages() {
	return messages;
}
public void setMessages(ArrayList<Message> messages) {
	this.messages = messages;
}
public void getDetails()
{
System.out.println("Contact Name : "+Coloured.ANSI_BRIGHT_GREEN+this.name+Coloured.ANSI_RESET
		+"\nPhone Number : "+Coloured.ANSI_BRIGHT_CYAN+this.number+Coloured.ANSI_RESET
		+"\nEmail : "+Coloured.ANSI_BRIGHT_BLUE+this.email+Coloured.ANSI_RESET);	
}
}
