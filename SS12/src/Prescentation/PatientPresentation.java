package Prescentation;

import model.Patient;
import servies.PatientService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PatientPresentation {
    private static PatientService patientService;
    Scanner sc= new Scanner(System.in);

     public PatientPresentation(){
         patientService= new PatientService();
     }




     public void displayPatient(){
         List<Patient> patients  = patientService.getPatient();



         if(Optional.ofNullable(patients).isEmpty()){
            System.out.println("list patients ís empty");
            return;
         }

         System.out.println("------------LIST PATIENT ------------------");
         System.out.println("");
         System.out.println("--------------------------------------------");
         for(Patient patient: patients){
             System.out.printf("%-5d %-20s %-5d %-50s%n",
                     patient.getId(),
                     patient.getFull_name(),
                     patient.getAge(),
                     patient.getDiagnos()
             );
         }
         System.out.println("==========================");
     }
         public void addPatientUI(){
             sc.nextLine();

             System.out.println("id: ");
             int id=sc.nextInt();
             sc.nextLine();

             System.out.print("Nhập tên: ");
             String name = sc.nextLine();

             System.out.print("Nhập tuổi: ");
             int age = sc.nextInt();

             sc.nextLine();
             System.out.print("Nhập bệnh: ");
             String diagnos = sc.nextLine();

             Patient p= new Patient(id,name, age, diagnos);

         }


    public void displayMenu(){
        int choice;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm bệnh nhân");
            System.out.println("3. Sửa bệnh nhân");
            System.out.println("4. Xoá bệnh nhân");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    displayPatient();
                    break;
                case 2:
                    addPatientUI();
                    break;
                case 3:
//                    updatePatientUI();
                    break;
                case 4:
//                    deletePatientUI();
                    break;
            }
        } while (choice != 0);
    }

}



