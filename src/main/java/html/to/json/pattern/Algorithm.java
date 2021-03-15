package html.to.json.pattern;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by mhesmkhani on 3/14/2021.
 */
public class Algorithm {
    public Algorithm(){}

    private static boolean ENABLE_JAVASCRIPT = false;

    public static String special_sanitizer(String html){
        html = html.replaceAll("<g:plusone>(?:.+?)?<\\/g:plusone>","");
        html = html.replaceAll("\"title","\" title");
        return html;
    }

    public static String sanitize_html(String html){
        html = html.replaceAll("(?:<!.+?>)","");

        html = html.replaceAll("(?<!\\\\)\"", "\\\\\"");
        if(!ENABLE_JAVASCRIPT)
            html = html.replaceAll("<script(?:.+?)<\\/script>","");
        html = special_sanitizer(html);
        html = "<div id='html_wrap'>"+html+"</div>";

        return html;
    }

    public static String getJSON(String url){
        String[] scripts = {"./scripts/html2json.js", "./scripts/htmlparser.js", "./scripts/main.js",  "./scripts/jumpcall.js"};

        @SuppressWarnings("serial")
        Map<String, Object> script_params = new HashMap<String, Object>(){{
            put("html", sanitize_html( new HttpRequest(false).send(HttpRequest.GET_METHOD, url, null).get(1)) );
        }};

        return (String)((String[]) new JSEngine(scripts, script_params).run())[0];
    }
}