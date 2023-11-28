package Repository;
import model.animaux;
import model.DB;
import java.util.List;
import Repository.AnimauxRepository;
import java.util.Scanner;

public class MenuRepository {
    public void Menu(){
        int choix,ch = 0;
        Scanner scanner = new Scanner(System.in);
        do {


            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Ajout animal");
            System.out.println("2. liste des animaux");
            System.out.println("3. Supprimer un animal");
            System.out.println("4. Rechercher via le nom");
            System.out.println("5. Recherche dans un interval age");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option : ");

            do{
                choix = scanner.nextInt();
                scanner.nextLine();
            }while (choix>6 && choix<1);
            switch (choix) {
                case 1:
                    System.out.println("=== AJOUTER UN ANIMAL ===");
                    System.out.print("le nom de animal : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrer age : ");
                    int age = scanner.nextInt();
                    do{
                        System.out.println("1. Male");
                        System.out.println("2. Female");
                        System.out.print("Choisissez une option : ");
                            ch = scanner.nextInt();
                            scanner.nextLine();

                    }while(ch>2 && ch<1 );
                    String sexe;
                    if(ch==1){
                         sexe="Male";
                    }else {
                        sexe="Female";
                    }
                    System.out.print("Entrer le matricule  : ");
                    String matricule = scanner.nextLine();

                    animaux an= new animaux( nom,age,sexe,matricule);
                    AnimauxRepository ap= new AnimauxRepository();
                    ap.addAnimal(an);
                    break;
                case 2:
                    AnimauxRepository ap1= new AnimauxRepository();
                    List<animaux> la =ap1.getAllAnimaux();
                    for (animaux element : la) {

                        System.out.println(element.getId()+element.getNom()+element.getAge()+element.getMatricule()+element.getMatricule());

                    }
                    break;
                case 3:
                    AnimauxRepository ap2= new AnimauxRepository();
                    List<animaux> la1 =ap2.getAllAnimaux();
                    for (animaux element : la1) {
                        System.out.println(element.getId()+element.getNom()+element.getAge()+element.getMatricule()+element.getMatricule());

                    }
                    System.out.println("Entrer l'id animal a supprimer");
                    int idd = scanner.nextInt();
                    ap2.deleteAnimal(idd);
                    System.out.println("Affichage apres suppression");
                    List<animaux> la11 =ap2.getAllAnimaux();
                    for (animaux element : la11) {
                        System.out.println(element);
                    }
                    break;
                case 4:
                    System.out.print("le nom de animal a rechercher : ");
                    String nom1 = scanner.nextLine();
                    AnimauxRepository ap3= new AnimauxRepository();
                    List<animaux> la2 =ap3.getAnimaux(nom1);
                    for (animaux element : la2) {
                        System.out.println(element.getId()+element.getNom()+element.getAge()+element.getMatricule()+element.getMatricule());

                    }
                    break;
                case 5:
                    System.out.print("Entrer age de debut : ");
                    int age1 = scanner.nextInt();
                    System.out.print("Entrer age de fin : ");
                    int age2 = scanner.nextInt();
                    AnimauxRepository ap4= new AnimauxRepository();
                    List<animaux> la3 =ap4.getAnimauxByAge(age1,age2);
                    for (animaux element : la3) {
                        System.out.println(element.getId()+" "+element.getNom()+" "+element.getAge()+" "+element.getMatricule()+" "+element.getMatricule());

                    }
                    break;
                default:
                    System.out.println("BYE BYE");

                    break;
            }



        }while (choix!=6);
    }
}
