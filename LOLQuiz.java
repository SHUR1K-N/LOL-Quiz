import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LOLQuiz extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton option[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	LOLQuiz(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			option[i]=new JRadioButton();	
			add(option[i]);
			bg.add(option[i]);
		}
		b2=new JButton("Next");
		b1=new JButton("Previous");
		b2.addActionListener(this);
		b1.addActionListener(this);
		add(b2);add(b1);
		set();
		l.setBounds(30,40,450,20);
		option[0].setBounds(50,80,200,20);
		option[1].setBounds(50,110,200,20);
		option[2].setBounds(50,140,200,20);
		option[3].setBounds(50,170,200,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(550,345);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b2)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==10)
			{
				b2.setEnabled(false);
				b1.setText("Result");
			}
		}
		if(e.getSource()==b1)
		{
			current--;
			set();	
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Previous"+y))
		{
			if(check())
				count=count-1;
			now=current-1;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("Correct answers: "+count);
			JOptionPane.showMessageDialog(this,"Correct answers: "+count);
			System.exit(0);
		}
	}
	void set()
	{
		option[4].setSelected(true);
		if(current==0)
		{
			l.setText("Question #1: What are you interacting with right now?");
			option[0].setText("Aliens");option[1].setText("A GUI");option[2].setText("The future");option[3].setText("God");	
		}
		if(current==1)
		{
			l.setText("Question #2: What is 2 + 2?");
			option[0].setText("Whoop!");option[1].setText("Did anyone make a calculator for their mini project?");option[2].setText("4");option[3].setText("Mom's spaghetti");
		}
		if(current==2)
		{
			l.setText("Question #3: What among these is NOT a valid keyword?");
			option[0].setText("int");option[1].setText("void");option[2].setText("public");option[3].setText("rightAnswer");
		}
		if(current==3)
		{
			l.setText("Question #4: String class is defined in which package?");
			option[0].setText("lang");option[1].setText("Swing");option[2].setText("Applet");option[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Question #5: You can only be a true patriot if you join:");
			option[0].setText("The army");option[1].setText("The CT side");option[2].setText("One For All, All For One");option[3].setText("The Olympics");
		}
		if(current==5)
		{
			l.setText("Question #6: What is a circular queue?");
			option[0].setText("A circular queue");option[1].setText("A queue that is circular in terms of conceptual virtual shape");option[2].setText("Trick question, this is OOPM");option[3].setText("Santa Claus");
		}
		if(current==6)
		{
			l.setText("Question #7: Choose Ligma if you're still paying attention.");
			option[0].setText("Swing");option[1].setText("Ligma");option[2].setText("ActionEvent");option[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Question #8: which one among these is not a function of Object class?");
			option[0].setText("toString");option[1].setText("finalize");option[2].setText("equals");option[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Question #9: What's the worst song in human history?");
			option[0].setText("All Tollywood songs");option[1].setText("Alan Walker - Fadead");option[2].setText("The Revival album");option[3].setText("I'm indecisive");
		}
		if(current==9)
		{
			l.setText("Question #10: How many marks should this project get?");
			option[0].setText("0");option[1].setText("This is a project?");option[2].setText("4");option[3].setText("Infinity");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			option[j].setBounds(50,80+i,500,20);
	}
	boolean check()
	{
		if(current==0)
			return(option[1].isSelected());
		if(current==1)
			return(option[2].isSelected());
		if(current==2)
			return(option[3].isSelected());
		if(current==3)
			return(option[0].isSelected());
		if(current==4)
			return(option[2].isSelected());
		if(current==5)
			return(option[2].isSelected());
		if(current==6)
			return(option[1].isSelected());
		if(current==7)
			return(option[3].isSelected());
		if(current==8)
			return(option[1].isSelected());
		if(current==9)
			return(option[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new LOLQuiz("LOLLOLQuiz [w/ GUI] - Aftab");
	}
}