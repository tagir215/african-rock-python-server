# AfricanRockPythonServer

The purpose of the project was to learn design patterns and use the top 20 design patterns in its operation. Approximately 17 design patterns were implemented in the project, but only about 13 are actually used in the core logic. The project is still partially incomplete, including JUnit tests and Spring Security-related functions. The user interface is also still under development.

## ComponentEntity

- ComponentEntity is an abstract entity for all computer components.
- There are implementations of ComponentEntity, such as MotherboardEntity and CpuEntity.
- ComponentEntity implements the CompositeComponent interface to make it easy to calculate cumulative prices.
- Some ComponentEntity implementations implement the CompatibilityComponent interface, which defines a method for a component to determine whether the input ComponentEntity is compatible with itself.

## Factories

- AbstractComputerFactory uses a builder to assemble computers, creating a ComputerInfo object.
- The ComputerInfo object contains information about the budget weight for each component.
- AbstractComputerFactory has various implementations, such as BasicComputerFactory, which creates its own ComputerInfo object.
- AbstractComputerFactory defines four build methods for different budget classes (Budget, Mid, High, Enthusiast), with price ranges determined based on each implementation.
- AbstractComputerFactory uses the ComponentSelector interface to select components, which returns a SelectedComponents record.

## ComponentSelector

- The ComponentSelector interface defines methods for selecting each component based on the input ComputerInfo, e.g., selectMotherboard, selectCpu.
- The selectComponent method is used by all individual select methods, with each passing different parameters.
- The logic for selecting individual components is implemented separately for each component type, making it easier to adjust if needed.
- Some select methods, such as selectGpu, pass CompatibilityComponents to the selectComponent method.
- The selectComponent method uses the ComponentFilterer class to filter out incompatible components based on price limits and the checkCompatibility method of the CompatibilityComponent interface.
- ComponentCollections contain a list of all available components for each component type, created from JSON or MySQL tables.

## FactoryController

- When a request is received, the FactoryController creates a Strategy based on the request parameter, selects a Factory implementation from the FactoryRegistry.
- The FactoryStrategyContext takes the strategy and Factory and returns a list of computer creations.

## Shopping Cart

- The CartController adds or removes products from the shopping cart based on requests.
- The ShoppingCart interface is implemented using the ShoppingCartFacade interface, which selects different implementations not only for the shopping cart interface methods but also based on whether the user is logged in or anonymous.
- ShoppingCartFacade also implements the Observer interface and notifies its subscribers about shopping cart events.
- Shopping cart transactions are saved in MySQL using user session cookies. This seemingly simple process took nearly four weeks to implement due to peculiar Hibernate issues.
- Since the program's products were not actual products but collections of components, relationships had to be used to link them to actual products. Somehow, Hibernate couldn't always distinguish between components of the same ComponentEntity abstract class.
- The problems could have been bypassed by saving only some kind of DTO with component ID values, but this time, I wanted to save entities as relationships. However, I gained a lot of confidence in how Hibernate and MySQL work during this process.

## Data

- Data was collected using Selenium from the ComputerBuilder.io website.
- ComputerBuilder.io provided compatibility information for various components and allowed open web scraping.
- A Selenium script was created to collect technical information about components from specific sections of the page and visit links for compatibility information.
- The script also checked if a compatible component had already been scraped at some point to reduce unnecessary scraping for time-saving.
- Selenium saved the data to JSON files using Jackson.


