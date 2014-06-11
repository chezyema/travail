-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mer 11 Juin 2014 à 21:36
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
  PRIMARY KEY (`idarrets`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `cartecarburant`
--

CREATE TABLE IF NOT EXISTS `cartecarburant` (
  `idcarte` int(11) NOT NULL AUTO_INCREMENT,
  `numcarte` varchar(25) DEFAULT NULL,
  `kmutilisation` int(11) DEFAULT NULL,
  `litrecarburant` int(11) NOT NULL,
  PRIMARY KEY (`idcarte`),
  KEY `numcarte` (`numcarte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  `numpermis` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idchauffeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `circuit`
--

CREATE TABLE IF NOT EXISTS `circuit` (
  `idcircuit` int(11) NOT NULL AUTO_INCREMENT,
  `nomcircuit` varchar(30) NOT NULL,
  `tempsprevu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idecole` int(11) NOT NULL,
  `id` varchar(30) NOT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  PRIMARY KEY (`idcircuit`),
  KEY `FK_circuit_idecole` (`idecole`),
  KEY `FK_circuit_id` (`id`),
  KEY `FK_circuit_idchauffeur` (`idchauffeur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  `id` varchar(30) NOT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  `idtype` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddocument`),
  KEY `FK_documentsAdministratifs_id` (`id`),
  KEY `FK_documentsAdministratifs_idchauffeur` (`idchauffeur`),
  KEY `FK_documentsAdministratifs_idtype` (`idtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  PRIMARY KEY (`idecole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  PRIMARY KEY (`ideleve`),
  KEY `FK_eleve_idcircuit` (`idcircuit`),
  KEY `FK_eleve_idecole` (`idecole`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`identretien`),
  KEY `dateentretien` (`dateentretien`),
  KEY `FK_entretien_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trajets`
--

CREATE TABLE IF NOT EXISTS `trajets` (
  `idtrajets` int(11) NOT NULL AUTO_INCREMENT,
  `heurededebut` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `heuredefin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `datetravail` date DEFAULT NULL,
  `kmdepart` int(11) DEFAULT NULL,
  `kmfin` int(11) DEFAULT NULL,
  `idchauffeur` varchar(15) NOT NULL,
  `idcircuit` int(11) NOT NULL,
  `id` varchar(30) NOT NULL,
  PRIMARY KEY (`idtrajets`),
  KEY `datetravail` (`datetravail`),
  KEY `FK_trajets_idchauffeur` (`idchauffeur`),
  KEY `FK_trajets_idcircuit` (`idcircuit`),
  KEY `FK_trajets_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `idtype` int(11) NOT NULL,
  `libelledocument` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisationcarte`
--

CREATE TABLE IF NOT EXISTS `utilisationcarte` (
  `idutilisation` int(11) NOT NULL AUTO_INCREMENT,
  `dateutilisation` date DEFAULT NULL,
  `id` varchar(30) NOT NULL,
  `idcarte` int(11) DEFAULT NULL,
  PRIMARY KEY (`idutilisation`),
  KEY `dateutilisation` (`dateutilisation`),
  KEY `FK_utilisationCarte_id` (`id`),
  KEY `FK_utilisationCarte_idcarte` (`idcarte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `circuit`
--
ALTER TABLE `circuit`
  ADD CONSTRAINT `FK_circuit_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`),
  ADD CONSTRAINT `FK_circuit_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
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
  ADD CONSTRAINT `FK_documentsAdministratifs_idtype` FOREIGN KEY (`idtype`) REFERENCES `type` (`idtype`),
  ADD CONSTRAINT `FK_documentsAdministratifs_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`),
  ADD CONSTRAINT `FK_documentsAdministratifs_idchauffeur` FOREIGN KEY (`idchauffeur`) REFERENCES `chauffeur` (`idchauffeur`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `FK_eleve_idecole` FOREIGN KEY (`idecole`) REFERENCES `ecole` (`idecole`),
  ADD CONSTRAINT `FK_eleve_idcircuit` FOREIGN KEY (`idcircuit`) REFERENCES `circuit` (`idcircuit`);

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
  ADD CONSTRAINT `FK_utilisationCarte_idcarte` FOREIGN KEY (`idcarte`) REFERENCES `cartecarburant` (`idcarte`),
  ADD CONSTRAINT `FK_utilisationCarte_id` FOREIGN KEY (`id`) REFERENCES `materielroulant` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
