package Test;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by yexiaoxin on 2017/9/12.
 */
public class TestHttpClient {
    public static  void get(int i) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("https://www.eclipse.org/downloads/");
            //System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            System.out.println("0:"+i);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");

                // 打印响应状态
                //System.out.println(response.getStatusLine());
                if (entity != null) {
//                    // 打印响应内容长度
//                    System.out.println("Response content length: " + entity.getContentLength());
//                    // 打印响应内容
//                    System.out.println("Response content: " + EntityUtils.toString(entity));
                    //System.out.println(Thread.currentThread().getId());

                }
                System.out.println("1:"+i);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        for(int i=0;i<100;i++){
            final int a = i;
            Thread thread = new Thread(){
                @Override
                public void run() {
                    get(a);
                }
            };
            thread.start();
        }
    }
}
