package org.example.seminar_tasks.homework_from_sem.task_3;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Vsevolod", "vsev123@gmail.com");
        UUID pk = UUID.randomUUID();
        emp1.setId(pk);

        QueryBuilder queryBuilder = new QueryBuilder();
        String insertQuery = queryBuilder.buildInsertQuery(emp1);

        System.out.println("Insert Query : " + insertQuery);

        String selectQuery = queryBuilder.buildSelectQuery(Employee.class, pk);
        System.out.println(selectQuery);

        String updateQuery = queryBuilder.buildUpdateQuery(emp1);
        System.out.println(updateQuery);

        String deleteQuery = queryBuilder.buildDeleteQuery(Employee.class, pk);
        System.out.println(deleteQuery);
    }
}
