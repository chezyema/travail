
phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mer 28 Mai 2014 à 13:41
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `tfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `arrets`
--

CREATE TABLE IF NOT EXISTS `arrets` (
  `idarrets` int(11) NOT NULL AUTO_INCREMENT,
  `adressearrets` varchar(40) NOT NULL,
  `supprimearrets` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idarrets`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `arrets`
--

INSERT INTO `arrets` (`idarrets`, `adressearrets`, `supprimearrets`) VALUES
(1, 'rue de l''agrafe 12 1070 Bruxelles', 0),
(2, 'rue blaes 12 1000 Bruxelles', 0),
(3, 'rue du dessin 876 1070 bruxelles', 0),
(4, 'rue haute 212 1000 bruxelles', 0),
(5, 'rue du menin 34 1081 bruxelles', 0),
(6, 'rue jean jacquet 58 1081 bruxelles', 0),
(7, 'boulevard poincare 432 1000 bruxelles', 0),
(8, 'bld louis mettewie 23 1080 bruxelles', 0),
(9, 'rue mettewie 54 1070', 0),
(10, 'avenue bertrand 23 1030 Bruxelles', 0),
(11, 'rue des pierres 2 1210 bruxelles', 0),
(12, 'rue alfred stevens 8 1180 bxl ', 0),
(13, 'rue de namur 45 1050 bruxelles', 0),
(14, 'rue wertz 39 1000 bruxelles', 0),
(15, 'rue clovis 124 1020 bruxelles', 0),
(16, 'rue gatti gamond 92 1180 Bruxelles', 0),
(17, 'rue de forest 65 1190 Bruxelles', 0),
(18, 'av van volxem 765 1190 bruxelles', 0),
(19, 'rue de la grenouile 32 1200 bruxelles', 0),
(20, 'rue sicile 34 1200 bruxelles', 0);

-- --------------------------------------------------------

--
-- Structure de la table `cartecarburant`
--

CREATE TABLE IF NOT EXISTS `cartecarburant` (
  `idcarte` int(11) NOT NULL AUTO_INCREMENT,
  `kmutilisation` int(11) DEFAULT NULL,
  `litrecarburant` int(11) NOT NULL,
  `numcarte` varchar(11) NOT NULL,
  `supprimecartecarburant` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcarte`),
  KEY `numcarte` (`numcarte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `cartecarburant`
--

INSERT INTO `cartecarburant` (`idcarte`, `kmutilisation`, `litrecarburant`, `numcarte`, `supprimecartecarburant`) VALUES
(1, 65000, 100, '100', 0),
(2, 123000, 234, '101', 0),
(3, 66000, 125, '102', 0),
(4, 125000, 98, '104', 0),
(5, 98000, 65, '104', 0),
(6, 453000, 250, '102', 0),
(7, 280000, 158, '103', 0),
(8, 176980, 67, '102', 0),
(9, 23000, 50, '101', 0),
(10, 24500, 230, '100', 0),
(11, 650000, 340, '102', 0),
(12, 657898, 452, '100', 0),
(13, 178698, 54, '101', 0),
(14, 345213, 98, '100', 0),
(15, 342567, 98, '101', 0),
(16, 123987, 123, '103', 0),
(17, 21000, 210, '101', 0),
(18, 22345, 127, '104', 0),
(19, 765432, 231, '103', 0),
(20, 150000, 125, '100', 0);

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE IF NOT EXISTS `chauffeur` (
  `idchauffeur` varchar(15) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) NOT NULL,
  `datenaissance` date NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `codepostal` int(11) DEFAULT NULL,
  `ville` varchar(30) NOT NULL,
  `numtelephone` varchar(11) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `numcartesis` varchar(11) NOT NULL,
  `numpermis` varchar(11) NOT NULL,
  `supprimechauffeur` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idchauffeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `chauffeur`
--

INSERT INTO `chauffeur` (`idchauffeur`, `nom`, `prenom`, `datenaissance`, `adresse`, `codepostal`, `ville`, `numtelephone`, `email`, `numcartesis`, `numpermis`, `supprimechauffeur`) VALUES
('69122554632', 'abdeslami', 'abselam', '1969-12-25', 'rue blaes 38', 1000, 'bruxelles', '0475432312', 'abselam@hotmail.com', '0', '0', 0),
('73092749087', 'guertit', 'fabienne', '1987-09-27', 'rue edmond bonehill  12', 1210, 'bruxelles', '025234321', 'fabienn@hotmail.com', '0', '0', 0),
('78102345678', 'vanden borre', 'anthony', '1978-10-23', 'rue saint guidon', 1070, 'bruxelles', '0476543212', 'anthony@yahoo.fr', '0', '0', 0),
('79102345678', 'van oudenhove', 'didier', '1979-10-23', 'rue blueth 45', 1040, 'bruxelles', '0496553212', 'didier@yahoo.fr', '0', '0', 0),
('82031345612', 'fathi', 'mezut', '1982-03-13', 'rue josaphat 54', 1030, 'bruxelles', '0483423145', 'fathi@yahoo.fr', '0', '0', 0),
('85112130960', 'zaoui', 'sofiane', '1985-11-21', 'rue stevens  25', 1190, 'bruxelles', '0483498251', 'zaoui@hotmail.com', '0', '0', 0),
('86112130960', 'zahri', 'yassine', '1986-11-21', 'rue de lessines 20', 1080, 'bruxelles', '484982513', 'chezyema@hotmail.com', '0', '0', 0),
('88061434567', 'lepierre', 'sophie', '1988-06-14', 'rue walem 122', 1083, 'bruxelles', '0498654534', 'sophie@skynet.be', '0', '0', 0),
('89080667854', 'alexander', 'vanof', '1989-08-06', 'rue claire 34', 1060, 'bruxelles', '0488675432', 'vanof@hotmail.com', '0', '0', 0),
('90050545678', 'amjik', 'faysal', '1990-05-05', 'rue des quatres vents 112', 1080, 'bruxelles', '0486754534', 'amjik@yahou.fr', '0', '0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `circuit`
--

CREATE TABLE IF NOT EXISTS `circuit` (
  `idcircuit` int(11) NOT NULL AUTO_INCREMENT,
  `nomcircuit` varchar(30) NOT NULL,
  `tempsprevu` varchar(20) NOT NULL,
  `kmdepart` int(11) NOT NULL,
  `kmfin` int(11) NOT NULL,
  `idecole` int(11) DEFAULT NULL,
  `id` varchar(30) NOT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  `supprimecircuits` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcircuit`),
  KEY `FK_circuit_idecole` (`idecole`),
  KEY `FK_circuit_id` (`id`),
  KEY `FK_circuit_idchauffeur` (`idchauffeur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `circuit`
--

INSERT INTO `circuit` (`idcircuit`, `nomcircuit`, `tempsprevu`, `kmdepart`, `kmfin`, `idecole`, `id`, `idchauffeur`, `supprimecircuits`) VALUES
(1, 'elephant', '2H00', 123001, 123123, 1, 'WWW090008UIYT546T', '69122554632', 0),
(2, 'les canards', '2h30', 128000, 128124, 2, 'WWW456FF4564456T6', '73092749087', 0);

-- --------------------------------------------------------

--
-- Structure de la table `contient`
--

CREATE TABLE IF NOT EXISTS `contient` (
  `idcircuit` int(11) NOT NULL,
  `idarrets` int(11) NOT NULL,
  PRIMARY KEY (`idcircuit`,`idarrets`),
  KEY `FK_contient_idarrets` (`idarrets`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `documentsadministratifs`
--

CREATE TABLE IF NOT EXISTS `documentsadministratifs` (
  `iddocument` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) DEFAULT NULL,
  `datevaliditer` date NOT NULL,
  `id` varchar(30) DEFAULT NULL,
  `idchauffeur` varchar(15) DEFAULT NULL,
  `supprimedocument` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`iddocument`),
  KEY `FK_documentsAdministratifs_id` (`id`),
  KEY `FK_documentsAdministratifs_idchauffeur` (`idchauffeur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `documentsadministratifs`
--

INSERT INTO `documentsadministratifs` (`iddocument`, `libelle`, `datevaliditer`, `id`, `idchauffeur`, `supprimedocument`) VALUES
(1, 'selection medical', '2015-05-14', NULL, '69122554632', 0),
(2, 'carte chauffeur', '2015-05-09', NULL, '69122554632', 0),
(3, 'cap', '2014-05-15', NULL, '69122554632', 0),
(4, 'assurance', '2015-05-07', 'WWW090008UIYT546T', NULL, 0),
(5, 'contrôle technique', '2014-09-18', 'WWW090008UIYT546T', NULL, 0);

-- --------------------------------------------------------

--
-- Structure de la table `ecole`
--

CREATE TABLE IF NOT EXISTS `ecole` (
  `idecole` int(11) NOT NULL AUTO_INCREMENT,
  `nomecole` varchar(30) NOT NULL,
  `adresseecole` varchar(30) NOT NULL,
  `cdpostal` int(11) NOT NULL,
  `vil` varchar(30) NOT NULL,
  `telecole` varchar(11) NOT NULL,
  `emailecole` varchar(30) DEFAULT NULL,
  `nomdirecteur` varchar(30) DEFAULT NULL,
  `supprimeecole` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idecole`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `ecole`
--

INSERT INTO `ecole` (`idecole`, `nomecole`, `adresseecole`, `cdpostal`, `vil`, `telecole`, `emailecole`, `nomdirecteur`, `supprimeecole`) VALUES
(1, 'la flutte enchante', 'bld mettewie 45', 1080, 'bruxelles', '025234231', 'laplume@hotmail.com', 'nathalie', 0),
(2, 'école europeen', 'chaussée de waterloo 1150', 1180, 'bruxelles', '022123456', 'ecoleeuropeen@hotmail.com', 'kriesh de wolf', 0),
(3, 'la plume', 'rue du midi 67', 1000, 'bruxelles', '024536758', 'laplume@hotmail.com', 'wissal ahmed', 0),
(4, 'Ecole 12', 'rue de veeweyde 76', 1070, 'bruxelles', '023432564', 'ecole12@gmail.com', 'edward stevens', 0);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `ideleve` varchar(30) NOT NULL,
  `nomeleve` varchar(30) DEFAULT NULL,
  `prenomeleve` varchar(30) DEFAULT NULL,
  `datedenaissance` date DEFAULT NULL,
  `adresseeleve` varchar(40) NOT NULL,
  `codepostal` int(11) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `nomresponsable` varchar(30) NOT NULL,
  `telresponsable` varchar(11) NOT NULL,
  `emailresponsable` varchar(30) DEFAULT NULL,
  `idcircuit` int(11) NOT NULL,
  `idecole` int(11) NOT NULL,
  `supprimeecole` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ideleve`),
  KEY `FK_eleve_idcircuit` (`idcircuit`),
  KEY `FK_eleve_idecole` (`idecole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `eleve`
--

INSERT INTO `eleve` (`ideleve`, `nomeleve`, `prenomeleve`, `datedenaissance`, `adresseeleve`, `codepostal`, `ville`, `nomresponsable`, `telresponsable`, `emailresponsable`, `idcircuit`, `idecole`, `supprimeecole`) VALUES
('10030467854', 'clovis', 'bernard', '2010-03-04', 'rue du menin 32', 1081, 'bruxelles', 'clovis serge', '0472345212', 'clovis@yahoo.fr', 1, 1, 0),
('11112378654', 'boubkar', 'moussa', '2011-11-23', 'rue de flandre 32', 1080, 'bruxelles', 'boubkar brahim', '0487765098', 'boubkar@hotmail.com', 1, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `identretien` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) DEFAULT NULL,
  `kmentretienfait` int(11) NOT NULL,
  `dateentretien` date NOT NULL,
  `id` varchar(30) NOT NULL,
  `supprimeentretien` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`identretien`),
  KEY `dateentretien` (`dateentretien`),
  KEY `FK_entretien_id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `entretien`
--

INSERT INTO `entretien` (`identretien`, `description`, `kmentretienfait`, `dateentretien`, `id`, `supprimeentretien`) VALUES
(1, 'changement de freins', 90000, '2012-07-12', 'WWW090008UIYT546T', 0),
(2, 'vidange huile', 95000, '2013-05-09', 'WWW090008UIYT546T', 0),
(3, 'changement bulles de pression', 100000, '2014-02-05', 'WWW090008UIYT546T', 0),
(4, 'remplacement essuie-glace', 110000, '2013-11-05', 'WWW090008UIYT546T', 0);

-- --------------------------------------------------------

--
-- Structure de la table `materielroulant`
--

CREATE TABLE IF NOT EXISTS `materielroulant` (
  `id` varchar(30) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `anneedeconstruction` date DEFAULT NULL,
  `carburant` varchar(30) NOT NULL,
  `numimmatr` varchar(7) DEFAULT NULL,
  `nbdeplaces` int(11) NOT NULL,
  `kmactuel` int(11) NOT NULL,
  `validiterexctincteur` date DEFAULT NULL,
  `supprimematerielroulant` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `materielroulant`
--

INSERT INTO `materielroulant` (`id`, `marque`, `type`, `anneedeconstruction`, `carburant`, `numimmatr`, `nbdeplaces`, `kmactuel`, `validiterexctincteur`, `supprimematerielroulant`) VALUES
('WWW090008UIYT546T', 'TEMSA', 'minibus', '2011-09-14', 'diesel', '1GFR567', 24, 67000, '2016-04-20', 0),
('WWW0987YTR456ED45', 'TEMSA', 'minibus', '2006-05-11', 'diesel', '1OPI765', 30, 92000, '2014-06-19', 0),
('WWW456FF4564456T6', 'volvo', 'bus', '2012-05-18', 'diesel', '1BBE234', 56, 50000, '2017-02-14', 0),
('WWW5677GHJ45678T98', 'mercedes', 'minibus', '2008-02-04', 'diesel', '1RET654', 20, 65000, '2015-05-22', 0),
('WWW87645RET234ZER5', 'volvo', 'bus', '2014-01-10', 'diesel', '1GFD879', 54, 20000, '2019-05-31', 0),
('WWW8765RTYU43ZE87', 'mercedes', 'minibus', '2008-04-16', 'diesel', '1AAA456', 20, 88000, '2016-05-12', 0),
('WWW9807FFG4356789', 'volvo', 'bus', '2005-05-05', 'diesel', '1AZE123', 56, 120000, '2014-05-30', 0),
('WWWSS123456789014', 'vanhool', 'bus', '2005-05-12', 'diesel', '1GFR567', 54, 123000, '2015-05-11', 0);

-- --------------------------------------------------------

--
-- Structure de la table `trajets`
--

CREATE TABLE IF NOT EXISTS `trajets` (
  `idtrajets` int(11) NOT NULL AUTO_INCREMENT,
  `heurededebut` varchar(25) DEFAULT NULL,
  `heuredefin` varchar(25) DEFAULT NULL,
  `datetravail` date DEFAULT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  `idcircuit` int(11) NOT NULL,
  `id` varchar(30) NOT NULL,
  `supprimetrajets` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idtrajets`),
  KEY `datetravail` (`datetravail`),
  KEY `FK_trajets_idchauffeur` (`idchauffeur`),
  KEY `FK_trajets_idcircuit` (`idcircuit`),
  KEY `FK_trajets_id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `trajets`
--

INSERT INTO `trajets` (`idtrajets`, `heurededebut`, `heuredefin`, `datetravail`, `idchauffeur`, `idcircuit`, `id`, `supprimetrajets`) VALUES
(1, '14H45', '17H00', '2014-05-08', '69122554632', 1, 'WWW090008UIYT546T', 0),
(2, '06H40', '8H45', '2014-03-06', '73092749087', 2, 'WWW456FF4564456T6', 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisationcarte`
--

CREATE TABLE IF NOT EXISTS `utilisationcarte` (
  `idutilisation` int(11) NOT NULL AUTO_INCREMENT,
  `dateutilisation` date DEFAULT NULL,
  `id` varchar(30) NOT NULL,
  `idcarte` int(11) DEFAULT NULL,
  `supprimeutilisationcarte` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idutilisation`),
  KEY `dateutilisation` (`dateutilisation`),
  KEY `FK_utilisationCarte_id` (`id`),
  KEY `FK_utilisationCarte_idcarte` (`idcarte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `utilisationcarte`
--

INSERT INTO `utilisationcarte` (`idutilisation`, `dateutilisation`, `id`, `idcarte`, `supprimeutilisationcarte`) VALUES
(1, '2014-05-15', 'WWW090008UIYT546T', 1, 0),
(2, '2014-05-23', 'WWW090008UIYT546T', 1, 0);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `circuit`
--
ALTER TABLE `circuit`
  ADD CONSTRAINT `FK_circuit_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
  ADD CONSTRAINT `FK_circuit_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`),
  ADD CONSTRAINT `FK_circuit_idecole` FOREIGN KEY (`idecole`) REFERENCES `ecole` (`idecole`);

--
-- Contraintes pour la table `contient`
--
ALTER TABLE `contient`
  ADD CONSTRAINT `FK_contient_idarrets` FOREIGN KEY (`idarrets`) REFERENCES `arrets` (`idarrets`),
  ADD CONSTRAINT `FK_contient_idcircuit` FOREIGN KEY (`idcircuit`) REFERENCES `circuit` (`idcircuit`);

--
-- Contraintes pour la table `documentsadministratifs`
--
ALTER TABLE `documentsadministratifs`
  ADD CONSTRAINT `FK_documentsAdministratifs_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
  ADD CONSTRAINT `FK_documentsAdministratifs_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `FK_eleve_idcircuit` FOREIGN KEY (`idcircuit`) REFERENCES `circuit` (`idcircuit`),
  ADD CONSTRAINT `FK_eleve_idecole` FOREIGN KEY (`idecole`) REFERENCES `ecole` (`idecole`);

--
-- Contraintes pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `FK_entretien_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`);

--
-- Contraintes pour la table `trajets`
--
ALTER TABLE `trajets`
  ADD CONSTRAINT `FK_trajets_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
  ADD CONSTRAINT `FK_trajets_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`),
  ADD CONSTRAINT `FK_trajets_idcircuit` FOREIGN KEY (`idcircuit`) REFERENCES `circuit` (`idcircuit`);

--
-- Contraintes pour la table `utilisationcarte`
--
ALTER TABLE `utilisationcarte`
  ADD CONSTRAINT `FK_utilisationCarte_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
  ADD CONSTRAINT `FK_utilisationCarte_idcarte` FOREIGN KEY (`idcarte`) REFERENCES `cartecarburant` (`idcarte`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
