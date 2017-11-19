package encrpy;

import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * Created by wsylp on 2017/6/26.
 */
public class HttpUtil {
    private static CloseableHttpClient httpclient = null;

    private static IdleConnectionMonitorThread scanThread = null;

    /**
     * 初始化client对象.
     */
    public static void init() {

        // 连接池设置
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(20); // 最多20个连接
        cm.setDefaultMaxPerRoute(20); // 每个路由20个连接

        // 创建client对象
        httpclient = HttpClients.custom().setConnectionManager(cm).build();

        // 扫描无效连接的线程
        scanThread = new IdleConnectionMonitorThread(cm);
        scanThread.start();
    }

    /**
     * 关闭连接池.
     */
    public static void close() {
        if (httpclient != null) {
            try {
                httpclient.close();
            } catch (IOException e) {
            }
        }
        if (scanThread != null) {
            scanThread.shutdown();
        }
    }

    /**
     * Get方式取得URL的内容.
     *
     * @param url
     *            访问的网址
     * @return
     */
    public static String getUrlContent(String url) {

        // 参数检查
        if (httpclient == null) {
            throw new RuntimeException("httpclient not init.");
        }
        if (url == null || url.trim().length() == 0) {
            throw new RuntimeException("url is blank.");
        }

        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {

            // 执行请求
            response = httpclient.execute(httpGet, HttpClientContext.create());

            // 转换结果
            HttpEntity entity1 = response.getEntity();
            String html = EntityUtils.toString(entity1);

            // 消费掉内容
            EntityUtils.consume(entity1);
            return html;
        } catch (IOException e) {

            return "";
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
            httpGet.releaseConnection();
        }
    }

    /**
     * Post方式取得URL的内容，默认为"application/x-www-form-urlencoded"格式，charset为UTF-8.
     *
     * @param url
     *            访问的网址
     * @param content
     *            提交的数据
     * @return
     */
    public static String postToUrl(String url, String content) {
        return postToUrl(url, content, "application/x-www-form-urlencoded",
            "UTF-8");
    }

    /**
     * json字符串形式请求
     *
     * @param url
     * @param content
     * @return
     */
    public static String postForJson(String url, String content) {
        return postToUrl(url, content, "application/json", "UTF-8");
    }

    /**
     * Post方式取得URL的内容.
     *
     * @param url
     *            访问的网址
     * @param content
     *            提交的数据
     * @return
     */
    public static String postToUrl(String url, String content,
        String contentType, String charset) {

        // 参数检查
        if (httpclient == null) {
            throw new RuntimeException("httpclient not init.");
        }
        if (url == null || url.trim().length() == 0) {
            throw new RuntimeException("url is blank.");
        }

        HttpPost httpPost = new HttpPost(url);

        // 设置内容
        ContentType type = ContentType.create(contentType,
            Charset.forName(charset));
        StringEntity reqEntity = new StringEntity(content, type);
        httpPost.setEntity(reqEntity);
        httpPost.addHeader("User-Agent",
            "Mozilla/4.0 (compatible; MSIE .0; Windows NT 6.1; Trident/4.0; SLCC2;)");
        httpPost.addHeader("Accept-Encoding", "*");

        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000).setConnectTimeout(30000).build();
        httpPost.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost, HttpClientContext.create());

            // 转换结果
            HttpEntity entity1 = response.getEntity();
            String html = EntityUtils.toString(entity1, charset);

            // 消费掉内容
            EntityUtils.consume(entity1);
            return html;
        } catch (IOException ex) {
            ex.printStackTrace();
            return "-1";
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                }
            }
            httpPost.releaseConnection();
        }
    }

    public static void main(String[] args) {
        HttpUtil.init();
        long a = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            String html = postForJson("https://www.baidu.com/",
                "{\"frm\":\"frm\",\"ipcc\":\"ipcc\"}");
            System.out.println(html.length());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(System.currentTimeMillis() - a);
        HttpUtil.close();

    }
}
