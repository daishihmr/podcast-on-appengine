import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {

        Date d = new Date();
        SimpleDateFormat fmt;

        System.out.println(TimeZone.getDefault());
        fmt = new SimpleDateFormat("dd HH:mm:ss");
        System.out.println(d.getTime());
        System.out.println(fmt.format(d));

        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

        System.out.println(TimeZone.getDefault());
        fmt = new SimpleDateFormat("dd HH:mm:ss");
        System.out.println(d.getTime());
        System.out.println(fmt.format(d));

    }
}
