
import java.util.*;

public class CollectionManagementSystem {

    static ArrayList<String> list = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static HashMap<Integer, String> map = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

  
public static void main(String[] args) {

    while (true) {

        System.out.println("\n===== COLLECTION MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Element to List");
        System.out.println("2. Remove Element from List");
        System.out.println("3. Display List");
        System.out.println("4. Add Element to Set");
        System.out.println("5. Remove Element from Set");
        System.out.println("6. Display Set");
        System.out.println("7. Add Entry to Map");
        System.out.println("8. Remove Entry from Map");
        System.out.println("9. Display Map");
        System.out.println("10. Exit");

        System.out.print("Enter your choice: ");

        String input = sc.nextLine();

        try {
            int choice = Integer.parseInt(input);

            switch (choice) {

                case 1:
                    addToList();
                    break;

                case 2:
                    removeFromList();
                    break;

                case 3:
                    displayList();
                    break;

                case 4:
                    addToSet();
                    break;

                case 5:
                    removeFromSet();
                    break;

                case 6:
                    displaySet();
                    break;

                case 7:
                    addToMap();
                    break;

                case 8:
                    removeFromMap();
                    break;

                case 9:
                    displayMap();
                    break;

                case 10:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Enter 1 to 10.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number!");
        }
    }
}


    // LIST OPERATIONS

    static void addToList() {
        System.out.print("Enter element to add: ");
        String value = sc.nextLine();

        list.add(value);

        System.out.println("Element added to List successfully!");
    }

    static void removeFromList() {
        System.out.print("Enter element to remove: ");
        String value = sc.nextLine();

        try {
            if (!list.remove(value)) {
                throw new NoSuchElementException("Element not found in List!");
            }

            System.out.println("Element removed successfully!");

        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayList() {
        System.out.println("List Elements: " + list);
    }

    // SET OPERATIONS

    static void addToSet() {
        System.out.print("Enter element to add: ");
        String value = sc.nextLine();

        if (set.add(value)) {
            System.out.println("Element added to Set successfully!");
        } else {
            System.out.println("Duplicate element! Set does not allow duplicates.");
        }
    }

    static void removeFromSet() {
        System.out.print("Enter element to remove: ");
        String value = sc.nextLine();

        try {
            if (!set.remove(value)) {
                throw new NoSuchElementException("Element not found in Set!");
            }

            System.out.println("Element removed successfully!");

        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displaySet() {
        System.out.println("Set Elements: " + set);
    }

    // MAP OPERATIONS

    static void addToMap() {
        try {
            System.out.print("Enter employee ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            if (map.containsKey(id)) {
                throw new IllegalArgumentException("Duplicate key! Employee ID already exists.");
            }

            map.put(id, name);

            System.out.println("Entry added to Map successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Employee ID must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void removeFromMap() {
        System.out.print("Enter employee ID to remove: ");

        try {
            int id = Integer.parseInt(sc.nextLine());

            if (!map.containsKey(id)) {
                throw new NoSuchElementException("Employee ID not found in Map!");
            }

            map.remove(id);

            System.out.println("Map entry removed successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Employee ID must be a number.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayMap() {
        System.out.println("Map Entries: " + map);
    }
}
