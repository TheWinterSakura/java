import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Classes classA = new Classes("Class A");
        Classes classB = new Classes("Class B");

        Group group1 = new Group("Group 1");
        group1.addStudent(new Student("Aa", 1001));
        group1.addStudent(new Student("Bb", 1002));

        Group group2 = new Group("Group 2");
        group2.addStudent(new Student("Cc", 1003));
        group2.addStudent(new Student("Dd", 1004));

        Group group3 = new Group("Group 3");
        group3.addStudent(new Student("Ee", 1005));
        group3.addStudent(new Student("Ff", 1006));

        Group group4 = new Group("Group 4");
        group4.addStudent(new Student("Gg", 1007));
        group4.addStudent(new Student("Hh", 1008));

        classA.addGroup(group1);
        classA.addGroup(group2);
        classB.addGroup(group3);
        classB.addGroup(group4);

        ArrayList<Student> allStudentsFromBothClasses = new ArrayList<>();
        allStudentsFromBothClasses.addAll(classA.getAllStudents());
        allStudentsFromBothClasses.addAll(classB.getAllStudents());

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择操作：");
        System.out.println("1. 随机抽取班级中的一个小组");
        System.out.println("2. 从班级中的某个小组随机抽取一个学生");
        System.out.println("3. 从整个班级随机抽取一个学生");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("请选择班级：1. Class A  2. Class B");
                int classChoice = scanner.nextInt();
                Classes selectedClass = classChoice == 1 ? classA : classB;
                Group randomGroup = selectedClass.pickRandomGroup();
                System.out.println("随机抽取的小组: " + randomGroup.getGroupName());
                break;

            case 2:
                System.out.println("请选择班级：1. Class A  2. Class B");
                classChoice = scanner.nextInt();
                selectedClass = classChoice == 1 ? classA : classB;
                System.out.println("请选择小组：1. " + selectedClass.getGroups().get(0).getGroupName() + "  2. " + selectedClass.getGroups().get(1).getGroupName());
                int groupChoice = scanner.nextInt();
                Group selectedGroup = selectedClass.getGroups().get(groupChoice - 1);
                Student randomStudent = selectedClass.pickRandomStudentFromGroup(selectedGroup);
                System.out.println("随机抽取的小组中的学生: " + randomStudent.getName());
                break;

            case 3:
                Random random = new Random();
                int index = random.nextInt(allStudentsFromBothClasses.size());
                Student randomStudentFromBothClasses = allStudentsFromBothClasses.get(index);
                System.out.println("从A和B班中随机抽取的学生: " + randomStudentFromBothClasses.getName());
                break;

            default:
                System.out.println("无效的选择");
                break;
        }

        scanner.close();
    }
}
