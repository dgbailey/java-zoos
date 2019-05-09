package com.lambdaschool.zoos;

//import com.lambdaschool.zoos.model.Quote;
import com.lambdaschool.zoos.model.Role;
import com.lambdaschool.zoos.model.User;
import com.lambdaschool.zoos.model.UserRoles;
import com.lambdaschool.zoos.repos.RoleRepository;
import com.lambdaschool.zoos.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u2 = new User("admin", "password", admins);
        userrepos.save(u2);
    }
}
