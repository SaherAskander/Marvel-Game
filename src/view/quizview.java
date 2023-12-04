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


public class quizview extends JFrame implements ActionListener{
JButton b1;
JButton b2;
JButton b3;
JButton b4;
Game game;

	public quizview() throws IOException{
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
    main.setLayout(new GridLayout(2, 2));
    
    b1=new JButton("Ability name");
	b1.setBackground(new Color(175, 31, 36));
	b1.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b1.setForeground(Color.white);

	b2=new JButton("Ability type");
	b2.setBackground(new Color(175, 31, 36));
	b2.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b2.setForeground(Color.white);

	b3=new JButton("counter");
	b3.setBackground(new Color(175, 31, 36));
	b3.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b3.setForeground(Color.white);
	
	b4=new JButton("next");
	b4.setBackground(new Color(175, 31, 36));
	b4.setFont(new Font("Arial Black", Font.PLAIN, 15));
	b4.setForeground(Color.white);
    b4.addActionListener(this);
    
    
	game=new Game(new Player("saha"), new Player("toti"));
	game.loadAbilities("Abilities.csv");
	
	main.add(b1);
	main.add(b2);
	main.add(b3);
	main.add(b4);
    add(main);
    
    
    
	revalidate();
	repaint();
	
}public static void main(String[] args) throws IOException {
	
	quizview x=new quizview();
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b4)
	{int r= (int)(Math.random()*45);
		Ability tmp=game.getAvailableAbilities().get(r);
		b1.setText(tmp.getName());
		if(tmp instanceof HealingAbility)
			b2.setText("Healing ability");
			if(tmp instanceof CrowdControlAbility)
				b2.setText("crowd control ability");
				if(tmp instanceof DamagingAbility)
		         b2.setText("damaging ability");
b3.setText(r+"");
		
		
		
		
	}
		
		
}
	

}
