package shu.ces.filmsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import shu.ces.filmsystem.Service.HttpClient;

import java.util.Map;

@RestController
public class HelloWorld {

    @Autowired
    HttpClient httpClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        String url = "https://api.douban.com/v2/movie/in_theaters";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url, method, params);
    }

    @RequestMapping(value = "/filminfo", method = RequestMethod.GET)
    public void getTop20(){
        Object json01 = JSONObject.parse(hello());
//将返回的jsonObj强转为一个Map集合
        Map<String,Object> jsonmap = (Map) json01;
        String data = jsonmap.get("subjects").toString();
//json格式字符串转数组
        JSONArray bookinfos = JSON.parseArray(data);
        for (int i= 0;i<bookinfos.size();i++ ){
            Object json02 = JSONObject.parse(bookinfos.get(i).toString());
            Map<String,Object> jsonmap02 = (Map) json02;
            System.out.println(jsonmap02.get("title"));
        }
    }
}
