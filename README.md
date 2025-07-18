This project goes hand in hand with https://github.com/ScyAge/GEMOC-TTQ. This part mainly concerns the analysis of minijava execution traces in order to be able to perform TTQs in Pharo.



## Purpose

The goal of this project is to analyze a trace in a generic way for any DSL.

For this, we are setting up several tools, which allow analyzing a trace: 
- First, we analyze the trace and place in wrappers each element on which the designer would like to be able to execute a TTQ. 
- Then, the wrappers allow us, via the information they contain and a visitor design pattern, to create a JSON file.
- This json file can then be sent via a server in Pharo. The information that the file contains allows us in Pharo to create selection functions for the TTQ.


## Progress

For the moment, to simplify, we are interested only in the static elements present in the trace and in the method call. We want to be able to test if the creation of a selection function is possible in a simpler case. The experience is conclusive.

### Part analysis of Trace:

This part contains three important elements, the wrappers, the runtimestep explorer, and the visitor.

Runtimestep explorer: is a class that can take a RuntimeStep or list of RuntimeStep and that will recursively remove all them. On each of these steps, he will use the vistor to test if an element wrapper of the metomodel exists. If yes, he instantiates it and adds it to a list

Visitor: All dsl for gemoc must define a visitor with a switch that allows visiting each of the elements of the metamodel, in this class there is a method by element of the model that will be executed by the switch. In our case, we redefined the code of some of these methods in a subclass, in order to instantiate our wrappers

Wrapper: the wrappers contain two main information, the element of the model that was wrapped and its original RuntimeStep, it is two pieces of information that allow us to retrieve both static and Runtime information in the wrapper and define how the retrieved in methods.


### Part Server:

The previous part is linked with a Java server with the Javalin API. This server is the entry point to use this project, it offers the possibility to question routes that allow:

- `/fetchAllAvailableTrace` to retrieve the name of all the traces present in the traceContainer folder of the server
- `/postTraceName` allows to load a trace present in the server folder so that it can be analyzed
-  `/getParsedTrace` allows retrieving the JSON of the chosen trace that has been analyzed





## Future work

### Part analysis of Trace:

We would like to have the runtime information in our wrapper in order to create more precise TTQs. Conduct tests on larger cases and not only on the method call.

We can find the references of the objects at the base of the trace that we retrieve, in the runtimeOnlyElements attribute. Each of the elements in this list represent a runtime object present in the trace, and each of them has a version attribute that allows to see all the versions of an object when an action was done on it during execution.

### Part Server:

For the moment, route `/getParsedTrace` returns a generic trace that has been analyzed and does not work based on previous routes. We would like to be able to operate it exactly as described previously



## Desinger and User part

### Desinger : 
In this project, some parts must be coded by the designer of the DSL who wants to adapt the TTQs for his language.

- the different wrapper
- the extension of the switch on the elements of its AST

There is one last case where the question arises as to whether it is the designer who must write the visitor pattern for serialization in JSON or it is he who must adapt when writing wrappers in order to match the API present in the serialization tool. This question is important because in the case of option 1, it will imply that the designer will have to apply strict rules in order to match the format of the JSON to the one expected by the TTQs in Pharo, under the risk of having to write in addition new Pharo adapters to match the format. Under option 2, a solution would be to provide methods to be completed (Template) that would indicate directly to the designer what he will need to write.


### User: 

In the case of the user, he should just have to install the server that has been created by a designer on his project and generate traces in the traceContainer folder. The rest of these actions will be performed in Pharo


## schema

<img width="2511" height="1301" alt="diagrameTTQPharoGemoc drawio (1)" src="https://github.com/user-attachments/assets/8b92545a-9dd4-4e37-933b-eedc782c6546" />




 ## How to make the exp again


- clone for GEMOC https://github.com/ScyAge/GemocTTQ/tree/add-server-route et allé sur la branche add server route

- clone for Pharo https://github.com/ScyAge/GEMOC-TTQ/tree/traceLoaderChange et allé sur la branche traceLoaderChange (Baseline)



GEMOC

Firstly, you need to get these libraries:

annotations-13.0.jar                
error_prone_annotations-2.38.0.jar  
gson-2.13.1.jar                   
javalin-6.6.0.jar                    
jetty-http-11.0.25.jar              
jetty-io-11.0.25.jar               
jetty-jakarta-servlet-api-5.0.2.jar  
jetty-security-11.0.25.jar         
jetty-server-11.0.25.jar           
jetty-servlet-11.0.25.jar           
jetty-util-11.0.25.jar           
jetty-webapp-11.0.25.jar             
jetty-xml-11.0.25.jar               
kotlin-stdlib-1.9.25.jar           
kotlin-stdlib-jdk7-1.9.25.jar       
kotlin-stdlib-jdk8-1.9.25.jar         
slf4j-api-2.0.17.jar               
slf4j-simple-2.0.16.jar               
websocket-core-common-11.0.25.jar    
websocket-core-server-11.0.25.jar     
websocket-jetty-api-11.0.25.jar       
websocket-jetty-common-11.0.25.jar    
websocket-jetty-server-11.0.25.jar  
websocket-servlet-11.0.25.jar        



- put all these exact dependencies in a libs package at the project root
- verify the dependencies in the classpath of the simpletrace and minijava modules
- check if the dependencies of libraries for the server are in the project’s METAINF (runtime/classpath) and in the Java buildpath (libraries/classpath)
- launch the server in the test folder, With the LaunchServerTest class

Pharo 

- once the baseline is loaded, in a playgroup do: 


```st
|app loader |

app := DynamicTTQCreatorApp new.


loader := DynamicTTQCreatorPresenter newApplication: app model: (DynamicTTQCreator new).


loader open.
```


- one then clicks on load trace 
- we enter the IP of the server and connect
- we can then fetch all trace (give fake files for the moment)
- we choose a track then we do setTrace
- then getTrace 
- an inspector should open on  the list of steps that we retrieved from the server
- you can now make a selection fonction by making this code in the inspector

```st
| selection test |

test := self collect: [ :a | MethodCallAdapteurToPharo createAdapterWithDictionary: a ].

selection := SkSelectionMessagesSentWithSelector new.
selection selector: #bubbleSort.
test select: [ :ps | selection value: ps].
```
