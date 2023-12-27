import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Prospect> listProspect = new HashMap<>();
        HashMap<String, Nasabah> listCustomer = new HashMap<>();
                Menu.menuUtama(listProspect, listCustomer);
    }

}