package com.voicediary;

import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;

class RetrieveEntry implements Runnable {
    private static final int RETRIEVE_TEXT_FILE = 2;
    private String mimeType;
    private Uri initialUri;

    public void run() {

    }
    private void openFile(Uri initialUri, String mimeType) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType(mimeType);
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, initialUri);

        //startActivityForResult(intent, RETRIEVE_TEXT_FILE);
    }

    private void readFile() {

    }
}
