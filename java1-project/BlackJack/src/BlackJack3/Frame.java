package BlackJack3;

import java.awt.*;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Frame extends JFrame {
	private JTextArea textArea;
	private JFrame frame;
	
	public Frame(KeyListener key) {
		frame = new JFrame();
		frame.setTitle("Let's play BlackJack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("D2Coding", Font.PLAIN, 22));
		textArea.addKeyListener(key);
		frame.add(textArea);
		
	}
	
	public void setText(String text){
		textArea.setText(text);
	}
	
	public void addText(String text){
		textArea.append(text);
	}

}

