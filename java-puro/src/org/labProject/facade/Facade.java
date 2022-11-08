package org.labProject.facade;

import SubSystem1.crm.CrmService;
import SubSystem2.zipCode.ZipCodeApi;

public class Facade {

    private static class Holder{
        public static Facade instance = new Facade();
    }

    private Facade(){
        super();
    }

    public static Facade getInstance(){
        return Holder.instance;
    }

    public void migrateClient(String name, String zipCode){
        String city = ZipCodeApi.getInstance().getCity(zipCode);
        String state = ZipCodeApi.getInstance().getState(zipCode);

        CrmService.saveClient(name, zipCode, city, state);
    }
}
