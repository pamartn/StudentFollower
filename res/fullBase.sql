

INSERT INTO Groupe(nom_groupe) VALUES ("J");

INSERT INTO Etudiant(nom,prenom,sexe,num_groupe) VALUES("Nicolas","Pamart",1,1);
INSERT INTO Etudiant(nom,prenom,sexe,num_groupe) VALUES("Glenn","Huth",1,1);
INSERT INTO Etudiant(nom,prenom,sexe,num_groupe) VALUES("Vincent","Laude",1,1);
INSERT INTO Etudiant(nom,prenom,sexe,num_groupe) VALUES("Sonia","Hachemi",1,1);


INSERT INTO Professeur(prenom, nom) VALUES ("Gery","Casiez");


INSERT INTO Horaire(date_debut,date_fin) VALUES ('2015-06-04 18:27:44','2015-06-04 20:27:44');

INSERT INTO Horaire(date_debut,date_fin) VALUES (datetime(),datetime());

INSERT INTO Cours(matiere,salle,num_groupe,num_prof,num_horaire) VALUES ("IHM","4A02",1,1,1);


INSERT INTO Cours(matiere,salle,num_groupe,num_prof,num_horaire) VALUES ("IHM","4A02",1,1,(SELECT DISTINCT num_horaire FROM Horaire WHERE date_debut=Datetime('2015-06-04 18:27:44')));