package pcd.lab02.check_act;

public class TestCheckAndAct {

	public static void main(String[] args) throws Exception {

		/*
		Bounded counter è thread safe ma visto che worker A e B mi causano check and act
		allora se eseguo il main mi da eccezione

		il motivo per cui ci sono 4 thread, 2 di tipo solo per generare più in fretta l'eccezione
		 */
		int ntimes = 1000000;
		
		BoundedCounter c = new BoundedCounter(0,1);

		WorkerA w1a = new WorkerA(c,ntimes);
		WorkerA w1b = new WorkerA(c,ntimes);
		WorkerB w2a = new WorkerB(c,ntimes);
		WorkerB w2b = new WorkerB(c,ntimes);
		
		w1a.start();
		w1b.start();
		w2a.start();
		w2b.start();
		
		w1a.join();
		w1b.join();
		w2a.join();
		w2b.join();
		
		System.out.println("Counter final value: "+c.getValue());
	}
}
