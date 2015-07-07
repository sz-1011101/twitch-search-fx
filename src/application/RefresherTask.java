package application;

import java.util.TimerTask;

public class RefresherTask extends TimerTask {

	private static final int REFRESH_DELAY = 3;
	private TwitchBrowser browser;

	public RefresherTask(TwitchBrowser browser) {
		this.browser = browser;
	}

	@Override
	public void run() {
		try {
			browser.refreshSavedStreams();
			Thread.sleep(60 * 1000 * REFRESH_DELAY);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
