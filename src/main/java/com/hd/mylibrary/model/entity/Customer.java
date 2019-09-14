package com.hd.mylibrary.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
@AttributeOverride(name = "id", column = @Column(name = "CUSTOMER_ID"))
public class Customer extends BaseEntity {

    @NotEmpty(message = "Firstname can not be empty.")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @NotEmpty(message = "Surname can not be empty")
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @NotEmpty
    @Min(value = 18, message = "Age can not be less than 18.")
    @Column(name = "AGE", nullable = false)
    private int age;

    @NotEmpty
    @Email(message = "Wrong Email.")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotEmpty(message = "Phone can not be empty.")
    @Pattern(regexp = "[0-9\\s]{12}", message = "Phone format wrong.")
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @NotEmpty(message = "Address can not be empty.")
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonIgnore
    private Set<Book> books;


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                firstName.equals(customer.firstName) &&
                surname.equals(customer.surname) &&
                email.equals(customer.email) &&
                phone.equals(customer.phone) &&
                address.equals(customer.address) &&
                books.equals(customer.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, age, email, phone, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", book=" + books +
                '}';
    }
}
