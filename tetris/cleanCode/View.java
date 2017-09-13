package cleanCode;

public interface View {
	public void update();

	public void pause();

	public void updateStatus(String newStatus);

	public void notifyGameOver();

	public void start();
}
