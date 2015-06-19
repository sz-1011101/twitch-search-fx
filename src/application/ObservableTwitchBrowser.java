package application;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ObservableTwitchBrowser extends TwitchBrowser implements
		Observable {

	List<InvalidationListener> invalidationListeners = new ArrayList<>();

	@Override
	public void addListener(InvalidationListener listener) {
		invalidationListeners.add(listener);
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		invalidationListeners.remove(listener);
	}

	public void notifyInvalidated() {
		for (InvalidationListener i : invalidationListeners) {
			i.invalidated(this);
		}
	}
}
