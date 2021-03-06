package pic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiHandler {

	public JPanel[][] panelHolder = new JPanel[3][7];
	JFrame anotherFrame;
	public void createForm() {
		
		anotherFrame = new JFrame();
		anotherFrame.setTitle("iran nuclear program");
		anotherFrame.setResizable(false);
		anotherFrame.setLayout(new GridLayout(3,7));

		for(int m = 0; m < 3; m++) {
		   for(int n = 0; n < 7; n++) {
		      panelHolder[m][n] = new JPanel();
		      panelHolder[m][n].setBackground(Color.WHITE);
		      anotherFrame.add(panelHolder[m][n]);
		   }
		}
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("papier.jpg"));
			JLabel picLabel= new JLabel(new ImageIcon(myPicture));
			this.panelHolder[2][0].add(picLabel);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		anotherFrame.pack();
		anotherFrame.setVisible(true);
		anotherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}

}
