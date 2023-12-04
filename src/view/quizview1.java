package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import engine.Game;
import engine.Player;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;


public class quizview1 extends JFrame implements ActionListener{
JButton b1;
JButton b2;
JButton b3;
int i;
int j;
int k;
Game game;

	public quizview1() throws IOException{
	this.setTitle("quiz");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;	
	this.setSize(screenWidth, screenHeight);
	this.setVisible(true);	
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    JPanel main = new JPanel();
    main.setBackground(new Color(0,0,0,180));
    main.setBounds(0,0,screenWidth,screenHeight);
    main.setLayout(new GridLayout(3, 0));
    
    b1=new JButton();
	b1.setBackground(new Color(175, 31, 36));
	b1.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b1.setForeground(Color.white);

	b2=new JButton();
	b2.setBackground(new Color(175, 31, 36));
	b2.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b2.setForeground(Color.white);

	b3=new JButton();
	b3.setBackground(new Color(175, 31, 36));
	b3.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b3.setForeground(Color.white);
	

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    
    
    
    
	game=new Game(new Player("saha"), new Player("toti"));
	game.loadAbilities("Abilities.csv");
	game.loadChampions("Champions.csv");
	main.add(b1);
	main.add(b2);
	main.add(b3);
    add(main);
    i= (int)(Math.random()*15);
    j= (int)(Math.random()*15);
    k= (int)(Math.random()*15);
    while(i==j||j==k||i==k)
    {i= (int)(Math.random()*15);
    j= (int)(Math.random()*15);
    k= (int)(Math.random()*15);
    	}
    b1.setText(game.getAvailableChampions().get(i).getName()+"  "+game.getAvailableChampions().get(i).getCurrentHP());
    b2.setText(game.getAvailableChampions().get(j).getName()+"  "+game.getAvailableChampions().get(j).getCurrentHP());
    b3.setText(game.getAvailableChampions().get(k).getName()+"  "+game.getAvailableChampions().get(k).getCurrentHP());
    
	revalidate();
	repaint();
	
}public static void main(String[] args) throws IOException {
	
	quizview1 x=new quizview1();
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
	{Champion champ1=game.getAvailableChampions().get(i);
	champ1.setCurrentHP(champ1.getCurrentHP()-500);
	 b1.setText(champ1.getName()+"  "+champ1.getCurrentHP());
	}
	if(e.getSource()==b2)
	{Champion champ2=game.getAvailableChampions().get(j);
	champ2.setCurrentHP(champ2.getCurrentHP()-500);
	 b2.setText(champ2.getName()+"  "+champ2.getCurrentHP());
	}
	if(e.getSource()==b3)
	{Champion champ3=game.getAvailableChampions().get(k);
	champ3.setCurrentHP(champ3.getCurrentHP()-500);
	 b3.setText(champ3.getName()+"  "+champ3.getCurrentHP());
	}
		
}
	

}
