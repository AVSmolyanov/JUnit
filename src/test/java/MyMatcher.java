import com.company.Employee;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class MyMatcher extends TypeSafeDiagnosingMatcher<List> {
    private Description mismatch;

    @Override
    public void describeTo(Description description) {
        description.appendText("Список должен содержать 2-х сотрудников:\n1,John,Smith,USA,25\n2,Inav,Petrov,RU,23");
    }

    @Override
    protected boolean matchesSafely(List item, Description mismatchDescription) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"John","Smith","USA",25));
        list.add(new Employee(2,"Inav","Petrov","RU",23));
        Boolean result = true;
        for (int ii=0 ; ii<Integer.max(item.size(), list.size()); ii++) {
            if (list.get(ii).equals(item.get(ii))==false) {
                mismatchDescription.appendText("Не работает???");
                result = false;
                break;
            };
        }
        return result;
    }


    public static MyMatcher isOurList() {
        return new MyMatcher();
    }

}
