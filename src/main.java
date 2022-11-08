import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Boolean again = true;

        System.out.println("=======================================");
        System.out.println("MOTOR INSURANCE CALCULATION APPLICATION");
        System.out.println("=======================================\n");
        System.out.println("Policy details:\n");

        while (again) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter start date of insurance policy: ");
            String dateInput = scanner.next();

            try {
                Policy policy = new Policy();
                int isStartDateValid = policy.isValidDate(dateInput);

                switch (isStartDateValid) {
                    case 0:
                        System.out.println("Start Date of Policy is incorrect format!\n");
                        continue;
                    case 1:
                        String startDateOfPolicy = dateInput;
                        Boolean addDriver = policy.addDriverDetails(startDateOfPolicy);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}