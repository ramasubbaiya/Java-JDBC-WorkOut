/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PersonDetails;

import Person.Person;
import java.util.List;

/**
 *
 * @author c0652863
 */
public interface PersonDetails {
    
    void createPersonTable();
    
    void insert(Person person);
    
    Person selectById(int id);
    
    List<Person> selectAll();
    
    void delete(int id);
    
    void update(int id);
}
