# SHMUP - INF112 Project

Team: Java Junkies (Gruppe 4) 

Forfattere: 
- Mats Dyrøy 
- Herman Torget Stautland
- Ljubomir Simic
- Philip Svenningsen
- Halvor Cappelen Wik
- Lars Haukland

[Lenke til gitlab](https://git.app.uib.no/javajunkies/shmup)

## Beskrivelse av spillet
Dette spillet er et Shoot ’Em Up spill. Inspiriasjon til spillet er hentet fra ulike [STGs](https://en.wikipedia.org/wiki/Shoot_%27em_up). 

## Hvordan kjøre prosjektet
Alternativ 1:
1. Installer [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html) eller nyere
2. Last ned en IDE som støtter Java / ta i bruk kommandolinjen til å kompilere Java filer
3. Klon prosjektet via Git, kan gjøres via HTTPS eller SSH. 
    - SSH: git clone git@git.app.uib.no:javajunkies/shmup.git
    - HTTPS: git clone https://git.app.uib.no/javajunkies/shmup.git 
4. Importer Maven endringer, ved bruk av IDE
5. Kjør src/main/java/inf112/shmup/desktop/Main.java eller kompiler manuelt via kommandolinje og spillet vil starte

Alternativ 2:
1. Pakkes med `mvn clean package`
2. Kjøres med `java -jar target/shmup-1.0-SNAPSHOT-fat.jar`

## Hvordan spille spillet
- Bruk piltastene til å navigere spiller
- Unngå å bli truffet av skudd fra fiender
- Treff fiender med egne skudd for å samle poeng
- Samle PowerUps fra fiender 
- Målet med spillet er å samle mest mulig poeng, lykke til! 

- Tips: Fang en "Ship-upgrade" for å utvikle skipet ditt! 

## Kjente feil
* Pipeline fungerer ikke

## Credits og lisenser
Applikasjonsrammeverk 
- LibGDX https://libgdx.com

Game assets
- Kenny https://kenney.nl/assets/pixel-shmup 

Online leaderboard hosting
- App42 http://api.shephertz.com/

Musikk og lydeffekter
- insert link

Alle har tillatelse til å anvende og dele kildekoden i dette prosjektet fritt. 
