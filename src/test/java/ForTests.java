import com.company.Employee;
import com.company.Main;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ForTests {
    @Test
    @DisplayName("Проверка 1")
    public void test1() {
        Assertions.assertNotNull(new Employee(1,"2","3","4",5));
    }
    @Test
    @DisplayName("Проверка 2")
    public void test2() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = new ArrayList<>();
        list = Main.parseCSV(columnMapping, fileName);
        assertThat(list, MyMatcher.isOurList());
    }
    @Test
    @DisplayName("Проверка 3")
    public void test3() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
//        Assertions.assertNotNull(Main.parseCSV(columnMapping, fileName));
        assertThat(Main.parseCSV(columnMapping, fileName),CoreMatchers.instanceOf(List.class));

    }
    @Test
    @DisplayName("Проверка вызова эксепшна")
//    @AfterEach
    public void test4() {
        Assertions.assertThrows(FileNotFoundException.class, () -> Main.writeJSON("", "k://zz.txt"));
    }

    @Test
    @DisplayName("Проверка JUnit + Hamcrest")
    public void test5() {
//        List<String> list = List.of("hello", "netology", "world");
//        assertThat(list, hasItems("hello", "netology"));

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
//        Assertions.assertNotNull(Main.parseCSV(columnMapping, fileName));
        assertThat(Main.parseCSV(columnMapping, fileName),CoreMatchers.notNullValue());

    }

}
