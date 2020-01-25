CREATE OR REPLACE PACKAGE BODY P_SECURITY AS

  FUNCTION f_security (
        p_secid         IN   security.sec_id%TYPE,
        p_secpassword   IN   security.sec_password%TYPE
    ) RETURN NUMBER IS emp_id NUMBER := 0;
  BEGIN
        SELECT EMPLOYEE_ID INTO emp_id
        FROM SECURITY
        WHERE SEC_ID = p_secid AND SEC_PASSWORD = p_secpassword;

    RETURN emp_id;
  END f_security;

  PROCEDURE p_emp_info (
        p_employeeid   IN    employees.employee_id%TYPE,
        p_info         OUT   cur_empinfo
    ) AS
  BEGIN

    OPEN p_info FOR
    SELECT *
    FROM   EMPLOYEES
    WHERE  EMPLOYEE_ID = p_employeeid;

  END p_emp_info;

END P_SECURITY;