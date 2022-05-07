import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ClassLoadTest {


    @Test
    public void test() throws SQLException, ClassNotFoundException {
        System.out.println( DriverManager.getConnection("jdbc:mysql://101.34.25.191:3306","root","Happy2010."));
    }





}
