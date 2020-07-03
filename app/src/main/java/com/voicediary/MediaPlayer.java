package com.voicediary;

public class MediaPlayer {

    public void play(view v) {
        if (player == null) {
            player = MediaPlayer.create(context: this, R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pause(view v) {
        if (player != null) {
            player.pause();

        }

    }

    public void record(view v) {}

    public void stop(view v) {
        stopPlayer();

    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.maketext(context: this, text: "MediaPLayer release", Toast.LENGTH_SHORT).show();

        }
    }
    @Override
    protected void OnStop() {
        super.OnStop();
        stopPlayer();
    }

}
