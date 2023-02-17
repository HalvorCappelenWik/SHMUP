## A1 - Roller 
<b> Teamlead: Mats.  </b> Teamlead skal ha overordnet kontroll over vårt prosjekt. Vi ønsker en teamlead som har tidligere erfaring fra utvikling av større prosjekter og erfaring med utvikling av programmer sammen med andre. Mats har tidligere jobbet på faktiske prosjekter ute hos kunde og er en naturlig teamlead for oss. 
 
 <b> Møtereansvarlig/Kundekontakt: Halvor. </b>  Vi ønsker å ha en person som er ansvarlig for møter og kommunikasjon med gruppeleder. Arbeidsoppgaver vil være å sette opp møtetidspunkter, føre referater/logg og sørge at alle i gruppen er klar over når og hvor møter tar plass. Vi prioriterer å ha en møteansvarlig ettersom vi ønsker i størst mulig grad å jobbe fysisk sammen og tidligere erfaring sier at møter ofte kan falle bort dersom ingen tar på seg dette ansvaret. 

<b> Brukeropplevelse/UX: Ljubo .</b> Vi ønsker å gi brukeren av spillet en best mulig opplevelse, derfor ønsker vi at en har overordnet ansvar for dette. Ansvar for å gi tilbakemelding på hvordan spiller fungerer i praksis. 

<b> Designansvarlig: Philip. </b> I vårt produkt ønsker vi å også vektlegge design. Derfor ønsker vi en ansvarlig for dette. Vi setter Philip som ansvarlig for dette. Philip har tidligere arbeidet med andre spillmotorer. Samt kunnskap om spilldesign, utviklingssyklusen til spill og vanlige fallgruver og byggesteiner bak spillutvikling.

<b> Testansvarlig: Herman </b> Vi kommer til å vektlegge å lage gode tester slik at vi sørger for at produktet vi leverer er så optimalt som mulig. Derfor ønsker vi å ha en som har overordnet ansvar for tester. Herman skal følge opp bugs og passe på at disse blir fikset. 

<b> Utviklere: Alle. </b> Vi ønsker at alle skal være med å bidra med mest mulig av utviklingen av spillet. Derfor vil alle, ved siden av sin spesifikke rolle, være utvikler. 

##  A2 - Konsept
- Spillfiguren kan styres med datamus, touch pad eller piltaster. 
- Todimensjonal verden:
    - Rullegardin-verden 
    - Spilleren beveger seg kontinuerlig oppover i "verden" så lenge spillet er aktivt.  
- Fiender:
    - Befinner seg i øverste del av "verden". 
    - Beveger seg og er skadelig ved berøring. 
    - Vil forsøke å skade spilleren ved å skyte ut skudd. 
- Spilleren kan skyte og samler poeng ved å treffe fiender.
- Fiender som blir truffet dør. Det vil være mulig å oppnå "power-ups" ved å drepe fiender. 
- Utfordringen i spillet er å unngå å bli truffet av skudd fra fienden samt skyte fienden.
- Spilleren samler en poengscore ut ifra hvor mange finender som er drept. 

Inspirasjon er hentet fra: [https://en.wikipedia.org/wiki/Space_Invaders](Space Invaders). 
Konseptbeskrivelsen er foreløpig og kommer til å bli oppdatert kontinuerlig. 

##  A3 - Prosjektmetodikk
Etter diskusjoner har vi kommet fram til at vi ønsker å følge scrum prosjektmetodikk .  Valget har falgt på scrum fordi vi anser det som mest naturlig med tanke på hvordan semesteroppgaven er bygget opp. Vi ønsker å bryte ned obligene, A1, A2, B4 osv. til en sprintkø som vi vil fullføre innen tidsbokser (sprinter). For progresjonskontroll kommer vi også til å benytte oss av GIT issue board. Vi kommer i tillegg til å hente inspirasjon fra XP programming mtp fleksabilitet og kodetekniske aspekter. Overordnet "filosofi" for prosjektet kommer til å være Agile programmvareutvikling. 

Noen tilpasnigner vi ønsker å gjøre er blant annet å ha endel parprogrammering. Ettersom nivået på kompetanse er ulikt innad i gruppen,  vil vi ved dette sørge for at alle får deltatt like mye og har like god kontroll på applikasjonen. Vi vil prioritere å møtes fysisk så mye som mulig. 

##### GIT issue board kolonner:
- Open 
- Closed

##### Viktige aspekter ved prosessen:
- Møter: Vi har satt et fast ukentlig tidspunkt hvor vi har møter (mandager kl. 12.00). Utover dette vil vi sette opp ekstra møter dersom nødvendig. 
- Kommunikasjon: Vi har opprettet en discord kanal hvor all kommunikasjon vil foregå. 
- Arbeidsfordeling: Vi vil spilte hver sprint inn i chunks, hvor hver av oss får en chunk som en skal jobbe med gjennom sprinten. Vi ønsker at alle skal ha vært innom alle aspekter ved utviklingen av spillet. Foruten om dette vil vi fordele arbeid etter interesser og etter roller. 
- Oppfølging av arbeid: Vi kommer til å benytte oss av GitLab issues for å ha en oversikt over hva som er gjort, hva som må gjøres og hva som er ønskelig å få gjort. Vi kommer også til å prøve å implementere en fast feedback mekanisme  som vi benytter oss av kontinuerlig gjennom prosjeket. Code-reviews og standups ved slutten av hver sprint er ønskelig. 
- Deling av oppgaver og kode: GIT og Git issues.

##### Tekniske praksiser 
Fra pensumboken Agile Technical Practices Distilled har vi følgende hovedprinsipper som vi vil forsøke å følge:
- Pair Programming
- TDD 
- Refactoring 
- Simple Design

##  A3 - Oversikt over forventet produkt
##### Overordnet mål
- Utvikle et velfungerende 2D spill. 
- Tilegne oss ny kunnskap og erfaring om utvikling av prosjekter i team. 
- Bli kjent med forskjellige prinsipper fra ulike prosjektmetodikk metoder. 

#####  MVP´s (prioritert liste) 
1. Vise et spillbrett 
2. Vise et element på spillbrettet
3. Flytte spiller/element 
4. Vise fiender
5. Spiller interagerer med fiender/spillelementer
6. Fiender kan bli skadet av spiller 
7. Spiller kan bli skadet av fiender
8. Spiller kan dø 
9. FIende kan dø
10. Meny-skjerm ved start/slutt av spill 

##### Brukerhistorier (MVP 1-3)
<b> Brukerhistorie #1: </b> Når jeg starter spillet vil jeg at det skal vises et grafisk vindu.

Acceptance criteria:
- Grafikken vises, en skjerm blir presentert for spiller. 
- Spillet kræsjer ikke. 

Task to perform:
- Implementer en klasse som abstraherer en spillskjerm
- Kall på den gitte spillskjermen i main  

<b> Brukerhistorie #2: </B> Som spiller ønsker jeg å kunne se spillelement på mitt spillbrett. 

Acceptance criteria:
- På spillbrettet skal det bli presentert et objekt 
- Objektet skal være selvstendig fra bakgrunn 

Task to perfrom:
- Implementer en klasse som abstraherer et spillobjekt 
- Finn grafikk som egner seg til å representere spillobjekt. 
- Kall på objekt i main. 

<b> Brukerhistorie #3: </B> Som spiller ønsker jeg å kunne flytte på mitt objekt rundt i spillverden

Acceptance criteria:
- Tastetrykk fører til at spillobjekt beveger seg. 
- Bevegelsen skal være begrenset til innenfor spillskjermets rammer. 

Task to perfrom:
- Implementer metoder som tar input fra tastetrykk. 
- Sørg for korrekt "størrelse" på bevegelse per tastetrykk. 
- Vis bevegelse på skjerm 


## A5 - Oppsummering 
#### Prosjekt-retrospektiv
Hva fungerte bra/dårlig?
- I starten av prosjektet var vi litt usikker på hvor mye kreves i MVP. Vi har opplevd at det har vært en noe skjev arbeidsfordeling da det ikke var like lett å fordele arbeid ettersom vi enda ikke har hatt en «stamme» i vårt prosjekt. Men mye programmering sammen fysisk har vært bra. Vi tror det kommer til å bli lettere å delegere oppgaver når vi skal jobbe mer med spesifikke deler av spillet. 

Kommunikasjon
- Vi er stort sett fornøyde med kommunikasjonen. Vi har tatt i bruk Git Issues for å holde en oversikt over arbeidsoppgaver og fordeling av ansvar. Discord blir brukt for generell kommunikasjon og loggføring av møter. Alle har blitt bedre kjent, og eventuelle uenigheter tas opp i plenum og er ingen problem å snakke om. 

Kode
- Vi har valgt å gå for en model-view-controller løsning. Dette hadde alle erfaring med fra INF101. Godt fornøyd med MVP og rammen er satt for videre utvikling. For MVP’en har vi alle stort sett jobbet på main-branch. Vi vil nok videre endre Git workflow slik at alle jobber på egne branches. 

Til oblig2 
- Vi må sette oss inn i libGDX og gjøre oss kjent med hvordan vi kan bruke rammeverket best mulig. Vurdere å sette opp enda et fast møte i uken. 


