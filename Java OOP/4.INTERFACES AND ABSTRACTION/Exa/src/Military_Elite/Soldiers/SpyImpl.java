package Military_Elite.Soldiers;

import Military_Elite.Interfaces.ISpy;

public class SpyImpl extends SoldierImpl implements ISpy {
    private String codeNumber;
    public SpyImpl(int id, String firstName, String lastName,String codeNumber) {
        super(id,firstName,lastName);
        this.codeNumber=codeNumber;
    }
    @Override
    public String getCode() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s",this.firstName,this.lastName,this.id,this.codeNumber);
    }
}
