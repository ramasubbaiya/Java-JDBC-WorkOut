
import Connection.connectionConf;
import Person.Person;
import java.sql.Connection;
import java.util.List;
import personQuery.personQuery;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author c0652863
 */
public class App {
    
    public static void main(String[] args) {

        
       personQuery pq = new personQuery();
       //Create a table
//       pq.createPersonTable();

        //Insert a new record
//        Person person = new Person("ram","Adaikkalam");
//        pq.insert(person);
      
       
        //Select by id
        //Person person = pq.selectById(3);
        //System.out.println(person.getId()+"\t"+person.getFirstName()+"\t"+person.getLastName());
        
       
       //Select All
        List<Person> persons = pq.selectAll();
        for(Person person:persons){
            System.out.println(person.getId()+", "+person.getFirstName()+", "+person.getLastName()+"");
       }
        
        //To delete
//       pq.delete(1);
        
        //to Update
//       Person person = new Person("Antony","nimya");
//       pq.update(person, 2);
    }
}
