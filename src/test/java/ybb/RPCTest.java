package ybb;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.XmlRpcClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RPCTest {

    private static String appkey="0d9c75516dbb8808a81776e2653518e1";
    private static String appsec="11f94d1e8e33d3869c24316130d9bf12";

    public static void main(String[] args ){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://222.66.156.245:8119/dec/api/");
        CloseableHttpResponse response = null;
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try {
            String key = DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex((appkey+time).getBytes())+appsec).getBytes());

            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("id",""));

            UrlEncodedFormEntity formEctity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
            httpPost.setEntity(formEctity);
            response = httpClient.execute(httpPost);
         HttpEntity responseEntity = response.getEntity();
         JSONObject jSONObject = JSONObject.parseObject(EntityUtils.toString(responseEntity));
         System.out.println(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
