package InterfacesExample.Interface;

interface Biometric{
    boolean verify();
    void createUser();

    private void verifyFaceData(String aadhaarId){
        System.out.println("Verifying face using aadhaar id");
    }

    //Default method if the implementing class have to create an user using Aadhaar then they can override this method
    default void createUserUsingAadhaar(String aadhaarId){
        verifyFaceData(aadhaarId);
        // Other lines of code
    }
}







