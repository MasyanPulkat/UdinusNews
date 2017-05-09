package id.pulkat.udinusnews.helper;

import android.graphics.Bitmap;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by masyan on 5/8/17.
 *
 * @Author Yanuar Eko Setyanto
 * @Email yanuarekosetyanto@gmail.com
 * @Github https://github.com/MasyanPulkat/
 * @Web http://masyan.web.id
 */

public class MemoryCache {
    private Map<String, SoftReference<Bitmap>> cache = Collections
            .synchronizedMap(new HashMap<String, SoftReference<Bitmap>>());

    public Bitmap get(String id) {
        if (!cache.containsKey(id))
            return null;
        SoftReference<Bitmap> ref = cache.get(id);
        return ref.get();
    }

    public void put(String id, Bitmap bitmap) {
        cache.put(id, new SoftReference<Bitmap>(bitmap));
    }

    public void clear() {
        cache.clear();
    }
}
