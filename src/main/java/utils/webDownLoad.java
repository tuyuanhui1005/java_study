package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class webDownLoad {

    public  void downLoader(String url,String fileName)  {

        try {
            FileUtils.copyURLToFile(new URL(url),new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader出现问题........................");
        }
    }



}
