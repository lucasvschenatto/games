package clean.tetris;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import clean.tetris.swing.SwingGame;
import reversej.controller.Controller;
import reversej.tracer.RepositoryRecorder;
public class DiagramGeneratingTest {

	@Test@Ignore
	public void test() {
		Controller controller = new Controller();
		controller.start();
		new SwingGame();
		controller.stop();
		RepositoryRecorder recorder = controller.getRecorder();
		recorder.describeAll().forEach((record)->System.out.println(record));
		assertFalse(recorder.isEmpty());
	}

}
