package com.ylch.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

/**
 * Created by yanglaichang1 on 2017/10/28.
 */
public class ZipServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String zipName = "myfile.zip";

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename="+zipName);

        //BufferedWriter bufferedWriter = new BufferedWriter();

        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        out.write("yyy".getBytes());
        response.flushBuffer();
    }
}
