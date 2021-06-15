package Military_Elite.Resources;

import java.util.Locale;

public class Repair {
    private String PartName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        PartName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return PartName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",this.getPartName(),getHoursWorked());
    }
}
