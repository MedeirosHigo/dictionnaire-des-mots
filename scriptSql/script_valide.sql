/**
*	Jeu de données testé, validé et approuvé
*/


			-- Dictionnaire -- 
INSERT INTO Dictionnaire VALUES (0, "amélioration", "progrès", "improvement", "nom commun", "Augmenter les capacités de qqln ou qqlchose");
INSERT INTO Dictionnaire VALUES (1, "partir", "quitter", "leave", "verbe", "prendre le départ");
INSERT INTO Dictionnaire VALUES (2, "marcher", "piétiner", "walk", "verbe", "avancer à pied");
INSERT INTO Dictionnaire VALUES (3, "manger", "engloutir", "eat", "verbe", "mon activité préférée");


			-- Type -- 
INSERT INTO type VALUES ("verbe irrégulier");
INSERT INTO type VALUES ("pronom");
INSERT INTO type VALUES ("adjectif qualifacatif");


			-- Equivalence --
INSERT INTO Equivalence VALUES ("improvement", "amélioration");
INSERT INTO Equivalence VALUES ("leave", "partir");
INSERT INTO Equivalence VALUES ("walk", "marcher");
INSERT INTO Equivalence VALUES ("eat", "manger");


			-- VerbeIrregulier -- 
INSERT INTO VerbeIrregulier VALUES ("left", "left", "leave", "partir");
INSERT INTO VerbeIrregulier VALUES ("ate", "eaten", "eat", "manger");


			-- Player -- 
INSERT INTO Player VALUES (0, "Pepito",10, 2021-10-12); 


