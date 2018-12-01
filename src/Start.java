import java.util.HashMap;
import java.util.Map;

public class Start {
    public static void main(String[] args) {
       Map<String, String> map = new CustomHashMap();
       map.put("aa","aaa");
       System.out.println(map.get("aa"));
        map.put("aab","aab");
        System.out.println(map.get("aab"));
        System.out.println(map.get("aa"));
        map.put("aa","bbb");
        System.out.println(map.get("aa"));
    }
}
