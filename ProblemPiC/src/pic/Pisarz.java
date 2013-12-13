package pic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pisarz extends PapierUser implements Runnable {

	public Pisarz() {
		super();
		try {
			myPicture = ImageIO.read(this.getClass().getResource("pis.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Pisarz(int column) {
		super();
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
}
