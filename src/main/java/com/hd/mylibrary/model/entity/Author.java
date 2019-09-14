package com.hd.mylibrary.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@AttributeOverride(name = "id", column = @Column(name = "AUTHOR_ID"))
public class Author extends BaseEntity {

    @NotEmpty(message = "Firstname can not be empty.")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @NotEmpty(message = "Surname can not be empty")
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @NotEmpty
    @Email(message = "Wrong Email.")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Min(value = 18, message = "Age can not be less than 18.")
    @Column(name = "AGE", nullable = false)
    private int age;


    @OneToMany(mappedBy = "author")
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
        Author author = (Author) o;
        return age == author.age &&
                firstName.equals(author.firstName) &&
                surname.equals(author.surname) &&
                email.equals(author.email) &&
                books.equals(author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, email, age, books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }
}
