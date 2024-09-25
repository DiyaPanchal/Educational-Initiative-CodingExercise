interface MediaPlayer {
    void play(String audioType, String fileName);
}

class VLCPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer = new VLCPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVLC(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported.");
        }
    }
}

public class AdapterPattern{
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("vlc", "example.vlc");
        player.play("mp3", "example.mp3");  
    }
}
