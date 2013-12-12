package pic;

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
		anotherFrame.getContentPane().setPreferredSize(new Dimension(800,600));
		anotherFrame.setLayout(new GridLayout(3,7));

		for(int m = 0; m < 3; m++) {
		   for(int n = 0; n < 7; n++) {
		      panelHolder[m][n] = new JPanel();
		      anotherFrame.add(panelHolder[m][n]);
		   }
		}
		
		BufferedImage myPicture;
		BufferedImage myPicture1;
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
		anotherFrame.resize(new Dimension(800,600));
		anotherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
