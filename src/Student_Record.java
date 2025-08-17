import java.util.*;
import java.util.Collections;
import java.util.Comparator;

class Login {
    private final String realUserName = "Aits";
    private final String realPassword = "admin@123";

    public boolean login_user(String username, String password) {
        return realUserName.equals(username) && realPassword.equals(password);
    }
}

class Student_Details {
    static ArrayList<Student_Details> students = new ArrayList<>();

    int rollno;
    String Stduent_Name;
    int stu_Age;
    char Gender;
    String Branch;
    int Year;
    int Sub_1;
    int Sub_2;
    int Sub_3;
    int total;
    double Percentaile;

    Student_Details(int rollno, String studentname, int age,
                    char gender, String brach, int year,
                    int sub1, int sub2, int sub3) {
        this.rollno = rollno;
        this.Stduent_Name = studentname;
        this.stu_Age = age;
        this.Branch = brach;
        this.Gender = gender;
        this.Year = year;
        this.Sub_1 = sub1;
        this.Sub_2 = sub2;
        this.Sub_3 = sub3;
        this.total = sub1 + sub2 + sub3;
        this.Percentaile = (total / 300.0) * 100;
    }

    void recalc() {
        this.total = Sub_1 + Sub_2 + Sub_3;
        this.Percentaile = (total / 300.0) * 100;
    }

    void Student_Details_Display() {
        System.out.println("Student Roll_No : " + rollno);
        System.out.println("Student Name : " + Stduent_Name);
        System.out.println("Student Branch : " + Branch);
        System.out.println("Student Age : " + stu_Age);
        System.out.println("Student Gender : " + Gender);
        System.out.println("Student Year : " + Year);
        System.out.println("Student Sub_1 Marks : " + Sub_1);
        System.out.println("Student Sub_2 Marks : " + Sub_2);
        System.out.println("Student Sub_3 Marks : " + Sub_3);
        System.out.println("Student total Marks : " + total);
        System.out.println("Student Percentaile Marks : " + Percentaile);
    }

    public String toString() {
        return "Roll No: " + rollno + ", Name: " + Stduent_Name +
                ", Branch: " + Branch + ", Age: " + stu_Age +
                ", Gender: " + Gender + ", Year: " + Year +
                ", Marks: [" + Sub_1 + ", " + Sub_2 + ", " + Sub_3 + "]" +
                ", Total: " + total + ", Percentaile: " + Percentaile;
    }
}

class Show_Details {
    void Show(int rollno) {
        boolean found = false;
        for (Student_Details sd : Student_Details.students) {
            if (sd.rollno == rollno) {
                System.out.println("*************************************");
                sd.Student_Details_Display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + rollno + " not found.");
        }
    }
}

class Update_Details {
    Scanner sc = new Scanner(System.in);

    void Show_Update(int rollno) {
        boolean found = false;
        boolean istrue = true;
        for (Student_Details sd : Student_Details.students) {
            if (sd.rollno == rollno) {
                while (istrue) {
                    System.out.println("1.Student Name ,2.Branch , 3.Age , 4.Year ");
                    System.out.println("5.Sub_1 Marks,6.Sub_2 Marks, 7.Sub_3 Marks,8.Quit ");
                    int opt = sc.nextInt();
                    switch (opt) {
                        case 1: {
                            System.out.println("Enter Name to Update : ");
                            sd.Stduent_Name = sc.next();
                            break;
                        }
                        case 2: {
                            System.out.println("Enter Branch to Update : ");
                            sd.Branch = sc.next();
                            break;
                        }
                        case 3: {
                            System.out.println("Enter Age to Update : ");
                            sd.stu_Age = sc.nextInt();
                            break;
                        }
                        case 4: {
                            System.out.println("Enter Year to Update : ");
                            sd.Year = sc.nextInt();
                            break;
                        }
                        case 5: {
                            System.out.println("Enter Sub_1 to Update : ");
                            sd.Sub_1 = sc.nextInt();
                            sd.recalc();
                            break;
                        }
                        case 6: {
                            System.out.println("Enter Sub_2 to Update : ");
                            sd.Sub_2 = sc.nextInt();
                            sd.recalc();
                            break;
                        }
                        case 7: {
                            System.out.println("Enter Sub_3 to Update : ");
                            sd.Sub_3 = sc.nextInt();
                            sd.recalc();
                            break;
                        }
                        case 8: {
                            System.out.println("Exiting....");
                            istrue = false;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Option...");
                        }
                    }
                }
                System.out.println("*********************************");
                System.out.println("Student Details After Update.....");
                sd.Student_Details_Display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + rollno + " not found.");
        }
    }
}

class Student_Delete_Record {
    void Delete(int rollno) {
        boolean found = false;

        for (int i = 0; i < Student_Details.students.size(); i++) {
            if (Student_Details.students.get(i).rollno == rollno) {
                Student_Details.students.remove(i);
                found = true;
                System.out.println("Student with Roll No " + rollno + " has been deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + rollno + " not found.");
        }
    }
}

class Display_All {
    void Display() {
        if (Student_Details.students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            Collections.sort(Student_Details.students,
                    (s1, s2) -> Double.compare(s2.Percentaile, s1.Percentaile));
            for (Student_Details s : Student_Details.students) {
                System.out.println(s);
            }
        }
    }
}

public class Student_Record {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        int count = 0;
        while (count < 3) {
            System.out.print("Enter Your UserName To Begin: ");
            String username = sc.nextLine();
            System.out.print("Enter Your Password To Begin: ");
            String password = sc.nextLine();

            if (login.login_user(username, password)) {
                System.out.println("You Have Successfully Logged In!!!");
                break;
            } else {
                System.out.println("Password or UserName Wrong Try Again!!");
                count += 1;
            }
        }

        if (count == 3) {
            System.out.println("Too many failed attempts Access denied");
            return;
        }

        boolean istrue = true;
        while (istrue) {
            System.out.println("\n1. Enter Records");
            System.out.println("2. Get Records");
            System.out.println("3. Update Records");
            System.out.println("4. Delete Records");
            System.out.println("5. Display All Records");
            System.out.println("6. Exit");
            System.out.print("Enter Your Option : ");
            int option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.print("Enter Student ID : ");
                    int id = sc.nextInt();
                    System.out.print("Enter Student Name : ");
                    String name = sc.next();
                    System.out.print("Enter Student Age : ");
                    int age = sc.nextInt();
                    System.out.print("Enter Student Gender : ");
                    char gen = sc.next().charAt(0);
                    System.out.print("Enter Student Branch : ");
                    String branch = sc.next();
                    System.out.print("Enter Student Year : ");
                    int year = sc.nextInt();
                    System.out.print("Enter Student Sub_1 Marks : ");
                    int sub1 = sc.nextInt();
                    System.out.print("Enter Student Sub_2 Marks : ");
                    int sub2 = sc.nextInt();
                    System.out.print("Enter Student Sub_3 Marks : ");
                    int sub3 = sc.nextInt();

                    Student_Details sd = new Student_Details(id, name, age, gen, branch, year, sub1, sub2, sub3);
                    Student_Details.students.add(sd);
                    sd.Student_Details_Display();
                    break;
                }
                case 2: {
                    System.out.print("Enter ID of Student : ");
                    int id = sc.nextInt();
                    Show_Details shd = new Show_Details();
                    shd.Show(id);
                    break;
                }
                case 3: {
                    System.out.println("Enter ID of Student : ");
                    int id = sc.nextInt();
                    Update_Details up = new Update_Details();
                    up.Show_Update(id);
                    break;
                }
                case 4: {
                    System.out.println("Enter ID to Delete Record : ");
                    int id = sc.nextInt();
                    Student_Delete_Record sdr = new Student_Delete_Record();
                    sdr.Delete(id);
                    break;
                }
                case 5: {
                    System.out.println("All Student Details...");
                    Display_All d = new Display_All();
                    d.Display();
                    break;
                }
                case 6: {
                    System.out.println("Exiting...");
                    istrue = false;
                    break;
                }
                default: {
                    System.out.println("Invalid Option. Try again.");
                }
            }
        }
        sc.close();
    }
}
