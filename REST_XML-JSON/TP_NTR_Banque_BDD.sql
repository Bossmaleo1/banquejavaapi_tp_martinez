-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le :  sam. 11 avr. 2020 à 21:05
-- Version du serveur :  5.6.35
-- Version de PHP :  7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `TP_NTR_Banque_BDD`
--
create database TP_NTR_Banque_BDD;
use TP_NTR_Banque_BDD;
-- --------------------------------------------------------
-- use `TP_NTR_Banque_BDD`;
--
-- Structure de la table `Banque`
--

CREATE TABLE `Banque` (
  `idBanque` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `siege` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Banque`
--

INSERT INTO `Banque` (`idBanque`, `nom`, `siege`) VALUES
(1, 'CIC', '6 avenue de Provence 75009 Paris'),
(2, 'BNP Paribas', '16 bd des Italiens 75009 Paris'),
(3, 'Crédit agricole', '12 place des États-Unis 92127 Montrouge Cedex'),
(4, 'Caisse d\'Epargne', '50 avenue Pierre Mendès France 75201 Paris Cedex 13'),
(5, 'LCL', '18 rue de la République 69002 Lyon'),
(6, 'Boursorama', '44 Rue Traversière, 92772 Boulogne-Billancourt'),
(7, 'Crédit du Nord', '28, place Rihour 59800 Lille');

-- --------------------------------------------------------

--
-- Structure de la table `Compte`
--

CREATE TABLE `Compte` (
  `idCompte` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `codePostal` int(5) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `idBanque` int(11) NOT NULL,
  `solde` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Compte`
--

INSERT INTO `Compte` (`idCompte`, `nom`, `prenom`, `adresse`, `codePostal`, `ville`, `idBanque`, `solde`) VALUES
(1, 'Dupont', 'Martin', '10 boulevard des routes', 59300, 'Valenciennes', 1, 200),
(2, 'Legrand', 'Bernard', '3 rue des choux', 59000, 'Lille', 2, 1000),
(3, 'Amazon', '', '67 Boulevard du Général Leclerc', 92110, 'Clichy', 2, 555555);

-- --------------------------------------------------------

--
-- Structure de la table `Operation`
--

CREATE TABLE `Operation` (
  `idOperation` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `date` text NOT NULL,
  `idCompteDebit` int(11) NOT NULL,
  `idCompteCredit` int(11) NOT NULL,
  `somme` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Operation`
--

INSERT INTO `Operation` (`idOperation`, `nom`, `date`, `idCompteDebit`, `idCompteCredit`, `somme`) VALUES
(3, 'Amazon', '2019-02-11', 1, 3, 10.2),
(4, 'Amazon', '2019-02-07', 2, 1, 72.12),
(5, 'Amazon', '2019-02-06', 1, 3, 19.99),
(7, 'Salaire', '2019-01-11', 3, 2, 1450),
(8, 'Remboursement', '2019-03-03', 1, 3, 14.99),
(9, 'Achat', '2019-03-04', 2, 1, 30),
(10, 'Virement', '2019-03-01', 3, 1, 20);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Banque`
--
ALTER TABLE `Banque`
  ADD PRIMARY KEY (`idBanque`);

--
-- Index pour la table `Compte`
--
ALTER TABLE `Compte`
  ADD PRIMARY KEY (`idCompte`),
  ADD KEY `fk_idBanque` (`idBanque`);

--
-- Index pour la table `Operation`
--
ALTER TABLE `Operation`
  ADD PRIMARY KEY (`idOperation`),
  ADD KEY `fk_idCompteDebit` (`idCompteDebit`),
  ADD KEY `idCompteCredit` (`idCompteCredit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Banque`
--
ALTER TABLE `Banque`
  MODIFY `idBanque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `Compte`
--
ALTER TABLE `Compte`
  MODIFY `idCompte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `Operation`
--
ALTER TABLE `Operation`
  MODIFY `idOperation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1053;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Compte`
--
ALTER TABLE `Compte`
  ADD CONSTRAINT `fk_idBanque` FOREIGN KEY (`idBanque`) REFERENCES `Banque` (`idBanque`);

--
-- Contraintes pour la table `Operation`
--
ALTER TABLE `Operation`
  ADD CONSTRAINT `fk_idCompteDebit` FOREIGN KEY (`idCompteDebit`) REFERENCES `Compte` (`idCompte`),
  ADD CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`idCompteCredit`) REFERENCES `Compte` (`idCompte`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
