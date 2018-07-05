--
-- Database: `OrderDetails_db`
--

CREATE DATABASE `OrderDetails_db`;
-- ENTITIES

--
-- Struttura della tabella `Customer`
--

    CREATE TABLE `OrderDetails_db`.`Customer` (	
        
        `Contact` varchar(40),

        
        `mail` varchar(40),

        
        `name` varchar(40),

        
        `password` varchar(40),

        
        `surname` varchar(40),

        
        `username` varchar(40),
        -- RELAZIONI
        `Orders` DECIMAL(38, 0), 
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Customer_PK` ON `OrderDetails_db`.`Customer` (`_id`);
    ALTER TABLE `OrderDetails_db`.`Customer` ADD CONSTRAINT `Customer_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `OrderDetails_db`.`Customer` MODIFY `_id` DECIMAL(38,0) NOT NULL;

--
-- Struttura della tabella `Item`
--

    CREATE TABLE `OrderDetails_db`.`Item` (	
        
        `Description` varchar(40),

        
        `Name` varchar(40),

        
        `Price` numeric,
        -- RELAZIONI
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Item_PK` ON `OrderDetails_db`.`Item` (`_id`);
    ALTER TABLE `OrderDetails_db`.`Item` ADD CONSTRAINT `Item_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `OrderDetails_db`.`Item` MODIFY `_id` DECIMAL(38,0) NOT NULL;

--
-- Struttura della tabella `Order`
--

    CREATE TABLE `OrderDetails_db`.`Order` (	
        
        `OrderDate` date,

        
        `OrderTotal` numeric,

        
        `Qty` numeric,
        -- RELAZIONI
        `Items` DECIMAL(38, 0), 
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Order_PK` ON `OrderDetails_db`.`Order` (`_id`);
    ALTER TABLE `OrderDetails_db`.`Order` ADD CONSTRAINT `Order_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `OrderDetails_db`.`Order` MODIFY `_id` DECIMAL(38,0) NOT NULL;


-- RELATIONS

    -- RELATIONS TABLE Customer
    
        
        -- foreign key Orders
        ALTER TABLE `OrderDetails_db`.`Customer` ADD CONSTRAINT `Customer_Orders` FOREIGN KEY (`Orders`)
        	  REFERENCES `Order` (`_id`) ON DELETE SET NULL;
        
        
        
        



    -- RELATIONS TABLE Item
    
        
        
        
        



    -- RELATIONS TABLE Order
    
        
        -- foreign key Items
        ALTER TABLE `OrderDetails_db`.`Order` ADD CONSTRAINT `Order_Items` FOREIGN KEY (`Items`)
        	  REFERENCES `Item` (`_id`) ON DELETE SET NULL;
        
        
        
        



INSERT INTO user (`_id`, `username`, `password`, `mail`, `name`, `surname`) VALUES (1, 'admin', '1a1dc91c907325c69271ddf0c944bc72', '', '', '');

CREATE TABLE `OrderDetails_db`.`roles` (	
    `role` VARCHAR(30), 
    `_user` DECIMAL(38, 0), 
    `_id` DECIMAL(38,0)
);

CREATE UNIQUE INDEX `ROLES_PK` ON `OrderDetails_db`.`roles` (`_id`);
ALTER TABLE `OrderDetails_db`.`roles` ADD CONSTRAINT `ROLES_PK` PRIMARY KEY (`_id`);
ALTER TABLE `OrderDetails_db`.`roles` MODIFY `_id` DECIMAL(38,0) NOT NULL;
ALTER TABLE `OrderDetails_db`.`roles` ADD CONSTRAINT `ROLES_FK1` FOREIGN KEY (`_user`)
	  REFERENCES `OrderDetails_db`.`user` (`_id`);

INSERT INTO roles (`role`, `_user`, `_id`) VALUES ('ADMIN', '1', 1);

