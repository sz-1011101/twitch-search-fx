package twitch;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class TwitchStreamContainerJson {

	private int _total;
	private Links _links;
	private Stream[] streams;

	class Channel {

		Channel() {

		}

		boolean mature;
		String status;
		String broadcaster_language;
		String display_name;
		String game;
		String delay;
		String language;
		int _id;
		String name;
		String created_at;
		String updated_at;
		String logo;
		String banner;
		String video_banner;
		String background;
		String profile_banner;
		String profile_background_color;
		boolean partner;
		String url;
		int views;
		int followers;
		StreamLinks _links;

		@Override
		public String toString() {
			return "Channel [mature=" + mature + ", status=" + status
					+ ", broadcaster_language=" + broadcaster_language
					+ ", display_name=" + display_name + ", game=" + game
					+ ", delay=" + delay + ", language=" + language + ", _id="
					+ _id + ", name=" + name + ", created_at=" + created_at
					+ ", updated_at=" + updated_at + ", logo=" + logo
					+ ", banner=" + banner + ", video_banner=" + video_banner
					+ ", background=" + background + ", profile_banner="
					+ profile_banner + ", profile_background_color="
					+ profile_background_color + ", partner=" + partner
					+ ", url=" + url + ", views=" + views + ", followers="
					+ followers + ", _links=" + _links + "]";
		}

	}

	class Stream {
		String game;
		int viewers;
		String created_at;
		long _id;
		Channel channel;

		@Override
		public String toString() {
			return "TwitchStream [game=" + game + ", viewers=" + viewers
					+ ", created_at=" + created_at + ", _id=" + _id
					+ ", channel=" + channel + "]";
		}

	}

	class Links {

		Links() {

		}

		String self;
		String next;

		@Override
		public String toString() {
			return "Links [self=" + self + ", next=" + next + "]";
		}

	}

	class StreamLinks {

		StreamLinks() {

		}

		String self;
		String follows;
		String commercial;
		String stream_key;
		String chat;
		String features;
		String subscriptions;
		String editors;
		String teams;
		String videos;

		@Override
		public String toString() {
			return "StreamLinks [self=" + self + ", follows=" + follows
					+ ", commercial=" + commercial + ", stream_key="
					+ stream_key + ", chat=" + chat + ", features=" + features
					+ ", subscriptions=" + subscriptions + ", editors="
					+ editors + ", teams=" + teams + ", videos=" + videos + "]";
		}

	}
	
	public ArrayList<TwitchStream> getTwitchStreamList() {
		ArrayList<TwitchStream> result = new ArrayList<>();
		
		for (Stream s: streams) {
			try {
				result.add(new TwitchStream(s.channel.name, new URL(s.channel.url), s.game, s.viewers));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public String toString() {
		return "TwitchStreamContainerJson [_total=" + _total + ", _links="
				+ _links + ", streams=" + Arrays.toString(streams) + "]";
	}

}
