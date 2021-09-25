use ecom_webapp;

DELIMITER &&
create procedure get_all_products_and_count()
begin
 SELECT * FROM ecom_webapp.ecom_products;
 SELECT count(id) as total_products FROM ecom_webapp.ecom_products;
end &&
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE add_product(IN pname varchar(100), IN pprice decimal(10,2))
INSERT INTO eproduct(name,price) values (pname,pprice)
$$
DELIMITER ;


{call add_product }