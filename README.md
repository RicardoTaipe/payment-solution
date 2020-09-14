# payment-solution
## OVERVIEW
Se utilizó un **(maven project)** en Eclipse para la creación de la aplicación.
La aplicación utiliza conceptos de OOP como encapsulación y herencia para que el código sea extensible.

- Clases implementadas:
  * _Main_:  
  Ejecuta la aplicacion de consola.
  * _Readfile_:  
  Permite leer el archivo y extraer la información del empleado.
  * _Employee_:  
  Contiene atributos como el nombre del empleado y horarios en los que trabajó.
Implementa el metodo `calculateTotalWage()` que permite calcular el salario total basado en las horas y días trabajados por el empleado.
  * _Schedule_:  
  Clase abstracta que contiene las hora de inicio y fin en que trabajo el empleado. Además el valor del pago para dicho horario basado en una tabla de referencia.
  * _WeekdaySchedule_:  
  Clase hija que hereda atributos de Schedule. Utilizada en horarios de Lunes - Viernes
  * _WeekendSchedule_:  
  Clase hija que hereda atributos de Schedule. Utilizada en horarios de Sabado -  Domingo

## TO RUN PROGRAM

**Importar el proyecto en Eclipse. Dentro del IDE:**

1. Ejecutar `Run as -> mvn install`. 
2. Luego ejecutar en el IDE la opción `Run as -> Java Application`
3. Para cambiar las entradas, modificar el archivo 'employee_data.txt' usando el formato del ejercicio.  
Ejemplo:  
`RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00`
## TO RUN TESTS
Ejecutar `Run as -> mvn test`



 

