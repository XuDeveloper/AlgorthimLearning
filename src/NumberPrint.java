public class NumberPrint {

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
        	    	
			try {
				new Thread(new PrintThread("a")).start();    
				new Thread(new PrintThread("a")).join();
				new Thread(new PrintThread("b")).start(); 
				new Thread(new PrintThread("b")).join();
				new Thread(new PrintThread("c")).start(); 
				new Thread(new PrintThread("c")).join();
				new Thread(new PrintThread("d")).start(); 
				new Thread(new PrintThread("d")).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
    }
   
}

// 注意用Runnable不能用Thread
class PrintThread implements Runnable {
	
	private String toPrint;
	
	public PrintThread(String toPrint) {
		this.toPrint = toPrint;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print(toPrint);
	}
}