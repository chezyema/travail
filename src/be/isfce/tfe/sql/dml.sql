-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Ven 13 Juin 2014 à 17:48
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `tfe1`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=26 ;

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
(20, 'rue sicile 34 1200 bruxelles', 0),
(21, 'rue de Lessines', 0),
(22, 'rue gatti gamond 12', 0),
(23, 'rue douvre 12 1000bxl', 0),
(24, 'az', 0),
(25, 'rue clos 1200 bxl', 0);

-- --------------------------------------------------------

--
-- Structure de la table `cartecarburant`
--

CREATE TABLE IF NOT EXISTS `cartecarburant` (
  `idcarte` int(11) NOT NULL AUTO_INCREMENT,
  `numcarte` varchar(25) NOT NULL,
  `supprimecartecarburant` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idcarte`),
  KEY `numcarte` (`numcarte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `cartecarburant`
--

INSERT INTO `cartecarburant` (`idcarte`, `numcarte`, `supprimecartecarburant`) VALUES
(1, '001', 0),
(2, '002', 0);

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE IF NOT EXISTS `chauffeur` (
  `idchauffeur` varchar(15) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `datenaissance` date NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `codepostal` int(11) NOT NULL,
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
('123456789013', 'oqisnoqisnd', 'Yacine', '2014-05-31', 'roqinsd', 1000, 'oiqnsd', '048888888', 'serroukh@gmail.com', '89', '89', 1),
('123456789090', 'Yacine', 'Yacine', '1986-06-12', 'Yacine', 1000, 'Bruxelles', '04888888', 'yacine@yacine.com', '1234567890', '1234567890', 0),
('69122554632', 'abdeslami', 'abselam', '1969-12-25', 'rue blaes 38', 1000, 'bruxelles', '0475432312', 'abselam@hotmail.com', '987651', '0', 1),
('73092749087', 'guertit', 'fabienne', '1987-09-27', 'rue edmond bonehill  12', 1210, 'bruxelles', '025234321', 'fabienn@hotmail.com', '654321', '0', 0),
('78102345678', 'vanden borre', 'anthony', '1978-10-23', 'rue saint guidon', 1070, 'bruxelles', '0476543212', 'anthony@yahoo.fr', '765432', '0', 0),
('79102345678', 'van oudenhove', 'didier', '1979-10-23', 'rue blueth 45', 1040, 'bruxelles', '0496553212', 'didier@yahoo.fr', '876543', '0', 0),
('82031345612', 'fathi', 'mezut', '1982-03-13', 'rue josaphat 54', 1030, 'bruxelles', '0483423145', 'fathi@yahoo.fr', '987654', '0', 0),
('85112130960', 'zaoui', 'sofiane', '1985-11-21', 'rue stevens  25', 1190, 'bruxelles', '0483498251', 'zaoui@hotmail.com', '342178', '0', 0),
('86112130960', 'zahri', 'yassine', '1986-11-21', 'rue de lessines 20', 1080, 'bruxelles', '484982513', 'chezyema@hotmail.com', '987654', '0', 0),
('88061434567', 'lepierre', 'sophie', '1988-06-14', 'rue walem 122', 1083, 'bruxelles', '0498654534', 'sophie@skynet.be', '567890', '0', 0),
('89080667854', 'alexander', 'vanof', '1989-08-06', 'rue claire 34', 1060, 'bruxelles', '0488675432', 'vanof@hotmail.com', '123456', '0', 1),
('90050545678', 'amjik', 'faysal', '1990-05-05', 'rue des quatres vents 112', 1080, 'bruxelles', '0486754534', 'amjik@yahou.fr', '456789', '0', 0);

-- --------------------------------------------------------

--
-- Structure de la table `circuit`
--

CREATE TABLE IF NOT EXISTS `circuit` (
  `idcircuit` int(11) NOT NULL AUTO_INCREMENT,
  `nomcircuit` varchar(30) NOT NULL,
  `tempsprevu` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `idecole` int(11) DEFAULT NULL,
  `id` varchar(30) DEFAULT NULL,
  `idchauffeur` varchar(15) DEFAULT NULL,
  `supprimecircuits` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcircuit`),
  KEY `FK_circuit_idecole` (`idecole`),
  KEY `FK_circuit_id` (`id`),
  KEY `FK_circuit_idchauffeur` (`idchauffeur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `circuit`
--

INSERT INTO `circuit` (`idcircuit`, `nomcircuit`, `tempsprevu`, `idecole`, `id`, `idchauffeur`, `supprimecircuits`) VALUES
(1, 'elephant', '2014-06-03 00:00:00', 1, 'WWW090008UIYT546T', '69122554632', 0);

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
  `datevaliditer` date NOT NULL,
  `id` varchar(30) DEFAULT NULL,
  `idchauffeur` varchar(15) DEFAULT NULL,
  `idtype` int(11) DEFAULT NULL,
  `supprimedocument` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`iddocument`),
  KEY `FK_documentsAdministratifs_id` (`id`),
  KEY `FK_documentsAdministratifs_idchauffeur` (`idchauffeur`),
  KEY `FK_documentsAdministratifs_idtype` (`idtype`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `documentsadministratifs`
--

INSERT INTO `documentsadministratifs` (`iddocument`, `datevaliditer`, `id`, `idchauffeur`, `idtype`, `supprimedocument`) VALUES
(4, '2014-06-15', NULL, '123456789090', 1, 0),
(5, '2014-06-28', NULL, '123456789090', 5, 0),
(6, '2014-06-19', NULL, '73092749087', 3, 0),
(7, '2014-06-21', 'WWW090008UIYT546T', NULL, 4, 0),
(8, '2014-06-15', NULL, '123456789090', 3, 0);

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
  `nomdirecteur` varchar(30) NOT NULL,
  `supprimeecole` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idecole`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `ecole`
--

INSERT INTO `ecole` (`idecole`, `nomecole`, `adresseecole`, `cdpostal`, `vil`, `telecole`, `emailecole`, `nomdirecteur`, `supprimeecole`) VALUES
(1, 'la flutte enchante', 'bld mettewie 45', 1080, 'bruxelles', '025234231', 'laplume@hotmail.com', 'nathalie', 0),
(2, 'école europeen', 'chaussée de waterloo 1150', 1180, 'bruxelles', '022123456', 'ecoleeuropeen@hotmail.com', 'kriesh de wolf', 0),
(3, 'la plume', 'rue du midi 67', 1000, 'bruxelles', '024536758', 'laplume@hotmail.com', 'wissal ahmed', 0),
(4, 'Ecole 12', 'rue de veeweyde 76', 1070, 'bruxelles', '023432564', 'ecole12@gmail.com', 'edward stevens', 0),
(5, 'ecole Imelda', 'chaussée de ninove 123', 1080, 'Bruxelles', '023425674', 'Imelda@hotmail.com', 'laurent depast', 0),
(6, 'lycee français', 'avenue brugmann 23', 1180, 'bruxelles', '028765432', 'lyceefrancais@gmail.com', 'petra romenige', 0);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

CREATE TABLE IF NOT EXISTS `eleve` (
  `ideleve` varchar(30) NOT NULL,
  `nomeleve` varchar(30) NOT NULL,
  `prenomeleve` varchar(30) NOT NULL,
  `datedenaissance` date NOT NULL,
  `adresseeleve` varchar(40) NOT NULL,
  `codepostal` int(11) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `nomresponsable` varchar(30) NOT NULL,
  `telresponsable` varchar(11) NOT NULL,
  `emailresponsable` varchar(30) DEFAULT NULL,
  `idcircuit` int(11) DEFAULT NULL,
  `idecole` int(11) DEFAULT NULL,
  `supprimeeleve` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ideleve`),
  KEY `FK_eleve_idcircuit` (`idcircuit`),
  KEY `FK_eleve_idecole` (`idecole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `eleve`
--

INSERT INTO `eleve` (`ideleve`, `nomeleve`, `prenomeleve`, `datedenaissance`, `adresseeleve`, `codepostal`, `ville`, `nomresponsable`, `telresponsable`, `emailresponsable`, `idcircuit`, `idecole`, `supprimeeleve`) VALUES
('99122530950', 'amraoui', 'mohamed', '1999-12-25', 'rue de l''agrafe 23', 1070, 'Bruxelles', 'amraoui ahmed', '0488765432', 'amraoui@gmail.com', NULL, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `identretien` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(30) NOT NULL,
  `kmentretienfait` int(11) NOT NULL,
  `dateentretien` date NOT NULL,
  `id` varchar(30) NOT NULL,
  `supprimeentretien` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`identretien`),
  KEY `dateentretien` (`dateentretien`),
  KEY `FK_entretien_id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `entretien`
--

INSERT INTO `entretien` (`identretien`, `description`, `kmentretienfait`, `dateentretien`, `id`, `supprimeentretien`) VALUES
(1, 'vidange', 80000, '2014-06-13', 'WWW090008UIYT546T', 0),
(2, 'changement de pneus', 92000, '2014-06-13', 'WWW2345FDER234567', 0);

-- --------------------------------------------------------

--
-- Structure de la table `materielroulant`
--

CREATE TABLE IF NOT EXISTS `materielroulant` (
  `id` varchar(30) NOT NULL,
  `marque` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `anneedeconstruction` date NOT NULL,
  `carburant` varchar(30) NOT NULL,
  `numimmatr` varchar(7) NOT NULL,
  `nbdeplaces` int(11) NOT NULL,
  `kmactuel` int(11) NOT NULL,
  `validiterexctincteur` date NOT NULL,
  `supprimematerielroulant` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `materielroulant`
--

INSERT INTO `materielroulant` (`id`, `marque`, `type`, `anneedeconstruction`, `carburant`, `numimmatr`, `nbdeplaces`, `kmactuel`, `validiterexctincteur`, `supprimematerielroulant`) VALUES
('WWW090008UIYT546T', 'TEMSA', 'minibuS', '2011-09-14', 'dieseL', '1GFR567', 24, 67000, '2016-04-20', 0),
('WWW0987YTR456ED45', 'TEMSA', 'minibus', '2006-05-11', 'diesel', '1OPI765', 30, 92000, '2014-06-19', 0),
('WWW2345FDER234567', 'mercedes', 'minibus', '2009-06-14', 'diesel', '1yrt432', 24, 110000, '2014-06-15', 0),
('WWW456FF4564456T6', 'volvo', 'bus', '2012-05-18', 'diesel', '1BBE234', 56, 50000, '2017-02-14', 0),
('WWW5677GHJ45678T98', 'mercedes', 'minibus', '2008-02-04', 'diesel', '1RET654', 20, 65000, '2015-05-22', 0),
('WWW6547GFR4563897', 'volvo', 'bus', '2011-06-10', 'diesel', '1ezr342', 54, 100000, '2014-06-29', 0),
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
  `heurededebut` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `heuredefin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `datetravail` date NOT NULL,
  `kmdepart` int(11) NOT NULL,
  `kmfin` int(11) NOT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  `idcircuit` int(11) NOT NULL,
  `id` varchar(30) NOT NULL,
  `supprimetrajets` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idtrajets`),
  KEY `datetravail` (`datetravail`),
  KEY `FK_trajets_idchauffeur` (`idchauffeur`),
  KEY `FK_trajets_idcircuit` (`idcircuit`),
  KEY `FK_trajets_id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `trajets`
--

INSERT INTO `trajets` (`idtrajets`, `heurededebut`, `heuredefin`, `datetravail`, `kmdepart`, `kmfin`, `idchauffeur`, `idcircuit`, `id`, `supprimetrajets`) VALUES
(1, '1970-01-01 06:10:00', '1970-01-01 08:10:00', '2014-06-13', 118000, 118210, '123456789090', 1, 'WWW090008UIYT546T', 0),
(2, '1970-01-01 14:00:00', '1970-01-01 16:00:00', '2014-06-16', 124000, 124321, '123456789090', 1, 'WWW090008UIYT546T', 0),
(3, '1970-01-01 07:05:00', '1970-01-01 08:25:00', '2014-06-17', 133879, 133934, '123456789090', 1, 'WWW090008UIYT546T', 0);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `idtype` int(11) NOT NULL AUTO_INCREMENT,
  `libelledocument` varchar(30) DEFAULT NULL,
  `supprimetype` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idtype`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `type`
--

INSERT INTO `type` (`idtype`, `libelledocument`, `supprimetype`) VALUES
(1, 'Sélection médicale', 0),
(2, 'CAP', 0),
(3, 'Carte Chauffeur', 0),
(4, 'Contrôle Technique', 0),
(5, 'Assurance', 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisationcarte`
--

CREATE TABLE IF NOT EXISTS `utilisationcarte` (
  `idutilisation` int(11) NOT NULL AUTO_INCREMENT,
  `dateutilisation` date NOT NULL,
  `litrecarburant` int(11) DEFAULT NULL,
  `kmutilisation` int(11) DEFAULT NULL,
  `id` varchar(30) NOT NULL,
  `idcarte` int(11) DEFAULT NULL,
  `supprimeutilisationcarte` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idutilisation`),
  KEY `dateutilisation` (`dateutilisation`),
  KEY `FK_utilisationCarte_id` (`id`),
  KEY `FK_utilisationCarte_idcarte` (`idcarte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `utilisationcarte`
--

INSERT INTO `utilisationcarte` (`idutilisation`, `dateutilisation`, `litrecarburant`, `kmutilisation`, `id`, `idcarte`, `supprimeutilisationcarte`) VALUES
(1, '2014-06-13', 123, 88000, 'WWW090008UIYT546T', 1, 0),
(2, '2014-06-13', 100, 88700, 'WWW090008UIYT546T', 1, 0),
(3, '2014-06-13', 122, 110000, 'WWW0987YTR456ED45', 2, 0);

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
  ADD CONSTRAINT `FK_documentsAdministratifs_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`),
  ADD CONSTRAINT `FK_documentsAdministratifs_idtype` FOREIGN KEY (`idtype`) REFERENCES `type` (`idtype`);

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
