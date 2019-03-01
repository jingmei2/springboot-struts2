package com.zfsoft.zftal.model;/**
 * Created by  Administrator on 2019-03-01 03:39 PM
 */

/**
 * @program: demo
 *
 * @description: User Demo
 *
 * @author: Majing
 *
 * @create: 2019-03-01 15:39
 **/
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    public User(Integer id, String firstName, String lastName, String age,
                String gender) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
