package ybb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsoupTest2 {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://www.chazhongzhi.cn:8080/jeecg-boot/major/getAll");
        CloseableHttpResponse response = null;
        DBOperation op = new DBOperation();
        try {
            op.init();
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            JSONObject jSONObject = JSONObject.parseObject(EntityUtils.toString(responseEntity));
            JSONArray data = (JSONArray)jSONObject.get("data");
            List<STVMajorType> list = JSON.parseArray(data.toJSONString(), STVMajorType.class);
            for(STVMajorType sTVMajorType: list){
                System.out.println(sTVMajorType.getCgName());
                for(STVMajor sTVMajor : sTVMajorType.getMajor()){
                    Thread.sleep(3000);
                    UrlEncodedFormEntity formEctity = new UrlEncodedFormEntity(Arrays.asList(new BasicNameValuePair("id",String.valueOf(sTVMajor.getId()))), Consts.UTF_8);
                    HttpPost majorPost = new HttpPost("http://www.chazhongzhi.cn:8080/jeecg-boot/major/majorInfo");
                    majorPost.setEntity(formEctity);
                    HttpEntity responseMaorEntity = httpClient.execute(majorPost).getEntity();
                    Major major = JSONObject.parseObject(EntityUtils.toString(responseMaorEntity)).getJSONObject("data").getObject("major",Major.class);
                    op.execSql("INSERT INTO z_zz(cgName, mjName, mjInfo, learningContent, prospects, workDirection, workPost) VALUES " +
                            "('"+sTVMajorType.getCgName()+"', '"+sTVMajor.getMjName()+"', '"+stripHtml(major.getMjInfo())+"', '"+major.getLearningContent()+"', '"+major.getProspects()+"', '"+major.getWorkDirection()+"', '"+major.getWorkPost()+"')");

                }
            }
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
                op.destory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static String stripHtml(String content) {
        // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "");
        // <br><br/>替换为换行
        content = content.replaceAll("<br\\s*/?>", "");
        // 去掉其它的<>之间的东西
        content = content.replaceAll("\\<.*?>", "");
        // 还原HTML
        // content = HTMLDecoder.decode(content);
        return content;
    }

}
