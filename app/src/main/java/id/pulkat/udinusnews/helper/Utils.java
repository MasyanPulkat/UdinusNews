package id.pulkat.udinusnews.helper;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by masyan on 5/8/17.
 *
 * @Author Yanuar Eko Setyanto
 * @Email yanuarekosetyanto@gmail.com
 * @Github https://github.com/MasyanPulkat/
 * @Web http://masyan.web.id
 */


public class Utils {
    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (;;) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }
}
