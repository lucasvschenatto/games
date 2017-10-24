package clean.tetris;

import static org.junit.Assert.*;

import org.junit.*;

public class ControllerTest {

	private ViewSpy spyView;
	private Controller controller;
	
	@Before
	public void setup() {
		spyView = new ViewSpy();
		controller = new Controller(spyView);
	}

	@Test
	public void givenStartViewAlsoStarts() {
		controller.start();
		assertEquals(1, spyView.startCount);
	}
	
	@Test
	public void givenStartAndPauseViewAlsoPauses() throws Exception {
		controller.start();
		controller.pause();
		assertEquals(1,spyView.pauses);
		assertTrue(spyView.paused);
		assertTrue(spyView.started);
	}
	
	@Test
	public void givenStartAndTwoPausesViewIsStarted() throws Exception {
		controller.start();
		controller.pause();
		controller.pause();
		assertTrue(spyView.started);
	}

}
