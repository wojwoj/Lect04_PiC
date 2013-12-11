package pic;

public class Czytelnik extends PapierUser implements Runnable {

	@Override
	public void run() {
		for (;;) {
			try {

				myPapier.seam.acquire();
				System.out.println("-> " + this.toString()
						+ " Czytam bo mam papier ");
				Thread.sleep((int) ((Math.random() + 1) * 2000));
				myPapier.seam.release();
				System.out.println("-> " + this.toString()
						+ " Skonczylem czytac ");
				Thread.sleep((int) ((Math.random()) * 4000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
