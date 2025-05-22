## Autorite nimed

Kristjan Kuus, Roman Kurm

---

### Projekti  kirjeldus

Projekti eesmärgiks oli valmistada puhta koodiga Viktoriini Mäng, millel on kaks mängumoodi. Saavutatasime eesmärgi.
Programmi enda eesmärk on testida mängija geograafiilisi teadmisi ning mängumoodide abil kasutajale rohkem meelelahutust pakkuda.
Mängija käivitab programmi ning  valib seejärel rippmenüüst soovitud raskusastme (TAVALINE või RASKE). Pärast seda hakkab programm esitama suvaliselt valitud riikide pealinnade küsimusi.

---

### Klasside kirjeldused

ViktoriiniProgramm: loeb tekstifailist riigid ja pealinnad, loob neist "Kysimus" objektid ning lisab need listi. Tegemist on peaklassiga, mis tegeleb nii mängu loogika kui ka graafilise kasutajaliidesega.
Kysimus: Lihtne klass, mis sisaldab isendi välju "riik" ja "pealinn". Igal küsimusel on oma "Kysimus" klass.
Mängumood: Enum klass, mis sisaldab mängumoodide raskusastmeid: TAVALINE ja RASKE. RASKE mängumoodi puhul lõppeb mäng automaatselt, kui kasutaja vastab ühele küsimusele valesti.

---

### Projekti tegemise protsess 

Roman seadistas üles Viktoriin ning Mängumood klassid. Tema ülesandeks oli programmeerida mängu läbiviimine. Kristjan kirjutas koodi, mis loeb failist küsimused ning viib need objektide kujule. Samuti oli tema ülesandeks veenduda, et kasutaja sisend ei põhjustaks programmis tõrkeid.

Teises etapis tegeles Kristjan mängu loogika ning logimisega, Roman aga kasutajaliidesega.
Mõlemad rühmaliikmed nägid vaeva ning on üksteise tööga vägagi rahul.


---

### Rühmaliikme panustused

Roman panustas klassi Viktoriin ning Mängumood loomisele, Kristjan panustas failist lugemisele ning kasutaja sisendi kontrollimisele. Romanil kulus natukene üle 1h, Kristjanil sama.

Teises etapis panustas Roman ViktoriiniProgramm kasutajaliidese loomisega, Kristjan mänguloogika ja logimisega.

### Tegemise mured 

Esimeses etappis muresid ei tekkinud, teadmised olid mõlemal olemas ning võibolla kui mõni üksik API osa oli meelest läinud, saime alati seda googeldada.

Teises etapis tekkis mure, sest ei teadnud kõiki JavaFX spetsifiilisi meetodeid. Leitsime lahendused oma probleemidele JavaFX API'st.

---

### Enesehinnang

Arvan, et saime kõigega üsna hästi hakkama. Teretulnud on igasugune tagasiside hindajalt, et saaksime põhjalikumalt oma potensiaalseid vigu analüüsida. Arenema peame veel kõiges - õppida on veel palju, kuna programmeerimises heaks saamine võtab kaua aega.

---

### Testimine

Kuna projekt ei olnud väga suur, ei pannud me eraldi osade testimisele palju rõhku. Meie lähenemine oli lihtne - kirjutame väikse osa koodist valmis, veendume et see töötaks ning lisame jooksvalt juurde.
Veendusime, et me ei kirjutaks liiga suurt osa koodist ilma testimata valmis, kuna pärast on seda debugida raskem.
