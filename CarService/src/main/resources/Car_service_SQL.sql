-- insertion statments 
use carservice;

  SELECT * FROM customers;

INSERT INTO customers (id, first_name, last_name, phone_number, address)
value(567, 'Jon','Smith', '303-456-8663', '123 Martin St, LA, 2356, US' ),
	(574, 'Alex', 'Murphy', '404-489-3879', '23 Eastland, LA, 3898, US' ),
    (589, 'Allen', 'Collins','102-489-9289', '327 Central Av, LA, US');
   select * from cars;
 
INSERT INTO cars (id, customers_id, license_plate, make, year)
value(15, 567, 'ABC-1234', 'TOYOTA' ,'2014'),
     (16, 574, 'DEF-4567', 'NISSAN', '2018'),
     (17, 589, 'CYG-9876', 'BMW', '2022');
    
INSERT INTO warrantys (id, cars_id, type, start_date, end_date)
value(332, 567, 'Basic', '2023-01-01', '2024-01-01'), 
      (333, 574, 'Extended', '2023-02-01', '2023-08-01'),
      (334, 589, 'Premium', '2022-03-01', '2023-03-01');
   select * from warrantys;   

INSERT INTO  appointments (id, customers_id, car_id, appointment_date, service_type)
value (12, 538, 23, '2023-07-15', 'oil change' ),
	  (13, 654, 43, '2023-08-18', 'cooler change'),
      (14, 859, 33, '2023-07-03', 'timing belts'); 
  
INSERT INTO mechanics (id, first_name, last_name, experience_years, hourly_rate) 
value(389, 'Ali', 'Gomez', 2, 30.00),
     (390, 'Sam','Collins', 4, 35.00), 
     (409, 'Allen', 'Murphy', 1, 20.00);

INSERT INTO service_record (id, Cars_id, decription, date)
value (101, 15, 'Oil Change', '2022-01-01'),
	  (202, 16, 'Brake Inspection', '2022-02-01'),
      (303, 17, 'Tire Rotation', '2022-03-01');
 
 
 select * from mechanics;

INSERT INTO supplies (id, name, address, phone)
value(1221, 'AutoZone', '897 S Oak st, LA, USA ', '404-980-3897'),
	 (1222, 'NAPA Auto', '544 NE Brea st, LA, USA', '303-987-9087'),
     (1223, 'OReilly', '278 N Market st, LA, USA','303-980-2345');

select * from supplies;
INSERT INTO parts (id, name, price)
value(28, 'headlight', 98), 
	(29, 'carquest', 100),
    (30, 'bumper cover', 115);
select * from parts;  


INSERT INTO inventories (supplies_id, parts_id, quantity)
value(101, 30, 5),
     (102, 31, 100), 
     (103, 32, 39);
    
INSERT INTO invoices (id, customers_id1, service_record_id, total_amount, date) 
value(1234, 567, 101, 100.00, '2023-03-29'),
     (2345, 574, 102, 89.30, '2023-01-11'),
     (4567, 589, 103, 120.00, '2023-04-19');
     

INSERT INTO payments (id, invoices_id, date, payment_method, amount)
value (98, 1234, '2022-01-01', 'credit card', 100.00),
      (97, 2345, '2022-02-01', 'credit card', 50.00),
      (96, 4567, '2022-03-01', 'cash', 75.00);
select * from payments;


    -- updat statement
 UPDATE customers SET phone_number = '789-6573760' WHERE id = 574;
 UPDATE appointments SET appointment_date = '2023-10-29' WHERE customers_id = 654;
 UPDATE appointments SET service_type = 'cooler change and oil change ' WHERE id = 13;
 UPDATE cars SET license_plate = 'BJX-786' WHERE customer_id = 859;
 UPDATE parts SET price = price * 1.05;
 UPDATE supplies SET address = '813 N Howard st, LA, USA' WHERE id = 1221;
 UPDATE warrantys SET type = 'Premium',start_date = '2023-06-01', end_date = '2024-06-01' where Car_id = 589;
 UPDATE invocies SET total_amount = total_amount + 25.00 WHERE customers_id = 574;
 UPDATE inventories SET quantity = quantity + 50 WHERE supplies_id = 101;
 UPDATE mechanics SET hourly_rate = CASE WHEN id = 389 THEN 32.00
                                        WHEN id = 390 THEN 37.00
                                        WHEN id = 409 THEN 22.00
                                        ELSE hourly_rate
									END;
--     deletions statment 
DELETE FROM appoitment WHERE id = 12;                               
DELETE FROM cars WHERE license_plate = 'CYG-9876';
DELETE FROM customers WHERE id = 567;    
DELETE FROM inventories WHERE Parts_id = 30;      
DELETE FROM invoices WHERE id = 1234;    
DELETE FROM mechanics WHERE experience_years < 1;    
DELETE FROM parts WHERE price > 1000.00;
DELETE FROM warrantys WHERE end_date = '2022-01-01';    
DELETE FROM supplies WHERE id= 1223 ;    
DELETE FROM service_record WHERE Cars_id = 17;


--  alter table.
ALTER TABLE customers ADD email_addres varchar(100); 
ALTER TABLE parts MODIFY COLUMN price double;
ALTER TABLE appointments RENAME COLUMN appointment_date TO date;
ALTER TABLE warrantys MODIFY COLUMN end_date date;
ALTER TABLE mechanics ADD email_addres varchar(100);

 --  join all tables in the database.
 
 SELECT * FROM customers 
 JOIN cars ON customers.id = cars.custimers_id
 JOIN appointments ON customers.id = appointments.custimers_id
 JOIN service_record ON cars.id = service_record.Cars_id
  
 JOIN inventories ON parts.id = inventories.Parts_id 
                 AND suppliers.id = inventories.suppliers_id
JOIN invoices ON customers.id = invoices.customers_id
              AND service_record = invoices.service_record_id
JOIN payments ON invoices.id = payments.Invoices_id
JOIN warrantys ON cars.id = warrantys.Cars_id;

--  statements with left, right, inner, outer joins.

SELECT *
FROM appointments
INNER JOIN customers ON appointments.customer_id = customers.id;

SELECT *
FROM customers
LEFT JOIN cars ON customers.id = cars.customers_id;

SELECT *
FROM invoices
RIGHT JOIN customers ON invoices.customers_id1 = customers.id;

SELECT *
FROM warranties
RIGHT OUTER JOIN cars ON warranties.cars_id = cars.id;

SELECT *
FROM customers
LEFT OUTER JOIN invoices ON customers.id = invoices.customers_id1;

-- statements with aggregate functions and group by and without having.
SELECT id, AVG(hourly_rate) AS average_hourly_rate
FROM mechanics
GROUP BY id;   
SELECT Invoice_id, MAX(price) AS max_price
FROM parts
GROUP BY Invoice_id;
SELECT Invoice_id, SUM(amount) AS total_amount
FROM payments
GROUP BY invoice_id;
SELECT customer_id, COUNT(*) AS appointment_count
FROM appointments
GROUP BY customer_id; 
SELECT customers_id, AVG(total_amount) AS average_total_amount
FROM Invoice
GROUP BY customers_id; 
SELECT make, AVG(YEAR(NOW()) - year) AS average_age
FROM cars
GROUP BY make;
SELECT name, SUM(price) AS total_price
FROM parts
GROUP BY name;

-- statements with aggregate functions and group by and with having.

SELECT mechanic_id, COUNT(*) AS service_count
FROM mechanics_has_service_record 
GROUP BY mechanic_id
HAVING COUNT(*) > 10;

SELECT name, SUM(price) AS total_price
FROM parts
GROUP BY name
HAVING total_price BETWEEN 100 AND 500;

SELECT parts_id, SUM(quantity) AS total_quantity
FROM inventories
GROUP BY parts_id
HAVING total_quantity > 10;

SELECT customers_id1, SUM(total_amount) AS total_amount
FROM invoices
GROUP BY customers_id1
HAVING total_amount > 500;

SELECT experience_years, AVG(hourly_rate) AS average_rate
FROM mechanics
GROUP BY experience_years
HAVING experience_years > 5;

