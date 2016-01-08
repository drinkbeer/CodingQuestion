/*
This class implements each single bucket in HashTable

Each bucket has an id as its key and a process as its value.
*/
public class Bucket{
    public int key;
    public Process value;
    //this boolean is to decide if the bucket has key and value
    //if false, can be deleted
    public boolean live;

    public Bucket(){
        this.live = true;
    }

    //constructer for a bucket with key and value
    public Bucket(Process p){
        this.key = p.getId();
        this.value = p;
        this.lvie = true;
    }

    public int getKey(){
        return this.key;
    }

    public Process getValue(){
        return this.value;
    }

    public boolean getLive(){
        return this.live;
    }

    public void setLive(boolean b){
        this.live = b;
    }

    //check if two buckets are the same based on name and live
    public boolean isSame(Bucket b){
        if(b == null) return false;
        if(this.value.getName().equals(b.getValue().getName()) && this.live == b.getLive()) return true;
        else return false;
    }

    //check if two buckets are the same based on key and value
    public boolean equals(Bucket b){
        if(b == null) return false;
        if(this.key == b.getKey() && this.value.equals(b.getValue()) && this.live == b.getLive()) return true;
        else return false;
    }
}