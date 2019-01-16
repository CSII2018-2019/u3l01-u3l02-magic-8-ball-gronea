import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MagicEightBall extends JFrame{
	
	private String message = null;
	
	private JLabel text = new JLabel (); //"Welcome" will become a variable to change
	
	JPanel centerPanelBackground = new JPanel ();
	JPanel centerPanel = new JPanel ();
	
	public MagicEightBall () {
		//setup what goes into the window
		initGUI();
		//Title
		setTitle("Online Magic Eight Ball");
		//Size
		setSize(800, 350); //pixels
		setResizable(true);
		//Makes everything really tight - overrides size
		//pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

		//Needs to one of the last things you do- making it visible	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		//TITLE
		//create label
		JLabel titleLabel = new JLabel("Magic Eight Ball");
		//Customizing label
		//Extra Font Options are on the slide "100 Fonts"
		//Once Downloaded replace Font.SERIF with "[FONT NAME]"
		Font titleFont = new Font (Font.SANS_SERIF, Font.BOLD, 32);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.LIGHT_GRAY);
		//titleLabel.setBackground(Color.BLACK); 
		//or Go on Google and search rgb color picker to find new colors then use:
		titleLabel.setBackground(new Color(29,62,114));
		titleLabel.setOpaque(true);
		//Add the label to the window, make sure it is on top
		add(titleLabel, BorderLayout.PAGE_START);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		
		//CENTER PANEL
		centerPanelBackground.setBackground(Color.BLACK);
		//add random array for shake
		add(centerPanelBackground, BorderLayout.CENTER);
		
		Dimension size = new Dimension(400,200);
		
		centerPanel.setBackground(Color.WHITE); //This will change with buttons
		centerPanel.setPreferredSize(size);
		centerPanelBackground.add(centerPanel);
		
		text.setText("Welcome");
		Font textFont = new Font (Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 16);
		text.setFont(textFont);
		text.setForeground(Color.BLUE);
		centerPanel.add(text);
		text.setHorizontalAlignment(JLabel.CENTER);
		
		//BUTTON PANEL
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(29,62,114));
		add(buttonPanel, BorderLayout.PAGE_END);
		
		//Buttons
		JButton shakeButton = new JButton("Shake"); //Add code to make it change text
		shakeButton.setBackground(Color.WHITE);
		shakeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shakeBall();
			}
		});
		buttonPanel.add(shakeButton);

	}

	private void shakeBall() {
		//Changes text
		String [] responseList = new String [5];
		responseList[0] = "yes";
		responseList[1] = "maybe";
		responseList[2] = "as you wish";
		responseList[3] = "nope";
		responseList[4] = "try again";
		int randomNum = (int) (Math.random()* 5);
		message = responseList[randomNum];
		System.out.println(message);
		
		updateText();
		
	}
	
	private void updateText() {
		text.setText(message);;
		
		centerPanel.add(text);
		
		
	}
	
	public static void main(String[] args) {
		try {
            //UI = user interface
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new MagicEightBall();
            }   
        });
	}

}
