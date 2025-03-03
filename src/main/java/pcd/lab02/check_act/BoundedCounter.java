package pcd.lab02.check_act;

public class BoundedCounter {

	private int cont;
	private int min, max;
	
	public BoundedCounter(int min, int max){
		this.cont = this.min = min;
		this.max = max;
	}
	
	public void inc() throws OverflowException {
		synchronized (this){
			if (cont + 1 > max){
				throw new OverflowException(); //lancia eccezione se il contatore aumenta troppo
			}
			cont++;
		}
	}

	public  void dec() throws UnderflowException {
		synchronized (this){
			if (cont - 1 < min){
				throw new UnderflowException(); //lancia eccezione se il contatore decresce troppo
			}
			cont--;
		}
	}
	
	public  int getValue(){
		synchronized (this){
			return cont;
		}
	}
}
