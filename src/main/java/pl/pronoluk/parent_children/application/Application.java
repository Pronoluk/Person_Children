package pl.pronoluk.parent_children.application;

import pl.pronoluk.parent_children.config.Configuration;
import pl.pronoluk.parent_children.dao.PersonDao;
import pl.pronoluk.parent_children.dao.PersonDaoImpl;
import pl.pronoluk.parent_children.model.AdultOrChild;
import pl.pronoluk.parent_children.model.Person;
import pl.pronoluk.parent_children.service.PersonService;
import pl.pronoluk.parent_children.service.PersonServiceImpl;
import pl.pronoluk.parent_children.service.WelcomeService;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {

        Connection dbConnection = Configuration.getInstance().getDbConnection();

        PersonDao databaseDao = new PersonDaoImpl(dbConnection);
        PersonService personService = new PersonServiceImpl(databaseDao);

        WelcomeService welcomeService = new WelcomeService(WelcomeService.EN_LANG);

        Person p1 = new Person("Slawek","Peszko",45,AdultOrChild.ADULT);
        Person p2 = new Person("Helena","Peszko",18,AdultOrChild.ADULT);

        Person p3 = new Person("Robert","Lewandowski",30,AdultOrChild.ADULT);
        Person p4 = new Person ("Ania","Lewandowska",30,AdultOrChild.ADULT);
        Person p5 = new Person("Klara","Lewandowska",1,AdultOrChild.CHILD);
        Person p6 = new Person("Adam","Lewandowski",0,AdultOrChild.CHILD);

        p3.addChild(p5);
        p3.addChild(p6);
        p4.addChild(p5);
        p4.addChild(p6);

        System.out.println("Trying to save persons to database");

        personService.savePerson(p1);
        personService.savePerson(p2);
        personService.savePerson(p3);
        personService.savePerson(p4);

        System.out.println("Reading persons from db");
        System.out.println(personService.getAllPersons());

    }
}
