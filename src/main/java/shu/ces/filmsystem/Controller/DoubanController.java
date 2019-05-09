package shu.ces.filmsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shu.ces.filmsystem.Service.DoubanService;
import shu.ces.filmsystem.Service.HttpClient;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DoubanController {
    @Autowired
    HttpClient httpClient;

    private String getJSONString(String url){
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        return httpClient.client(url, method, params);
    }

    @RequestMapping(value = "/doubanSearchByName", method = RequestMethod.GET)
    public HashMap<String, Integer> searchFilmByName(@RequestParam("name") String name){
        String url = "https://api.douban.com/v2/movie/search?q=" + name + "&start=0";
        return new DoubanService().getName_IDMap(getJSONString(url));
    }
}
