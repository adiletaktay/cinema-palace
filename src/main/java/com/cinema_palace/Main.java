package com.cinema_palace;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isStart = true;
        Scanner in = new Scanner(System.in);
        CinemaTicketSystem system = new CinemaTicketSystem();
        while (isStart) {
            System.out.println("Здравствуйте, у вас есть следующие доступные функции:");
            System.out.println("1. Добавить новый фильм;");
            System.out.println("2. Показать все доступные фильмы;");
            System.out.println("3. Добавить нового пользователя;");
            System.out.println("4. Купить билет;");
            System.out.println("5. Отменить покупку билета;");
            System.out.println("6. Показать все билеты;");
            System.out.println("7. Показать всех пользователей;");
            System.out.println("8. Завершить операцию");
            System.out.print("Ваш ответ: ");
            int response = in.nextInt();
            in.nextLine();
            int responseId;
            switch (response) {
                case 1:
                    System.out.println("Введите название нового фильма");
                    String movieName = in.nextLine();
                    responseId = system.addMovie(movieName);
                    System.out.println("id добавленного фильма: " + responseId);
                    break;
                case 2:
                    system.showAllMovies();
                    break;
                case 3:
                    System.out.println("Введите имя нового пользователя:");
                    String userName = in.nextLine();
                    responseId = system.addUser(userName);
                    System.out.println("id добавленного пользователя:" + responseId);
                    break;
                case 4:
                    System.out.println("Введите id пользователя:");
                    int userId = in.nextInt();
                    in.nextLine();
                    System.out.println("Введите id фильма:");
                    int movieId = in.nextInt();
                    in.nextLine();
                    responseId = system.buyTicket(userId, movieId);
                    if (responseId == -1) {
                        System.out.println("id пользователя или фильма не правильны!");
                    } else {
                        System.out.println("Вы покупаете билет с id: " + responseId);
                    }
                    break;
                case 5:
                    System.out.println("Введите id билета");
                    int idTicket = in.nextInt();
                    in.nextLine();
                    boolean bl = system.cancelTicket(idTicket);
                    if (bl) {
                        System.out.println("Вы отменили покупку билета с id:" + idTicket);
                    } else {
                        System.out.println("Вы не смогли отменить покупку билета с id:" + idTicket);
                    }
                    break;
                case 6:
                    system.showTickets();
                    break;
                case 7:
                    system.showUsers();
                    break;
                case 8:
                    isStart = false;
                    break;
            }
        }
        in.close();
    }
}
