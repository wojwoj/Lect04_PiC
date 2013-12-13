package pic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Czytelnik extends PapierUser implements Runnable {

	public Czytelnik() {
		super();
		try {
			myPicture = ImageIO.read(this.getClass().getResource("czyt.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Czytelnik(int column) {
		super();
		this.column = column;

		try {
			myPicture = ImageIO.read(this.getClass().getResource("czyt.jpg"));
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
				myPapier.seam.acquire();
				System.out.println("-> " + this.toString()
						+ " Czytam bo mam papier ");
				this.isActive();
				Thread.sleep((int) ((Math.random() + 1) * 2000));
				myPapier.seam.release();
				System.out.println("-> " + this.toString()
						+ " Skonczylem czytac ");
				this.isSleeping();
				Thread.sleep((int) ((Math.random()) * 4000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
