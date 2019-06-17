package com.example.springbootdemo.common.utils;

import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * 文件工具类
 *
 * @author jiancheng
 * @date 2019-6-17
 */
public class FileUtils {

    /**
     * 获取资源文件夹下的文件
     *
     * @param filePath 文件路径
     * @return 字符串
     */
    public static String getResourcesFile(String filePath) {
        FileInputStream fis = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            File file = ResourceUtils.getFile(filePath);
            fis = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(inputStreamReader);
            String line;
            StringBuilder str = new StringBuilder();
            while ((line = br.readLine()) != null) {
                str.append(line);
            }
            return str.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
