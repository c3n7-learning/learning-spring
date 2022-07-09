package tech.c3n7.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
    }

    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING SILLY STUFF: ADDING A SILLY THING");

        return true;
    }
}
