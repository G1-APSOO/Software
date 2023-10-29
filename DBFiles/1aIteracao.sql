-- MySQL Script generated by MySQL Workbench
-- Thu Oct 19 18:56:23 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbname
-- -----------------------------------------------------
USE `dbname` ;

-- -----------------------------------------------------
-- Table `dbname`.`Bolo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Bolo` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Bolo` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `valorUnitario` DOUBLE NOT NULL,
  `peso` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Cliente` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `RG` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `CEP` VARCHAR(20) NOT NULL,
  `celular` VARCHAR(13) NOT NULL,
  `telefoneResidencial` VARCHAR(13) NOT NULL,
  `telefoneComercial` VARCHAR(13) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`Doce`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Doce` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Doce` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `valorUnitario` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`DoceSelecionado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`DoceSelecionado` ;

CREATE TABLE IF NOT EXISTS `dbname`.`DoceSelecionado` (
  `quantidade` INT NOT NULL,
  `fk_idDoce` INT NOT NULL,
  `fk_idOrcamentoBuffetCompleto` INT NOT NULL,
  PRIMARY KEY (`fk_idOrcamentoBuffetCompleto`, `fk_idDoce`),
  INDEX `fk_idOrcamentoBuffetCompleto_idx` (`fk_idOrcamentoBuffetCompleto` ASC) VISIBLE,
  INDEX `fk_idDoce_idx` (`fk_idDoce` ASC) VISIBLE,
  CONSTRAINT `fk_idOrcamentoBuffetCompleto`
    FOREIGN KEY (`fk_idOrcamentoBuffetCompleto`)
    REFERENCES `dbname`.`OrcamentoBuffetCompleto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idDoce`
    FOREIGN KEY (`fk_idDoce`)
    REFERENCES `dbname`.`Doce` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`OrcamentoBuffetCompleto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`OrcamentoBuffetCompleto` ;

CREATE TABLE IF NOT EXISTS `dbname`.`OrcamentoBuffetCompleto` (
  `id` INT NOT NULL,
  `numeroDeConvidados` INT NOT NULL,
  `numeroDeColaboradores` INT NOT NULL,
  `horaDeInicio` VARCHAR(8) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `teraCerveja` TINYINT NOT NULL,
  `fk_cpfCliente` VARCHAR(11) NOT NULL,
  `fk_idBolo` INT NOT NULL,
  `fk_idPagamento` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cpfCliente_idx` (`fk_cpfCliente` ASC) VISIBLE,
  CONSTRAINT `fk_cpfCliente`
    FOREIGN KEY (`fk_cpfCliente`)
    REFERENCES `dbname`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idBolo`
    FOREIGN KEY (`id`)
    REFERENCES `dbname`.`Bolo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idPagamento`
    FOREIGN KEY (`id`)
    REFERENCES `dbname`.`Pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`OrcamentoLocacaoDeEspaco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`OrcamentoLocacaoDeEspaco` ;

CREATE TABLE IF NOT EXISTS `dbname`.`OrcamentoLocacaoDeEspaco` (
  `id` INT NOT NULL,
  `numeroDeConvidados` INT NOT NULL,
  `numeroDeColaboradores` INT NOT NULL,
  `horaDeInicio` VARCHAR(8) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `fk_cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cpfCliente_idx` (`fk_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_cpf`
    FOREIGN KEY (`fk_cpf`)
    REFERENCES `dbname`.`Cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`Pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Pagamento` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Pagamento` (
  `id` INT NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `formaDePagamento` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`Salgado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Salgado` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Salgado` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `valorUnitario` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`SalgadoSelecionado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`SalgadoSelecionado` ;

CREATE TABLE IF NOT EXISTS `dbname`.`SalgadoSelecionado` (
  `quantidade` INT NOT NULL,
  `fk_idSalg` INT NOT NULL,
  `fk_idOrcamentoBuffetComp` INT NOT NULL,
  INDEX `fk_idSalgado_idx` (`fk_idSalg` ASC) VISIBLE,
  INDEX `fk_idOrcamentoBuffetCompleto_idx` (`fk_idOrcamentoBuffetComp` ASC) VISIBLE,
  PRIMARY KEY (`fk_idOrcamentoBuffetComp`, `fk_idSalg`),
  CONSTRAINT `fk_idSalg`
    FOREIGN KEY (`fk_idSalg`)
    REFERENCES `dbname`.`Salgado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idOrcamentoBuffetComp`
    FOREIGN KEY (`fk_idOrcamentoBuffetComp`)
    REFERENCES `dbname`.`OrcamentoBuffetCompleto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`ServicoAdicional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`ServicoAdicional` ;

CREATE TABLE IF NOT EXISTS `dbname`.`ServicoAdicional` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(200) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`ServicoContratado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`ServicoContratado` ;

CREATE TABLE IF NOT EXISTS `dbname`.`ServicoContratado` (
  `fk_idServicoAdicional` INT NOT NULL,
  `fk_idOrcamentoLocacaoDeEspaco` INT NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`fk_idServicoAdicional`, `fk_idOrcamentoLocacaoDeEspaco`),
  INDEX `fk_idOrcamentoLocacaoDeEspaco_idx` (`fk_idOrcamentoLocacaoDeEspaco` ASC) VISIBLE,
  CONSTRAINT `fk_idOrcamentoLocacaoDeEspaco`
    FOREIGN KEY (`fk_idOrcamentoLocacaoDeEspaco`)
    REFERENCES `dbname`.`OrcamentoLocacaoDeEspaco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idServicoAdicional`
    FOREIGN KEY (`fk_idServicoAdicional`)
    REFERENCES `dbname`.`ServicoAdicional` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `dbname`.`Usuario` (
  `login` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(500) NOT NULL,
  `nome` VARCHAR(150) NOT NULL,
  `tipoDeUsuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbname`.`parcela`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbname`.`parcela` ;

CREATE TABLE IF NOT EXISTS `dbname`.`parcela` (
  `id` INT NOT NULL,
  `valorPago` DOUBLE NOT NULL,
  `dataVencimento` VARCHAR(10) NOT NULL,
  `dataPagamento` VARCHAR(10) NOT NULL,
  `fk_idPagam` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_idPagam`
    FOREIGN KEY (`id`)
    REFERENCES `exgrupo`.`Pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;