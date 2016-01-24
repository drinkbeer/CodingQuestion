/*
Call Center. Call center has three levels of employees: respondent, manager, and director. An incoming telephone call must be first allocated to a respondent who is free. If the respondent cannot handle the call, must escalate the call to manager. If the manager is not free, escalate to director.
Design the classes and data structures. Implement a method dispatchCall(), which assigns a call to the first available employee.

Analysis:
Employee
    attribute: id, name, 
    action: getId(), getName(), response(), isAvailable(), escalate()

Respondent
    
Manager
    
Director
    
Call:
    attr: phone number, response id
    action: start(), end(), record()

CallCenter:
    attr: int id, Queue<Call> queue, List<Respondent>, List<Manager>, List<Director>
    action: dispatchCall()
*/

public class CallCenter{
    public int id;
    Queue<Call> queue = new LinkedList<Call>();
    int size;
    List<Respondent> respondents = new LinkedList<Respondent>();
    List<Manager> managers = new LinkedList<Manager>();
    List<Director> directors = new LinkedList<Director>();

    public CallCenter(){...}

    public int getId(){return id;}
    public void addCall(Call c){
        queue.offer(c);
        size++;
    }
    public Call removeCall(){
        if(size > 0){
            queue.poll();
            size--;
        }
    }

    public boolean registerRespondent(Respondent r){
        this.respondents.add(r);
        return true;
    }

    public boolean registerManager(Manager m){
        this.managers.add(m);
        return true;
    }

    public boolean registerDirector(Director d){
        this.directors.add(d);
        return true;
    }

    public boolean dispatchCall(){
        while(!queue.isEmpty()){
            //find a employee who is available now
            Employee e = null;
            for(Respondent r : respondents){
                if(r.isAvailable){
                    e = (Employee)r;
                }
            }
            if(e == null) {
                for(Manager m : managers){
                    if(m.isAvailable) e = (Employee)m;
                }
            }
            if(e == null){
                for(Director d : directors){
                    if(d.isAvailable) e = (Employee)d;
                }
            }
            if(e == null) return false;
            Call c = queue.poll();
            r.response(c);
        }
    }
}

public class Call{
    public long phoneNum;

    public Call(){...}

    public long getPhoneNum(){return phoneNum;}
    public void setPhoneNum(long phoneNum){phoneNum = phoneNum;}
    public void start(){...}
    public void end(){...}
    public void record(){...}

}

public abstract class Employee{
    protected int id;
    protected int name;

    public int getId(){return id;}
    public int getName(return name;)
    public void setName(String name){name = name;}
    public abstract boolean escalate();     //implement by children class
    public void response(Call call){...}
}
public class Respondent extends Employee{

    public boolean isAvailable(){...}
    public boolean escalate(){...}  //If one respondent a call, but he/she cannot handle it, he will escalate to a manager
}
public class Manager extends Employee{

    public boolean isAcailable(){...}
    public boolean escalate(){...}  //if one manager cannot handle a call, escalate to a director

}
public class Director extends Employee{
    public boolean isAcailable(){...}
}
