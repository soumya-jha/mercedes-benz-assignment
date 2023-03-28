# mercedes-benz-assignment

Use Case:
Design and implement an event driven service, where an event of either true or false along with a
random city of India is constantly pushed from one service to another service. Events are pushed once
in every 2 minutes unless there is any update, if there is any update then the event is pushed instantly.

The event receiving service should implement a messaging broker for handling the events and based
upon the event value the service should do a specific task.

Here the event true means that the fuel lid of the car is opened and false means its closed, when you get
true then call an API to know the fuel cost at a given city (for instance {fuellid: true; city: Bangalore}) and
assuming that the car can take 1 liter/30 seconds then calculate the amount of fuel got into the tank and
calculate the price. For now, price can be logged inside the event receiving service.

Car location can be random, for any random city try to get the fuel price from a 3rd party provider and
calculate the amount of fuel cost. Explore an 3rd party API which can provide fuel cost of any given
Indian city, if you were not able to find out the API then create a mocked service that returns fuel cost
for a given Indian city.

Considering the cost of fuel will change once in every 24 hours, please consider introducing caching to
cache cost of fuel for a requested city if not already requested within 24 hours.


Note: From the service, which can trigger event please expose an API where the event can be triggered
manually.


Mandatory:
API’s should be securely accessed and well documented documentation.
