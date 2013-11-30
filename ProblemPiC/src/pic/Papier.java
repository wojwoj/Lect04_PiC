package pic;

import java.util.concurrent.Semaphore;

public class Papier {

	public Semaphore seam;

	public Papier(int permits) {
		seam = new Semaphore(permits, true);
	}

}
