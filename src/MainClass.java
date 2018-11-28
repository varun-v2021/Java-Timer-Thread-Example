import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*List<String[]> ll = new ArrayList<>();
		String[] input = { "1", "2", "3", "4", "5", "6" };
		ll.add(input);
		for (String[] str : ll) {
			System.out.println(str[0]);
		}*/
		
		Foo foo1 = new Foo();
		Myworker wk1 = new Myworker();
		wk1.addListener(foo1);		
		Thread th1 = new Thread(wk1);
		
		Foo foo2 = new Foo();
		Myworker wk2 = new Myworker();
		wk2.addListener(foo2);		
		Thread th2 = new Thread(wk2);
		
		th1.start();
		th2.start();

		th1.join();
		th2.join();
	}

}
