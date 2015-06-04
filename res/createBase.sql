CREATE TABLE IF NOT EXISTS Etudiant(
	num_etu integer PRIMARY KEY AUTOINCREMENT,
	nom VARCHAR(20),
	prenom VARCHAR(20),
	sexe INT,
	num_groupe INT,
	FOREIGN KEY (num_groupe) REFERENCES Groupe(num_groupe)
);

CREATE TABLE IF NOT EXISTS Horaire(
	num_horaire integer PRIMARY KEY AUTOINCREMENT,
	date_debut DATETIME,
	date_fin DATETIME,
	UNIQUE(date_debut, date_fin) ON CONFLICT REPLACE
);

CREATE TABLE IF NOT EXISTS Professeur(
	num_prof integer PRIMARY KEY AUTOINCREMENT,
	prenom VARCHAR(20),
	nom VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Cours(
	num_cours integer PRIMARY KEY AUTOINCREMENT,
	matiere VARCHAR(20),
	salle VARCHAR(20),
	num_groupe integer,
	num_prof INT,
	num_horaire INT,
	FOREIGN KEY (num_groupe) references Groupe(num_groupe),
	FOREIGN KEY (num_horaire) references Horaire(num_horaire),
	FOREIGN KEY (num_prof) references Professeur(num_prof)
);



CREATE TABLE IF NOT EXISTS Commentaire(
	num_etu integer,
	num_cours integer,
	num_prof integer,
	texte VARCHAR(255),
	avis INT,
	PRIMARY KEY(num_etu,num_cours,num_prof),
	FOREIGN KEY (num_cours) references Cours(num_cours),
	FOREIGN KEY (num_etu) references Etudiant(num_etu),
	FOREIGN KEY (num_prof) references Professeur(num_prof)
);

CREATE TABLE IF NOT EXISTS Groupe (
	num_groupe integer PRIMARY KEY AUTOINCREMENT,
	nom_groupe VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS Retard (
	num_cours integer,
	num_etu integer,
	minutes integer,
	PRIMARY KEY(num_etu,num_cours)
);
CREATE TABLE IF NOT EXISTS Absence (
	num_cours integer,
	num_etu integer,
	PRIMARY KEY(num_etu,num_cours)
);



