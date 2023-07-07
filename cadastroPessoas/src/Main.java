import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Selecione a opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Remover");
            System.out.println("4 - Editar");
            System.out.println("5 - Listar Estudantes");
            System.out.println("6 - Listar Estudantes por Gênero");
            System.out.println("7 - Sair");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(nameToFind);
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.println("Qual o gênero que deseja listar?");
                    String genderToFilter = scanner.next();
                    listStudentsByGender(genderToFilter);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante:");
        String name = scanner.nextLine();

        System.out.println("Digite o gênero do estudante:");
        String gender = scanner.nextLine();

        System.out.println("Digite a idade do estudante:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner após a leitura do inteiro

        Person student = new Person(name, age, gender);
        students.add(student);

        System.out.println("Estudante cadastrado com sucesso!");
    }

    private static void findStudent(String studentName) {
        boolean found = false;

        for (Person student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Estudante encontrado:");
                System.out.println("Nome: " + student.getName());
                System.out.println("Gênero: " + student.getGender());
                System.out.println("Idade: " + student.getAge());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Estudante não encontrado.");
        }
    }

    private static void removeStudent() {
        System.out.println("Qual o nome que deseja remover?");
        String name = scanner.next();

        boolean removed = false;

        for (Person student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                students.remove(student);
                System.out.println("Estudante removido com sucesso!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Estudante não encontrado.");
        }
    }

    private static void editStudent() {
        System.out.println("Qual o nome do estudante que deseja editar?");
        String name = scanner.next();

        boolean found = false;

        for (Person student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Qual é o novo nome?");
                String newName = scanner.next();
                student.name = newName;
                System.out.println("Estudante editado com sucesso!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Estudante não encontrado.");
        }
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("Não há estudantes cadastrados.");
        } else {
            System.out.println("Lista de Estudantes:");

            for (Person student : students) {
                System.out.println("Nome: " + student.getName());
                System.out.println("Gênero: " + student.getGender());
                System.out.println("Idade: " + student.getAge());
                System.out.println("--------------------");
            }
        }
    }

    private static void listStudentsByGender(String gender) {
        boolean found = false;

        for (Person student : students) {
            if (student.getGender().equalsIgnoreCase(gender)) {
                System.out.println("Nome: " + student.getName());
                System.out.println("Gênero: " + student.getGender());
                System.out.println("Idade: " + student.getAge());
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Não há estudantes do gênero informado.");
        }
    }
}