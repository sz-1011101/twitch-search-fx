package twitch;

public class SavedTwitchStream {

	private String name;
	private boolean online;

	public SavedTwitchStream(String name, boolean online) {
		this.name = name;
		this.online = online;
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

}
