Vraag 4.1:
Die Josephus-probleem behels ’n sirkel van n persone, genommer 1 tot n. Beginnende by persoon 1, word elke k-de persoon uitgeskakel tot slegs een persoon oorbly:
•    Skryf ’n Java-program (of ’n enkele metode) wat as invoer twee getalle n (aantal mense) en k (elke k-de persoon word uitgeskakel) neem, en dan die nommer van die laaste persoon wat oorbly teruggee.
•    Jy kan ’n tou (queue) gebruik om die proses te simuleer.
•    Nadat k getel is, verwyder die ooreenstemmende persoon en gaan voort met die volgende persoon. Die telling Swaai (wrap) weer om na die begin soos nodig.

Voorbeeld: Vir n = 7 en k = 3, verloop die uitskakelingsvolgorde as: 3, 6, 2, 7, 5, 1 – laaste oorblywende persoon is nr. 4. Uitvoer behoort 4 te wees.

Vraag 4.2:
Skryf ’n gesorteerde enkel-gekoppelde lys in Java. Die lys moet ten alle tye stygend gesorteerd bly wanneer nuwe elemente bygevoeg word.
Vereistes:
1.    Node-klas: ’n Node moet ’n int bevat (sy data) en ’n verwysing na die volgende node.
2.    SortedLinkedList-klas: Skryf ’n klas met ten minste: 
o    insert(int value): Voeg ’n nuwe heelgetal in op die korrekte plek, sodat die lys steeds sorteer bly (stygend).
o    display(): Druk (of roteer) die elemente in orde, bv. deur hulle in ’n ry te wys.
3.    Toets: In main, skep ’n leë SortedLinkedList en voeg in hierdie volgorde by: 5, 3, 8, 1, 6. Roep na elke (of ná al) invoeging(e) display() aan om die inhoud van die lys te wys.
Verwagte Laaste Uitvoer (na al vyf invoegings):
1 3 5 6 8
(Hierdie volgorde toon dat die lys stygend sorteer is ná elke invoeging.)

Nota: Wees veral versigtig met invoeging by die kop (Head) (as value die kleinste is) en by die einde (as value die grootste is), sowel as in die middel.
