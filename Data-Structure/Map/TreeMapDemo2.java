
/*
sh-4.3$ java -Xmx128M -Xms16M HelloWorld
black dog - 15
yellow dog - 20
red dog - 10
white dog - 5
*/

class Dog implements Comparable<Dog>{
    String color;
    int size;
 
    public Dog(String c, int s) {
        color = c;
        size = s;
    }
    public boolean equals(Object o) {
        return ((Dog) o).color.equals(this.color);
    }
 
    public int hashCode() {
        return color.length();
    }
    
    public String toString(){   
        return color + " dog";
    }
    
    public int compareTo(Dog dog){
        return dog.size - this.size;
    }
}

public class TreeMapDemo2{
    
     public static void main(String []args){
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 90);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("yellow", 50);
 
        java.util.TreeMap<Dog, Integer> treeMap = new java.util.TreeMap<Dog, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
 
        for (java.util.Map.Entry<Dog, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
     }
}
