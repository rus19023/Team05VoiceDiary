package com.voicediary;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class GetAsyncTranscript implements Runnable {
    private static final String TAG = "GetTranscription";
    private MainActivity context;
    private MediaPlayer voiceRecord;
    private String text;


    /**
     * Sets up the runnable to be called. It needs the MainActivity so it can run code on the
     * UI thread, and also the voice recorded so that it can get transcribed to text.
     *
     * @param context
     * @param
     */

    public GetAsyncTranscript(MainActivity context, MediaPlayer voiceRecord) {
        this.context = context;
        this.voiceRecord = voiceRecord;

    }

    @Override
    public void run() {
        // request transcription from the API

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is code that will now run on the UI thread. Call the function in
                // MainActivity that will update the UI correctly.

            }

            /*here must implement the runnable*/
        });}

    public  String requestTranscription () {
        Toast.makeText(context, "working connection to requestTranscription", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In  requestTranscription");
        return text;
    }

    public static void sampleRecognize() {
        // TODO(developer): Replace these variables before running the sample.
        String localFilePath = "resources/raw";
        sampleRecognize(localFilePath);
    }

    /**
     * Transcribe a short audio file using synchronous speech recognition
     *
     * @param localFilePath Path to local audio file, e.g. /path/audio.wav
     */
    public static void sampleRecognize(String localFilePath) {
        try (SpeechClient speechClient = SpeechClient.create()) {

            // The language of the supplied audio
            String languageCode = "en-US";

            // Sample rate in Hertz of the audio data sent
            int sampleRateHertz = 16000;

            // Encoding of audio data sent. This sample sets this explicitly.
            // This field is optional for FLAC and WAV audio formats.
            RecognitionConfig.AudioEncoding encoding = RecognitionConfig.AudioEncoding.LINEAR16;
            RecognitionConfig config =
                    RecognitionConfig.newBuilder()
                            .setLanguageCode(languageCode)
                            .setSampleRateHertz(sampleRateHertz)
                            .setEncoding(encoding)
                            .build();
            Path path = Paths.get(localFilePath);
            byte[] data = Files.readAllBytes(path);
            ByteString content = ByteString.copyFrom(data);
            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(content).build();
            RecognizeRequest request =
                    RecognizeRequest.newBuilder().setConfig(config).setAudio(audio).build();
            RecognizeResponse response = speechClient.recognize(request);
            for (SpeechRecognitionResult result : response.getResultsList()) {
                // First alternative is the most probable result
                SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                System.out.printf("Transcript: %s\n", alternative.getTranscript());
            }
        } catch (Exception exception) {
            System.err.println("Failed to create the client due to: " + exception);
        }
    }

    // receive text from the API as json and put it in a string
    public String receiveText() {
        Toast.makeText(context, "working connection to  receiveText", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "In receiveText  ");
        // TODO needs to display in fragment_recording, editTextTextMultiLine box
        return text;
    }


}