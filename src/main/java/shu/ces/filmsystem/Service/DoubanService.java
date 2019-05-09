package shu.ces.filmsystem.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import shu.ces.filmsystem.Model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoubanService {

    public HashMap<String,Integer> getName_IDMap(String JSONString){
        /**
         * @param: json string
         * @return: map with filmId and film name.
         */
        HashMap<String,Integer> resultMap = new HashMap<String,Integer>();
        Map<String,Object> jsonMap = (Map) JSONObject.parse(JSONString);
        String data = jsonMap.get("subjects").toString();
        JSONArray resultArray = JSON.parseArray(data);
        for (int i= 0; i < resultArray.size(); i++ ){
            Map<String,Object> filmMap = (Map) JSONObject.parse(resultArray.get(i).toString());
            System.out.println(filmMap.get("title") + " " + filmMap.get("id"));
            resultMap.put((String)filmMap.get("title"), Integer.parseInt((String)filmMap.get("id")));
        }
        return resultMap;
    }

    public ArrayList<Film> FilmArray(String JSONString){
        /** TODO
         * @param: json string
         * @return: film array
         */
        ArrayList<Film> list = new ArrayList<>();
        Map<String,Object> jsonMap = (Map) JSONObject.parse(JSONString);
        String data = jsonMap.get("subjects").toString();
        JSONArray resultArray = JSON.parseArray(data);
        for (int i= 0; i < resultArray.size(); i++ ){
            Map<String,Object> filmMap = (Map) JSONObject.parse(resultArray.get(i).toString());
            System.out.println(filmMap.get("title") + " " + filmMap.get("id"));
            //resultMap.put((String)filmMap.get("title"), Integer.parseInt((String)filmMap.get("id")));
            Film film = new Film();
            film.setId(Integer.parseInt((String)filmMap.get("id")));
            film.setName((String)filmMap.get("title"));

        }
        return list;
    }
}
