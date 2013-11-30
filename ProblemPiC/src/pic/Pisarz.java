package pic;

public class Pisarz extends PapierUser implements Runnable {

	public Pisarz() {

	}

	@Override
	public void run() {
		for (;;) {
			try {
				myPapier.seam.acquire(numberOfWriters);
				System.out.println("-> " + this.toString()
						+ " Pisze bo mam papier");
				Thread.sleep((int) ((Math.random() + 1) * 2000));
				myPapier.seam.release(numberOfWriters);
				System.out.println("-> " + this.toString()
						+ " Skonczylem pisac");
				Thread.sleep((int) ((Math.random() + 1) * 1000));

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out
						.println("Czekam bo nie ma papieru" + this.toString());

			}
		}

	}
}
