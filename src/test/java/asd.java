import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class asd {
    @Test
    public void rest()
    {
        SimpleDateFormat ad = new SimpleDateFormat("yyyy-MM-dd");
        String date = ad.format(new Date());
        System.out.println(date);
    }
}
