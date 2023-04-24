## Del 1 - Prosjektrapport 
#### *Hvordan fungerer rollene i teamet?*

#### *Kommentar til prosjektmetodikk*

#### *Kommunikasjon og gruppedynamikk*

#### *Retrospektiv*

#### *Kommentar til commits*

#### *3 forbedringspunkter fra retrospektiv*

## Del 2 - Krav og spesifikasjon 
#### *Prioriteringer*

#### *Veien videre* 

#### *Justeringer på  MVP krav* 

#### *Bugs (som vi vet om)* 

## Del 3 - Produkt og kode 
#### *Kommentater til kode:*

#### *Utarbedring av feil*

#### *Lage README*
Se [README.md](shmup/README.md)

#### *Klassediagram*


#### *Manuelle tester*

#### *Automatiske tester*
 

## Møtereferater 
#### - Uke 16 - 
- Dato: 17.04
- Tilstede: Lars, Philip, Mats, Herman, Ljubo

Tema & arbeid: 
#### - Uke 16 - 
- Dato: 20.04 
- Tilstede: Lars, Philip, Mats, Halvor, Herman, Ljubo

tema & arbeid: 
#### - Uke 17 - 
- Dato:  24.04
- Tilstede: Lars, Philip, Mats, Halvor, Ljubo

tema & arbeid: 
#### - Uke 18 - 
- Dato:  01.05 
- Tilstede: 

tema & arbeid: 
#### - Uke 18 - 
- Dato:  
- Tilstede: 

tema & arbeid:
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

