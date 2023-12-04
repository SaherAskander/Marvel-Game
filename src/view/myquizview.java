package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class myquizview extends JFrame implements ActionListener{
JButton b1;
JButton b2;
JButton b3;
JButton b4;
int counter;
int random;
Champion selectChampion;
JPanel top;
JPanel bottom;
Game game;

public myquizview() throws IOException{
	counter=0;
	this.setTitle("quiz");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;	
	this.setSize(screenWidth, screenHeight);
	this.setVisible(true);	
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    game=new Game(new Player("saher"), new Player("samer"));
	game.loadAbilities("Abilities.csv");
    game.loadChampions("Champions.csv");
	random=(int)(Math.random()*15);
    selectChampion=game.getAvailableChampions().get(random);
    
	b1=new JButton("componenet 1");
	b1.setBackground(new Color(78, 211, 36));
	b1.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b1.setForeground(Color.white);
    b1.setText(selectChampion.getName());
	
	
	b2=new JButton("componenet 2");
	b2.setBackground(new Color(175, 31, 36));
	b2.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b2.setForeground(Color.white);
	
	
	

	b3=new JButton("componenet 3");
	b3.setBackground(new Color(175, 31, 36));
	b3.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b3.setForeground(Color.white);
	
	
	b4=new JButton("componenet 4");
	b4.setBackground(new Color(175, 31, 36));
	b4.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b4.setForeground(Color.white);
	
	b1.addActionListener(this);

	
	bottom=new JPanel();	
	bottom.setLayout(new GridLayout(1,3));
    bottom.add(b2);
    bottom.add(b3);
    bottom.add(b4);
	top=new JPanel();
	top.setLayout(new GridLayout(1,1));
    top.add(b1);
    this.add(top,BorderLayout.NORTH);
    this.add(bottom,BorderLayout.CENTER);
	
	this.revalidate();
	this.repaint();
}


	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1&&counter==0)
		{b2.setText(selectChampion.getAbilities().get(0).getName());
	    counter=1;
	    return;}
	if(e.getSource()==b1&&counter==1)
	{b3.setText(selectChampion.getAbilities().get(1).getName());
    counter=2;
    return;}
	if(e.getSource()==b1&&counter==2)
	{b4.setText(selectChampion.getAbilities().get(2).getName());
    counter=3;
    return;}
	if(e.getSource()==b1&&counter==3)
	{random=(int)(Math.random()*15);
    selectChampion=game.getAvailableChampions().get(random);
		b1.setText(selectChampion.getName());
		b2.setText("Component 2");
		b3.setText("Component 3");
		b4.setText("Component 4");
		
    counter=0;
    return;}
	
	}
	public static void main(String[] args) throws IOException {
		
		myquizview x=new myquizview();
	}

}
