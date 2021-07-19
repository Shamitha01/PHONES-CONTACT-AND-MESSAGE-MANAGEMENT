package project;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Main  extends Songs implements Lock{
	private static String password;
	private static ArrayList<Contacts> contacts;
	private static Scanner scanner;
	private static int id=0;
	private static int size=6;
	static
	{
	password="111";	
	}
	public static void main(String[] args)  {
		int count=0;
		 scanner=new Scanner(System.in);
        System.out.println("Please enter your phone password");
		count++;
		Main object=new Main();
		boolean check=object.enterPassword(scanner.nextLine());
		if(check)
		{
			System.out.println(Coloured.ANSI_BG_GREEN+"Password matched"+Coloured.ANSI_RESET);
		}
		if(!check)
		{
		do
		{
			if(count%2==0)
		{
				System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : WRONG PASSWORD, PLEASE WAIT FOR 10 SECONDS"+Coloured.ANSI_RESET);
			try
			{
				for(int i=10;i>=1;i--)
				{
			Thread.sleep(1000);
			System.out.print(Coloured.ANSI_BG_RED+i +"\t");
				}
				System.out.println(Coloured.ANSI_RESET);
				System.out.println();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
			if(count%2!=0)
			{
		System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : WRONG PASSWORD");
			}
		System.out.println(Coloured.ANSI_RESET+"Please enter correct password");
		count++;
		check=object.enterPassword(scanner.nextLine());
		if(check)
		{
			System.out.println(Coloured.ANSI_BG_GREEN+"Password matched"+Coloured.ANSI_RESET);
		}
		}while(!check);
		}
     contacts=new ArrayList<>();
     setting();
     System.out.println(Coloured.ANSI_BG_CYAN+"\n-------------------------WELCOME TO THE SCREEN OF YOUR PHONE--------------------------------------\n"+Coloured.ANSI_RESET);
     showInitialOptions();
		
	}
private static void setting() {
	
	Contacts object1=new Contacts("Amanda","9123467456","amanda@gmail.com");
	contacts.add(object1);
	Contacts object2=new Contacts("Carla","9183897656","carla@gmail.com");
	contacts.add(object2);
	Contacts object3=new Contacts("Shamuel","9923897456","samuel@gmail.com");
	contacts.add(object3);
	Contacts object4=new Contacts("Garcia","9433467456","garcia@gmail.com");
	contacts.add(object4);
	Message message=new Message("Hello","Amanda",++id);
	Message message2=new Message("Please finish your work as soon as possible","Carla",++id);
	for(Contacts c : contacts)
	{
		if(c.getName().equalsIgnoreCase("Amanda"))
		{
			c.getMessages().add(message);
		}
		if(c.getName().equalsIgnoreCase("carla"))
		{
			c.getMessages().add(message2);
		}
	}
	
	}
public static void showInitialOptions()
{
	System.out.println("\nPlease select any one of the option"
			+"\n\t1. Manage Contacts"
			+"\n\t2. Messages"
			+"\n\t3. Play Song"
			+"\n\t4. Reset Password"
			+"\n\t5. Quit");
	scanner=new Scanner(System.in);
	int choice=Integer.parseInt(scanner.nextLine());
	switch(choice)
	{
	case 1:
		
		manageContacts();	
		break;
	case 2:
		manageMessages();
		break;
	case 3:
		try {
			playSong();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		break;
	case 4:
		Main object=new Main();
		object.reset();
		break;
	default:
		break;
	}
}

private void reset() {
	resetPassword();
	showInitialOptions();
	
}
private static void playSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	System.out.println("\nEnter the phone screen password");
	String check=scanner.nextLine();
	if(!check.equals(Main.password))
	{
		do
		{
			System.out.println(Coloured.ANSI_BG_RED+"\nWrong password"+Coloured.ANSI_RESET);
	System.out.println("\nPlease confirm phone screen password");
	check=scanner.nextLine();
		}while(!check.equals(Main.password));
	}
	System.out.println(Coloured.ANSI_BG_GREEN+"\nPassword matched\n"+Coloured.ANSI_RESET);
	playMusic();
	showInitialOptions();
}
private static void manageMessages() {
System.out.println("\nPlease select one : "
		+"\n\t1. Show all messages"
		+"\n\t2. Send a new Message"
		+"\n\t3. Go Back");
int choice=Integer.parseInt(scanner.nextLine());
switch(choice)
{
case 1:
	showAllMessages();
	break;
case 2:
	sendNewMessage();
	break;
	default:
		showInitialOptions();
		break;
}
}
private static void sendNewMessage() {
System.out.println("\nEnter the Contact's name to send a message");
String name=scanner.nextLine();
do
{
if(name.equals(""))
{
	System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : Contact name cannot be empty\n"+Coloured.ANSI_RESET+"Please enter the name of the contact");
name=scanner.nextLine();
}
}while(name.equals(""));

	boolean doesExist=false;
	for(Contacts c : contacts)
	{
		if(c.getName().equalsIgnoreCase(name))
		{
			doesExist=true;
		}
	}
	if(doesExist)
	{
		System.out.println("\nEnter the message to be sent");
		String text=scanner.nextLine();
		do
		{
		if(text.equals(""))
		{
			System.out.println(Coloured.ANSI_BG_RED+"\n***Warning*** : Message to be sent cannot be empty\n"+Coloured.ANSI_RESET+"Please enter Message");
			text=scanner.nextLine();
		}
		}while(text.equals(""));
		
			id++;
			Message newMessage=new Message(text,name,id);
			for(Contacts c : contacts)
			{
			if(c.getName().equalsIgnoreCase(name))
			{
				ArrayList<Message> newMessages=c.getMessages();
			newMessages.add(newMessage);
				c.setMessages(newMessages);
				System.out.println(Coloured.ANSI_BG_GREEN+"\nMessage has been successfully sent to "+c.getName()+"!!"+Coloured.ANSI_RESET);
			}
		}
	}
	else
	{
		System.out.println(Coloured.ANSI_BG_YELLOW+"\nContact with Name "+name+" doesn't exists"+Coloured.ANSI_RESET);
	}
manageMessages();
}
private static void showAllMessages() {
	ArrayList<Message> allMessages=new ArrayList<>();
	for(Contacts c : contacts)
	{
		allMessages.addAll(c.getMessages());
	}
	if(allMessages.size()>0)
	{
		System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);
		for(Message m : allMessages)
		{
			m.getDetails();
			System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);
		}
	}
	else
	{
		System.out.println(Coloured.ANSI_BG_YELLOW+"\nYou don't have any message"+Coloured.ANSI_RESET);
	}
	manageMessages();
}
private static void manageContacts()
{
	System.out.println("\nPlease Select one : "
			+"\n\t1. Show All Contacts"
			+"\n\t2. Add a new Contact"
			+"\n\t3. Search for a contact"
			+"\n\t4. Delete a contact"
			+"\n\t5. Go Back");
	
	int choice=Integer.parseInt(scanner.nextLine());
	switch(choice)
	{
	case 1:
		showAllContact();
		break;
	case 2:
		addNewContact();
		break;
	case 3:
		searchForContact();
		break;
	case 4:
		deleteContact();
		break;
		default:
	showInitialOptions();
			break;
	}
}
private static void deleteContact() {
	System.out.println("\nPlease enter the name of the contact");
	String name=scanner.nextLine();
	do
	{
	if(name.equals(""))
	{
	System.out.println(Coloured.ANSI_BG_RED+"\n**Warning** : Contacts name cannot be empty\n"+Coloured.ANSI_RESET+"Please enter contact name");
	name=scanner.nextLine();
	}
	}while(name.equals(""));

		boolean doesExist=false;
		for(Contacts c:contacts)
		{
			if(c.getName().equalsIgnoreCase(name) || c.getName().startsWith(name))
			{
				doesExist=true;
				System.out.println(Coloured.ANSI_BG_YELLOW+"\nAre you sure you want to remove "+c.getName()+Coloured.ANSI_RESET
				+"\n\t"+Coloured.ANSI_BG_YELLOW+"1. Yes"+Coloured.ANSI_RESET+"\n\t"+Coloured.ANSI_BG_YELLOW+"2. No "+Coloured.ANSI_RESET);
				if(Integer.parseInt(scanner.nextLine())==1)
				{
				System.out.println(Coloured.ANSI_BG_GREEN+"\n"+c.getName()+" has been successfully removed from the contacts"+Coloured.ANSI_RESET);
				contacts.remove(c);
				break;
				}
				else
				{
					break;
				}
			}
		}
		if(!doesExist)
		{
			System.out.println(Coloured.ANSI_BG_YELLOW+"\nThere is no such contact available in your phone"+Coloured.ANSI_RESET);
		}
	manageContacts();
}
private static void searchForContact() {
	System.out.println("\nEnter the contact name : ");
	String name=scanner.nextLine();
	if(name.equals(""))
	{
		do
	{
    System.out.println(Coloured.ANSI_BG_RED+"\n**Warning** : Contacts name cannot be empty\n"+Coloured.ANSI_RESET+"Please enter contact name");
		name=scanner.nextLine();
		}while(name.equals(""));
	}
	
		boolean doesExist=false;
		for(Contacts c : contacts)
		{
			if(c.getName().equalsIgnoreCase(name) || c.getName().startsWith(name))
		{
				doesExist=true;
		System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);
				c.getDetails();
		System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);

				}
		}
		if(!doesExist)
		{
			System.out.println(Coloured.ANSI_BG_YELLOW+"\nThere is no such contact available in your phone"+Coloured.ANSI_RESET);
		}
	manageContacts();
}
private static void addNewContact() {
	if(contacts.size()<size)
	{
	System.out.println("\nGetting ready to add a new contact........"
			+"\n\nPlease Enter the contact's name");
	String name=scanner.nextLine();
	do
	{
	if(name.equals(""))
	{
		System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : Contacts name cannot be empty\n"+Coloured.ANSI_RESET+"Please enter a name");
		name=scanner.nextLine();
	}
	}while(name.equals(""));
	boolean doesExist=false;
	for(Contacts c : contacts)
	{
		if(c.getName().equalsIgnoreCase(name))
		{
			System.out.println(Coloured.ANSI_BG_YELLOW+"\nContact with the name "+name+" already exists\n"+Coloured.ANSI_RESET);
			doesExist=true;
		}
	}
	if(!doesExist)
	{
System.out.println("\nPlease Enter contact's number");
	String number=scanner.nextLine();
	do
	{
		if(number.equals("") || number.length()!=10)
		{
			System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : Total numbers in phone number must be 10\n"+Coloured.ANSI_RESET+"Please enter correct phone number");
			number=scanner.nextLine();
		}
	}while(number.length()!=10 || number.equals(""));
	System.out.println("\nPlease enter contact's email");
	String email=scanner.nextLine();
	do
	{
		if(email.equals("") || !email.contains("@gmail.com"))
		{
			System.out.println(Coloured.ANSI_BG_RED+"\n***WARNING*** : Please enter valid mail id\n"+Coloured.ANSI_RESET+"Please enter correct Email id");
			email=scanner.nextLine();
		}
	}while(email.equals("") || !email.contains("@gmail.com"));
		Contacts contact=new Contacts(name,number,email);
		contacts.add(contact);
		System.out.println(Coloured.ANSI_BRIGHT_BG_GREEN+"\n"+name+" has been successfully added to the contacts"+Coloured.ANSI_RESET);
	}
	else
	{
		addNewContact();
	}
	}
	else
	{
		System.out.println(Coloured.ANSI_BG_RED+"***warning*** : Memory is full Delete unwanted memory to add a new contact"+Coloured.ANSI_RESET);
	}
	manageContacts();
}
private static void showAllContact() {
	if(contacts.size()==0)
	{
		System.out.println(Coloured.ANSI_BG_YELLOW+"Contacts list is empty!!"+Coloured.ANSI_RESET);
	}
	else
	{
	System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);
for(Contacts c : contacts)
{
c.getDetails();	
System.out.println(Coloured.ANSI_BRIGHT_BG_BLACK+"--------------------------------------------------------------"+Coloured.ANSI_RESET);
}
	}
manageContacts();
}
@Override
public void resetPassword() {
	System.out.println("\nEnter the phone screen password");
	String check=scanner.nextLine();
	if(!check.equals(Main.password))
	{
		do
		{
			System.out.println(Coloured.ANSI_BG_RED+"\nWrong password"+Coloured.ANSI_RESET);
	System.out.println("\nPlease confirm phone screen password");
	check=scanner.nextLine();
		}while(!check.equals(Main.password));
	}
	System.out.println(Coloured.ANSI_BG_GREEN+"Password matched"+Coloured.ANSI_RESET);
	System.out.println("\nEnter the new password");
	Main.password=scanner.nextLine();
	System.out.println("\nConfirm new password");
	 check=scanner.nextLine();
	if(!check.equals(Main.password))
	{
		do
		{
			System.out.println(Coloured.ANSI_BG_RED+"\nWrong password"+Coloured.ANSI_RESET);
	System.out.println("\nPlease confirm password");
	check=scanner.nextLine();
		}while(!check.equals(Main.password));
	}
System.out.println(Coloured.ANSI_BG_GREEN+"\nPassword has been successfully set"+Coloured.ANSI_RESET);
}
@Override
public boolean enterPassword(String userPass) {
	return userPass.equals(password);	
}
}
