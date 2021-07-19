package project;
public class Message {
private String text;
private String recipient;
private int id;
public Message(String text, String recipient, int id) {
	super();
	this.text = text;
	this.recipient = recipient;
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getRecipient() {
	return recipient;
}
public void setRecipient(String recipient) {
	this.recipient = recipient;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void getDetails()
{
	System.out.println("Contact Name : "+Coloured.ANSI_BRIGHT_GREEN+this.recipient+Coloured.ANSI_RESET
			+"\nMessage : "+Coloured.ANSI_BRIGHT_CYAN+this.text+Coloured.ANSI_RESET
			+"\nId : "+Coloured.ANSI_BRIGHT_BLUE+this.id+Coloured.ANSI_RESET);
}
}
