package SubSystem2.zipCode;

public class ZipCodeApi {
    private static final ZipCodeApi instance = new ZipCodeApi();

    private ZipCodeApi(){
        super();
    }

    public static ZipCodeApi getInstance(){
        return instance;
    }

    public String getCity(String zipCode){
        return "Iguatu";
    }

    public String getState(String zipCode){
        return "Ceará";
    }
}
