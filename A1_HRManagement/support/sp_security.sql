CREATE OR REPLACE PACKAGE BODY p_security AS

    FUNCTION f_security (
        p_secid         IN   security.sec_id%TYPE,
        p_secpassword   IN   security.sec_password%TYPE
    ) RETURN NUMBER IS
        emp_id NUMBER := 0;
    BEGIN
        SELECT
            employee_id
        INTO emp_id
        FROM
            security
        WHERE
            sec_id = p_secid
            AND sec_password = p_secpassword;

        RETURN emp_id;
    EXCEPTION
        WHEN no_data_found THEN
            RETURN 0;
    END f_security;

    PROCEDURE p_emp_info (
        p_employeeid   IN    employees.employee_id%TYPE,
        p_info         OUT   cur_empinfo
    ) AS
    BEGIN
        OPEN p_info FOR SELECT
                            *
                        FROM
                            employees
                        WHERE
                            employee_id = p_employeeid;

    END p_emp_info;

END p_security;