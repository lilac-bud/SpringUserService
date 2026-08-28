package io.github.lilacbud.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    
    @Override
    public String toString() {
        return String.format("User ID: %d Name: %s Email: %s Age: %d", id, name, email, age);
    }
}
