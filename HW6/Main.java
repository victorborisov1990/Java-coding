package HW6;

import java.util.ArrayList;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Notebook note1 = new Notebook("Lenovo G580", Cpu.intel, 8, 750);
        Notebook note2 = new Notebook("Acer A320ln", Cpu.amd, 16, 512, Os.win);
        Notebook note3 = new Notebook("MateBook D 15", Cpu.intel, 16, 512, Os.win);
        Notebook note4 = new Notebook("MSI Modern 14", Cpu.amd, 32, 256);
        Notebook note5 = new Notebook("HIPER G16", Cpu.intel, 16, 1000, Os.lin);
        Notebook note6 = new Notebook("Apple MacBook Pro", Cpu.intel, 64, 600, Os.mac);
        List <Notebook> notes = new ArrayList<>(Arrays.asList(note1,note2,note3,note4,note5,note6));
        // System.out.println(notes.get(5));
        // System.out.println(note2);


        Scanner scan = new Scanner(System.in);
        System.out.print("Выберете критерий поиска: \n 1 Процессор \n 2 Объем ОЗУ \n 3 Объем диска \n 4 Операционная система \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "1"://////////////////выбор по процессору//////////////////////
                    List <Cpu> cpus = Arrays.asList(Cpu.values());
                    for (int i = 0; i < cpus.size();i++) {//выводим список процессоров
                        System.out.printf("%d - ", i);//индекс
                        System.out.println(cpus.get(i)); //соответсвующее название процессора   
                    }
                    System.out.print("Выберете процессор:");
                    int sel_cpu = scan.nextInt();//вводим индекс нужного процессора
                    scan.nextLine();
                    if (sel_cpu > 0 && sel_cpu < cpus.size()){//если индекс в пределах списка
                        Cpu search_cpu = cpus.get(sel_cpu);//выбираем по этому индексу процессор для поиска
                        for(int j = 0; j < notes.size(); j++){//в спске ноутбуков. если у текущего ноута название процессора совпад с назв процессора из поиска
                            if(notes.get(j).getCpu().getCpuName().equals(search_cpu.getCpuName())){
                                System.out.println(notes.get(j));//выводим в консоль
                            }
                        }
                    }   
                    break;
                case "2": //////////////////////////выбор по объему ОЗУ/////////////////////
                    Map<String, Integer> ram_search_range = new HashMap<>();
                    System.out.print("Введите объем ОЗУ от:");
                    ram_search_range.put("min", scan.nextInt());
                    scan.nextLine();
                    System.out.print("Введите объем ОЗУ до:");
                    ram_search_range.put("max", scan.nextInt());
                    scan.nextLine();
                    for(int j = 0; j < notes.size(); j++){//в списке ноутбуков. если у текущего ноута объем озу в пределах поиска
                        if(notes.get(j).getRam() >= ram_search_range.get("min") && notes.get(j).getRam() <= ram_search_range.get("max")){
                            System.out.println(notes.get(j));//выводим в консоль
                        }
                    }
                    break;
                case "3": //////////////////////////выбор по объему диска /////////////////////
                    Map<String, Integer> drive_search_range = new HashMap<>();
                    System.out.print("Введите объем диска от:");
                    drive_search_range.put("min", scan.nextInt());
                    scan.nextLine();
                    System.out.print("Введите объем диска до:");
                    drive_search_range.put("max", scan.nextInt());
                    scan.nextLine();
                    for(int j = 0; j < notes.size(); j++){//в списке ноутбуков. если у текущего ноута объем озу в пределах поиска
                        if(notes.get(j).getStor() >= drive_search_range.get("min") && notes.get(j).getStor() <= drive_search_range.get("max")){
                            System.out.println(notes.get(j));//выводим в консоль
                        }
                    }
                break;
                case "4": //////////////////////////выбор по Операционной системе/////////////////////
                    List <Os> osList = Arrays.asList(Os.values());
                    for (int i = 0; i < osList.size();i++) {
                        System.out.printf("%d - ", i);
                        System.out.println(osList.get(i));    
                    }
                    System.out.print("Выберете операционную систему:");
                    int sel_os = scan.nextInt();
                    scan.nextLine();
                    if (sel_os > 0 && sel_os < osList.size()){//если индекс в пределах списка
                        Os search_os = osList.get(sel_os);//выбираем по этому индексу OC для поиска
                        for(int j = 0; j < notes.size(); j++){//в спске ноутбуков. если у текущего ноута название OC совпад с назв OC из поиска
                            if(notes.get(j).getOs().getOsName().equals(search_os.getOsName())){
                                System.out.println(notes.get(j));//выводим в консоль
                            }
                        }
                    }
                    break;        
            }
            System.out.println("****************************************************"); 
            System.out.print("Выберете критерий поиска: \n 1 Процессор \n 2 Объем ОЗУ \n 3 Объем диска \n 4 Операционная система \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        scan.close();

    }
}

//for (Cpu item : Cpu.values()) {
//  System.out.println(item.getCpuName()); 
// }
//вариант перебора значений в enum