package pic;

public class TestPic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Papier wyborcza = new Papier(10);
		
		PapierUser.numberOfWriters =10;
		PapierUser.myPapier =wyborcza;
		
		
		Pisarz p1 = new Pisarz();
		//p1.myPapier = wyborcza;
		//p1.numberOfWriters =10;
		
		Pisarz p2 = new Pisarz();
		Pisarz p3 = new Pisarz();
		
		Czytelnik c1 = new Czytelnik();
		Czytelnik c2 = new Czytelnik();
		Czytelnik c3 = new Czytelnik();
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
		
		GuiHandler gh = new GuiHandler();
		gh.createForm();
		
	
	}

}
