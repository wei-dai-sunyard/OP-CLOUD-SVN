package com.sunyard.op.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TransUtil {

    public static final String RET_HTTP_CODE = "ResponseCode";
    public static final String RET_HTTP_MESSAGE = "Message";

    public Map<String, String> sendJsonCtxWithHttp(String url, String methodType, String jsonCtx) {

        HttpURLConnection connection = null;
        OutputStreamWriter out = null;
        InputStream in = null;
        Map<String, String> retMap = new HashMap<>();
        try {
            URL httpUrl = new URL(url);
            connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod(methodType);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            if ("POST".equalsIgnoreCase(methodType)) {
                out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
                out.append(jsonCtx);
                out.flush();
            }
            in = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            bufferedReader.close();
            retMap.put(RET_HTTP_CODE, String.valueOf(connection.getResponseCode()));
            retMap.put(RET_HTTP_MESSAGE, sb.toString());
            return retMap;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                retMap.put(RET_HTTP_CODE, String.valueOf(connection.getResponseCode()));
                retMap.put(RET_HTTP_MESSAGE, "{'retCode':'通讯异常','retReason': '" + e.getMessage() + "'}");
            } catch (Exception e1) {
                retMap.put(RET_HTTP_CODE, "NULL");
                retMap.put(RET_HTTP_MESSAGE, "{'retCode':'通讯异常','retReason': '" + e.getMessage() + "'}");
            }
            return retMap;
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                retMap.put(RET_HTTP_CODE, "NULL");
                retMap.put(RET_HTTP_MESSAGE, "{'retCode':'通讯异常','retReason': '" + e2.getMessage() + "'}");
                return retMap;
            }
        }
    }
}