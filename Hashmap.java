import java.util.HashMap;
import java.util.Map; 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Student Record Management System");

        Map<Integer, Student> studentRecords = new HashMap<>(); 

        boolean isRunning = true; 

        while (isRunning) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Insert Record");
            System.out.println("2. Remove Record");
            System.out.println("3. Update Record");
            System.out.println("4. Display Single Record");
            System.out.println("5. Display All Records");
            System.out.println("6. Exit");
            System.out.print("Enter Your Option : ");
            int option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Enter Data To Insert:");
                    System.out.print("Enter Student Rollno : ");
                    int rollno = sc.nextInt();
                    sc.nextLine(); 

                    System.out.print("Enter Student Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Class : "); 
                    String clas = sc.nextLine();

                    System.out.print("Enter Student Branch : "); 
                    String branch = sc.nextLine();

                    studentRecords.put(rollno, new Student(rollno, name, clas, branch));
                    System.out.println("Record inserted successfully.");
                    break;
                }
                case 2: {
                    System.out.print("Enter Rollno to Remove Record : ");
                    int rollno = sc.nextInt();
                    if (studentRecords.remove(rollno) != null) {
                        System.out.println("Record removed successfully.");
                    } else {
                        System.out.println("Record with Roll No " + rollno + " not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Enter Student Rollno to Update : ");
                    int rollnoToUpdate = sc.nextInt();
                    sc.nextLine(); 

                    if (studentRecords.containsKey(rollnoToUpdate)) {
                        Student studentToUpdate = studentRecords.get(rollnoToUpdate);
                        System.out.println("1. Name 2. Class 3. Branch");
                        System.out.print("Enter Your Option to Update : ");
                        int updateOption = sc.nextInt();
                        sc.nextLine();

                        switch (updateOption) {
                            case 1: {
                                System.out.print("Enter New Student Name : ");
                                studentToUpdate.setName(sc.nextLine());
                                System.out.println("Name updated.");
                                break;
                            }
                            case 2: {
                                System.out.print("Enter New Student Class : ");
                                studentToUpdate.setClas(sc.nextLine());
                                System.out.println("Class updated.");
                                break;
                            }
                            case 3: {
                                System.out.print("Enter New Student Branch : ");
                                studentToUpdate.setBranch(sc.nextLine());
                                System.out.println("Branch updated.");
                                break;
                            }
                            default:
                                System.out.println("Invalid update option.");
                        }
                    } else {
                        System.out.println("Record with Roll No " + rollnoToUpdate + " not found.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter Student Rollno to Display : ");
                    int rollnoToDisplay = sc.nextInt();
                    Student student = studentRecords.get(rollnoToDisplay);
                    if (student != null) {
                        System.out.println(student); // Uses Student's toString()
                    } else {
                        System.out.println("Record with Roll No " + rollnoToDisplay + " not found.");
                    }
                    break;
                }
                case 5: {
                    if (studentRecords.isEmpty()) {
                        System.out.println("No records to display.");
                    } else {
                        System.out.println("\n--- All Student Records ---");
                        for (Student student : studentRecords.values()) {
                            System.out.println(student);
                        }
                    }
                    break;
                }
                case 6: {
                    isRunning = false;
                    System.out.println("Exiting Student Record Management System.");
                    break;
                }
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}


class Student {
    private int rollno;
    private String name;
    private String clas;
    private String branch;

    public Student(int rollno, String name, String clas, String branch) {
        this.rollno = rollno;
        this.name = name;
        this.clas = clas;
        this.branch = branch;
    }


    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getClas() {
        return clas;
    }

    public String getBranch() {
        return branch;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollno + ", Name: " + name + ", Class: " + clas + ", Branch: " + branch;
    }
}
