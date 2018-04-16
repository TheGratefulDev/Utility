package me.kaling.util;

import android.util.Log;

import java.io.File;

public class FileUtils {

    private static final String TAG = FileUtils.class.getSimpleName();

    /**
     * calling this method with a folder file path, the method will delete the entire folder
     * calling this method with a file path, the method will delete the file.
     *
     * @param file File or Folder Path
     */
    public static void deleteDirectoryOfThis(File file){

        if (file.isDirectory()) {
            String[] children = file.list();
            for (String aChildren : children) {

                File file1 = new File(file, aChildren);
                if(file1.isDirectory()){
                    deleteDirectoryOfThis(file1);
                }else{
                    boolean deleted = file1.delete();
                    Log.d(TAG, deleted + " " + file1.toString() );
                }

            }
        }else{
            boolean deleted = file.delete();
            Log.d(TAG, deleted + " " + file.toString() );
        }
    }

}
