import java.util.*;

/*
Output: 
sh-4.3$ java TreeMapDemo
Ayan: 2000
Daisy: 50.0
Mahnaz: 100.0
Qadir: -20.0
Zara: 3000.0
*/
public class TreeMapDemo1 {
    private static void TreeMapDemo1(){
      // Create a hash map
      TreeMap tm = new TreeMap();
      // Put elements to the map
      tm.put("Zara", new Double(3000));
      tm.put("Mahnaz", new Double(100));
      tm.put("Ayan", new Double(2000));
      tm.put("Daisy", new Double(50));
      tm.put("Qadir", new Double(-20));
      
      Set set = tm.entrySet();
      Iterator i = set.iterator();
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.println(me.getKey() + ": " + me.getValue());
      }
    }
    
   public static void main(String args[]) {
      TreeMapDemo1();
   }
}