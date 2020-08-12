package ybb;

public class RPCTest {

    public static void main(String[] args ){
       /** CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:6300/middle/question/countInterestScore");
        httpPost.addHeader("wx-req","admin");
        httpPost.addHeader("content-type", "application/json;charset=utf-8");
        CloseableHttpResponse response = null;

        String ss= "100001913105132,100000900906081,100000174191979,100002012956606,100001174909924,100001869059025,100001542308322";


        try {
           // List<NameValuePair> paramList = new ArrayList<>();
           //paramList.add(new BasicNameValuePair("id",""));
           //UrlEncodedFormEntity formEctity = new UrlEncodedFormEntity(paramList, Consts.UTF_8);
           //httpPost.setEntity(formEctity);
            String[] split = ss.split(",");
            System.out.println(split.length);
            for (String userId : split){
                String json = "{\"flag\":0,\"questionnaireSchoolId\":1594607971,\"userId\":"+userId+"}";
                httpPost.setEntity(new StringEntity(json, Charset.forName("utf-8")));
                response = httpClient.execute(httpPost);
                HttpEntity responseEntity = response.getEntity();
                JSONObject jSONObject = JSONObject.parseObject(EntityUtils.toString(responseEntity));
                System.out.println(jSONObject);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }**/
    }
}
