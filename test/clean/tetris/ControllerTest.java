package clean.tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {

	@Test
	public void givenStartViewAlsoStarts() {
		ViewSpy spy = new ViewSpy();
		Controller c = new Controller(spy);
		c.start();
		assertTrue(spy.didStart);
	}
	
	@Test
	public void givenStartAndPauseViewAlsoPauses() throws Exception {
		ViewSpy spy = new ViewSpy();
		Controller c = new Controller(spy);
		c.start();
		c.pause();
		assertEquals(1,spy.pauses);
	}
	@Test
	public void givenStartAndPauseViewUpdates() throws Exception {
		ViewSpy spy = new ViewSpy();
		Controller c = new Controller(spy);
		c.start();
		spy.updates = 0;
		c.pause();
		assertEquals(1,spy.updates);
	}
	@Test
	public void givenStartAndTwoPausesViewResumes() throws Exception {
		ViewSpy spy = new ViewSpy();
		Controller c = new Controller(spy);
		c.start();
		c.pause();
		c.pause();
		assertEquals(1,spy.resumes);
	}
	
	@Test
	public void height(){
		Controller c = new Controller(new ViewSpy());
		c.setHeight(123);
		assertEquals(123,c.getHeight());
	}
	
	@Test
	public void width() throws Exception {
		Controller c = new Controller(new ViewSpy());
		c.setWidth(456);
		assertEquals(456,c.getWidth());
	}

}
