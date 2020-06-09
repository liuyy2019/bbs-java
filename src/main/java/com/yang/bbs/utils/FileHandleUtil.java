package com.yang.bbs.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/13 10:46
 */
public class FileHandleUtil {


    /**
     * 创建文件夹路径
     */
    private static void createDirIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 删除文件
     *
     * @param path 文件访问的路径upload开始 如： /upload/image/test.jpg
     * @return true 删除成功； false 删除失败
     */
    public static boolean delete(String path) {
        File file = new File(path);
        return file.exists() == true ? file.delete() : true;
    }

    /**
     * 获取服务部署根路径 http:// + ip + port
     *
     * @param request
     * @return
     */
    public static String getServerIPPort(HttpServletRequest request) {
        //+ ":" + request.getServerPort()
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }

}
