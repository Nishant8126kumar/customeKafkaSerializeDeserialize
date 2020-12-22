package model;

import org.json.JSONObject;

public class User {

    private int age;
    private String name;
    private String contact;

    public User(int age, String name, String contact) {
        this.age = age;
        this.name = name;
        this.contact = contact;
    }

    public User()
    {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return new JSONObject().put("name",this.name)
                .put("age",this.age)
                .put("contact",this.contact).toString();
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
