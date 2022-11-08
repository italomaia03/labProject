package SubSystem1.crm;

public class CrmService {

    private CrmService(){
        super();
    }

    public static void saveClient(String name, String zipCode, String city, String state){
        System.out.println("Client has been saved in CRM System.");
        System.out.println(name);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zipCode);
    }
}
