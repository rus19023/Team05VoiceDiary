package com.voicediary;

import android.content.Intent;
import android.net.Uri;
import android.provider.DocumentsContract;

class SaveEntry implements Runnable{
    private String mimeType;
    private static final int CREATE_FILE = 1;
    private Uri initialUri;
    public String fileName;

    public void run() {

    }
    private void createSaveFile(Uri initialUri, String mimeType) {
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType(mimeType);
        intent.putExtra(Intent.EXTRA_TITLE, fileName);
        intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, initialUri);

        //startActivityForResult(intent, CREATE_FILE);
    }
}
