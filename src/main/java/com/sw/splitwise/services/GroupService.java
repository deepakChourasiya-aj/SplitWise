package com.sw.splitwise.services;

import com.sw.splitwise.models.Group;
import com.sw.splitwise.models.User;
import com.sw.splitwise.repositories.GroupRepository;
import com.sw.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {
    public GroupRepository groupRepository;
    public UserRepository userRepository;

    public GroupService(GroupRepository groupRepository,UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createNewGroup(String name, Long userId){
        Optional<Group> OptionalGroup = groupRepository.findByName(name);
        if(OptionalGroup.isPresent()){
            throw new RuntimeException("Group already exists with name: " + name + " use some other name.");
        }

        Optional<User> OptionalUser = userRepository.findById(userId);

        if(OptionalUser.isEmpty()){
            throw new RuntimeException("User does not exist with id: " + userId + " use some other id.");
        }

        User user = OptionalUser.get();

        Group group = new Group();
        group.setName(name);
        group.setCreatedBy(user);

        return groupRepository.save(group);

    }


}
