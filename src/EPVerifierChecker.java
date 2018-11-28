import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class EPVerifierChecker implements ThreadListener {

	private static volatile EPVerifierChecker epVerifierChecker = null;
	
    private Timer mConnRetryTimer;

    private static final int mRetryInterval = 10;
    
    private final ActionListener mConnListener = new ActionListener() {
        public void actionPerformed(final ActionEvent evt) {
            checkEPAndNotify();
        }
    };
    
    public static EPVerifierChecker getInstance() {
		if(epVerifierChecker == null) {
		//	synchronized(TokenManager.class) {
				if(epVerifierChecker == null) {
					epVerifierChecker = new EPVerifierChecker();
				}
		//	}
		}
		return epVerifierChecker;
	}
    
    public final void startConnRetryTimer() {
    	System.out.println("Entering startConnRetryTimer");
        mConnRetryTimer = new Timer(mRetryInterval, mConnListener);
        mConnRetryTimer.setInitialDelay(10);
        mConnRetryTimer.start();
        System.out.println("Exiting startConnRetryTimer");
    }
    
	@Override
	public void stateChange() {
		// TODO Auto-generated method stub
		System.out.println("State changed on EPVerify check");
	}
	
	public final void checkEPAndNotify() {
		System.out.println("Checking EP and Notify");
	}

}
