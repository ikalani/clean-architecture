# clean-architecture

**_Clean_ architecture** refers to organizing the project so that it's easy to understand and easy to change as the project grows. This architecture model was proposed in 2012 by Robert C. Martin. Here my effort is to explain Uncle Bob’s Clean Architecture with simple manners. Let’s start with the layered architecture we all are familiar with and will discuss the problems with the layered architecture.


## Problem with layered architecture

Layered architecture has more restrictions between layers so it’s difficult to define and defend clear abstraction from one layer to another. 

Also most of the time we do database driven designs in our projects in layered architecture. That couples domain logic or services in the business layer into the persistence layer.

So we first build a persistence layer and then we build business logic but it should be the other way around. Domain logic is the most important in this so we need to build domain logic first and then we have to implement the persistence layer. 

The layered architecture allows short cuts like layer bridging for example web layer can access the persistence layer sometimes it makes testing harder.

As the solution to the issues in layered architecture, we can use Clean Architecture instead. It has wrapped these layers with each other.


## What is Clean Architecture

A software application has a **domain** that includes all the business rules and defines what the application does. Domain should be the core of the application. **Infrastructure** includes Database, UIs, APIs which are supported to the domain rule to function.

Architecture represented by the picture will reduce the cost of the software lifecycle. Because science, the domain, and infrastructure has clear boundaries so it was easy to change and maintain the application. Because of the boundary between the Domain and Infrastructure. Domain does not know anything about infrastructure. This means that business rules do not depend on database or UI. Not like the layered architecture here, the persistence layer has been decoupled from the business layer. So we can independently work on these two layers. We can call this as a plugin architecture.

To make clear the domain layer has been divided into two sub-layers call **Entity** and **Use Case** and the input and output between the domain and infrastructure Adapter layer was introduced. 

So domain layers include all the business logic and outside of the domain layer are just details that need to perform the business. Dependencies between the layers only may point inwards.

Let’s look into each of these layers individually and what those layers do.


### Entity

As Uncle Bob says **_Entities_ _encapsulate_ _Enterprise_ _wide_ _business_ _rules._** These can be POJOs,
objects with methods, or even data structures. Entities encapsulate most general and high-level business rules. These should not be affected by any change external to them, and these should be the most stable code within your application.


### Use Case

Use Cases include **_application_ _specific_ _business_ _rules._** These encapsulate and implement all the use cases of the system. Changes in the Usecase layer should not affect the entity also this layer should not be affected by the outer layers such as database UI or the frameworks.


### Adapter

Adapters are translators between the domain and the infrastructure which can trigger as an interactor to perform business logic.
They take input from the Infrastructure layer (as an example from GUI) and translate data that is convenient for Domain layer(UseCase and entities) also they take the output from the domain layer and form the data that convenient for Infrastructure layer (such as GUI, Database).


### Infrastructure

This layer is where all the I/O components go: the UI, database, frameworks, devices, etc. t's the most volatile layer.


## **Implementation**

To implement the solution with Clean Architecture we need to have a better understanding of SOLID principles. I have recognized two basic principles that are very important for better implementation. Those two are the **Single Responsibility Principle **and **Dependency Inversion. **I am going to brief these** **two principles here. That does not mean the other principles are not in use but those are better to have.


### **Dependency Inversion Principle**

DIP refers to **Higher-level modules should not depend on lower-level modules. Instead, both higher-level modules and lower level modules should depend on abstractions.**

This means that less stable classes and components should depend on more stable ones, not the other way around.
 In the layered architecture which has database-driven architecture service has a dependency on the database through the entity, it couples to the persistence layer. What we do in Clean architecture is we inverse above dependency other way around no longer the service layer has a dependency on persistence but other way around. The entity is no longer belongs to the persistence layer ad it belongs to the domain layer 
### **Single Responsibility Principle**
SRP refers to **_a module that should have only one reason to change._**
A **module** can be a class, package, component, etc.. 
EX: A class should only have one job to perform. It may have multiple methods, but these methods all work together to do one main thing. The class should only have one reason to change.
When we look into layered architecture dependencies are always pointed downwards so if we did some changes in the persistence layer it may affect the business layer. 

But in clean architecture with dependency inversion all the dependencies are pointed inwards means the persistence layer depends on the domain but not the other way around. So any change that happens to the persistence layer does not affect business.
