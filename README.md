# Transportation Recommendations
## RoMoSo - Roster: Clara Mohri, Soojin Choi, Rohan Ahammed

### What the User is Presented With
The program finds the shortest path between stations. This program does not use real time data, but rather uses the relations of stops on subway lines to determine the best route. 
The best route is ultimately the the route with the least number of stops (or stations)  in between. This program is run from the terminal by making a terminal command. The user is prompted with various questions to determine their departing and arriving station. This program is meant to be used with a subway map, but if the user knows enough about the NYC Subway System or the exact stations they would like to depart/arrive to and what lines they are, a subway map is not necessary
### How It Works
Stations in New York City (excluding Staten Island stations and S train stations) are treated as nodes that carry a lot of useful information. Stations of each SubwayLine are linked together in a LinkedList structure, in which one end is the terminus of one end of the line and the other end of the LList is the other terminus. The way the program finds the shortest path is by using Dijkstra's algorithm for a single-source shortest path. It does this by:
  1. Putting every station in a minheap
  2. Setting source station's tentative distance
  3. Removing source from heap, and calculating tentative distances from source to other stations
  4. Re-min-heapifying and continuing until a distance from every station to the source is registered and the heap is empty

The source of the data about the stations was acquired by processing a CSV file from data available from the MTA: http://web.mta.info/developers/data/nyct/subway/Stations.csv

### Launch Instructions

Gamplay involves the user inputing values that match the number of their answer. To run the program  please run 
```
javac SubwayMap.java 
```
in terminal followed by
```
java SubwayMap
```
Follow the instructions found in the interface exactly. Only input integers. We are currently case sensitive with letters.

If you wish to go on the A line, you must type "A". Typing "a" will not work.

If there are any issues with launching the game, please contact any one of the developers!

Please check a MTA map to figure out what line your departing and arriving stations are. 
