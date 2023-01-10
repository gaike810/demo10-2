package com.example.demo.util;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class HttpUtils {

    private static final String ENCODING = "UTF-8";
    private static int requestGetCount = 0;

    /**
     * GET查询接口
     *
     * @param jsonInfo
     * @return
     * @throws Exception
     */
    public static String httpGetRequest(String getUrl, Map<String, Object> jsonInfo) {
        String result = "";
        BufferedReader bufferedReader = null;
        String urlNameString = getUrl;
        HttpURLConnection connection = null;
        requestGetCount++;
        try {
            StringBuilder postData = new StringBuilder();
            if (jsonInfo != null) {
                for (Map.Entry<String, Object> param : jsonInfo.entrySet()) {
                    if (postData.length() != 0) {
                        postData.append('&');
                    }
                    postData.append(param.getKey());
                    postData.append('=');
                    postData.append(String.valueOf(param.getValue()));
                }
                urlNameString = getUrl + "?" + postData;
            }

            URL realUrl = new URL(urlNameString);
            connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                bufferedReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                connection.disconnect();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


    public static String sendPost2(String requestUrl, String params) throws MyException {
        HttpClient httpClient = new HttpClient();// 客户端实例化
        PostMethod postMethod = new PostMethod(requestUrl);
        String result = null;
        try {
            byte[] requestBytes = params.getBytes("utf-8"); // 将参数转为二进制流
            postMethod.setRequestHeader("Content-Type", "application/json");
            Credentials credentials = new UsernamePasswordCredentials("huida", "xs123456");
            httpClient.getState().setCredentials(AuthScope.ANY, credentials);
            InputStream inputStream = new ByteArrayInputStream(requestBytes, 0, requestBytes.length);
            RequestEntity requestEntity = new InputStreamRequestEntity(inputStream, requestBytes.length, "application/json; charset=utf-8"); // 请求体
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);// 执行请求

            InputStream soapResponseStream = postMethod.getResponseBodyAsStream();// 获取返回的流
            byte[] datas = readInputStream(soapResponseStream);// 从输入流中读取数据
            result = new String(datas, "UTF-8");// 将二进制流转为String
            // 打印返回结果
            System.out.println("查询成功--------" + result + DateUtils.currentStringTime());
        } catch (Exception e) {
            System.out.println("httpPost异常------------" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }

}
