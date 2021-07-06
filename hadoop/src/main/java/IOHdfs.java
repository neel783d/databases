import java.io.InputStream;
import java.net.URL;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class IOHdfs {
  static {
    // Setting up input url stream
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
  }

  private void readHdfsFile(String fileUrl) throws Exception {
    // Reads an hdfs file and print to System.out
    InputStream in = null;
    try {
      in = new URL(fileUrl).openStream();
      IOUtils.copyBytes(in, System.out, 4096, false);
    } finally {
      IOUtils.closeStream(in);
    }
  }

  public static void main(String[] args) throws Exception {
    IOHdfs ioHdfs = new IOHdfs();
    ioHdfs.readHdfsFile("hdfs://localhost/neel/pom.xml");
  }
}
