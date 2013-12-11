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

	JPanel[][] panelHolder = new JPanel[3][6];
	public void createForm() {
		JFrame anotherFrame = new JFrame();
		anotherFrame.getContentPane().setPreferredSize(new Dimension(800,600));

		anotherFrame.setLayout(new GridLayout(3,6));

		for(int m = 0; m < 3; m++) {
		   for(int n = 0; n < 6; n++) {
		      panelHolder[m][n] = new JPanel();
		      anotherFrame.add(panelHolder[m][n]);
		   }
		}
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(50, 60, 80, 30);

		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		BufferedImage myPicture;
		BufferedImage myPicture1;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("czyt.jpg"));
			myPicture1 = ImageIO.read(this.getClass().getResource("pis.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
			panelHolder[0][0].add(picLabel);
			panelHolder[2][5].add(picLabel1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//anotherFrame.add(quitButton);
		anotherFrame.pack();
		anotherFrame.setVisible(true);
	}

}
