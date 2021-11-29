# Assignment 2
## Reflections
### Computer mouse
Ved test af computer mus ville jeg teste følgende: 
-	Sikre at musens højre knap virker
-	Sikre at musens venstre knap virker
-	Sikre at det er muligt at scrolle på toppen af musen
-	Sikre at pilen på skærmen bevæger sig, når musen kører over en flade
-	Sikre at der ikke sker noget hvis musen ligger på hovedet 
### Catastrophic failure 
Ved overførsel af penge ville det være et stort problem, hvis en overførsel kunne gå igennem, selvom kontonummer og registreringsnummer ikke matchede eller eksisterede.
### Two katas
- Opgave 1: [String utility](https://github.com/fred8728/SOFT_DeveloperTest/tree/master/Assignment2/stringUtility)
-  Opgave 2: [Bowling game](https://github.com/fred8728/SOFT_DeveloperTest/tree/master/Assignment2/BowlingGame)
## Investigation of tools
### Junit5
```
@Tag
# Giver en mulighed for at filtrerer i sine test. 
# Fx hvis man både har unittest og integrationstest implementeret kan man anvende tagget – @Tag(”IntegrationsTest”)
@Disabled
# Kan anvendes over selve klassen eller en metode for at ”deaktivere den”.
@RepeatedTest
# Giver en mulighed for at køre ens test x antal gange
# Erstatter den normale @Test annotation
@BeforeEach
# Angiver at metoden skal execute før alle testmetoder i klassen
@AfterEach
# Angiver at metoden skal execute efter alle testmetoder i klassen
@BeforeAll
# Angiver at den annoterede metode vil blive executed før alle testmetoder
@AfterAll
# Angiver at den annoterede metode vil blive executed efter alle testmetoder 
@DisplayName
# Giver ens tests metoder customized navne, som vises i stedet for ens metode navn
# Eksempelvis: @DisplayName(”Order test”) 
@Nested
# Giver en mulighed for at have en inner class i vores test klasse. Dermed har man mulighed for at gruppere mere test klasser under den samme parent (samme initialisering)
# Indeholder pr. default metoder, såsom @BeforeEach og @AfterEach 
assumeFalse
# Validerer at den givne antagelse er falsk, og hvis dette er tilfældet skal testen fortsætte – ellers bliver den afbrudt.
assumeTrue
# Validerer at den given antagelse er sand, og hvis dette er tilfældet skal testen fortsætte – ellers bliver den afbrudt.
```
## Mocking frameworks
Jeg har valgt Mockito og EasyMock
### Hvad er deres ligheder?
-	De kan begge mock både klasser og interfaces
-	De kan anvendes sammen med andre frameworks, såsom JUNIT og TestNG.
### Hvad er deres forskelle?
En af forskellene på de to frameworks er at Mockito er giver en mulighed for at oprette mock objekter i automatiserede unit tests, hvor formålet er TDD eller BDD. EasyMock er derimod et framework som giver en mulighed for at oprette mock objekter ud fra et interface gennem Java Reflection. 

En anden forskel på de to frameworks er deres syntax – eksempelvis ved mocked metode kald anvender man when i Mockito og expect i EasyMock. Derudover er der en lille syntax forskel hvis man ønsker at kaste en exception, hvor man i Mockito anvender andTrow(..) og i EasyMock anvender andThrow(..) efter et mocked metode kald. 
Eksempler på mocked metode kald: 
```
Mockito: 
# Mockito.when(mock.metod(args)).thenReturn(value)
# EasyMock: EasyMock.expect(mock.method(args)).andReturn(Value)
```
Eksempler på Exception throwing:
```
Mockito: 
# En exception kan blive mocked gennem .thenThrow(ExceptionClass.class) efter man har kaldt Mockito.when(mock.method(args)) metoden.
EasyMock: 
# En exception kan blive mocked gennem andThrow(new ExceptionClass()) efter man har kaldt EasyMock.expect(..) metoden.
```
### Hvilken ville du foretrække, hvis nogen og hvorfor?
Jeg har ikke særlig meget erfaring med de to frameworks, så umiddelbart ville jeg teste begge af for at finde ud af det.
