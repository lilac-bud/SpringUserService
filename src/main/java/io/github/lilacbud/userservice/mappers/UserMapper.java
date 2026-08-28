package io.github.lilacbud.userservice.mappers;

import io.github.lilacbud.userservice.dto.UserDTO;
import io.github.lilacbud.userservice.model.User;

public class UserMapper {
    public User mapToUserEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAge(dto.getAge());
        return entity;
    }
    
    public UserDTO mapToUserDTO(User entity) {
        if (entity == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setAge(entity.getAge());
        return dto;
    }
}
