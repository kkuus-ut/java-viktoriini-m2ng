autorite nimed;

Kristjan Kuus, Roman Kurm

projekti põhjalik kirjeldus, kus on kirjas programmi eesmärk ja selgitus programmi üldisest tööst, vajadusel lühike kasutusjuhis;

Projekti eesmärgiks oli valmistada puhta koodiga Viktoriini Mäng, millel on kaks mängumoodi. See eesmärk sai meil endi arust saavutatud.
Programmi enda eesmärk on testida mängija geograafiilisi teadmisi ning mängumoodide abil kasutajale rohkem meelelahutust pakkuda.
Mängija sisestab mängumoodi raskuse (TAVALINE või RASKE), seejärel hakkab programm mängijalt küsima erinevate suvaliselt valitud riikide pealinnu.

iga klassi kohta eraldi selle eesmärk ja olulisemad meetodid;

ViktoriiniProgramm: loeb tekstifailist riigid ja pealinnad ning lisab ned "Kysimus" objektidena objekti "Viktoriin" isendivälja "kysimused" listi. Samuti vastutab see klass mängumoodi küsimise ning Viktoriini objekti tegemise eest.
Kysimus: Lihtne klass, mis sisaldab isendi välju "riik" ja "pealinn". Igal küsimusel on oma "Kysimus" klass.
Viktoriin: Tegeleb mängu läbiviimisega. Vastutab suvaliste küsimuste valimise eest ning programmi töö lõpetamise eest vastavalt mängumoodile.
Mängumood: Enum klass, mis sisaldab mängumoodide raskusastmeid: TAVALINE ja RASKE. RASKE mängumoodi puhul lõppeb mäng automaatselt, kui kasutaja vastab ühele küsimusele valesti.

projekti tegemise protsessi kirjeldus (erinevad etapid ja rühmaliikmete osalemine neis);

Roman seadistas üles Viktoriin ning Mängumood klassid. Tema ülesandeks oli programmeerida mängu läbiviimine. Kristjan kirjutas koodi, mis loeb failist küsimused ning viib ned objektide kujule. Samuti oli tema ülesandeks veenduda, et kasutaja sisend ei põhjustaks programmis tõrkeid.
Mõlemad rühmaliikmed nägid vaeva ning on üksteise tööga vägagi rahul.

iga rühmaliikme panus (sh tehtud klassid/meetodid) ja ajakulu (orienteeruvalt);

Roman panustas klassi Viktoriin ning Mängumood loomisele, Kristjan panustas failist lugemisele ning kasutaja sisendi kontrollimisele. Romanil kulus natukene üle 1h, Kristjanil sama.

tegemise mured (nt millistest teadmistest/oskustest tundsite projekti tegemisel puudust);

Muresid ei tekkinud, teadmised olid mõlemal olemas ning võibolla kui mõni üksik API osa oli meelest läinud, saime alati seda googeldada.

hinnang oma töö lõpptulemusele (millega saite hästi hakkama ja mis vajab arendamist);

Arvan, et saime kõigega üsna hästi hakkama. Teretulnud on igasugune tagasiside hindajalt, et saaksime põhjalikumalt oma potensiaalseid vigu analüüsida. Arenema peame veel kõiges - õppida on veel palju, kuna programmeerimises heaks saamine võtab kaua aega.

selgitus ja/või näited, kuidas programmi osi eraldi ja programmi tervikuna testisite ehk kuidas veendusite, et programm töötab korrektselt.

Kuna projekt ei olnud väga suur, ei pannud me eraldi osade testimisele palju rõhku. Meie lähenemine oli lihtne - kirjutame väikse osa koodist valmis, veendume et see töötaks ning lisame jooksvalt juurde.
Veendusime, et me ei kirjutaks liiga suurt osa koodist ilma testimata valmis, kuna pärast on seda debugida raskem.
