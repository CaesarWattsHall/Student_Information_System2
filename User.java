package caesarobi_registrationform;
public class User
{
           String crwhUID;
           String obiNAME; 
           String crwhGENDER;
           String obiADDRESS; 
           String crwhCONTACT;

           User(String id,String name,String gender,String address,String contact) {
                  this.crwhUID = id;
                  this.obiNAME = name;
                  this.crwhGENDER = gender; 
                  this.obiADDRESS = address;
                  this.crwhCONTACT = contact;

           } 

}