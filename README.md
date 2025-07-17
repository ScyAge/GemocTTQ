Ce projet va de pair avec https://github.com/ScyAge/GEMOC-TTQ. Cette partie concerne principalement l'analyse de trace d'exécution minijava afin de pouvoir réaliser des TTQs dans Pharo.



## But

Le but de ce projet est d'analyser une trace de manière générique pour n'importe quelle DSL.

Pour cela on met en place plusieurs outils, qui permettent d'analyser une trace : 
- Dans un premier temps, on analyse la trace et on place dans des wrappers chaque élément sur lequel le designer voudrait pouvoir exécuter une TTQ. 
- Ensuite, les wrappers nous permettent, via les informations qu'ils contiennent et un patron de conception visiteur, de créer un fichier JSON.
- Ce fichier json peut ensuite être envoyé via un serveur en Pharo. Les informations que le fichier contient nous permettent dans Pharo de créer des fonctions de sélection pour les TTQ.

## Avancement

Pour le moment pour simplifier on s'interesesse uniquement aux éléments statique présent dans la trace et au appel de méthod.On veut pouvoir  testé si la création d'une fonction de selection et possible dans un cas plus simple. L'experience est concluante.

### Partie analyse de Trace:

Cette partie contient trois élement imporant, les wrappers, le runtimestep explorer et le visiteur.

Runtimestep explorer: est une classe qui peut prendre un RuntimeStep ou list de RuntimeStep et qui va récursivement tous les expolerer. Sur chacun des ces step il va utiliser le visteur afin de testé si un wrapper d'élement du métomodel  existe. Si oui il l'instancie et l'ajoute dans une liste

Visiteur : Tous les dsl pour gemoc doivent definir un visiteur avec un switch qui permet de visiter chacun des élements du metamodel, dans cette classe il y une method par élement du model qui sera executer par le switch. Dans notre cas on redefinis le code de certaine des ces méthodes dans une sous classe, afin de pouvoir instancier nos wrappers

Wrapper : les wrapper contienne deux information principal, l'élement du model qui a été  envelopper et son RuntimeStep d'origine, c'est deux informations nous permettent de pouvoir récupérer aussi bien les information statique que Runtime dans le wrapper et de définir comment les récuperes dans des méthodes.

### Partie Server:

La partie précédente est reliée avec un serveur Java avec l'API Javalin. Ce serveur est le point d'entrée pour utiliser ce projet, il offre la possibilité de questionner des routes qui permettent :

- `/fetchAllAvailableTrace` de récupérer le nom de toute les trace présente dans le dossier traceContainer du server
- `/postTraceName` permet de chargé une trace présente dans le dossier du server afin qu'elle soit analyser
-  `/getParsedTrace` permet de récuper le JSON de la trace choisis qui à été analyser




## Travail futur

### Partie analyse de Trace:

On voudrait pouvoir avoir les informations runtime dans nos wrapper afin de créer des TTQs plus précises. Faire des tests sur des cas plus grands et pas seulement sur les méthodCall.

### Partie Server:

Pour le moment, la route `/getParsedTrace` renvoie une trace générique qui a été analysée et ne fonctionne pas en fonction des routes précédentes. On voudrais pouvoir le faire fonctionner exactement comme décrit précédemment ? 


## Desinger and User part

### Desinger : 
Dans ce projet, certaines parties doivent être réalisées par le designer du DSL qui veut adapter les TTQs pour son langage.

Grâce à Pharo, on souhaiterait pouvoir générer des templates pour les wrappers, car c'est le designer qui connaît bien son langage et donc c'est lui qui doit spécifier comment récupérer chacune des informations afin de faire des TTQ pertinentes.
Ça serait à lui aussi de sous-classer le visiteur des éléments de son langage. Il pourra donc choisir quel élément il voudra wrapper et lequel ne l'intéresse pas.

### User : 

Dans le cas de l'utilisateur, il devrait juste avoir à installer le serveur qui existe pour son Dsl sur son projet et générer des traces dans le dossier traceContainer. Le reste de ces actions seront effectuées dans Pharo




