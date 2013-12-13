package pic;

import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public abstract class PapierUser {

	public static Papier myPapier;
	public static int numberOfWriters;
	public static GuiHandler gh;
	
	public int column;
	
	public BufferedImage myPicture;
	public JLabel picLabel;
	public JLabel empty;
	
	public void isSleeping(){
		this.gh.panelHolder[0][column].add(picLabel);
		this.gh.panelHolder[1][column].add(empty);
		this.gh.panelHolder[2][column].add(empty);
		this.gh.panelHolder[0][column].revalidate();
		this.gh.panelHolder[1][column].revalidate();
		this.gh.panelHolder[2][column].revalidate();
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();
	}
	
	public void isWaiting(){
		this.gh.panelHolder[0][column].add(empty);
		this.gh.panelHolder[1][column].add(picLabel);
		this.gh.panelHolder[2][column].add(empty);
		this.gh.panelHolder[0][column].revalidate();
		this.gh.panelHolder[1][column].revalidate();
		this.gh.panelHolder[2][column].revalidate();
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();

	}
	
	public void isActive(){
		this.gh.panelHolder[0][column].add(empty);
		this.gh.panelHolder[1][column].add(empty);
		this.gh.panelHolder[2][column].add(picLabel);
		this.gh.panelHolder[0][column].revalidate();
		this.gh.panelHolder[1][column].revalidate();
		this.gh.panelHolder[2][column].revalidate();
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();
	}

}
