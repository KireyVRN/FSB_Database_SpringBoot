package ru.kireev.FSB_Database_SpringBoot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kireev.FSB_Database_SpringBoot.entities.Role;
import ru.kireev.FSB_Database_SpringBoot.entities.User;
import ru.kireev.FSB_Database_SpringBoot.repository.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
//@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);



    public void addNewUser(User user) {

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(Role.USER);
        userRepository.saveAndFlush(user);
    }

    public boolean suchUserExists(User user) {
       return userRepository.findByLogin(user.getLogin()).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Такого пользователя не существует"));

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                transferRolesToAuthorities(Arrays.asList(user.getRole())));
    }

    private Collection<? extends GrantedAuthority> transferRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.name())).collect(Collectors.toList());
    }
}
