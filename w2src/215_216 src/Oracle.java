/*
file: src/java/Oracle.java
 */
import java.util.ArrayList;
import java.util.List;

public class Oracle {
    //
    public List<String> bestProducts(String type){
        List<String> list = new ArrayList<>();
        if(type.equals("sweet_milk_sauce_html")){
            list.add("VIcosa");
            list.add("Boreal");
        }else if(type.equals("cheese")){
            list.add("Candido Tostes");
            list.add("Humaita");
            list.add("O da minha Tia Totonia");
        }
        return list;
    }
    
}
