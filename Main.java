//import necessary libraries
import java.sql.*;    //for database connectivity and sql queries
import java.util.Scanner; //for user input

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";    //replace 'testdb' with your database name
        String username = "root";                            //default username
        String password = "Shruti1302@";                     //mysql workbench password

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            try (
                Connection conn = DriverManager.getConnection(url, username, password);
                Scanner scanner = new Scanner(System.in); //for reading user input
            ) {
                System.out.println("✅ Connected to MySQL successfully!");

                int choice;
                
                //loop the menu until user chooses to exit
                do {
                    System.out.println("\n========== To-Do List Menu ==========");
                    System.out.println("1. Add Task");
                    System.out.println("2. View Tasks");
                    System.out.println("3. Mark Task as Done");
                    System.out.println("4. Delete Task");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice (1-5): ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter task: ");
                            String task = scanner.nextLine();

                            //insert task into database with default status 'pending'
                            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO todo (task) VALUES (?)");
                            insertStmt.setString(1, task);
                            insertStmt.executeUpdate();   //runs the insert command in the database
                            System.out.println("✅ Task added successfully!");
                            break;

                        case 2:
                            Statement stmt = conn.createStatement();    //doesn't require any paramters to run
                            ResultSet rs = stmt.executeQuery("SELECT * FROM todo");   //to fetch all rows from the todo table
                            System.out.println("\n📋 Your Tasks:");

                            //display each tasks with id, description, status
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + ". " + rs.getString("task") + " - " + rs.getString("status"));
                            }
                            break;

                        case 3:
                            System.out.print("Enter task ID to mark as done: ");
                            int doneId = scanner.nextInt();

                            //update task status to done in database
                            PreparedStatement updateStmt = conn.prepareStatement("UPDATE todo SET status = 'done' WHERE id = ?");
                            updateStmt.setInt(1, doneId);
                            updateStmt.executeUpdate();   //executes the update statement
                            System.out.println("✅ Task marked as done.");
                            break;

                        case 4:
                            System.out.print("Enter task ID to delete: ");
                            int deleteId = scanner.nextInt();

                            //delete the task from database
                            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM todo WHERE id = ?");
                            deleteStmt.setInt(1, deleteId);
                            deleteStmt.executeUpdate(); //executes the delete task 
                            System.out.println("🗑️ Task deleted successfully!");
                            break;

                        case 5:
                            System.out.println("👋 Exiting the menu... Goodbye!");
                            break;

                        default:
                            System.out.println("❌ Invalid choice... Please try again!");
                    }
                } while (choice != 5);   //continue looping until user exists
            }
        } catch (ClassNotFoundException e) {
            //handle error if jdbc driver is not found
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            //handle error is there is an error in sql connection
            System.out.println("❌ Connection or query failed.");
            e.printStackTrace();
        }
    }
}