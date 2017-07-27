# Kalkulator DAS28

Prosty kalkulator liczący medyczny wskaźnik DAS28.

> Skala DAS28 (Disease Activity Score – Wskaźnik Aktywności Choroby) – jest to międzynarodowa skala 
> oceniająca aktywność stanu zapalnego w stawach. Posługuje się nią lekarz reumatolog, który wie jak 
> badać i uciskać poszczególne stawy.

Prawidłowość wyników można sprawdzić [tutaj](http://www.mp.pl/gabinet/das28.php "Kalkulator DAS28") lub [tutaj](https://www.termedia.pl/reumatologia/Kalkulatory/DAS/ "Kalkulator DAS28")

#### JAK URUCHOMIĆ

Po sklonowaniu repozytorium należy dodać do niego katalog `bin` i (pod Linuksem) wspisać w terminalu 2 komendy:

`javac -d bin -sourcepath src src/kalkulatorDAS28/*/*.java`

`java -cp bin kalkulatorDAS28.main.Launcher`