package html.to.json.controller;

import html.to.json.pattern.Pattern;
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
public class ConverterController extends Pattern{
    @PostMapping(path = "/converter")
    public ResponseEntity<Map> InsertHtml(HttpServletRequest request) throws Exception {
        try {
            Pattern pattern = new Pattern();
         return  pattern.AddClassToTag(request.getParameter("code"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
