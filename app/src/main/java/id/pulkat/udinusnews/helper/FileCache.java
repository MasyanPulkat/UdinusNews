package id.pulkat.udinusnews.helper;

import android.content.Context;

import java.io.File;

/**
 * Created by masyan on 5/8/17.
 *
 * @Author Yanuar Eko Setyanto
 * @Email yanuarekosetyanto@gmail.com
 * @Github https://github.com/MasyanPulkat/
 * @Web http://masyan.web.id
 */


public class FileCache {

    private File cacheDir;

    public FileCache(Context context) {

        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
            cacheDir = new File(android.os.Environment
                    .getExternalStorageDirectory(), "LazyList");
        else
            cacheDir = context.getCacheDir();
        if (!cacheDir.exists())
            cacheDir.mkdirs();
    }

    public File getFile(String url) {

        String filename = String.valueOf(url.hashCode());

        File f = new File(cacheDir, filename);
        return f;

    }

    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
            return;
        for (File f : files)
            f.delete();
    }

}

