package com.vic.sb15.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 自定义端点-注解方式
 * @author victor
 * date: 2020/11/18 18:02
 */
@Endpoint(id = "person") // person 为端点ID
@Component
public class PersonEndpoint {

    private final Map<String, Person> personMap = new HashMap<>();

    PersonEndpoint() {
        this.personMap.put("mike", new Person("Michael Redlich"));
        this.personMap.put("rowena", new Person("Rowena Redlich"));
        this.personMap.put("barry", new Person("Barry Burd"));
    }

    // 对应get请求
    @ReadOperation
    public List<Person> getAll() {
        return new ArrayList<>(this.personMap.values());
    }

    /**
     * 对应person/{name}
     * 对应get请求
     * @param person
     * @return
     */
    @ReadOperation
    public Person getPerson(@Selector String person) {
        return this.personMap.get(person);
    }

    // 对应post请求
    @WriteOperation
    public void updatePerson(@Selector String name, String person) {
        this.personMap.put(name, new Person(person));
    }

    public static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
