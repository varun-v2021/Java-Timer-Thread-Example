import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Myworker implements Runnable {

	public ThreadListener listener = null;

	private Timer mConnRetryTimer;

	private final ActionListener mConnListener = new ActionListener() {
        public void actionPerformed(final ActionEvent evt) {
        	System.out.println("Entering actionPerformed");
        	informListener();
        }
    };
    
	public void addListener(ThreadListener listener) {
		System.out.println("Entering addListener");
		this.listener = listener;
	}

	public void informListener() {
		System.out.println("Entering informListener");
		if (listener != null) {
			//System.out.println("calling listener.stateChange()");
			//listener.stateChange();
			System.out.println("Interrupting current thread");
			Thread.currentThread().interrupt();
		}
	}

	public final void startConnRetryTimer() {
		System.out.println("Entering startConnRetryTimer");
		mConnRetryTimer = new Timer(1000, mConnListener);
		//mConnRetryTimer.setInitialDelay(1000);
		mConnRetryTimer.start();
		System.out.println("Exiting startConnRetryTimer");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startConnRetryTimer();
		System.out.println("My worker is running");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//informListener();
	}

}