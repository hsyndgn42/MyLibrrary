package com.hd.mylibrary.model.request;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class CreateCustomerRequest implements Serializable {

    private static final long serialVersionUID = 6259906250940426693L;

    @Valid
    @NotNull(message = "Name can not be null")
    private String firstName;

    @Valid
    @NotNull(message = "Surname can not be null")
    private String surname;

    @Valid
    @NotNull(message = "Age can not be null")
    private int age;

    @Valid
    @NotNull(message = "Email can not be null")
    @Email
    private String email;

    @Valid
    @NotNull(message = "Phone can not be null")
    @Pattern(regexp = "[0-9\\s]{12}", message = "Phone format wrong.")
    private String phone;

    @Valid
    @NotNull(message = "Address can not be null")
    private String address;

    @Valid
    @NotNull(message = "Book can not be null")
    private Set<Long> bookIds;

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

    public Set<Long> getBookIds() {
        return bookIds;
    }

    public void setBookId(Set<Long> bookIds) {
        this.bookIds = bookIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCustomerRequest that = (CreateCustomerRequest) o;
        return age == that.age &&
                firstName.equals(that.firstName) &&
                surname.equals(that.surname) &&
                email.equals(that.email) &&
                phone.equals(that.phone) &&
                address.equals(that.address) &&
                bookIds.equals(that.bookIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, age, email, phone, address, bookIds);
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", bookId=" + bookIds +
                '}';
    }
}
