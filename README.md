# Fastest Subway Route Finder
## RoMoSo - Roster: Clara Mohri, Soojin Choi, Rohan Ahammed
### What the User is Presented With
The program finds the shortest path between stations. This program does not use real time data, but rather uses the geographical distance between stations and the average speed of a MTA train to determine what would the best route would be. The best route is ultimately the fastest way to get from one station to the next. This program is run from the terminal by making a terminal command.
### How It Works
Stations in New York City (excluding Staten Island stations and S train stations) are treated as nodes that carry a lot of useful information, like borough and geographic coordinates. Stations of each SubwayLine are linked together in a LinkedList structure, in which one end is the terminus of one end of the line and the other end of the LList is the other terminus. The way the program finds the shortest path is by doing a depth-first recursive algorithm. The program will try a certain path,  and then compare it to the shortest path found so far. The trains and transfers the user needs to make will be returned back to the user.
### Launch Instructions

Gamplay involves the user inputing values that match the number of their answer. To play the game please run 
```
javac SubwayMap.java 
```
in terminal followed by
```
java SubwayMap
```
If there are any issues with launching the game, please contact any one of the developers!

Please check a MTA map to figure out what line your departing and arriving stations are. Make sure to type in station names exactly as they appear in the program.
