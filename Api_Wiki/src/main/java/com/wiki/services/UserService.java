package com.wiki.services;

import com.wiki.entities.Item_wiki;
import com.wiki.entities.Users;
import com.wiki.entities.Version_wiki;
import com.wiki.repository.UserRepository;
import com.wiki.repository.VersionWikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findByTypeNot("admin");
    }

    public Users updateUserType(Long id, Users user) {
        Users userbyid = userRepository.findById(id).orElse(null);

        if (userbyid != null) {
            userbyid.setType(user.getType());
            return userRepository.save(userbyid);
        }
        return null;
    }
    public Users getUserbyemail(String email)
    {
        return userRepository.findByEmail(email);
    }
    public Users getUserbyusername(String username)
    {
        return userRepository.findByUsername(username);
    }
    public Users getUserbyid(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public Users signin (Users user)
    {
        Users authuser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return authuser;
    }

    public Users signup (Users user)
    {
        return userRepository.save(user);
    }
}
