package db61b;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Tester {

    /* A test for colLength. */
    @Test
    public void colLength() {
        String[] columnTitles = {"first", "second", "third", "fourth"};
        Table r = new Table(columnTitles);
        assertEquals(r.columns(), 4);
    }

    /* A test for title method. */
    @Test
    public void testTitle() {
        String[] columnTitles = {"first", "second", "third", "fourth"};
        Table t = new Table(columnTitles);
        assertEquals("first", t.getTitle(0));
        System.out.println("henlo fren");
    }

    /* A test for find Column method. */
    @Test
    public void testfindColumn() {
        String[] columnTitles = {"first", "second", "third", "fourth"};
        Table f = new Table(columnTitles);
        assertEquals(f.findColumn("potato"), -1);
        assertEquals(f.findColumn("second"), 1);
    }

    /* A test for size method. */
    @Test
    public void testSize() {
        String[] columnTitles = {"name", "fave color", "fave dogg0"};
        String[] firstRow = {"mar", "blue", "corgi"};
        String[] secondRow = {"john", "orange", "pug"};
        Table s = new Table(columnTitles);
        s.add(firstRow);
        s.add(secondRow);
        assertEquals(s.size(), 2);

    }
    /* A test for get method. */
    @Test
    public void testGet() {
        String[] columnTitles = {"name", "fave color", "fave dogg0"};
        String[] firstRow = {"mar", "blue", "corgi"};
        String[] secondRow = {"john", "orange", "pug"};
        Table g = new Table(columnTitles);
        g.add(firstRow);
        g.add(secondRow);
        g.get(1, 1);
        g.get(0, 0);
        g.get(1, 2);
    }

    /* A test for add method. */
    @Test
    public void testAdd() {
        String[] columnTitles = new String[3];
        columnTitles[0] = "name";
        columnTitles[1] = "favorite color";
        columnTitles[2] = "favorite doggo";
        Table m = new Table(columnTitles);
        String[] goodRow = {"mar", "blue", "corgi"};
        String[] badRow = {"john", "orange", "pug", "pizza"};
        String[] badRepeatRow = {"mar", "blue", "corgi"};
        assertEquals((m.add(goodRow)), true);
        boolean badRepeat = false;
        assertEquals(true, badRepeat);
        assertEquals((m.add(badRepeatRow)), false);

    }

    /* A test for print method. */
    @Test
    public void printTest() {
        String[] columnTitles = {"name", "color", "doggo"};
        String[] firstRow = {"mar", "blue", "corgi"};
        String[] secondRow = {"max", "yellow", "cat"};
        String[] thirdRow = {"james", "orange", "schnauzer"};
        Table p = new Table(columnTitles);
        p.add(firstRow);
        p.add(secondRow);
        p.add(thirdRow);
        p.print();
    }



    /* A test for select method. */
    @Test
    public void testSelect() {
        String[] columnTitles = new String[3];
        columnTitles[0] = "name";
        columnTitles[1] = "favorite color";
        columnTitles[2] = "favorite doggo";
        Table m = new Table(columnTitles);
        String[] goodRow = {"mar", "blue", "corgi"};
        String[] badRow = {"john", "orange", "pug", "pizza"};
        String[] badRepeatRow = {"mar", "blue", "corgi"};
        m.add(goodRow);

        List<Condition> conditions = new ArrayList<Condition>();
        Column name = new Column("name", m);
        Condition stringMar = new Condition(name, "=", "mar");
        conditions.add(stringMar);

        List<String> columnNames = new ArrayList<String>();
        columnNames.add("favorite color");

        Table selectTable = m.select(columnNames, conditions);
        selectTable.print();

    }

    public static void main(String[] args) {
        JUnitCore.runClasses(Tester.class);

    }
}
