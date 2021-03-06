package com.johncrisanto.courseregsystem.user;

public class CourseRegSystemUser {

//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String username;

//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String password;

//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String matchingPassword;

//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String firstName;

//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String lastName;

//    @ValidEmail
//    @NotNull(message = "is required")
//    @Size(min = 1, message = "is required")
    private String email;

    public CourseRegSystemUser() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
