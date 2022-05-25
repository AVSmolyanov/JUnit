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
    @DisplayName("�������� �������� ������")
    public void test1() {
        Assertions.assertNotNull(new Employee(1,"2","3","4",5));
    }

    @Test
    @DisplayName("�������� parseXML")
    public void test3() {
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee(1,"John","Smith","USA",25));
        expectedList.add(new Employee(2,"Inav","Petrov","RU",23));

        Assertions.assertEquals(expectedList, Main.parseXML("data.xml"),"������� �� �����");
    }

    @Test
    @DisplayName("�������� ������ ��������")
    public void test4() {
        Assertions.assertThrows(FileNotFoundException.class, () -> Main.writeJSON("", "k://zz.txt"));
    }

    @Test
    @DisplayName("�������� JUnit + Hamcrest")
    public void test5() {
        List<Employee> expectedList = new ArrayList<>();
        expectedList.add(new Employee(1,"John","Smith","USA",25));
        expectedList.add(new Employee(2,"Inav","Petrov","RU",23));

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
//        Assertions.assertEquals(expectedList,Main.parseCSV(columnMapping, fileName),"������� �� �����");
        assertThat(Main.parseCSV(columnMapping, fileName),CoreMatchers.is(expectedList));
    }

    @Test
    @DisplayName("�������� ������ parseCSV (����������� ������)")
//  ������ ��� ���������� ��������� ������������ �������
    public void test2() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";

        List<Employee> list = new ArrayList<>();
        list = Main.parseCSV(columnMapping, fileName);
        assertThat(list, MyMatcher.isOurList());
    }

}
