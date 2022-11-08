import java.util.ArrayList;
import java.util.Scanner;

public class Policy {
    int driverCounter = 0;
    String s;

    public int isValidDate(String dateInput) {
        String strPattern = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";

        if (dateInput.matches(strPattern))
            return 1;
        else
            return 0;
    }

    public boolean isAlpha(String s) {
        return s != null && s.chars().allMatch(Character::isLetter);
    }

    public int isEqualIgnoreCase(String res) {
        if (res != null && res.equalsIgnoreCase("y"))
            return 1;

        else if (res != null && res.equalsIgnoreCase("n"))
            return 0;

        else
            return -1;
    }

    public boolean addDriverDetails(String startDateOfPolicy) {
        ArrayList<Driver> drivers = new ArrayList<>();
        Boolean validFirstName, validLastName, validOccupation, validDOB;
        int response;
        char choice;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nDriver " + (driverCounter += 1) + ":");

            System.out.print("Please enter driver first name: ");
            String driverFirstName = scanner.next();
            validFirstName = isAlpha(driverFirstName);

            System.out.print("Please enter driver last name: ");
            String driverLastName = scanner.next();
            validLastName = isAlpha(driverLastName);

            System.out.print("Please enter driver occupation (Chauffeur / Accountant): ");
            String driverOccupation = scanner.next();
            validOccupation = (
                    driverOccupation.matches("[a-zA-Z]+") &&
                            driverOccupation != null &&
                            (driverOccupation.equalsIgnoreCase("Chauffeur") ||
                                    driverOccupation.equalsIgnoreCase("Accountant"))
            );

            System.out.print("Please enter driver dob: ");
            String driverDOB = scanner.next();
            validDOB = isValidDate(driverDOB) != 0;

            if (validFirstName && validLastName && validOccupation && validDOB) {
                Driver driver = new Driver(driverFirstName, driverLastName, driverOccupation, driverDOB);
                drivers.add(driver);
                System.out.println("Driver " + driverCounter + " added to insurance premium.\n");

                while (driverCounter < 6) {
                    System.out.print("Add another driver to premium? ");
                    choice = scanner.next().charAt(0);
                    s = Character.toString(choice);
                    response = isEqualIgnoreCase(s);
                    switch (response) {
                        case 1:
                            addDriverDetails(startDateOfPolicy);
                        case -1:
                            System.out.println("Invalid response(s) given!");
                            continue;
                        case 0:
                            break;
                    }
                }
            }
            else {
                System.out.println("\nInvalid details were specified!");
                driverCounter--;
                addDriverDetails(startDateOfPolicy);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}