package ticketCounter;
import java.util.*;

public class TicketCounterStack {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st = null;

        System.out.println("Choose initialization:");
        System.out.println("1. Empty stack with size");
        System.out.println("2. Stack initialized with array of Persons");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter size: ");
            int size = sc.nextInt();
            sc.nextLine();
            st = new Stack(size);
        } else if (choice == 2) {
            System.out.print("Enter number of Persons: ");
            int n = sc.nextInt();
            sc.nextLine();
            Person arr[] = new Person[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());
                arr[i] = new Person(name, age, gender);
            }
            st = new Stack(arr);
        }

        int option;
        do {
            System.out.println("\nMenu ");
            System.out.println("1. Push one Person");
            System.out.println("2. Push two Persons");
            System.out.println("3. Pop one Person");
            System.out.println("4. Pop multiple Persons");
            System.out.println("5. Display all Persons");
            System.out.println("6. Display top n Persons");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                    Gender g1 = Gender.valueOf(sc.nextLine().toUpperCase());
                    st.push(new Person(name1, age1, g1));
                    break;

                case 2:
                    System.out.print("Enter name for Person 1: ");
                    String n1 = sc.nextLine();
                    System.out.print("Enter age: ");
                    int a1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                    Gender g11 = Gender.valueOf(sc.nextLine().toUpperCase());

                    System.out.print("Enter name for Person 2: ");
                    String n2 = sc.nextLine();
                    System.out.print("Enter age: ");
                    int a2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
                    Gender g22 = Gender.valueOf(sc.nextLine().toUpperCase());

                    st.push(new Person(n1, a1, g11), new Person(n2, a2, g22));
                    break;

                case 3:
                    Person popped = st.pop();
                    if (popped != null) {
                        System.out.print("Popped Person: ");
                        popped.displayPerson();
                    }
                    break;

                case 4:
                    System.out.print("Enter number of Persons to pop: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    st.pop(n);
                    break;

                case 5:
                    st.display();
                    break;

                case 6:
                    System.out.print("Enter number of top Persons: ");
                    int topN = sc.nextInt();
                    sc.nextLine();
                    st.display(topN);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while(option != 7);
    }


}


