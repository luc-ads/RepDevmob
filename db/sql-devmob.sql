-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE devmob;
CREATE SCHEMA IF NOT EXISTS `devmob` DEFAULT CHARACTER SET utf8 ;
USE `devmob` ;

-- -----------------------------------------------------
-- Table `devmob`.`tb_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_company` (
    `id_company` INT NOT NULL AUTO_INCREMENT,
    `company_name` VARCHAR(100) NULL,
    `company_cnpj` INT NULL,
    `company_address` VARCHAR(200) NULL,
    `company_email` VARCHAR(100) NULL,
    `company_password` VARCHAR(20) NULL,
    `company_phone_number` VARCHAR(45) NULL,
    PRIMARY KEY (`id_company`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_users` (
    `id_user` INT NOT NULL AUTO_INCREMENT,
    `fk_company` INT NOT NULL,
    `fk_manager` INT NULL,
    `user_name` VARCHAR(100) NULL,
    `user_email` VARCHAR(100) NULL,
    `user_password` VARCHAR(20) NULL,
    `user_phone_number` VARCHAR(15) NULL,
    PRIMARY KEY (`id_user`),
    FOREIGN KEY (`fk_company`)
        REFERENCES `devmob`.`tb_company` (`id_company`),
    FOREIGN KEY (`fk_manager`)
        REFERENCES `devmob`.`tb_users` (`id_user`)
);


-- -----------------------------------------------------
-- Table `davmob`.`tb_equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_equipment` (
    `id_equipment` VARCHAR(200) NOT NULL,
    `fk_user` INT NOT NULL,
    `operational_system` VARCHAR(100) NULL,
    `manufacturer` VARCHAR(100) NULL,
    `architecture` VARCHAR(100) NULL,
    `equipment_ram` VARCHAR(100) NULL,
    `equipment_hd` VARCHAR(100) NULL,
    `name_processor` VARCHAR(100) NULL,
    `physical_cpus` INT NULL,
    `logical_cpus` INT NULL,
    PRIMARY KEY (`id_equipment` , `fk_user`),
    FOREIGN KEY (`fk_user`)
        REFERENCES `devmob`.`tb_users` (`id_user`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_computer_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_computer_log` (
    `id_log` INT NOT NULL AUTO_INCREMENT,
    `fk_equipment` VARCHAR(200) NOT NULL,
    `log_time` TIMESTAMP DEFAULT now(),
    `cpu_percentage` DOUBLE NULL,
    `cpu_temperature` DECIMAL(2) NULL,
    `hd_percentage` DECIMAL(2) NULL,
    `ram_percentage` LONG NULL,
    PRIMARY KEY (`id_log`),
    FOREIGN KEY (`fk_equipment`)
        REFERENCES `devmob`.`tb_equipment` (`id_equipment`)
);


-- -----------------------------------------------------
-- Table `davmob`.`tb_points`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_points` (
    `fk_user` INT NOT NULL,
    `points` INT NULL,
    `last_update` TIMESTAMP DEFAULT now(),
    PRIMARY KEY (`fk_user`),
    FOREIGN KEY (`fk_user`)
        REFERENCES `devmob`.`tb_users` (`id_user`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_employee` (
    `id_employee` INT NOT NULL AUTO_INCREMENT,
    `employee_name` VARCHAR(100) NULL,
    `employee_sector` VARCHAR(30) NULL,
    `employee_status` VARCHAR(10) NULL,
    PRIMARY KEY (`id_employee`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_occurrence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_occurrence` (
    `id_occurrence` INT NOT NULL AUTO_INCREMENT,
    `fk_user` INT NOT NULL,
    `description` VARCHAR(300) NULL,
    `occurrence_status` VARCHAR(10) NULL,
    `occurrence_time` TIMESTAMP DEFAULT now(),
    PRIMARY KEY (`id_occurrence`),
    FOREIGN KEY (`fk_user`)
        REFERENCES `devmob`.`tb_users` (`id_user`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_occurrence_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_occurrence_service` (
    `fk_employee` INT NOT NULL AUTO_INCREMENT,
    `fk_occurrence` INT NOT NULL,
    `attendance_time` TIMESTAMP DEFAULT now(),
    PRIMARY KEY (`fk_employee` , `fk_occurrence` , `attendance_time`),
    FOREIGN KEY (`fk_employee`)
        REFERENCES `devmob`.`tb_employee` (`id_employee`),
    FOREIGN KEY (`fk_occurrence`)
        REFERENCES `devmob`.`tb_occurrence` (`id_occurrence`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_leads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_leads` (
    `id_leads` INT NOT NULL AUTO_INCREMENT,
    `leads_name` VARCHAR(100) NULL,
    `leads_company_name` VARCHAR(100) NULL,
    `leads_phone` VARCHAR(15) NULL,
    `leads_email` VARCHAR(100) NULL,
    `leads_description` VARCHAR(300) NULL,
    PRIMARY KEY (`id_leads`)
);


-- -----------------------------------------------------
-- Table `devmob`.`tb_leads_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `devmob`.`tb_leads_service` (
    `fk_employee` INT NOT NULL AUTO_INCREMENT,
    `fk_leads` INT NOT NULL,
    `attendance_time` TIMESTAMP NOT NULL,
    PRIMARY KEY (`fk_employee` , `fk_leads` , `attendance_time`),
    FOREIGN KEY (`fk_employee`)
        REFERENCES `devmob`.`tb_employee` (`id_employee`),
    FOREIGN KEY (`fk_leads`)
        REFERENCES `devmob`.`tb_leads` (`id_leads`)
);

INSERT INTO tb_company VALUES(
NULL, 'COMPANY ADM','123456789','BANDTEC','COMPANY@ADM.COM','123','TEL'
);

INSERT INTO tb_users VALUES(
NULL, 1 ,NULL,'ADM','USER@ADM.COM','123','TEL'
);

INSERT INTO tb_users VALUES(
NULL, 1 ,1,'teste','teste','teste','TEL'
);

SELECT * FROM tb_company;

SELECT * FROM tb_users;

SELECT * FROM tb_equipment;

SELECT * FROM tb_computer_log;

SELECT fk_equipment,cpu_percentage, ram_percentage FROM tb_computer_log ORDER BY fk_equipment = 'BFEBFBFF000A0660' DESC LIMIT 1;

-- SELECT (fk_equipment, cpu_percentage, ram_percentage ) FROM tb_computer_log ORDER BY fk_equipment = '1' DESC LIMIT 1; 