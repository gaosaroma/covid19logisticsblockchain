package tjsse20.covid19logisticsblockchain.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class HTTPUtil {
    public static String request(String jscode){
        RestTemplate restTemplate=new RestTemplate();
        String url="https://api.weixin.qq.com/sns/jscode2session?appid=wxe536ed00a8c2ecdc&secret=b0ca85f15ede880bc5ad970441974fa5&js_code=" + jscode + "&grant_type=authorization_code";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String strbody=restTemplate.exchange(url, HttpMethod.GET, entity,String.class).getBody();
        JSONObject result = JSONObject.parseObject(strbody);
        return result.getString("openid");
    }
}
