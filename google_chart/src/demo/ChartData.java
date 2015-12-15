package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chitboon on 12/15/15.
 */
public class ChartData {
    List<Column> cols = new ArrayList<Column>();
    List<Row> rows = new ArrayList<Row>();

    // create mock data, normally your data would be extracted from database
    // and you need to convert these data into the ChartData format
    // normally, this would be done in a for loop instead of what we are doing here

    public void createTestData() {

        // add first row -- mushroom
        // Noticed the use of generic to indicate that different type of v for Cell class.
        Cell<String> c1 = new Cell<String>();
        Cell<Integer> c2 = new Cell<Integer>();
        // with the use of generic in Cell class, v can be String, Integer etc depending your declaration
        // this is a neat way for you to define an attribute can be based on any supported generic type
        c1.v = "mushroom";
        c2.v = 5;
        Row r = new Row();
        r.c.add(c1);
        r.c.add(c2);
        rows.add(r);

        // add first row -- mushroom
        Cell<String> c3 = new Cell<String>();
        Cell<Integer> c4 = new Cell<Integer>();
        c3.v = "cheese";
        c4.v = 3;
        Row r2 = new Row();
        r2.c.add(c3);
        r2.c.add(c4);
        rows.add(r2);

        // add column description Toppings, slices
        Column col1 = new Column();
        Column col2 = new Column();
        col1.label = "Toppings";
        col1.type = Column.STRING_TYPE;
        col2.label = "slices";
        col2.type = Column.NUMBER_TYPE;
        cols.add(col1);
        cols.add(col2);
    }

}

// This contains the column description, the minimum you will be the label, and type
// for other fields, refer to the documentation
class Column {
    static final String STRING_TYPE = "string";
    static final String NUMBER_TYPE = "number";
    String id = "";
    String label = "";
    String pattern = "";
    String type = "";
}

// This contains the row of cells, the number of cells must match your columns
class Row {
    List<Cell> c = new ArrayList<Cell>();
}

// Noticed the use of Generics here, where the type of T can be string or integer
class Cell<T> {
    T v;
    String f;
}