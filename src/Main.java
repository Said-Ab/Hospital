

import database.IdCounter;
import models.*;
import service.impls.*;
import enums.Gender;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            HospitalIMPL hospitalService = new HospitalIMPL();
            DepartmentIMPL departmentService = new DepartmentIMPL();
            DoctorIMPL doctorService = new DoctorIMPL();
            PatientIMPL patientService = new PatientIMPL();

            while (true) {
                System.out.println("\n=== Hospital Management System ===");
                System.out.println("1. Add Hospital");
                System.out.println("2. Find Hospital by ID");
                System.out.println("3. View All Hospitals");
                System.out.println("4. View All Patients in Hospital");
                System.out.println("5. Delete Hospital by ID");
                System.out.println("6. Get All Hospitals by Address");
                System.out.println("7. Add Department to Hospital");
                System.out.println("8. Get All Departments by Hospital");
                System.out.println("9. Find Department by Name");
                System.out.println("10. Update Department by ID");
                System.out.println("11. Add Doctor to Hospital");
                System.out.println("12. Find Doctor by ID");
                System.out.println("13. Assign Doctor to Department");
                System.out.println("14. Get All Doctors by Hospital ID");
                System.out.println("15. Get All Doctors by Department ID");
                System.out.println("16. Add Patient to Hospital");
                System.out.println("17. Find Patient by ID");
                System.out.println("18. Get Patients by Age");
                System.out.println("19. Sort Patients by Age");
                System.out.println("20. Update Patient by ID");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {


                        System.out.print("Enter Hospital Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();

                        Hospital hospital = new Hospital(IdCounter.hospitalId(), name, address, List.of(), List.of(), List.of());
                        System.out.println(hospitalService.addHospital(hospital));
                    }
                    case 2 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(hospitalService.findHospitalById(id));
                    }
                    case 3 -> System.out.println(hospitalService.getAllHospital());
                    case 4 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(hospitalService.getAllPatientFromHospital(id));
                    }
                    case 5 -> {
                        System.out.print("Enter Hospital ID to remove: ");
                        Long id = scanner.nextLong();
                        System.out.println(hospitalService.deleteHospitalById(id));
                    }
                    case 6 -> {
                        System.out.print("Enter Address: ");
                        String address = scanner.nextLine();
                        System.out.println(hospitalService.getAllHospitalByAddress(address));
                    }
                    case 7 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long hospitalId = scanner.nextLong();
                        scanner.nextLine();

                        scanner.nextLine();
                        System.out.print("Enter Department Name: ");
                        String name = scanner.nextLine();

                        Department department = new Department(IdCounter.departmentId(), name);
                        System.out.println(departmentService.add(hospitalId, department));
                    }
                    case 8 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(departmentService.getAllDepartmentByHospital(id));
                    }
                    case 9 -> {
                        System.out.print("Enter Department Name: ");
                        String name = scanner.nextLine();
                        System.out.println(departmentService.findDepartmentByName(name));
                    }
                    case 10 -> {
                        System.out.print("Enter Department ID to update: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter New Department Name: ");
                        String name = scanner.nextLine();

                        Department department = new Department(id, name);
                        System.out.println(departmentService.updateById(id, department));
                    }
                    case 11 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long hospitalId = scanner.nextLong();
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Enter Doctor First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Doctor Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Doctor Gender (MALE/FEMALE): ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter Experience Year: ");
                        int experienceYear = scanner.nextInt();

                        Doctor doctor = new Doctor(IdCounter.doctorId(), firstName, lastName, Gender.valueOf(gender.toUpperCase()), experienceYear);
                        System.out.println(doctorService.add(hospitalId, doctor));
                    }
                    case 12 -> {
                        System.out.print("Enter Doctor ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(doctorService.findDoctorById(id));
                    }
                    case 13 -> {
                        System.out.print("Enter Department ID: ");
                        Long departmentId = scanner.nextLong();
                        System.out.println("Enter Doctor IDs (comma-separated): ");
                        scanner.nextLine();
                        String[] ids = scanner.nextLine().split(",");
                        List<Long> doctorIds = Arrays.stream(ids).map(Long::parseLong).toList();
                        System.out.println(doctorService.assignDoctorToDepartment(departmentId, doctorIds));
                    }
                    case 14 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(doctorService.getAllDoctorsByHospitalId(id));
                    }
                    case 15 -> {
                        System.out.print("Enter Department ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(doctorService.getAllDoctorsByDepartmentId(id));
                    }
                    case 16 -> {
                        System.out.print("Enter Hospital ID: ");
                        Long hospitalId = scanner.nextLong();
                        scanner.nextLine();
                        scanner.nextLine();
                        System.out.print("Enter Patient First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter Patient Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter Patient Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter Patient Gender (MALE/FEMALE): ");
                        String gender = scanner.next();

                        Patient patient = new Patient(IdCounter.patientId(), firstName, lastName, age, Gender.valueOf(gender.toUpperCase()));
                        System.out.println(patientService.add(hospitalId, patient));
                    }
                    case 17 -> {
                        System.out.print("Enter Patient ID: ");
                        Long id = scanner.nextLong();
                        System.out.println(patientService.getPatientById(id));
                    }
                    case 18 -> {
                        System.out.print("Enter Patient Age: ");
                        int age = scanner.nextInt();
                        System.out.println(patientService.getPatientByAge(age));
                    }
                    case 19 -> {
                        System.out.print("Sort by Age (ASC/DESC): ");
                        String order = scanner.nextLine();
                        System.out.println(patientService.sortPatientsByAge(order));
                    }
                    case 20 -> {
                        System.out.print("Enter Patient ID to update: ");
                        Long id = scanner.nextLong();
                        scanner.nextLine();
                        System.out.print("Enter New First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter New Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter New Age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter New Gender (MALE/FEMALE): ");
                        String gender = scanner.next();

                        Patient patient = new Patient(id, firstName, lastName, age, Gender.valueOf(gender.toUpperCase()));
                        System.out.println(patientService.updateById(id, patient));
                    }
                    case 0 -> {
                        System.out.println("Exiting...");
                        return;

                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
