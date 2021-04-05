package tjsse20.covid19logisticsblockchain.util;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.HttpClientConnection;
import org.apache.http.client.HttpClient;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RiskUtil {
    public static int getRiskLevel(float longitude, float latitude){
        return new Random().nextInt(3);
    }

    public static void getRiskLevel(String province, String city, String district) throws IOException {
//        String code = getCode(province, city, district);
        Connection connection = Jsoup.connect("http://103.66.32.242:8005/zwfwMovePortal/interface/interfaceJson");
        connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
        connection.header("Accept-Encoding", "gzip, deflate");
        connection.header("Connection", "keep-alive");
        connection.header("Content-Length", "256");
        connection.header("Content-Type", "application/json; charset=UTF-8");
        connection.header("Host", "103.66.32.242:8005");
        connection.header("Origin", "http://bmfw.www.gov.cn");
        connection.header("Referer", "http://bmfw.www.gov.cn/");
        connection.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        connection.data("appId", "NcApplication");
        connection.data("area_code", "140107");
        connection.data("key", "2CA32596474B4077834CCC191D351839");
        connection.data("nonceHeader", "123456789abcdefg");
        connection.data("paasHeader", "zdww");
        connection.data("signatureHeader", "23CE9C194A4AEE0A4BCC10BACFC88AF4F25EC0431EFE3B8E50D2C9E4388403F3");
        connection.data("timestampHeader", "1609695271");
        Document result = connection.post();
        System.out.println(result);
    }

    private static String getCode(String province, String city, String district) throws IOException {
        String url_ = "http://www.ip33.com/area_code.html";
        URL url = new URL(url_);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
        InputStream inputStream = conn.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder buffer = new StringBuilder();
        String str = null;
        while ((str = bufferedReader.readLine()) != null){
            buffer.append(str);
        }
        Document document = Jsoup.parse(buffer.toString());
        Elements elements = document.getElementsByClass("ip");
        for (Element element : elements){
            String p = element.getElementsByTag("h4").get(0).val();
            if (p.contains(province)){
                Elements cities = element.getElementsByTag("ul");
                for (Element cityElem : cities){
                    String c = cityElem.getElementsByTag("h5").get(0).val();
                    if (c.contains(city)){
                        Elements districts = cityElem.getElementsByTag("ul");
                        for (Element districtElem: districts){
                            String d = districtElem.val();
                            if (d.contains(district)){
                                return d.split(" ")[1];
                            }
                        }
                    }
                }
            }
        }
        return "120101";
    }

    public static void main(String [] args) throws IOException {
        getRiskLevel("", "","");
    }

    public static int getStaticRiskLevel(String province, String city, String district){
        if ("北京市".contains(province)){
            if ("顺义区".contains(district) || "朝阳区".contains(district)){
                return ConstantDefinition.RISK_TYPE_LOW;
            }
        }
        else if ("辽宁省".contains(province)){
            if ("沈阳市".contains(city)){
                if ("皇姑区".contains(district) || "铁西区".contains(district) || "于洪区".contains(district)){
                    return ConstantDefinition.RISK_TYPE_LOW;
                }
            }
            else if ("大连市".contains(city)){
                if ("金州区".contains(district) || "金普新区".contains(district) || "沙河口区".contains(district) || "高新区".contains(district)){
                    return ConstantDefinition.RISK_TYPE_LOW;
                }
            }
        }
        else if ("黑龙江省".contains(province)){
            if ("黑河市".contains(city)){
                if ("爱辉区".contains(district)){
                    return ConstantDefinition.RISK_TYPE_LOW;
                }
            }
        }
        return ConstantDefinition.RISK_TYPE_NO;
    }
}
