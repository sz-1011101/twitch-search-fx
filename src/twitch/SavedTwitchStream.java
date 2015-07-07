package twitch;

public class SavedTwitchStream {

	private String name;
	private transient boolean online = false;
	private transient TwitchStream stream;

	public SavedTwitchStream(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isOnline() {
		return online;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavedTwitchStream other = (SavedTwitchStream) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void refreshStatus() {
		// TODO
		
	}

}
