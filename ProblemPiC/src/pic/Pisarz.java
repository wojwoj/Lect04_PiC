package pic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pisarz extends PapierUser implements Runnable {

	BufferedImage myPicture;
	JLabel picLabel;
	JLabel empty;

	public Pisarz() {
		super();
		try {
			myPicture = ImageIO.read(this.getClass().getResource("pis.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Pisarz(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("pis.jpg"));
			empty = new JLabel();
			picLabel = new JLabel(new ImageIcon(myPicture));
			this.isSleeping();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		for (;;) {
			try {
				this.isWaiting();
				myPapier.seam.acquire(numberOfWriters);
				this.isActive();
				System.out.println("-> " + this.toString()
						+ " Pisze bo mam papier");
				Thread.sleep((int) ((Math.random() + 1) * 2000));
				myPapier.seam.release(numberOfWriters);
				System.out.println("-> " + this.toString()
						+ " Skonczylem pisac");
				this.isSleeping();
				Thread.sleep((int) ((Math.random()) * 4000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out
						.println("Czekam bo nie ma papieru" + this.toString());
			}
		}

	}


	public void isSleeping() {		
		this.gh.panelHolder[0][column].add(picLabel);
		this.gh.panelHolder[1][column].add(empty);
		this.gh.panelHolder[2][column].add(empty);
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();
		//this.gh.anotherFrame.getContentPane().repaint();
	}

	@Override
	public void isWaiting() {
		this.gh.panelHolder[0][column].add(empty);
		this.gh.panelHolder[1][column].add(picLabel);
		this.gh.panelHolder[2][column].add(empty);
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();

	}

	@Override
	public void isActive() {
		this.gh.panelHolder[0][column].add(empty);
		this.gh.panelHolder[1][column].add(empty);
		this.gh.panelHolder[2][column].add(picLabel);
		this.gh.panelHolder[0][column].repaint();
		this.gh.panelHolder[1][column].repaint();
		this.gh.panelHolder[2][column].repaint();

	}
}
