package html.to.json.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mhesmkhani on 3/14/2021.
 */
@RestController
@RequestMapping(path = "/api")
public class ConverterController {
    @PostMapping(path = "/converter")
    public ResponseEntity<Map> InsertHtml(HttpServletRequest request) throws Exception {
        try {
            final String HTML = request.getParameter("code");
            Document document = Jsoup.parse(HTML);
            Element table = document.select("table").first();
            String arrayName = "result";
            Map jsonObj = new HashMap();
            Map jsonArr = new HashMap();
            Map jo = new HashMap();
            Elements ttls = table.getElementsByClass("ttl");
            Elements nfos = table.getElementsByClass("nfo");
            for (int i = 0, l = ttls.size(); i < l; i++) {
                String key = ttls.get(i).text();
                String value = nfos.get(i).text();
                jo.put(key, value);
            }
            jsonArr.put("data",jo);
            jsonObj.put(arrayName, jsonArr);
            return ResponseEntity.status(200).body(jsonObj);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
