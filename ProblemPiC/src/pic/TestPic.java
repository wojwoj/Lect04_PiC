package pic;

public class TestPic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GuiHandler gh = new GuiHandler();
		gh.createForm();
		Papier wyborcza = new Papier(10);
		PapierUser.numberOfWriters =10;
		PapierUser.myPapier =wyborcza;
		PapierUser.gh =gh;
	
		Czytelnik c1 = new Czytelnik(4);
		Czytelnik c2 = new Czytelnik(5);
		Czytelnik c3 = new Czytelnik(6);
		
		new Thread(c1).start();
		
		
		Pisarz p1 = new Pisarz(1);		
		Pisarz p2 = new Pisarz(2);
		Pisarz p3 = new Pisarz(3);
		
		new Thread(p1).start();
		new Thread(p2).start();
		
		new Thread(c2).start();
		new Thread(c3).start();
		new Thread(p3).start();
		
	
	}

}
