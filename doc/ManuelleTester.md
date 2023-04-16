## Tester for MVP 1: Se spillbrett 
##### ShowScreenTest()
- Kjør main.java
- Testen passerer dersom en skjerm dukker opp 

##### ShowGameboardTest()
- Kjør main.java 
- Trykk på "Play" med touchpad/mus
- Testen passerer kun om man kan se et spillbrett på skjermen

## Tester for MVP 2: Vise spiller 
##### PlayerVisibleTest()
- kjør main.java
- Trykk på "Play" med touchpad/mus
- Testen passerer kun om man ser et spillobjekt på skjermen

## Tester for MVP 3: Flytte spiller
##### MovePlayerTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Trykk og hold piltast "opp" i ca 1 sekund. 
    - Testen feiler dersom spillfiguren ikke beveger seg mot opp i y-retning i det pilstast blir trykt ned, gitt at det er ingen hindringer i veien
- Trykk og hold piltast "ned" i ca 1 sekund. 
    - Testen feiler dersom spillfiguren ikke beveger seg mot ned i y-retning i det pilstast blir trykt ned, gitt at det er ingen hindringer i veien
- Trykk og hold piltast "venste" i ca 1 sekund. 
    - Testen feiler dersom spillfiguren ikke beveger seg i x-retning mot venstre i det pilstast blir trykt ned, gitt at det er ingen hindringer i veien
- Trykk og hold piltast "høyre" i ca 1 sekund. 
    - Testen feiler dersom spillfiguren ikke beveger seg i x-retning mot høyre i det pilstast blir trykt ned, gitt at det er ingen hindringer i veien
- Testen passerer dersom testen ikke har feilet til nå 

##### PlayerInBoundsTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Trykk og hold ned "ned" piltast til spillfiguren treffer en vegg + 1 sekund til
    - Testen feiler dersom spillfiguren beveger seg ut av skjermen   
- Trykk og hold ned "opp" piltast til spillfiguren treffer en vegg + 1 sekund til
    - Testen feiler dersom spillfiguren beveger seg ut av skjermen   
- Trykk og hold ned "venste" piltast til spillfiguren treffer en vegg + 1 sekund til
    - Testen feiler dersom spillfiguren beveger seg ut av skjermen   
- Trykk og hold ned "høyre" piltast til spillfiguren treffer en vegg + 1 sekund til
    - Testen feiler dersom spillfiguren beveger seg ut av skjermen   
- Testen passerer dersom testen ikke har feilet til nå

## Tester for MVP 4: Vise fiender 
##### EnemyVisibleTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Testen passerer kun dersom en fiende vises i skjermen

## Tester for MVP 6 & 7: Spiller/Fiende kan auto-skyte 
##### PlayerShootTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Testen passerer kun dersom "skudd" kommer ut av spiller 

##### EnemyShootTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Testen passerer kun dersom "skudd" kommer ut av fiende 

## Tester for MVP 8 & 9: Spiller/Fiende kan dø av skudd
##### PlayerKillEnemyTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Bruk piltaster til å bevege spillfigur slik at spillfigurens skudd treffer fiende
- Testen passerer kun dersom fiende dør (forsvinner) ved kontakt av spillfigurs skudd

##### EnemyKillPlayerTest()
- Kjør main.java
- Trykk på "Play" med touchpad/mus
- Bruk piltaster til å bevege spillfigur slik at fiendes skudd treffer spillfigur
- Testen passerer kun dersom spill avsluttes ved kontat av fiendes skudd. 

## Tester for MVP 10: Meny-skjerm ved start/slutt 
##### StartScreenTest()
- Kjør main.java
- Testen passerer dersom det kommer opp en skjerm med spillsintruksjoner og spillet starter ved trykk på "Play" 

##### EndScreenTest()
- Kjør main.java 
- Naviger spiller slik at fiendeskudd treffer spiller 
- Testen passerer dersom gameover dukker opp når spiller blir truffet, hvis score til spiller dukker opp og hvis nytt spill starter ved trykk på "Try again" 

## Tester for MVP 11: Score
##### ScoreTest()
- Kjør main.java 
- Naviger spiller slik at skudd fra spiller treffer fiender
- testen passerer dersom score øker ved å treffe fiender. 

## Tester for MVP 11: Waves 
##### WavesTest()
- Kjør main.java
- Naviger spiller slik at skudd fra spiller treffer fiende 
- Testen passerer dersom nye fiender dukker opp ved eliminering av siste fiende på spillbrettet. 







