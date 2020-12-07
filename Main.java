package com.company;

import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Введите два числа в промежутке от 1 до 10 или от I до X" +
                " и знак математической операции (+,-,*,/) между ними." +
                "\n" +  "Не забывайте поставить пробел перед каждым числом\n" +
                "Пример: 1 + 1 или I + I\n" +
                "Разрешено использовать арабские или римские цифры.\n" +
                "Запрещено использовать арабские и римские цифры вместе.");

        String exp = scanner.nextLine();
        int first = -1;
        int second = -1;
        var length = exp.length();
        char chr[]= new char[length];
        while(first == -1 || second==-1){
            String[] parts = exp.split(" ");
            if(parts.length<3){
                System.out.println("Неверный ввод числовых данных");
                exp = scanner.nextLine();
            }
            else if ((parts[0].equals("I") || parts[0].equals("II") || parts[0].equals("III") || parts[0].equals("IV")
                    || parts[0].equals("V") || parts[0].equals("VI") || parts[0].equals("VII") || parts[0].equals("VIII")
                    || parts[0].equals("IX")|| parts[0].equals("X"))
                    && (parts[2].equals("I") || parts[2].equals("II") || parts[2].equals("III") || parts[2].equals("IV")
                    || parts[2].equals("V") || parts[2].equals("VI") || parts[2].equals("VII") || parts[2].equals("VIII")
                    || parts[2].equals("IX")|| parts[2].equals("X"))){
                first = RomanNumerals.toArabic(parts[0]);
                second = RomanNumerals.toArabic(parts[2]);}
            else if ((parts[0].equals("1") || parts[0].equals("2") || parts[0].equals("3") || parts[0].equals("4")
                    || parts[0].equals("5") || parts[0].equals("6") || parts[0].equals("7") || parts[0].equals("8")
                    || parts[0].equals("9")|| parts[0].equals("10"))
                    && (parts[2].equals("1") || parts[2].equals("2") || parts[2].equals("3") || parts[2].equals("4")
                    || parts[2].equals("5") || parts[2].equals("6") || parts[2].equals("7") || parts[2].equals("8")
                    || parts[2].equals("9")|| parts[2].equals("10"))){
                first = Integer.parseInt(parts[0]);
                second = Integer.parseInt(parts[2]);}
            else {
                System.out.println("Одно из чисел или оба числа - находятся в недопустимом промежутке! " +
                        "\nПожалуйста, введите два числа из заданного промежутка (от 1 до 10 или от I до X)" +
                        "\nПожалуйста, попробуйте снова!");
                exp = scanner.nextLine();
            }}


        String[] parts = exp.split(" ");
        char action = check(parts,exp);
        int calculation = calc(first,second,action);
        System.out.println(arabicToRoman(calculation,parts));

    }
    public static char check(String[] parts,String exp){
        var action = parts[1].charAt(0);
        if(parts.length<3){
            System.out.println("Произошла ошибка! Пожалуйста, попробуйте снова!");
            exp = scanner.nextLine();
        }
        else if (action != '+' && action != '-' && action != '/' && action != '*' || parts[1].length() != 1) {
            System.out.println("Ошибка при выполенении операции. Пожалуйста, попробуйте снова!");
            String exp1 = scanner.nextLine();
            String[] parts1 = exp1.split(" ");
            action = check(parts1,exp);
        }
        return action;
    }

    public static int calc(int first,int second,char action){
        if (action == '+') return first+second;
        if (action == '-') return first-second;
        if (action == '*') return first*second;
        else return first/second;
    }
    public static String arabicToRoman(int calculation,String[] parts){
        String result = null;
        if(parts[0].equals("I") || parts[0].equals("II") || parts[0].equals("III") || parts[0].equals("IV")
                || parts[0].equals("V") || parts[0].equals("VI") || parts[0].equals("VII") || parts[0].equals("VIII")
                || parts[0].equals("IX")|| parts[0].equals("X"))
        {return result = RomanNumerals.toRoman(calculation);}
        else {return result = String.valueOf(calculation);}
    }

}
