package cleanCode;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import reversej.controller.Controller;
import reversej.tracer.RepositoryRecorder;
public class TetrisTest {

	@Test@Ignore
	public void test() {
		Controller controller = new Controller();
		controller.start();
		new Game();
		controller.stop();
		RepositoryRecorder recorder = controller.getRecorder();
		recorder.describeAll().forEach((record)->System.out.println(record));
		assertFalse(recorder.isEmpty());
	}

}
