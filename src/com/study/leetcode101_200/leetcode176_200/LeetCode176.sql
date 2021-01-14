select
    ifnull(
        (select distinct Salary
            from employee
            order by Salary DESC
            limit 1 offset 1),null
        )as SecondHighestSalary