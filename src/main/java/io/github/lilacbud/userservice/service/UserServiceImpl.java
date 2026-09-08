package io.github.lilacbud.userservice.service;

import io.github.lilacbud.userservice.dto.UserDTO;
import io.github.lilacbud.userservice.mappers.UserMapper;
import io.github.lilacbud.userservice.model.User;
import io.github.lilacbud.userservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    
    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id) {
        return mapper.mapToUserDTO(repository.findById(id).orElseThrow(() 
                -> new EntityNotFoundException("Failed to find user")));
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO dto) {
        return mapper.mapToUserDTO(repository.save(mapper.mapToUserEntity(dto)));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Failed to find user"));
        return mapper.mapToUserDTO(repository.save(mapper.mapToUserEntity(dto, user)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {
        List<UserDTO> resultList = new ArrayList<>();
        repository.findAll().forEach(user -> resultList.add(mapper.mapToUserDTO(user)));
        return resultList;
    }

    @Override
    @Transactional
    public void deleteAllUsers() {
        repository.deleteAll();
    } 
}
