package html.to.json.controller;
import html.to.json.pattern.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * Created by mhesmkhani on 3/14/2021.
 */
@RestController
@RequestMapping(path = "/api")
public class ConverterController extends Pattern{
    @PostMapping(path = "/node/convert")
    public ResponseEntity<String> AddUrl(HttpServletRequest request) throws Exception {
        try {
            Pattern pattern = new Pattern();
         return  pattern.ConvertToJson(request.getParameter("url"));

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }
    @PostMapping(path = "/tables/convert")
    public ResponseEntity<Map> ConvertTable(HttpServletRequest request) throws Exception {
        try {
            Pattern pattern = new Pattern();
            return  pattern.ConvertTablesToJson(request.getParameter("code"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
