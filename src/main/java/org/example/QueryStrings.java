package org.example;

public class QueryStrings {

    public static String addNewPersonalFile =
            "INSERT INTO [Личные_данные] " +
                    "([Id_Сотрудника], [Имя], [Фамилия], [Отчество], [Номер_телефона], [Адрес])";

    public static String addNewPosition =
            "INSERT INTO [Должность] " +
                    "([Id_Сотрудника], [Название_должности], [Заработная_плата], [Стаж_работы], [Повышение_должности])";

    public static String addNewDepartment =
            "INSERT INTO [Отдел] " +
                    "([Id_Отдела], [Название_отдела], [Начальник_отдела], [Проекты])";

    public static String addNewEmployee =
            "INSERT INTO [Сотрудник] " +
                    "([Id_Сотрудника], [Должность], [Отдел])";

    public static String addNewProject =
            "INSERT INTO [Действующие_проекты] " +
                    "([Id_Проекта], [Название_проекта], [Отдел_исполнитель], [Финансирование_проекта], " +
                    "[Срок_сдачи])";
}
