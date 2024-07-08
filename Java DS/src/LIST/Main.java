package LIST;

import javax.sql.DataSource;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }
}
