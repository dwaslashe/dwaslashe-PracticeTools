# ⚔️ dwaslashe-PracticeTools

Dedykowany zestaw narzędzi i mechanik pomocniczych dla sektora **Practice / PvP** w sieci serwerów **pvpplay.pl**. Plugin odpowiada za obsługę komend graczy i administracji, systemy kar, cząsteczki (particles), integracje z antycheatem oraz automatyzację ogłoszeń na trybie Practice.

---

## 🌟 Główne Funkcje & Mechaniki

### 🗡️ Narzędzia Practice & Kosmetyka
* **Partikles / Cząsteczki:** Personalizacja efektów cząsteczkowych wokół gracza (`ParticlesCommand`, `PlayerParticles`).
* **Kolory Nicków & Sklep Nad Głową:** Modyfikacje wyglądu gracza oraz sklepy nad głowami (`NickColorCommand`, `AboveNameShopCommand`).
* **Komendy Szybkiej Walki & Przedmiotów:** Odnawianie przedmiotów, leczenie, karmienie i naprawa ekwipunku (`HealCommand`, `FeedCommand`, `RepairCommand`, `MoreCommand`).

### 🛠️ Administracja & Moderacja
* **System Kar i Antycheat:** Dedykowane integracje i zarządzanie karami oraz podgląd/kontrola powiadomień antycheata (`PunishmentCommand`, `NcpCommand`, `VerusCommand`).
* **Nadzór i Niewidzialność:** Tryb niewidzialności oraz podgląd prywatnych wiadomości graczy (`VanishCommand`, `SocialSpyCommand`, `InvseeCommand`).
* **Teleportacja & Kontrola Świata:** Zaawansowana teleportacja oraz sterowanie pogodą i czasem (`TpCommand`, `TpHereCommand`, `DayCommand`, `NightCommand`, `StormCommand`, `SunCommand`).

### 📢 Komunikacja & Automatyzacja
* **Zarządzanie Czatem:** Ignorowanie graczy, wyciszanie/czyszczenie czatu (`IgnoreCommand`, `UnIgnoreCommand`, `ChatCommand`, `ClearCommand`).
* **Powiadomienia Automatyczne:** Automatyczne ogłoszenia na czacie oraz pasek BossBar (`AutoMessageTask`, `AutoBossBarTask`, `AlertsCommand`, `BcCommand`).
* **System Nagród i Zakupów:** Sklep, odbieranie nagród i rang (`PurchaseCommand`, `RewardCommand`, `RankCommand`).

---

## 📂 Struktura Projektu

```text
xyz.dwaslashe.tools
├── commands/           # Komendy graczy, kosmetyczne oraz administracyjne
│   └── managers/       # Zarządzanie rejestracją i egzekucją komend (CommandManager)
├── configs/            # Konfiguracja pluginu oraz spersonalizowanych komend
├── helpers/            # Helpery pomocnicze (InventoryHelper, ReflectionHelper)
├── listeners/          # Obsługa zdarzeń Bukkit (Chat, Join, Quit, Others)
├── managers/           # Menedżerowie systemowi (CooldownManager, TeleportManager)
├── objects/            # Obiekty domenowe (PlayerParticles)
├── tasks/              # Pętle asynchroniczne (AutoBossBarTask, AutoMessageTask)
└── utils/              # API pomocnicze (Api, BossBarApi, ChatApi, ItemApi, LicenseApi, TimerApi)
