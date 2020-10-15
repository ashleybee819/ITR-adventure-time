import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws BadInputException, IOException {
        try {
            getInput();
        } catch (BadInputException | InputMismatchException ex) {
            System.out.println("Sorry, try again.");
            main(null);
        }
    }

    public static void getInput() throws BadInputException, InputMismatchException {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter a number between 1 and 10, inclusive: ");
            int number = scan.nextInt();

            if (number > 10 || number < 1) {
                throw new BadInputException("Outside of bounds.");
            }

        } while (scan.hasNextLine());
    }
}