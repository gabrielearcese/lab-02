package pcd.lab02.lost_updates;

public class UnsafeCounter {

	private int cont;
	
	public UnsafeCounter(int base){
		this.cont = base;
	}

	//si puo anche mettere public syncronized void inc() per includere la sincronizzazione direttamente nel metodo
	public void inc(){
		synchronized (this){
			cont++;
		}
	}
	
	public int getValue(){
		synchronized (this){
			return cont;
		}
	}
}
