package html.to.json.pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mhesmkhani on 3/14/2021.
 */
public class Pattern {
    public ResponseEntity <String>ConvertToJson(String inputUrl) throws Exception {
        try {
            String url = inputUrl;
            return ResponseEntity.status(200).body(Algorithm.getJSON(url));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(200).body("encoding unset");
        }
    }

    public ResponseEntity<Map>ConvertTablesToJson(String html) throws Exception {
        try {
            final String HTML = html;
            Document document = Jsoup.parse(HTML);
            Elements table = document.select("table");
            Elements row = table.select("tr");
            Map map = new HashMap();
            for (int j = 0; j < row.size();  j++) {
                Elements cols = row.eq(j).select("td");
                String key = cols.get(0).text();
                String value = cols.get(1).text();
                map.put(key,value);
            }
            return ResponseEntity.status(200).body(map);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
