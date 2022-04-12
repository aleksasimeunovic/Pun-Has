/*INSERT INTO COMPANY (name, address) VALUES ('FTN', 'Trg Dositeja Obradovića 6');

INSERT INTO DEPARTMENT (name, company_id) VALUES ('Menadžment', 1);
INSERT INTO DEPARTMENT (name, company_id) VALUES ('Računarski centar', 1);

INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Aleksandar', 'Aleksić', 'radnik', 1);
INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Milica', 'Milić', 'menadžer', 1);
INSERT INTO EMPLOYEE (first_name, last_name, position, department_id) VALUES ('Slavica', 'Slavić', 'radnik', 2);

INSERT INTO PROJECT (name, deadline) VALUES ('Biću student FTN', '2019-02-10');
INSERT INTO PROJECT (name, deadline) VALUES ('Podizanje sistema', '2019-05-1');

INSERT INTO WORKING (project_id, employee_id) VALUES (1, 1);
INSERT INTO WORKING (project_id, employee_id) VALUES (1, 2);
INSERT INTO WORKING (project_id, employee_id) VALUES (2, 3);*/

INSERT INTO KORISNIK (KorisnickoIme, Lozinka, Ime, Prezime, Pol, Datum_rodjenja, Uloga) VALUES ('aleksasimeunovic', 'aleksa1234', 'Aleksa', 'Simeunovic', 'MUSKO', '2001-07-19', Admin);
INSERT INTO KORISNIK (KorisnickoIme, Lozinka, Ime, Prezime, Pol, Datum_rodjenja, Uloga) VALUES ('nemanjaranitovic', 'nemanjica1234', 'Nemanja', 'Ranitovic', 'MUSKO', '2001-07-28', Admin);
INSERT INTO KORISNIK (KorisnickoIme, Lozinka, Ime, Prezime, Pol, Datum_rodjenja, Uloga) VALUES ('nikolacvejic', 'dzonibrate', 'Nikola', 'Cvejic', 'MUSKO', '2001-06-16', Dostavljac);
INSERT INTO KORISNIK (KorisnickoIme, Lozinka, Ime, Prezime, Pol, Datum_rodjenja, Uloga) VALUES ('vladimirblanusa', 'blanushaolin', 'Vladimir', 'Blanusa', 'MUSKO', '2001-01-28', Menadzer);
INSERT INTO KORISNIK (KorisnickoIme, Lozinka, Ime, Prezime, Pol, Datum_rodjenja, Uloga) VALUES ('radovicnikola', 'sunjalica', 'Nikola', 'Radovic', 'MUSKO', '2001-11-03', Kupac);

INSERT INTO RESTORAN(Naziv, Tip, Lokacija) VALUES ('Ognjiste', 'Rostilj', 1);
INSERT INTO RESTORAN(Naziv, Tip, Lokacija) VALUES ('Papricica', 'Rositlj', 2);
INSERT INTO RESTORAN(Naziv, Tip, Lokacija) VALUES ('Canzona', 'Italijanski restoran', 3);

INSERT INTO ARTIKAL(Naziv, Cena, Tip, Kolicina, Opis) VALUES ('Pljeskavica', 250.60, Jelo, 200.0,' Punjena pljeskavica');
INSERT INTO ARTIKAL(Naziv, Cena, Tip, Kolicina, Opis) VALUES ('Pizza', 170.20, Jelo, 120.0,' Margharita ');

INSERT INTO KOMENTAR(Komentar, Ocena) VALUES('Dobra hrana!', 4.5);
INSERT INTO KOMENTAR(Komentar, Ocena) VALUES('Losa hrana!', 2.5);

INSERT INTO LOKACIJA(Pozicija, Adresa) VALUES ((2,3), 'Bulevar Oslobodjenja 25');
INSERT INTO LOKACIJA(Pozicija, Adresa) VALUES ((12,13), 'Janka Cmelinka 24');

INSERT INTO PORUDZBINA(Datum, Vreme, Cena, Status) VALUES('2022-04-12', 11:28:43, 250.60, Obrada);

INSERT INTO TIPKUPCA(Ime, Popust, TrazeniBrB) VALUES ('Zlatni', 30, 10);
INSERT INTO TIPKUPCA(Ime, Popust, TrazeniBrB) VALUES ('Srebrni', 20, 6);
INSERT INTO TIPKUPCA(Ime, Popust, TrazeniBrB) VALUES ('Bronzani', 10, 3);







INSERT INTO DOSTAVLJAC()