import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class IOHdfs {

  static {
    // Setting up input url stream
    // only used in readHdfsFileUrlStream
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
  }

  private void readHdfsFileUsingFileSystem(String fileUrl) throws Exception {
    // Reads an hdfs file and print to System.out
    InputStream in = null;
    Configuration conf = new Configuration();
    FileSystem fs = FileSystem.get(URI.create(fileUrl), conf);

    try {
      in = fs.open(new Path(fileUrl));
      IOUtils.copyBytes(in, System.out, 4096, false);
    } finally {
      IOUtils.closeStream(in);
    }
  }

  private void readHdfsFileUrlStream(String fileUrl) throws Exception {
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
    String fp = "hdfs://localhost/neel/pom.xml";
    int choice = 2;
    IOHdfs ioHdfs = new IOHdfs();

    switch (choice) {
      case 2:
        ioHdfs.readHdfsFileUsingFileSystem(fp);
        break;
      default:
        ioHdfs.readHdfsFileUrlStream(fp);
    }



  }
}
