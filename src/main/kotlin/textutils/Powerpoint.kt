package textutils


import org.apache.poi.xslf.usermodel.XMLSlideShow
import org.apache.poi.xslf.usermodel.XSLFSlide
import org.apache.poi.xslf.usermodel.XSLFSlideLayout
import org.apache.poi.xslf.usermodel.XSLFSlideMaster
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.regex.Pattern

fun main() {
    val templatePath = "AI pro DF.pptx"
    val outputPath = "AI pro DF v01.pptx"

    // Paste your markdown content here
    val markdown = """
## Sekce A: Vize "Černé skříňky"

**Snímek 1: Úvodní snímek**
* **Nadpis:** Návrh IT systému umožňujícího AI
* **Podnadpis:** Od legacy systémů k agentní inteligenci
* **Kontext:** Workshop architektonické strategie

**Snímek 2: Manažerské shrnutí (Executive Summary)**
* **Cíl:** Umožnit byznysu "mluvit" s daty a "přikazovat" akce.
* **Posun:** Přechod od **Aplikací** (formuláře, tlačítka) k **Záměru** (cíle, konverzace).
* **Výstup:** Jednotná inteligenční vrstva, která sedí *nad* vaší současnou infrastrukturou, nenahrazuje ji.

**Snímek 3: Současná krajina ("Stav As-Is")**
* **Vizuál:** Izolované bloky (sila) představující ERP, CRM, BPM, Excel, Email.
* **Tření:** Uživatelé musí překládat *obchodní záměr* ("Doplň olej") do *systémových akcí* (Přihlášení -> Menu -> Objednávkový formulář -> Vypsat SKU).
* **Problém:** Data jsou uvězněna v silech; procesy jsou jen manuální můstky mezi nimi.

**Snímek 4: Koncept "Černé skříňky"**
* **Koncept:** Abstraktní vrstva.
* **Uživatelská zkušenost:** Uživatel interaguje *pouze* s Černou skříňkou.
* **Příslib:** Uživatel poskytne **Záměr**; Černá skříňka zajistí **Exekuci**.
[Vizuál: Velká, elegantní krabice "AI Vrstva" umístěná na vrchu bloků "Stávajícího stavu"]

**Snímek 5: Funkce 1 - "Mluvte se svými daty"**
* **Scénář:** Obchodní zástupce potřebuje poslední objednávku daného zákazníka a její stav.
* **Starý způsob:** Přihlásit do ERP -> Hledat.
* **Nový způsob:** "Jaká byla poslední objednávka pro zákazníka X?"
* **Klíčová hodnota:** Přirozené rozhraní, rychlost, hands-free.
[Vizuál: Dva obchodníci; jeden něco zadává do tabletu, druhý mluví - přes handsfree - s chatbotem, oba (obchodník i chatbot) mají prázdné bubliny pro text]

**Snímek 6: Funkce 1b - "Mluvte se svou dokumentací"**
* **Scénář:** Obchodník potřebuje prodejní argumenty pro daný produkt.
* **Starý způsob:** Přihlásit do CRM -> Hledat NEBO Sharepoint -> Hledat.
* **Nový způsob:** "Jaké jsou prodejní argumenty pro motorový olej Castrol WD-40?"
* **Klíčová hodnota:** Přirozený jazyk, kontextualizované odpovědi (nejen odkazy na soubory).

**Snímek 7: Funkce 2 - Odvozování nových dat**
* **Scénář:** Nestrukturovaná zpětná vazba od klienta (emaily, záznamy hovorů).
* **Schopnost:** Černá skříňka čte text a *extrahuje* strukturovaná data.
* **Příklad:** Email: "Dodávka zpožděna, balík roztržený." -> AI aktualizuje CRM: `Sentiment: Negativní`, `Problém: Logistika`.

**Snímek 8: Funkce 3 - Řízení procesů (Proaktivní)**
* **Scénář:** Nízký stav zásob.
* **Schopnost:** AI monitoruje toky dat a spouští procesy.
* **Akce:** "Zásoba motorového oleje 5W-30 je kritická. Připravil jsem objednávku ke schválení."
* **Posun:** Od "Pull" (Uživatel kontroluje data) k "Push" (Systém upozorňuje uživatele).

**Snímek 9: Pohled dovnitř**
* **Koncept:** Černá skříňka se stává průhlednou.
* **Vnitřní struktura:**
    * *Specializovaní agenti:* Tým "digitálních zaměstnanců".
    * *Engineering:* Robustní síť služeb ("Svaly").
    * *Governance (Řízení):* Bezpečnost a kontrola ("Svědomí").
[Vizuál: Stejný vizuál jako na snímku 4, krabice "AI Vrstva" na blocích "Stávajícího stavu". Černá krabice je nyní mírně průhledná a odhaluje:
    * vlevo nahoře: síť agentů, někteří komunikují ven, někteří jen interně. Někteří agenti mluví se servisní vrstvou pod nimi
    * vlevo uprostřed: síť služeb, některé interagují s vnějším světem, některé s agenty, některé mezi sebou, některé s datovou vrstvou dole
    * vlevo dole: shluk zdrojů dat, všechny připojené k servisní vrstvě nad nimi
    * pravá strana: Svislý pruh s nápisem "Pozorování a Kontrola" (Observation and Control)
]

**Snímek 10: Specializovaní agenti**
* **Koncept:** Černá skříňka není jeden obří mozek; je to tým specialistů.
* **Příklady:**
    * *Kalendářní agent:* Kontroluje události, spravuje kalendáře.
    * *Skladový agent:* Kontroluje hladiny zásob, upozorňuje obchodníky při nedostatku.
    * *Reklamační agent:* Validuje fotky, kontroluje záruky, vystavuje vratkové dokumenty, sleduje průběh.
    * *Agent prodejních akcí:* Běží v noci, připravuje prodejní akce na další den pro každého zákazníka.
    * *Agent přípravy prodeje:* Kontroluje prodejní akce, sepisuje argumenty na míru zákazníkovi.
[Vizuál: Kresba ve stylu cartoon zobrazující různé agenty popsané výše. Nakreslete agenty jako Mimoni s různými osobnostmi a obchodníka jako Grua]

**Snímek 11: Realita architektury**
* **Vizuál:** Diagram architektury orientované na služby (SOA).
* **Zpráva:** Černá skříňka je systém služeb, a jako takový vyžaduje rigorózní inženýrství.
* **Komponenty:** Orchestrace, Bezpečnost, Pozorovatelnost (Observability), Monitoring, Nasazení, Verzování.

**Snímek 12: Governance & Mantinely (Guardrails)**
* **Omezení:** Člověk ve smyčce (Human-in-the-loop) pro:
    * Nejistotu (Nízké skóre spolehlivosti).
    * Specifické vysoce rizikové akce (Transakce > $5k).
    * Kontrolu označených chybných odpovědí.
* **Bezpečnost:** Role-Based Access Control (RBAC) — AI vidí jen to, co má dovoleno vidět uživatel.
* **Audit:** Každá akce AI, myšlenka a volání API je logováno.
* **Monitoring:** Upozornění na abnormální chování (špičky v útratě, smyčky halucinací).
[Vizuál: Kresba ve stylu cartoon s agenty Mimoni podle snímku 10, nyní 4 z nich na něčem pracují, jeden čeká před Gruem, který drží obrovské razítko "Schváleno"]

## Sekce B: Podstata inteligence

**Snímek 13: Dekonstrukce "AI"**
* **Tvrzení:** "AI" je marketingový pojem. My stavíme pomocí **Modelů**.
* **Taxonomie:** Kategorizace podle **Povahy** (Jak to myslí) a **Druhu** (Co to dělá).

**Snímek 14: Dle povahy - 1. Velký jazykový model (LLM)**
* **Analogie:** "Knihovník."
* **Silné stránky:** Usuzování, jazyk, sumarizace, kreativita.
* **Slabé stránky:** Matematika, přesné počítání, fakta (bez nápovědy).
[Vizuál: Karikatura textu proudícího do zosobněného LLM modelu (knihovník) a textu proudícího ven]

**Snímek 15: Dle povahy - 2. Statistické ML (Prediktivní)**
* **Analogie:** "Pojistný matematik (Aktuár)."
* **Příklady:** Random Forest, XGBoost.
* **Silné stránky:** Předpovídání poptávky, credit scoring, anomálie.
* **Pravidlo:** Nechtějte po ChatGPT předpověď prodejů; ptejte se Random Forestu.
[Vizuál: Karikatura čísel proudících do zosobněného ML modelu (aktuár) a čísel proudících ven]

**Snímek 16: Dle povahy - 3. Smysly (Zrak & Řeč)**
* **Analogie:** "Oči a uši."
* **Případy užití:** OCR, analýza regálů (shelf-share), kontrola kvality.
* **Interakce:** Chatování s agenty hlasem, instrukce v přirozeném jazyce.
[Vizuál: Karikatura řeči a obrázků proudících do zosobněného modelu Řeči a Vize (ucho, oko) a textu a JSONů proudících ven]

**Snímek 17: Dle druhu - 1. Procesory**
* **Funkce:** Vstup -> Transformace -> Výstup.
* **Úkol:** Řeč na text, OCR na text.
* **Úkol:** Rozpoznání záměru (Klasifikace "Chci vrátit peníze" vs. "Kde je má objednávka").
* **Úkol:** Strukturování: Převod volného textu na JSON.

**Snímek 18: Dle druhu - 2. Vyhledávače (Searchers)**
* **Funkce:** Retrieval Augmented Generation (RAG).
* **Úkol:** "Jaké jsou prodejní argumenty pro tento motorový olej?"
* **Hodnota:** Řešení problému "Znalostní hranice" (Knowledge Cutoff).

**Snímek 19: Dle druhu - 3. Poradci (Advisors)**
* **Funkce:** Syntéza + Doporučení.
* **Úkol:** "Vzhledem k historii tohoto majitele autoservisu, *který* argument vyhraje?"

**Snímek 20: Dle druhu - 4. Optimalizátory**
* **Funkce:** Matematická maximalizace.
* **Úkol:** "Jaký mix promo akcí přinese nejvyšší marži?"

**Snímek 21: Hybridní workflow**
[Vizuál: Vision Model (Přečte fakturu a vytvoří markdown dokument) -> LLM Model (Extrahuje informace o dodavateli jako json) -> Stat ML (Kontrola podvodu) -> LLM Model (Sepíše email: Omlouváme se, ale váš úvěr byl zamítnut.)]

## Sekce C: Hloubkový ponor do LLM
*[Kdo: Ondra]*

**Snímek 22: Jak fungují LLM**
* **Mechanismus:** Predikce následujícího tokenu (Next Token Prediction).
* **Důsledek:** Probabilistické (pravděpodobnostní), nikoliv deterministické.

**Snímek 23: Všemocný prompt**
* **Definice:** Prompt je nový zdrojový kód.
* **Koncept:** In-Context Learning (učení pomocí příkladů v promptu).

**Snímek 24: Framework agenta**
* **Anatomie:** Persona + Paměť + Nástroje + Plánování.
* **Smyčka:** Myšlenka -> Plán -> Akce -> Pozorování.

**Snímek 25: RAG vs. Nástroje (Tools)**
* **RAG:** *Čtení* (Získávání znalostí).
* **Nástroje:** *Konání* (Interakce se systémem přes MCP).

**Snímek 26: Relace & Paměť**
* **Krátkodobá:** Kontextové okno.
* **Dlouhodobá:** Vektorové/Grafové databáze.

**Snímek 27: Manipulace s promptem (Prompt Manipulation)**
* **Technika:** Programové vložení dat (Jméno uživatele, Stav skladu) do promptu *před* odesláním do LLM.

---

# Část 2: Znalostní vrstva (Ontologie & RAG)
*10:45 - 12:30*

## Sekce A: Koncepty & Architektura

**Snímek 28: Strategie**
* **Tvrzení:** Vyhledávání klíčových slov a textu nestačí pro sémantické hledání.
* **Tvrzení:** Vektory hledají *podobnosti*. Grafy hledají *vztahy*. Potřebujeme obojí.
* **"Super" Obchod:** FullText (Hledání) + Vektor (Význam) + Graf (Kontext).
[Vizuál: The "Super" Store: FullText (Hledání) + Vektor (Význam) + Graf (Kontext)]

**Snímek 29: Definice Ontologie**
* **Definice:** "Schéma" světa.
* **Komponenty:** Třídy, Vztahy (`je_dodáván_kým`), Atributy.
* **Role:** Společný jazyk mezi Člověkem, Databází a Agentem.
[Vizuál: Příklad znalostního grafu se Zákazníky, Dodavateli, Výrobci a Zbožím]

**Snímek 30: Proč jsou ontologie důležité pro AI**
* **Mantinely:** Zabraňují halucinacím, křížově ověřují vztahy a fakta.
* **Disambiguace (Jednoznačnost):** Rozlišení kontextu (např. "Shell" jako značka vs. "Shell" jako technický termín/terminal).
* **Inference:** Logické odvozování nových faktů.

**Snímek 31: Architektura Datového SuperStore**
* **Úložiště:**
    * **Relační DB:** Kmenová data, transakce, historie.
    * **Grafová DB:** Metadata: Koncepty, vlastnosti, vztahy.
* **Koncept:** Graf funguje jako "Index" k relačním datům.
[Vizuál: Datový SuperStore. Má dva hlavní bloky, Grafovou databázi a Relační databázi. Grafová databáze obsahuje znalostní graf nahoře a graf mapování konceptů na tabulky Relační databáze]

**Snímek 32: Architektura Dokumentového SuperStore**
* **Ingestování:** Různé formáty dokumentů (PDF, Doc, HTML).
* **Zpracování:** Strukturní analýza (Tabulky, Nadpisy).
* **Úložiště:**
    * **Relační DB:** Metadata & Audit.
    * **Vektorová DB:** Vektorové embeddingy (Sémantické chunky).
    * **Grafová DB:** Vztahy částí dokumentů (Sekce A *je_v* Dokumentu B).
    * **Fulltext:** Klíčová slova.
* **Koncept:** Jeden logický dokument, čtyři fyzické reprezentace.
[Vizuál: Tok dokumentu do Dokumentového SuperStore. Vizualizujte prosím tento proces:
1. dokument přichází k ingestování.
2. je rozdělen na úseky/chunky (tabulky, nadpisy, odstavce). Chunky tvoří stromovou strukturu (Nadpis 1 -> Nadpis 2 -> Odstavec)
3. celý dokument a každý chunk je uložen ve Fulltextu
4. celý dokument a každý chunk projde embedding službou a výsledný vektor je uložen ve Vektorové DB.
5. celý strom chunků (s hierarchickými vztahy) je uložen v Grafové DB.
]

## Sekce B: Konzumpce agenty

**Snímek 33: Výhody Znalostního grafu**
* **Detektiv s více skoky (Multi-Hop):** "Ovlivní zpoždění *Komponenty X* klienta *Y*?"
* **Standardizace slovníku:** Zvládá synonyma, zkratky, akronymy automaticky.
* **Ověřování faktů (Fact Checking):** "Je toto SKU *skutečně* kompatibilní s tímto autem?" (Ověřování tvrzení LLM).
[Vizuál: Skupina agentů (styl Mimoni) shromážděná kolem Znalostního grafu, trhající z něj kousky (malé podgrafy)]

**Snímek 34: Jak agenti "čtou" Graf**
* **Přímý dotaz:** LLM píše Cypher (SQL pro Grafy).
* **GraphRAG:** Systém vyhledá "Sousedství" souvisejících konceptů a dodá je jako kontext.
* **Document RAG:** Předpočítáváme textovou reprezentaci grafu.

**Snímek 35: Strategie vyhledávání (Router)**
* **Klíčové slovo:** Přesná SKU.
* **Vektor:** Široké koncepty.
* **Graf:** Komplexní vztahy.

**Snímek 36: Ontologie jako součást Datového SuperStore**
* **Role:** "Sémantická vrstva."
* **Funkce:** Mapuje *Mentální model uživatele* ("Klienti", "Problémy") na *Fyzický model systému* (Tabulka `T05`, Pole `K88`).
* **Interakce agenta:** Agent se ptá Ontologie: "Kde najdu dodací adresu?" -> Ontologie odpovídá: "Spoj Tabulku A a B."

**Snímek 37: Ověřování faktů & Zpětná vazba**
* **Kritický agent:** Ověřuje odpovědi LLM oproti faktům v Grafu.
* **Smyčka zpětné vazby:** Agenti označují "odchylky" (drift) nebo chyby v datech pro lidskou kontrolu.
* **Upřímná zpětná vazba:** Uživatelé označují chyby.

## Sekce C: "Jak na to" - Implementace

**Snímek 38: Návrh Ontologie**
* **Nástroje:** Protégé, WebVOWL.
* **Proces:** Identifikace entit -> Definice vztahů -> Governance.

**Snímek 39: Automatizované plnění (ETL)**
* **Workflow:** Chunkování dok. -> LLM Extrakce -> Validace vůči Ontologii -> Vložení do Neo4j.

**Snímek 40: Poloautomatizované plnění (ETL)**
* **Workflow:** Chunkování dok. -> LLM Extrakce -> Návrh -> Lidská validace -> Verze Ontologie.

**Snímek 41: Mapování byznysu na data**
* **Propojování:** Uzly grafu obsahují Primární klíče (ID) ukazující na tabulky ERP.
* **Virtuální grafy:** Ukládání ukazatelů/dotazů, nikoliv duplikování transakční historie.

**Snímek 42: Mapovač konceptuálního modelu**
* **Koncept:** Nástroj, který mapuje byznysové koncepty na datové modely.
* **Role:** Ontologie (a všechna metadata) je zdrojem pravdy.
* **Technologie:** Jazyk + Diagramy -> Git (verzování) -> Grafová databáze.

---

# Část 3: Demonstrace
*13:30 - 14:30*

**Snímek 43: Přehled dema**
* **Cíl:** Proof of Concept. Přesun od teorie k běžícímu kódu.

**Snímek 44: Demo 1 - Návrhář ontologií**
*[Kdo: Bora]*
* **Na co se dívat:** Jak vizuálně modelujeme byznysovou doménu.
* **Scénář:** Definování "Problému s autem" a jeho propojení s "Produktovým řešením".

**Snímek 45: Demo 2 - Dokumentové úložiště (Document Store)**
*[Kdo: Bora]*
* **Akce:** Ingestování technického manuálu v PDF.
* **V zákulisí:** Ukažte rozdělení dat do Qdrant (Vektor) a Neo4j (Graf) současně.

**Snímek 46: Demo 3 - "Old School" NLP vs. LLM**
*[Kdo: Bora]*
* **Soutěž:** Extrakce názvů značek.
* **Soutěžící A:** Spacy/NER (Milisekundy, levné).
* **Soutěžící B:** GPT-4 (Sekundy, drahé).
* **Lekce:** Na optimalizaci záleží.

**Snímek 47: Demo 4 - Agent MCP**
*[Kdo: Ondra, Honza]*
* **Scénář:** Vícekrokový úkol. "Zkontroluj sklad pro Produkt X a navrhni email."
* **Highlight:** Smyčka "Použití nástrojů" (Tool Use). Sledujte, jak se Agent zastaví, spustí kód, přečte výsledek a pokračuje.

**Snímek 48: Demo 5 - Zvukový agent**
*[Kdo: Ondra, Honza]*
* **Scénář:** Poslech obchodníka, který si dělá poznámky (simulovaný hlasový vstup).
* **Highlight:** Transkripce v reálném čase kombinovaná s **Extrakcí entit**. Agent jen "neposlouchá"; automaticky "vyplňuje formulář" během poslechu.

**Snímek 49: Demo 6 - Obrazový agent**
*[Kdo: Bora]*
* **Scénář:** Analýza fotek z garáže/dílny.
* **Highlight:** **Inteligence regálu (Shelf Intelligence).** Převod pixelů na skladová data. Identifikace našich produktů vs. produktů konkurence v nepřehledném prostředí.

---

# Část 4: Technologické volby
*14:30 - 16:30*

## Sekce 0: Hlavní principy
*[Kdo: Bora]*
[Úkol: doplnit]
[Poznámky:
- žádný vendor lock-in (závislost na dodavateli)
- skrýt implementační detaily
- mít vše pod kontrolou
- řídit náklady
- používat standardy a opensource kdekoliv je to možné
- ...
Celková filozofie: Trh se vyvíjí překotně a my chceme udržet celou věc co nejvíce modulární a volně vázanou (loosely coupled), abychom mohli měnit jednotlivé komponenty za jiné technologie bez přepisování celého systému.
[Vizuál: modulární systém (vypadá jako elektroinstalace), kde mechanik vybírá jednu část a nahrazuje ji jinou; jen prostým odpojením a zapojením standardizovaných drátů.]
]


## Sekce A: Kompletní stack komponent

**Snímek 50: Vrstvená architektura**
* **Vrstva 1: Vstup (Legacy & Zdroje)**
    * ERP Data (SQL), Procesy (Camunda), Dokumenty (Sharepoint).
* **Vrstva 2: Datová základna ("Super Store")**
    * *Datové pipeliny:* Synchronizace a čištění (Azure Data Factory).
    * *Fyzické úložiště:* SQL (Fakta), Neo4j (Vztahy), Qdrant (Vektory), OpenSearch (Text).
* **Vrstva 3: Servisní vrstva (Kotlin)**
    * *Přístupové služby:* Skrývání DB za čistá API.
    * *Konceptuální služby:* Překlad hrubých dat do "Business Objects".
    * *MCP Servery:* Vystavování schopností Agentům.
* **Vrstva 4: Inteligenční vrstva (Python)**
    * *Orchestrátor:* Řízení smyčky agenta.
    * *Modely:* LLMs (GPT-4o, Claude 3.5, Llama 3).
* **Vrstva 5: Rozhraní**
    * Chat UI, Hlas, ERP Pluginy.
[Vizuál: Obrázek Vrstvené Architektury - viz architektura výše
Poznámka: Toto bych rád upravil. Bylo by možné vygenerovat tento vizuál ve formě diagramu, který mohu později upravit? Například jako `draw.io` diagram?
]

## Sekce B: Datová základna (Azure)

**Snímek 51: Cloudová strategie**
* **Poskytovatel:** Azure.
* **Proč:** Existující vztah, integrace Active Directory, shoda s bezpečnostními předpisy.

**Snímek 52: Datová vrstva - Azure Fabric**
* **Koncepty:** (Dimenziální) Data Warehouse + OneLake.
* **Role:** Jednotné úložiště pro hrubá data ().
* **Integrace:** Hladce krmí komponenty "Super Store".

**Snímek 54: Relační DWH**
* **Role:** Data. Připraveno pro reporting.
* **Technologie:** Azure MS SQL.
* **Alternativy:**
    * *Snowflake / Databricks:* Kanón na vrabce pro současné měřítko (Overkill).
    * *PostgreSQL (Oracle, MariaDB):* Již máme expertízu v MS SQL.

**Snímek 55: Vektorová DB**
* **Role:** Vektorové vyhledávání podobnosti (Texty, Obrázky).
* **Technologie:** Qdrant.
* **Proč:** Vysoký výkon, založeno na Rustu, skvělá podpora filtrování.
* **Alternativy:**
    * *MS SQL*: nutno prověřit, je to nové, silná možnost.
    * *Opensearch:* nutno otestovat (benchmark); mohlo by zjednodušit infrastrukturu o jednu komponentu.
    * *PostgreSQL (pgvector):* Dobré pro jednoduché případy, hůře se škáluje.
    * *Azure AI Search:* Nativní volba, ale: vendor lock-in, vnitřnosti jsou černá skříňka, cenotvorba je černá skříňka.

**Snímek 56: Grafová DB**
* **Role:** Znalostní graf.
* **Technologie:** Neo4j.
* **Proč:** Lídr trhu, nejlepší vizualizační nástroje, bohatý dotazovací jazyk Cypher.
* **Alternativy:**
    * *Azure Cosmos DB (Gremlin):* Integrace je dobrá, ale dotazování a vizualizace slabé oproti Neo4j.
    * *JanusGraph:* Vysoká údržba (Open Source).

**Snímek 57: Text**
* **Role:** Fulltext vyhledávání, fuzzy matching.
* **Technologie:** Opensearch.
* **Alternativy:**
    * *Azure AI Search:* Nativní volba, ale: vendor lock-in, vnitřnosti jsou černá skříňka, cenotvorba je černá skříňka.

## Sekce C: Modely
*[Kdo: Ondra]*

**Snímek 58: Modelová agnosticita**
* **Strategie:** Neženíme se s modelem. Ženíme se s **API**.
* **Architektura:** Všichni agenti volají "Model Gateway". Můžeme vyměnit GPT-4 za Claude 3.5 zítra bez přepisování kódu.

**Snímek 59: Strategie "Routeru"**
* **Koncept:** Různé mozky pro různé úkoly.
* **Úroveň 1 (Génius):** GPT-4o / Claude 3.5 Sonnet.
    * *Použití pro:* Komplexní usuzování, plánování, kódování. Vysoká cena.
* **Úroveň 2 (Dělník):** GPT-4o-mini / Llama 3.
    * *Použití pro:* Sumarizace, extrakce, jednoduchý chat. Nízká cena.

**Snímek 60: Soukromí & Lokální modely**
* **Možnost:** Běh modelů lokálně (Ollama / vLLM).
* **Proč:** Žádná data neopouští síť (Bezpečnost/GDPR).
* **Trade-off (Kompromis):** Vyžaduje těžký GPU hardware (Capex) vs. platba za token (Opex).

## Sekce D: Stack Jazyků / Frameworků

**Snímek 61: Architektura "Dvou mozků"**
* **Tvrzení:** Potřebujeme rychlost podnikových systémů a flexibilitu výzkumu AI.
* **Rozhodnutí:** Budeme používat dva primární jazyky.

**Snímek 62: Agentní vrstva - Python**
* **Proč:** Python je mateřský jazyk AI (PyTorch, LangChain, CrewAI).
* **Benefit:** Přístup k nejnovějším knihovnám (podpora Day 0).
* **Role:** Orchestrace, interakce s LLM, definice promptů.

**Snímek 63: Servisní vrstva - Kotlin (JVM)**
* **Proč:** Podniková stabilita, Typová bezpečnost (Type Safety), Konkurence (Coroutines).
* **Benefit:** Udržovatelnost, existující expertíza týmu, výkon.
* **Role:** Byznysová logika, API Gateway, těžké zpracování dat, MCP Servery.

**Snímek 64: Proč ne JS / .NET / Go?**
* **JS/TS:** Backendová typová bezpečnost pro komplexní datové modelování je horší než u Kotlinu.
* **.NET:** Validní možnost, ale vytváří vendor lock-in.
* **Go:** Příliš ukecané (verbose) pro komplexní doménové modelování.

## Sekce E: Integrace & Standardy

**Snímek 65: Interní API**
* **Standard:** Otevřený standard pro komunikaci.
* **Architektura:** Služby mluví přes **gRPC** (interní rychlost) a **REST** (externí/agentní přístup).
* **Pravidlo:** Agenti nikdy nemluví s DB přímo. Mluví se Sémantickými API.

**Snímek 66: Model Context Protocol (MCP)**
* **Standard:** Otevřený standard pro propojení AI modelů s daty.
* **Architektura:** Kotlin Mikroslužby vystavují **MCP Endpointy**.
* **Benefit:** Odděluje "Mozek" od "Rukou".

**Snímek 67: Datová pipeline**
* **Standard:** Azure Data Factory (ADF) + Azure Data Lake.
* **Benefit:** Škálovatelnost.

**Snímek 68: Komunikace agentů (Async)**
* **Architektura:** Pub/Sub (Messaging).
* **Scénář:** Agent A spustí "Výzkumný úkol". Trvá to 10 minut. Agent B ho převezme.
* **Benefit:** Ne-blokující uživatelská zkušenost.

**Snímek 69: Vývojový cyklus**
* **Kód:** Git (Verzování kódu A Promptů).
* **Testování:** "LLM-jako-Soudce" (Automatizovaná evaluace).
* **Pozorovatelnost (Observability):** Sledování myšlenek agenta (LangSmith / Arize).

**Snímek 70: Diagram finální architektury**
* **Vizuál:** Kompletní mapa (Uživatel -> Agent -> MCP/Služba -> Datový Super Store).

**Snímek 71: Další kroky**
* **Fáze 1:** Pilot (Jeden Agent, Omezený rozsah).
* **Fáze 2:** Vybudování jádra Znalostního grafu.
* **Fáze 3:** Škálování na celou firmu (Enterprise).


   """.trimIndent() // Replace ... with your full markdown content

    // Patterns
//    val sectionPattern = Pattern.compile("""## Section (.+)""")
//    val slidePattern = Pattern.compile("""\*\*Slide (\d+): ([^\*]+)\*\*([\s\S]*?)(?=\*\*Slide|\#\# Section|\Z)""")
    val sectionPattern = Pattern.compile("""## Sekce (.+)""")
    val slidePattern = Pattern.compile("""\*\*Snímek (\d+): ([^\*]+)\*\*([\s\S]*?)(?=\*\*Snímek|\#\# Sekce|\Z)""")

    // Load template
    val ppt = FileInputStream(templatePath).use { XMLSlideShow(it) }

    // Find the "Nadpis a obsah" layout (Title and Content)
    val nadpisLayout: XSLFSlideLayout = ppt.slideMasters
        .flatMap { it.slideLayouts.toList() }
        .find { it.name.contains("Nadpis a obsah", ignoreCase = true) || it.name.contains("Title and Content", ignoreCase = true) }
        ?: ppt.slideMasters[0].slideLayouts[1] // fallback

    // Find the Title Slide layout for section dividers
    val titleLayout: XSLFSlideLayout = ppt.slideMasters
        .flatMap { it.slideLayouts.toList() }
        .find { it.name.contains("Záhlaví oddílu", ignoreCase = true) || it.name.contains("Section Header", ignoreCase = true) }
        ?: ppt.slideMasters[0].slideLayouts[0] // fallback

    // Parse sections
    val sectionMatcher = sectionPattern.matcher(markdown)
    val sectionPositions = mutableListOf<Pair<Int, String>>()
    while (sectionMatcher.find()) {
        sectionPositions.add(sectionMatcher.start() to sectionMatcher.group(1))
    }

    // Parse slides
    val slideMatcher = slidePattern.matcher(markdown)
    val slides = mutableListOf<Triple<Int, String, String>>()
    while (slideMatcher.find()) {
        slides.add(Triple(slideMatcher.start(), slideMatcher.group(2).trim(), slideMatcher.group(3).trim()))
    }

    // Add section divider slides
    for ((_, sectionName) in sectionPositions) {
        val slide = ppt.createSlide(titleLayout)
        slide.placeholders[0].text = "Section: $sectionName"
    }

    // Add content slides
    for ((_, slideTitle, slideContent) in slides) {
        val slide = ppt.createSlide(nadpisLayout)
        slide.placeholders[0]?.text = slideTitle
        slide.placeholders[1]?.text = slideContent.replace("*", "")
    }

    // Save the presentation
    FileOutputStream(outputPath).use { ppt.write(it) }
    println("Presentation saved as $outputPath")
}
