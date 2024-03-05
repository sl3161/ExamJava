import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        boolean flag = true;
        System.out.println("Список игрушек сформирован :");
        ArrayList<Toy> toys = GenerateList(4);
        for (Toy item : toys) {
            System.out.println(item);
        }
        while (flag==true) {
        try {
           
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите нужный пункт меню :");
            System.out.println("0 Сгенерировать список игрушек заново");
            System.out.println("1 Распечатать список игрушек");
            System.out.println("2 - Добавить игрушку");
            System.out.println("3 - Изменить вес игрушки");
            System.out.println("4 - Выбрать игрушку и звписать в файл");
            System.out.println("5 - Выйти");
            Integer choice = scanner.nextInt();
            switch (choice) {
            case 0:
            System.out.println("Список игрушек сформирован :");
            toys = GenerateList(4);
                for (Toy item : toys ) {
                    System.out.println(item);
                } 
                System.out.println("_______________________________________________________________________________"); 
                break; 
            case 1:
            for (Toy item : toys ) {
                System.out.println(item);
            }  
            System.out.println("_______________________________________________________________________________");   
                break; 
            case 2:
            changeQuantity(toys);
            System.out.println("Кол во изменено ");
            for (Toy item : toys ) {
                System.out.println(item);
            } 
            System.out.println("_______________________________________________________________________________");  

            break;
            case 3:
            changeWeight(toys);
            System.out.println("Вес изменен ");
            for (Toy item : toys ) {
                System.out.println(item);
            } 
            System.out.println("_______________________________________________________________________________");  
            break; 
            case 4:
            String toy = play(toys);
            System.out.println("Выбрана игрушка :   "+ play(toys));
            System.out.println("_________________________________________________________________________________");
            WriteInFile (toy, "file");
            for (Toy item : toys ) {
                System.out.println(item);
            }  
            System.out.println("_______________________________________________________________________________");   
                break;   
            case 5:
            flag = false;
           
            break;   
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    }
     static void WriteInFile ( String toy, String fileName){
        try (FileWriter fr = new FileWriter(fileName, true)) {
                fr.write (toy.toString() +"\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    static String play ( ArrayList<Toy> list){
        Toy selectedToy = new Toy(null, 0, 0, 0);
        Random random = new Random();
        ArrayList <Integer> array = new ArrayList<>();
        for (Toy item : list) {
            for (int index = 1; index <= item.weight; index++) {
                array.add(item.id);
            } 
        }
        if (array.size()<1){
            System.out.println("Игрушки закончились(");
            return null;
            
        }
        int randNum = random.nextInt(0,array.size()-1);
        int id = array.get(randNum);
        for (Toy item : list) {
            if (item.id == id){ 
            selectedToy = item;
            item.quantity-=1; 
            }
           
        }
        if ( selectedToy.quantity==0) list.remove(selectedToy);
        return selectedToy.toString();
    }

    static void changeQuantity (ArrayList<Toy> list){
        Scanner scanner = new Scanner ( System.in);
        System.out.println("Введите id игрушки ");
        int id = scanner.nextInt();
        System.out.println("Введите кол во которое необходимо добавить ");
        int addQuantity = scanner.nextInt();
        for (Toy item : list) {
            if (item.id == id){
                item.quantity=item.quantity+addQuantity;
            }
        }
    }

    static void changeWeight (ArrayList<Toy> list){
        Scanner scanner = new Scanner ( System.in);
        System.out.println("Введите id игрушки ");
        int id = scanner.nextInt();
        System.out.println("Введите вес который необходимо внести ");
        int newWeight = scanner.nextInt();
        for (Toy item : list) {
            if (item.id == id){
                item.weight = newWeight;
            }
        }
    }

    static ArrayList<Toy> GenerateList( int quantity ){
        ArrayList<Toy> list = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
                list.add (new Toy(GetName(), i, 2, 4));
         
        }
        return list;
    }
    static String GetName ( ){
        return NamesOfToys.values()[new Random().nextInt(NamesOfToys.values().length-1)].name();
    }
   

}
