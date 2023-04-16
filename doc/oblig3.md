## Del 1 - Prosjektrapport 
#### *Hvordan fungerer rollene i teamet?*
Stort sett fungerer rollene bra. Tankene vi gjorde oss angående roller og arbeidsoppgaver i forrige oblig (oblig2) står vi fortsatt ved. Som sagt opplever vi at de spesifikke rollene vi har satt føles som noe øverflødig eller irrelevant, da alle stort sett har hatt arbeidsoppgaver som er noe uavhengige av hvilken rolle de er tildelt. 

Når det er sagt sitter vi med en følelse av at om prosjektet hadde vært enda større og mer komplekst ser vi en åpenbar verdi i å ha spesifikke roller, da dette nok sikrer en utvikling som i større grad tar vare på alle aspekter ved et prosjekt.
Vi finner derimot fremdeles stor verdi i å ha en teamlead som har overordnet ansvar. Spesielt ettersom denne obligen har vært i påskeferien når teamet har vært splittet og fysisk kontakt har vært begrenset. 

#### *Kommentar til prosjektmetodikk*
Som forklart i oblig2 har vi fortsatt med å bruke Git Issues for progresjonskontroll. Dette syns vi fungerer strålende. Vi har fortsatt å jobbe mot våre 2 siste Milestones:
- shmup%"Oblig 3: Release candidate"
- shmup%"Oblig 4: Final"

Igjen bryter vi ned milestones i ulike issues (Se [Issues List](https://git.app.uib.no/javajunkies/shmup/-/issues)) og «assigner» issues til ulike gruppemedlemmer. En oversikt over hva som må gjøres/er gjort har vi på vårt [Issues Board](https://git.app.uib.no/javajunkies/shmup/-/boards). 

Dette har vært spesielt nyttig når vi ikke har kunnet møtes fysisk like hyppig som tidligere. Vi har kontinuerlig oversikt over hvem som gjør hva og hva som er gjort eller ikke gjort. Vi har tatt til oss tilbakemeldingene fra oblig2 og har diskutert hvordan vi kan få til et step for «verification», slik at vi bedre kan spredt kunnskapen om spillet til alle. Vi har ikke fått implementert et slik step i Git issues, men har nok i større grad blitt bevisste på å fortelle/forklare hverandre hva man har gjort når en har fullført ulike arbeidsoppgaver. En ting vi har prøvd, er «review-requests» i Git. Eksempelvis, dersom et gruppemedlem vil merge to branches, kan han legge til et annet medlem som deretter må godkjenne requesten. Dette vil være en form for verification step. 

#### *Kommunikasjon og gruppedynamikk*
Vi er fortsatt samstemte på at dynamikken og stemningen i gruppen er god. Til forskjell fra oblig2 har kommunikasjonen i denne obligen i større grad gått igjennom vår discord kanal. Dette kommer nok av flere grunner. Først og fremst ettersom de fleste har vært «hjemme» på påskeferie og ikke vært i Bergen. Vi opplever også at vi lærer hverandre å kjenne bedre og bedre etter hvert som vi kommer lenger ut i prosjektet. Det er naturlig å tro at terskelen for å si i fra om noe bare blir lavere og lavere, noe som vi syns er bra. 

I retrospektiv fra oblig2 la vi vekt på at vi blant annet ønsker å samle gruppen litt ekstra før hver innlevering. I og med at innleveringen av denne obligen kommer rett etter påskeferien har mange av oss vært bortreist. For vår del, som liker best å møtes fysisk, har dette vært noe suboptimalt. Men vi har løst det med gode møter digitalt via vår discord kanal. 

#### *Retrospektiv*
I motsetning til tidligere har vi i denne obligen jobbet noe mer individuelt. Med en god ramme for spillet har det vært gøy å jobbe med ulike features. Vi er totalt sett fornøyde med hva vi har fått til i denne obligen og føler vi ser enden på prosjektet. Tester er fremdeles noe vi har forbedringspotensialet på. Et annet punkt vi føler vi kan bli bedre på er det å se over hverandres arbeid og dele hva hver enkelt av oss har gjort, altså code-review. Ble på et tidspunkt også noe forvirring rundt ulike branches, men dette løste seg. Mest sannsynlig en konsekvens av at de fleste har jobbet hjemmefra i påskeferien. Alt i alt er vi godt fornøyde. 

#### *Kommentar til commits*
I retrospektiv fra oblig2 la vi blant annet vekt på at det har delvis vært utfordrende å fordele oppgaver/arbeid på en effektiv måte (rettferdig fordeling av mengde arbeid). Dette kommer i hovedsak av at med ulike ferdighetsnivåer vil ulike gruppemedlemmer bruke ulik mengde tid på å løse oppgaver. Dette kan nok gjenspeile seg i vår commit-historikk, da et erfarent gruppemedlem kan bruke like lang tid på å løse 3-4 issues som en mindre erfaren bruker på 1 issue. Det kan derfor oppleves som issues er noe skjevfordelt, men dette er altså noe vi er helt bevisste på. 

I likhet med oblig to har vi derfor prøvd å jobbe med kode i fellesskap på møter, slik at de mindre erfarne på gruppen kan lære av andre. Videre har vi samme refleksjoner rundt commits som tidligere:
-   Folk har forskjellig praksis på commits (noen commiter oftere enn andre, eks commits av typos/hele features).
-   Kan derfor oppleves at commit-historikken ikke er helt representativ for enhver gruppemedlems arbeid. 
- Vi ønsker informative commits meldinger som referer til respektive issues. 

#### *3 forbedringspunkter fra retrospektiv*
1. Testing
2. Code-review 
3. Koordinering. Litt surr med forskjellige brancher. 

## Del 2 - Krav og spesifikasjon 
#### *Prioriteringer*
Som det kommer fram av shmup%"Oblig 3: Release candidate" har vi til denne obligen hatt følgende mål:
-   All game-elements are implemented
-   Game is playable 

Like etter levering av oblig2 hadde vi et møte der vi planla og kartla hva vi ønsker å få til videre og hvordan vi skal få til dette. Se [PlanleggingOblig3.png](shump/doc/PlanleggingOblig3.png). En tydelighet i hvor veien går videre er noe vi prioriterer og som vi tror vi har nytt godt av. Leveringen av oblig3 ønsker vi skal være en «release candidate», noe som medfører at alle av spillets elementer og features skal være implementert. Dette kunne oppleves som et noe hårete mål, men noe vi ville få til.

Får vår del betyr en release candidate at vi måtte implementere graphics i from av sprites vi vil bruke, splash-screen, og en «main menu». Vi måtte utarbeide «liv» til både spiller og fiende. En måte å holde oversikt over en spillers score. Og vi måtte utarbeide power-ups. Samt ønsket vi å få til en «infinite scrolling background». 

#### *Veien videre* 
Overordnet er vi nå inne i siste del av prosjektet, vi begynner sakte, men sikkert å se et mer og mer fullverdig spill. Avhengig av hvor mye vi får til i denne obligen, vil bestemme hvordan shmup%"Oblig 4: Final" ser ut og hva må få til her. I utgangspunktet ønsker vi som sagt at siste uker etter levering av oblig3 skal gå til finjustering og tweaking av eksisterende kode. Gitt at vi har fått til alt vi satt oss som mål i oblig3. Når det er sagt prøver vi å være dynamiske og smidige i utviklingen slik at dersom noe «akutt» oppstår eller det er noe vi ikke har fått til i denne obligen har vi ingen problem med å fullføre dette i neste oblig. Vi føler uansett at vi er i rute til å ha et fullverdig spill som tilfredsstiller både våre og fagets spesifikasjoner og krav når deadline kommer. 

Mest sannsynlig kommer vi til å utsette justeringer på menu-skjermer, rolling-background og kanskje flere power-ups etc. til oblig4. 

 #### *Justeringer på  MVP krav* 
Med gode tilbakemeldinger på MVP krav og tilhørende brukerhistorier har vi ikke gjort store endringer her. Vi har dog utarbeidet og lagt til noen nye krav og brukerhistorier. I hovedsak krav relatert til liv, power-ups og score. For alle disse kravene se brukerhistorier med tilhørende akseptansekriterier [her](#Brukerhistorier-(MVP-1-10)). Vi har også lagt til slik-at delen etter tilbakemelding fra oblig1.  

 #### *Bugs (som vi vet om)* 
 Bug: Sudden player death 
-   Spiller døde plutselig etter å ha drept en fiende, ved slutten av en wave. 
-   Etter debugging fant vi ut at dette oppstår ettersom WaveManager kaster index out of bounds exception når spilleren har kommet forbi siste nivå. 
-   Løsning: repetere siste eller de siste nivåene. Evt. genere nye nivåer. (Foreløpig fikset ved loop).  

Bug: Crash on player-death
-   Av og til når spiller dør, kræsjer hele game. 
-   Når en screen er endret, vil gamle screens hide() bli kalt. Akkurat nå gjør ikke metoden noe, men dette er eneste måten det funker. I teorien forkastes aldri «old screen», men dersom vi prøver å forkaste den kræsjer spillet. 

## Del 3 - Produkt og kode 
#### *Kommentater til kode:*
Foruten implementasjon av liv, score og power-ups har vi ryddet noe opp i filstrukturen til prosjektet. Vi opplevde at tidligere struktur var noe «rotete», spesielt følte vi at actors/ mappen begynte å bli noe overfylt. Dermed bestemte vi oss for å gjøre endel endringer her. Følgende struktur blir nå brukt:

src/main/java/inf112/shmup/
-   core/ - Contains cross-platform code
    - bullets/ - Contains bullets and related classes 
    - enemies/ - Contains enemies and related classes
    - powerups – Contains power-ups and related classes
    - ui/ - Contains screens, ui-components and related classes
    - utilities/ - Contains utility classes. 
    - Game.java – Previous src/main/java/inf112 /shmup/app/ShmupGame.java
    - Player.java – Previous src/main/java/inf112/shmup/view/actors/Player.java
-   Desktop / - Conatins code sesific to desktop appliations

#### *Utarbedring av feil*
Vi har rettet opp i tilbakemeldinger fra oblig1 og oblig2. 

#### *Lage README*
Se [README.md](shmup/README.md)

#### *Klassediagram*
Etter tilbakemelding har vi «minket» detaljene i klassediagrammet for å enda tydeligere få et bedre overblikk over prosjektets arkitektur. Se [forenkletKlassediagram.png](shmup/doc/classDiagram.png)

#### *Manuelle tester*
Lik som forrige oblig. Vi har heller valgt å fokusere på automatiske tester. Se [manuelletester.md](shmup/doc/ManuelleTester.md)

#### *Automatiske tester*
Ref retrospektiv oblig2 og tilbakemelding fra gruppeleder har vi prøvd få lagd automatiske tester. Kommer nok til å ta oss enda mer tid til dette i oblig4.  

## Møtereferater 
#### - Uke 11 - 
- Dato: 15.03
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

Tema & arbeid: La en plan for oblig3. Snakket i plenum om hva vi ønsker å få til. Vi ønsker power-ups, score, forskjellige typer fiender og liv til spiller. Laget issues til disse tingene og diskuterte og ble enige om arbeidsfordelingen for oblig3. 

#### - Uke 12 - 
- Dato: 20.03 
- Tilstede: Lars, Philip, Mats, Halvor

tema & arbeid: Oppdatering på hverandres arbeid. Debugging i fellesskap med hverandres problemer. Diskuterte implementasjonen av lyd og lydeffekter. 
 

#### - Uke 13 - 
- Dato:  27.03
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

tema & arbeid: Oppdatering på hverandres arbeid. Bugfixing. Diskuterte et ønske om å endre filstrukturen i prosjektet. En følelse av at nåværende struktur ikke er optimal. Blant annet føles actors/ noe overfylt. Neste ukes fysiske møte utgår da alle er på påskeferie. 
 

#### - Uke 15 (digitalt) - 
- Dato:  14.04 
- Tilstede: Lars, Mats, Herman, Ljubo, Halvor, Philip 

tema & arbeid: Oppdatering etter påskeferie. Diskutering og skriving av prosjektrapport for oblig3. Vi spørr oss hvordan syns vi oblig3 har gått og om vi er fornøyd med det vi har fått til. Ettersom vi har fått utsatt frist for innlevering til søndag 16.04, tar vi et nytt møte før vi leverer denne dagen. 

#### - Uke 15 (digitalt) - 
- Dato:  16.04 
- Tilstede: Lars, Mats, Herman, Ljubo, Halvor

tema & arbeid: Gjennomgang av oblig3 før levering. 

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
13. Power-ups 

##### Brukerhistorier (MVP 1-12)
<b> Brukerhistorie #1: </b> Vise grafisk vindu slik at bruker ser spillvinduet. 

Acceptance criteria:
- Grafikken vises, en skjerm blir presentert for spiller. 
- Spillet kræsjer ikke. 

Task to perform:
- Implementer en klasse som abstraherer en spillskjerm
- Kall på den gitte spillskjermen i main  

Stories:
- Som spiller trenger jeg et spillbrett slik at jeg i spillet kan bevege og styre min spiller
- Som utvikler trenger jeg et spillbrett som vil vise min spillverden og hvor jeg kan plassere ulike spillobjekter. 

<b> Brukerhistorie #2: </B> Se spillelement på mitt spillbrett slik at bruker ser «spiller» som skal styres.  

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

<b> Brukerhistorie #3: </B> Flytte på objekt rundt i spillverden slik at bruker har mulighet til å interagere med spillverden. 

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

<b> Brukerhistorie #4: </B> Se fiendene mine på spillbrettet slik at bruker har mulighet til å se fiender som skal bekjempes. 

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

<b> Brukerhistorie #5: </b> Interagere med spillverden/fiender slik at bruker har mulighet til å bevege seg «korrekt» i spillverden. 

Acceptance criteria:
- Spiller kan ikke gå gjennom fiender
- Spiller kan ikke gå gjennom andre objekter i spillverden. 

Task to perfrom:
- Sørge for at spiller og fiende objekter blir stoppet ved kollisjon. 

Stories:
- Som spiller trenger jeg at navigering i spillverden er logisk og at spillobjekter ikke kan gå inn i hverandre. 
- Som utvikler trenger jeg en måte å sørge for at spilleren beveger seg logisk gjennom spillverdenen. 

<b> Brukerhistorie #6: </b> Spiller/Fiende kan skyte slik at bruker ser verdi i spillet og kan følge spillets gang.  

Acceptance criteria:
- Objekt som representer skudd kommer ut av spiller 

Task to perfrom:
- Implementere en klasse som abstraherer skudd 
- Implementer metode som får skudd til å gå ut fra spiller. 

Stories:
- Som spiller trenger jeg at mitt spillobjekt kan skyte for at jeg skal kunne spille spillet og for at spillet i det hele tatt kan være gøy. 
- Som utvikler trenger jeg at spillobjektet skyter skudd slik at det kan interagere med fiender. 

<b> Brukerhistorie #7: </b> Spiller kan dø slik at bruker har en «utfordring» og insentiv til å spille. 

Acceptance criteria:
- Dersom spiller blir "truffet" av fiende skudd avsluttes spillet. 

Task to perfrom:
- Implementer metode som sjekker om fiendeskudd er i kontakt med spiller. 

Stories:
- Som spiller må jeg kunne dø for at spillet i det hele tatt skal være utfordrende og morsomt. 
- Som utvikler må jeg definere når en spiller er død for å kunne avslutte spillet. 

<b> Brukerhistorie #8: </b> Fiende kan dø slik at bruker har mulighet til å samle poeng og komme «lenger» i spillet. 

Acceptance criteria:
- Dersom fiende blir "truffet" av spiller-skudd skal fienden forsvinne.  

Task to perfrom:
- Implementer metode som sjekker om spillerskudd er i kontakt med fiende. 

Stories:
- Som spiller må jeg kunne "drepe" fiender for å kunne ha progresjon i spillet og samle poeng. 
- Som utvikler må jeg definere hvordan spiller kan komme seg videre i spillet. 

<b> Brukerhistorie #9: </b> Meny-skjerm ved start/slutt slik at bruker selv kan styre når spill skal starte og når spillet er over. 

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

<b> Brukerhistorie #10: </b> Waves slik at bruker opplever at spillet «fortsetter» og vanskelighetsgraden kan økes. 

Acceptance criteria:
- Når siste fiende på brettet dør skal nye fiender komme på brettet. 

Task to perfrom:
- Implementere en klasse som kan styre en rekke med fiender
- Implementer metoder som "kaster" inn nye fiender når siste fiende på brettet er fjernet. 

Stories:
- Som spiller må jeg kunne få opp nye fiender når alle på spillbrettet er borte. 
- Som utvikler må jeg kunne ha metoder som sørger for at nye fiender kommer på brettet når det er tomt. 

<b> Brukerhistorie #11: </b> Score slik at bruker har et insentiv for å komme lenger i spiller og drepe fiender. 

Acceptance criteria:
- Spilleren skal ha en poengscore. 
- Spilleren må ha en mulighet for å samle poeng. 
- Spillerens poengscore må endres når den utfører handling som skal gi poeng. 
- Score skal være en funksjon av hvor mange fiender som er drept og hvor langt ut i spillet spiller er kommet. 

Task to perfrom:
- Implementere poengscore for spiller 
- Vise poengscore på skjermen 
- Ha metoder for å endre poengscore

Stories:
- Som spiller må jeg ha et insentiv for å komme så langt som mulig i spillet. 
- Som utvikler trenger jeg metoder for å kunne endre og holde på spillerens poengscore. 

<b> Brukerhistorie #12: </b> Power-ups, slik at bruker har mulighet til å gjennom spiller oppnå fordeler ved å drepe fiender. 

Acceptance criteria:
-   Enkelte fiender skal «droppe» power-ups når de blir drept.
-   Ved at spiller skyter droppet power-up skal spillet bli forandret på en eller annen måte. 

Task to perfrom:
-   Lage en PowerUp klasse som extender Actor-class og Damageable-interface
-   Når Damageable.takeDamage() blir kalt skal power-up bli aktivert 

Stories:
-   Som spiller ønsker jeg en belønning for å ha drept fiender. 
-   Som utvikler trenger jeg metoder som styrer funksjoner til power-ups og når disse skal bli aktivert. 


    

