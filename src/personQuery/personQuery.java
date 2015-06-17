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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
            System.out.println("connection" + connection);
            statement = connection.createStatement();
            System.out.println("statement" + statement);
            statement.execute("CREATE TABLE person(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1), first_name varchar(55), last_name varchar(55),  PRIMARY KEY (id) )");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionConf.getConnection();
            //System.out.println("connection" +connection);
            preparedStatement = connection.prepareStatement("INSERT INTO person (first_name,last_name) VALUES (?,?)");
            //System.out.println("statement"+preparedStatement);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("Inserted");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Person selectById(int id) {
        Person person = new Person();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = connectionConf.getConnection();
            //System.out.println("connection" +connection);
            preparedStatement = connection.prepareStatement("SELECT  * FROM  person where id = ?");
            //System.out.println("statement"+preparedStatement);
            preparedStatement.setInt(1, id);
            //preparedStatement.setString(2, person.getLastName());
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
            }

            System.out.println("Selected");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }

    @Override
    public List<Person> selectAll() {
        List<Person> persons = new ArrayList<Person>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = connectionConf.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM person");

            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));

                persons.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return persons;

    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionConf.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Person person, int id) {
        //List<Person> persons = new ArrayList<Person>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //ResultSet rs =null;

        try {
            connection = connectionConf.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE person SET first_name = ?,last_name = ? WHERE id =?");

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Updated");
    }

}
