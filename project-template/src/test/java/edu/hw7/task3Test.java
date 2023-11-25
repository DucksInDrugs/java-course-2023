package edu.hw7;

import edu.hw7.task3.CachedService;
import edu.hw7.task3.CachedServiceReadWriteLock;
import edu.hw7.task3.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class task3Test {
    @Test
    public void findBySmthWithEmptyFieldsTest() {
        Person person1 = new Person(1, "Null", null, "515152445");
        Person person2 = new Person(2, "Mbe", null, "54122000");
        Person person3 = new Person(3, "Next", "12388", null);
        Person person4 = new Person(4, "Time", null, "88005553535");

        CachedService service = new CachedService();
        CachedServiceReadWriteLock serviceReadWriteLock = new CachedServiceReadWriteLock();
        service.add(person1);
        service.add(person2);
        service.add(person3);
        service.add(person4);
        serviceReadWriteLock.add(person1);
        serviceReadWriteLock.add(person2);
        serviceReadWriteLock.add(person3);
        serviceReadWriteLock.add(person4);

        assertEquals(0, service.findByAddress("12388").size());
        assertEquals(0, service.findByName("Mbe").size());
        assertEquals(0, service.findByPhone("88005553535").size());

        assertEquals(0, serviceReadWriteLock.findByAddress("12388").size());
        assertEquals(0, serviceReadWriteLock.findByName("Mbe").size());
        assertEquals(0, serviceReadWriteLock.findByPhone("88005553535").size());
    }

    @Test
    public void findBySmthWithoutEmptyFieldsTest() {
        Person person1 = new Person(1, "Null", "111111", "515152445");
        Person person2 = new Person(2, "Mbe", "51 st", "54122000");
        Person person3 = new Person(3, "Next", "12388", "12323232");
        Person person4 = new Person(4, "Time", "st st st st st", "88005553535");

        CachedService service = new CachedService();
        CachedServiceReadWriteLock serviceReadWriteLock = new CachedServiceReadWriteLock();
        service.add(person1);
        service.add(person2);
        service.add(person3);
        service.add(person4);
        serviceReadWriteLock.add(person1);
        serviceReadWriteLock.add(person2);
        serviceReadWriteLock.add(person3);
        serviceReadWriteLock.add(person4);

        assertEquals(1, service.findByAddress("12388").size());
        assertEquals(1, service.findByName("Mbe").size());
        assertEquals(1, service.findByPhone("88005553535").size());

        assertEquals(1, serviceReadWriteLock.findByAddress("12388").size());
        assertEquals(1, serviceReadWriteLock.findByName("Mbe").size());
        assertEquals(1, serviceReadWriteLock.findByPhone("88005553535").size());
    }
}
