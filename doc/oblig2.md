## Del 1 - Prosjektrapport 
#### *Hvordan fungerer rollene i teamet?*
Isolert sett fungerer rollene i teamet ganske bra. Praktisk sett er vi ikke kommet så langt i utviklingen av spillet enda at spesifike roller som UX, Design og Test-ansvarlig ikke har vært nødvendig. Derimot har alles rolle som utvikler fungert bra, og vi har på møter blitt enige over hvem som skal gjøre hvilke arbeidsoppgaver (Git issues). Teamlead har også til en viss grad hatt overordnet ansvar over kodebasen, noe som vi synes har fungert godt. Vi har også opplevd at det å ha en som er ansvarlig for booking av møterom, referater etc. har vært veldig fint. Derfor ønsker vi ikke å gjøre noen forandringer på rollene som ble satt i oblig1. 

#### *Kommentar til prosjektmetodikk*
I oblig1 bestemte vi oss for å forsøke å følge scrum prosjektmetodikk, i hvilken grad vi har lykkes med dette kan diskuteres. Tanken var å kjøre tidsbegrensede sprinter med standups ved slutten av sprintene. Det vi har gjort er å bryte ned oblig2, oblig3 og oblig4. Og innenfor disse igjen spesifisert hvilke krav vi har og hva som må fullføres før deadline til de respektive obligene. Altså er hver oblig en sprint som ender ved innlevering av oblig. 

Videre bestemte vi oss i oblig1 å benytte oss av Git Issues for progresjonskontroll. Dette er vi veldig fornøyde med. I Issues har vi laget Milestones som representerer hver oblig; 
- shmup%"Oblig 2: Alpha" 
- shmup%"Oblig 3: Release candidate"
- shmup%"Oblig 4: Final"

Hver eneste milestone er igjen brutt ned til ulike issues, hvor vi spesifiserer hva som må gjøres (Se [Issues List](https://git.app.uib.no/javajunkies/shmup/-/issues)). Vi merker issues med hvilke milestone de tilhører og "assigner" issues til et av gruppemedlemene. Videre ligger alle issues på [Issues Board](https://git.app.uib.no/javajunkies/shmup/-/boards), her har vi en oversikt over hvilke oppgaver som er "open" og hvilke som er "closed". 
Bruken av disse verktøyene har gjør at vi hele tiden har oversikt over hva som må gjøres, hva som er gjort, hvem som har gjort hva og hvem som holder på med hvilke arbeidsoppgaver. Noe som altså er veldig bra! 

#### *Kommunikasjon og gruppedynamikk*
Vi er i stor grad enig i at dynamikken i gruppen er god. Kommunikasjonen foregår på vår discord kanal og face-to-face, og dette synes vi fungerer godt. Alle som er med i gruppen stiller opp på våre faste møter når de kan og bidrar så godt de kan.  

#### *Retrospektiv*
-- skal fylles ut -- 

#### *Kommentar til commits*
Vi har prøvd å fordele arbeidsoppgaver likt så godt det lar seg gjøre. Samt har vi prioritert å jobbe med kode i fellesskap på møter, slik at de mindre erfarne på gruppen kan lære av andre. I tillegg har vi skjønt at det innad i gruppen er forskjellig praksis på commits (noen commiter oftere enn andre, eks commits av typos/hele features). Derfor er nok ikke commit-historikken helt representativ for hvor mye arbeid som er gjort av hver enkelt gruppemedlem.

Forutenom dette prøver vi å lage informative commits meldinger som referer til respektive issues. 

#### *3 forbedringspunkter fra retrospektiv*
1. -- skal fylles ut -- 
2. -- skal fylles ut -- 
3. Være flinkere på testdrevet utvikling. 

## Del 2 - Krav og spesifikasjon 
#### *Prioriteringer*
Som det kommer fram av shmup%"Oblig 2: Alpha" har vi til denne obligen hatt følgende mål:
- switch from Swing to libGDX 
- Player can move. (But restricted to lower part of screen)
- Player can auto-shoot.
- Enemy can move.
- Bullets can kill enemies if touched.
- When all enemies are killed, a new wave of enemies is spawned.
- Can render sprites. (One for player, one for enemy and one for bullet)

Disse prioiteringene ble bestemt i plenum på det første møtet etter innlevering av oblig1. Det vi si at vi det er dette vi har prioritert i denne obligen. For vår del kommer utvikling av ny funksjonalitet ganske naturlig. Først må en spller kunne beveges, så må bevegelsen restrikteres, så må spiller kunne auto-skyte, så må spilleren ha noen å skyte på, så må det som skytes på kunne bli "skadet", så må fiender kunne "skade" spilleren osv osv. For alle disse kravene se brukerhistorier med tilhørende akseptansekriterier [her](#Brukerhistorier-(MVP-1-10)). 

#### *Veien videre* 
Nå ved levering av oblig2 (uke 10), har vi via neste milestone klart for oss hva som blir veien videre. Per nå har vi et absolutt minimum av et spill. Det er spillbart, men fortsatt mye som gjenstår før spillet er fullstendig og helhetlig. Det betyr at vi fremover kommer til å fortsette å implementere alle elementene vi ønsker at vårt spill skal ha (lyd, forside/hjelpeside, highscore, "power-ups" etc.). Samtidig vil vi fokusere på å gjøre kodebasen så robust som mulig. Eksempelvis gjennom å kartlegge gjenbruk av kode, arv, "generic-ifisering" av klasser, encapsulation, generell "separation of concerns" og testing. Etter innlevering av oblig2 har vi planlagt å sette oss ned og spesifisere og diskutere hva vi vil prioritere i oblig3. 
 

 #### *Justeringer på  MVP krav* 
ingen store justeringer på MVP krav. Kravene fra oblig1 var utformet ganske generelle av den grunn å kunne tilfredstille ulik implementasjon. Vi har derimot lagt til noen krav ettersom vi har kommet lengre i utviklingen av spillet og spesifisert noen krav etterhver som vi har sett hva vi ønsker. Se [MVP's](#MVP's).
 
 #### *Bugs (som vi vet om)* 
ingen 

## Del 3 - Produkt og kode 
#### *Kommentater til kode:*
I oblig1 benyttet vi oss av et model-view-controller oppsett. En av de store omveltningene på vårt prosjekt til denne obligen er å vri oss vekk fra dette og til en mer actor-basert modell. Dette har vi gjort da et slikt oppsett er mer kompatibelt med libGDX. 

#### *Utarbedring av feil*
Ved forrige oblig var kun krav 1-3 fullført, og kun disse hadde brukerhistorier. Nå har alle krav fått tilhørende brukerhistorier. Og nye krav er lagt til. 

#### *Lage README*
Se [README.md](shmup/README.md)

#### *Klassediagram*
Se [klassediagram.png](shmup/doc/klassediagram.png)

#### *Manuelle tester*
Se [manuelletester.md](shmup/doc/ManuelleTester.md)

#### *Automatiske tester*
Automatiske tester har dessverre blitt nedprioritert i oblig2. Som sagt er noe av det vi har lyst til å forbedre til oblig3 dette. Vi har hatt stort fokus på kun implementering og neglisjert det å skrive tester. 

## Møtereferater 
#### - Uke 8 - 
- Dato: 20 februar  
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

Tema & arbeid: 
- Lagde en plan for videre arbeid. Hvordan vi kan implementere libGDX i vårt prosjekt. 
- Opprettet issues og milestones for tiden framover.

#### - Uke 9 - 
- Dato: 27 februar  
- Tilstede: Lars, Philip, Mats, Halvor 

tema & arbeid: 
- Jobbet videre med oblig2. 
- Flyttet bulletlogic fra gameview til playerbullet. 
- Flyttet playerlogic fra gamescreen til player. 
- Snakket om veien videre til obligfrist og oppdaterte issues. 
- Alle jobber selvstendig med egne issues fram til neste møte. 

#### - Uke 10 - 
- Dato: 6 mars 
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

tema & arbeid:  -- hentes fra discord kanal -- 

#### - Uke 10 (møte 2) - 
- Dato: 9 mars  
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

tema & arbeid:  -- hentes fra discord kanal --

#### - Uke 10 (møte 3) - 
- Dato: 10 mars  
- Tilstede: Lars, Philip, Mats, Herman, Ljubo

tema & arbeid:  -- hentes fra discord kanal --

## MVP's
1. Vise et spillbrett 
2. Vise et element på spillbrettet
3. Flytte spiller/element 
4. Vise fiender
5. Spiller interagerer med fiender/spillelementer
6. Spiller kan auto-skyte 
7. Fiende kan auto-skyte
8. Spiller kan dø 
9. FIende kan dø
10. Meny-skjerm ved start/slutt av spill 
11. Waves 
12. Score 

##### Brukerhistorier (MVP 1-10)
<b> Brukerhistorie #1: </b> Vise grafisk vindu

Acceptance criteria:
- Grafikken vises, en skjerm blir presentert for spiller. 
- Spillet kræsjer ikke. 

Task to perform:
- Implementer en klasse som abstraherer en spillskjerm
- Kall på den gitte spillskjermen i main  

Stories:
- Som spiller trenger jeg et spillbrett slik at jeg i spillet kan bevege og styre min spiller
- Som utvikler trenger jeg et spillbrett som vil vise min spillverden og hvor jeg kan plassere ulike spillobjekter. 

<b> Brukerhistorie #2: </B> Se spillelement på mitt spillbrett. 

Acceptance criteria:
- På spillbrettet skal det bli presentert et objekt 
- Objektet skal være selvstendig fra bakgrunn 

Task to perfrom:
- Implementer en klasse som abstraherer et spillobjekt 
- Finn grafikk som egner seg til å representere spillobjekt. 
- Kall på objekt i main. 

Stories:
- Som spiller trenger jeg en "egen" identifiserbar objekt som kan interagere med spillet. 
- Som utvikler trenger jeg et objekt som vil representere en spiller i spillet. 

<b> Brukerhistorie #3: </B> Flytte på mitt objekt rundt i spillverden

Acceptance criteria:
- Tastetrykk fører til at spillobjekt beveger seg. 
- Bevegelsen skal være begrenset til innenfor spillskjermets rammer. 

Task to perfrom:
- Implementer metoder som tar input fra tastetrykk. 
- Sørg for korrekt "størrelse" på bevegelse per tastetrykk. 
- Vis bevegelse på skjerm 

Stories:
- Som spiller trenger jeg å kunne bevege på min spiller i spillverdene ved hjelp av piltaster. 
- Som utvikler trenger jeg at en spiller kan manipulere  sitt spillobjekt i spillverdenen for å kunne spille spillet. 

<b> Brukerhistorie #4: </B> Se fiendene mine på spillbrettet

Acceptance criteria: 
- På spillbrettet skal det bli presentert et objekt 
- Objektet skal være selvstendig fra bakgrunn 
- Objektet skal være selvstendig fra "spilleren" 

Task to perfrom:
- Implementer en klasse som abstraherer et spillobjekt 
- Finn grafikk som egner seg til å representere spillobjekt. 
- Kall på objekt i main. 

Stories:
- Som spiller trenger jeg å kunne se "fiender" i spillverden for at jeg skal kunne interagere med dem. 
- Som utvikler trenger jeg at det vises fiender på spillbrettet ettersom de skal interagere med spiller. 

<b> Brukerhistorie #5: </b> Interagere med spillverden/fiender

Acceptance criteria:
- Spiller kan ikke gå gjennom fiender
- Spiller kan ikke gå gjennom andre objekter i spillverden. 

Task to perfrom:
- Sørge for at spiller og fiende objekter blir stoppet ved kollisjon. 

Stories:
- Som spiller trenger jeg at navigering i spillverden er logisk og at spillobjekter ikke kan gå inn i hverandre. 
- Som utvikler trenger jeg en måte å sørge for at spilleren beveger seg logisk gjennom spillverdenen. 

<b> Brukerhistorie #6: </b> Spiller/Fiende kan skyte 

Acceptance criteria:
- Objekt som representer skudd kommer ut av spiller 

Task to perfrom:
- Implementere en klasse som abstraherer skudd 
- Implementer metode som får skudd til å gå ut fra spiller. 

Stories:
- Som spiller trenger jeg at mitt spillobjekt kan skyte for at jeg skal kunne spille spillet og for at spillet i det hele tatt kan være gøy. 
- Som utvikler trenger jeg at spillobjektet skyter skudd slik at det kan interagere med fiender. 

<b> Brukerhistorie #7: </b> Spiller kan dø 

Acceptance criteria:
- Dersom spiller blir "truffet" av fiende skudd avsluttes spillet. 

Task to perfrom:
- Implementer metode som sjekker om fiendeskudd er i kontakt med spiller. 

Stories:
- Som spiller må jeg kunne dø for at spillet i det hele tatt skal være utfordrende og morsomt. 
- Som utvikler må jeg definere når en spiller er død for å kunne avslutte spillet. 

<b> Brukerhistorie #8: </b> Fiende kan dø

Acceptance criteria:
- Dersom fiende blir "truffet" av spiller-skudd skal fienden forsvinne.  

Task to perfrom:
- Implementer metode som sjekker om spillerskudd er i kontakt med fiende. 

Stories:
- Som spiller må jeg kunne "drepe" fiender for å kunne ha progresjon i spillet og samle poeng. 
- Som utvikler må jeg definere hvordan spiller kan komme seg videre i spillet. 

<b> Brukerhistorie #9: </b> Meny-skjerm ved start/slutt

Acceptance criteria:
- Vise startskjerm når applikasjonen startes. 
- Vise spillinstruksjoner på startskjerm. 
- Vise avsluttningsskjerm når spillet er over. 

Task to perfrom:
- Lage grafikk for start/slutt skjerm 
- Implementer skjermer 

Stories:
- Som spiller trenger jeg å vite når spillet starter og slutter, og hvordan jeg spiller spillet. 
- Som utvikler trenger jeg metoder for å bytte mellom de forskjellige skjermene på. 

<b> Brukerhistorie #10: </b> Waves

Acceptance criteria:
- Når siste fiende på brettet dør skal nye fiender komme på brettet. 

Task to perfrom:
- Implementere en klasse som kan styre en rekke med fiender
- Implementer metoder som "kaster" inn nye fiender når siste fiende på brettet er fjernet. 

Stories:
- Som spiller må jeg kunne få opp nye fiender når alle på spillbrettet er borte. 
- Som utvikler må jeg kunne ha metoder som sørger for at nye fiender kommer på brettet når det er tomt. 

<b> Brukerhistorie #11: </b> Score

Acceptance criteria:
- Spilleren skal ha en poengscore. 
- Spilleren må ha en mulighet for å samle poeng. 
- Spillerens poengscore må endres når den utfører handling som skal gi poeng. 

Task to perfrom:
- Implementere poengscore for spiller 
- Vise poengscore på skjermen 
- Ha metoder for å endre poengscore

Stories:
- Som spiller må jeg ha et insentiv for å komme så langt som mulig i spillet. 
- Som utvikler trenger jeg metoder for å kunne endre og holde på spillerens poengscore. 
