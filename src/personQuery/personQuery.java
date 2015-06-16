/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personQuery;

import Connection.connectionConf;
import Person.Person;
import PersonDetails.PersonDetails;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author c0652863
 */
public class personQuery implements PersonDetails {

    @Override
    public void createPersonTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connectionConf.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person(id int primary key unique auto increment, first_name varchar(55), last_name varchar(55) )");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void insert(Person person) {
    }

    @Override
    public Person selectById(int id) {
        return null;
    }

    @Override
    public List<Person> selectAll() {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(int id) {
    }

}
