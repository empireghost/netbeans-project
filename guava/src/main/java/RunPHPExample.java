
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunPHPExample {
    
    private static final Logger logger = LoggerFactory.getLogger(RunPHPExample.class);

    public static void main(String[] args) {
        String emailCrypt = "bGl1aGFoYXlhQDE2My5jb20=";
        String custIdCrypt = "6P0GNxVEZrTen1LFGt7syg==";
        try {
            
            CodeSource cs = RunPHPExample.class.getProtectionDomain().getCodeSource();
            URL url = cs.getLocation();
            logger.info("stringPath is {}",url.getFile());
            String dir = FilenameUtils.getFullPath(url.getFile());
            logger.info("fileDir is {}", dir);
            
            String emailGBK = new String(emailCrypt.getBytes(), "gb2312");
            String custIdGBK = new String(custIdCrypt.getBytes(), "gb2312");
            
            String commandStr = "php CryptoCustIdHelper.php " + emailGBK + " " + custIdGBK;
            logger.info("commandStr is {}", commandStr);
            
            String path = Thread.currentThread().getContextClassLoader().getResource("php/CryptoCustIdHelper.php").getPath();
            logger.info("path is {}",path);
            
            String fileDir = FilenameUtils.getPath(path);
            logger.info("fileDir is {}", fileDir);
            
            List<String> command = new ArrayList<String>(Arrays.asList(commandStr.split(" ")));
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(new File(fileDir));
            
            Process process = pb.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                InputStream is = process.getInputStream();
                String isStr = read(is);
                System.err.println(Arrays.toString(isStr.getBytes()));
                System.err.println(Long.valueOf(isStr.substring(2)));
                //中文字符
                System.err.println(Arrays.toString("中文".getBytes()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String read(InputStream inputStream) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
