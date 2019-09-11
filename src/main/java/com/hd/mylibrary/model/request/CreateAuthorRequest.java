package com.hd.mylibrary.model.request;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CreateAuthorRequest implements Serializable {

    private static final long serialVersionUID = -229548328174336427L;

    @Valid
    @NotNull(message = "FirstName can not be null")
    private String firstName;

    @Valid
    @NotNull(message = "SurName can not be null")
    private String surname;

    @Valid
    @NotNull(message = "Email can not be null")
    @Email(message = "Email is not valid")
    private String email;

    @Valid
    @NotNull(message = "Age can not be null")
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthorRequest that = (CreateAuthorRequest) o;
        return age == that.age &&
                firstName.equals(that.firstName) &&
                surname.equals(that.surname) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, email, age);
    }

    @Override
    public String toString() {
        return "CreateAuthorRequest{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
