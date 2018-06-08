/*
RoMoSo
Clara Mohri, Rohan Ahammed, Soojin Choi
*/
//This file has been written by the Python file process.py
//A few manual alterations have been made to ensure that stations are in order
//Afterwards, we made the decision to have this in the form a class called Subway Map where all of the subway lines are a linked list. Some of the python code has been altered, but we could not rewrite the Python script because this would change the order of the stations, setting us back.


// Algorithm for finding shortest path between two subway stations.
// 1. imports map.
// 2. creates data structures for subway graph (matrices
// 3. single-source shortest-paths algorithm.
// 4. returns shortest path. 

import java.util.LinkedList;
import java.util.PriorityQueue;
import cs1.Keyboard;

public class Driver{

    //instance vars:
    //the different lines:
    SubwayLine one, two, three, four, five, six, seven, a, c, e, b, d, f, m, n, q, r, w, j, z, l, g;
    //route string is what will be printed once path has been found
    String route = "";
    LinkedList<Station> path;    
    ALHeap queue;

    public Driver(){

	        //the one line:
	        one = new SubwayLine();
		one.add(new Station("293", "Van Cortlandt Park - 242 St", "Bx", "1", "40.889248", "-73.898583", "1"));
		one.add(new Station("294", "238 St", "Bx", "1", "40.884667", "-73.90087", "1"));
		one.add(new Station("295", "231 St", "Bx", "1", "40.878856", "-73.904834", "1"));
		one.add(new Station("296", "Marble Hill - 225 St", "M", "1", "40.874561", "-73.909831", "1"));
		one.add(new Station("297", "215 St", "M", "1", "40.869444", "-73.915279", "1"));
		one.add(new Station("298", "207 St", "M", "1", "40.864621", "-73.918822", "1"));
		one.add(new Station("299", "Dyckman St", "M", "1", "40.860531", "-73.925536", "1"));
		one.add(new Station("300", "191 St", "M", "1", "40.855225", "-73.929412", "1"));
		one.add(new Station("301", "181 St", "M", "1", "40.849505", "-73.933596", "1"));
		one.add(new Station("605", "168 St - Washington Hts", "M", "1", "40.840556", "-73.940133", "1AC"));
		one.add(new Station("303", "157 St", "M", "1", "40.834041", "-73.94489", "1"));
		one.add(new Station("304", "145 St", "M", "1", "40.826551", "-73.95036", "1"));
		one.add(new Station("305", "137 St - City College", "M", "1", "40.822008", "-73.953676", "1"));
		one.add(new Station("306", "125 St", "M", "1", "40.815581", "-73.958372", "1"));
		one.add(new Station("307", "116 St - Columbia University", "M", "1", "40.807722", "-73.96411", "1"));
		one.add(new Station("308", "Cathedral Pkwy", "M", "1", "40.803967", "-73.966847", "1"));
		one.add(new Station("309", "103 St", "M", "1", "40.799446", "-73.968379", "1"));
		one.add(new Station("310", "96 St", "M", "1", "40.793919", "-73.972323", "123"));
		one.add(new Station("311", "86 St", "M", "1", "40.788644", "-73.976218", "1"));
		one.add(new Station("312", "79 St", "M", "1", "40.783934", "-73.979917", "1"));
		one.add(new Station("313", "72 St", "M", "1", "40.778453", "-73.98197", "123"));
		one.add(new Station("314", "66 St - Lincoln Center", "M", "1", "40.77344", "-73.982209", "1"));
		one.add(new Station("614", "59 St - Columbus Circle", "M", "1", "40.768247", "-73.981929", "1ABCD"));
		one.add(new Station("316", "50 St", "M", "1", "40.761728", "-73.983849", "1"));
		one.add(new Station("611", "Times Sq - 42 St", "M", "1", "40.75529", "-73.987495", "123NQRWACE7S"));
		one.add(new Station("318", "34 St - Penn Station", "M", "1", "40.750373", "-73.991057", "123"));
		one.add(new Station("319", "28 St", "M", "1", "40.747215", "-73.993365", "1"));
		one.add(new Station("320", "23 St", "M", "1", "40.744081", "-73.995657", "1"));
		one.add(new Station("321", "18 St", "M", "1", "40.74104", "-73.997871", "1"));
		one.add(new Station("601", "14 St", "M", "1", "40.737826", "-74.000201", "123LFM"));
		one.add(new Station("323", "Christopher St - Sheridan Sq", "M", "1", "40.733422", "-74.002906", "1"));
		one.add(new Station("324", "Houston St", "M", "1", "40.728251", "-74.005367", "1"));
		one.add(new Station("325", "Canal St", "M", "1", "40.722854", "-74.006277", "1"));
		one.add(new Station("326", "Franklin St", "M", "1", "40.719318", "-74.006886", "1"));
		one.add(new Station("327", "Chambers St", "M", "1", "40.715478", "-74.009266", "123"));
		one.add(new Station("328", "Cortlandt St", "M", "1", "40.711835", "-74.012188", "1"));
		one.add(new Station("329", "Rector St", "M", "1", "40.707513", "-74.013783", "1"));
		one.add(new Station("635", "South Ferry", "M", "1", "40.702068", "-74.013664", "1RW"));
		
		//the two line:
		//had to swap two sections to make two train in order
		two = new SubwayLine();
		two.add(new Station("416", "Wakefield - 241 St", "Bx", "2", "40.903125", "-73.85062", "2"));
		two.add(new Station("417", "Nereid Av", "Bx", "2", "40.898379", "-73.854376", "25"));
		two.add(new Station("418", "233 St", "Bx", "2", "40.893193", "-73.857473", "25"));
		two.add(new Station("419", "225 St", "Bx", "2", "40.888022", "-73.860341", "25"));
		two.add(new Station("420", "219 St", "Bx", "2", "40.883895", "-73.862633", "25"));
		two.add(new Station("421", "Gun Hill Rd", "Bx", "2", "40.87785", "-73.866256", "25"));
		two.add(new Station("422", "Burke Av", "Bx", "2", "40.871356", "-73.867164", "25"));
		two.add(new Station("423", "Allerton Av", "Bx", "2", "40.865462", "-73.867352", "25"));
		two.add(new Station("424", "Pelham Pkwy", "Bx", "2", "40.857192", "-73.867615", "25"));
		two.add(new Station("425", "Bronx Park East", "Bx", "2", "40.848828", "-73.868457", "25"));
		two.add(new Station("426", "E 180 St", "Bx", "2", "40.841894", "-73.873488", "25"));
		two.add(new Station("427", "West Farms Sq - E Tremont Av", "Bx", "2", "40.840295", "-73.880049", "25"));
		two.add(new Station("428", "174 St", "Bx", "2", "40.837288", "-73.887734", "25"));
		two.add(new Station("429", "Freeman St", "Bx", "2", "40.829993", "-73.891865", "25"));
		two.add(new Station("430", "Simpson St", "Bx", "2", "40.824073", "-73.893064", "25"));
		two.add(new Station("431", "Intervale Av", "Bx", "2", "40.822181", "-73.896736", "25"));
		two.add(new Station("432", "Prospect Av", "Bx", "2", "40.819585", "-73.90177", "25"));
		two.add(new Station("433", "Jackson Av", "Bx", "2", "40.81649", "-73.907807", "25"));
		two.add(new Station("434", "3 Av - 149 St", "Bx", "2", "40.816109", "-73.917757", "25"));
		two.add(new Station("603", "149 St - Grand Concourse", "Bx", "2", "40.81841", "-73.926718", "254"));
		two.add(new Station("438", "135 St", "M", "2", "40.814229", "-73.94077", "23"));
		two.add(new Station("439", "125 St", "M", "2", "40.807754", "-73.945495", "23"));
		two.add(new Station("440", "116 St", "M", "2", "40.802098", "-73.949625", "23"));
		two.add(new Station("441", "Central Park North (110 St)", "M", "2", "40.799075", "-73.951822", "23"));
		two.add(new Station("310", "96 St", "M", "2", "40.793919", "-73.972323", "123"));
		two.add(new Station("313", "72 St", "M", "2", "40.778453", "-73.98197", "123"));
		two.add(new Station("611", "Times Sq - 42 St", "M", "2", "40.75529", "-73.987495", "123NQRWACE7S"));
		two.add(new Station("318", "34 St - Penn Station", "M", "2", "40.750373", "-73.991057", "123"));
		two.add(new Station("601", "14 St", "M", "2", "40.737826", "-74.000201", "123LFM"));
		two.add(new Station("327", "Chambers St", "M", "2", "40.715478", "-74.009266", "123"));
		two.add(new Station("624", "Park Pl", "M", "2", "40.713051", "-74.008811", "23ACE"));
		two.add(new Station("628", "Fulton St", "M", "2", "40.709416", "-74.006571", "23JZAC45"));
		two.add(new Station("333", "Wall St", "M", "2", "40.706821", "-74.0091", "23"));
		two.add(new Station("334", "Clark St", "Bk", "2", "40.697466", "-73.993086", "23"));
		two.add(new Station("620", "Borough Hall", "Bk", "2", "40.693219", "-73.989998", "23R45"));
		two.add(new Station("336", "Hoyt St", "Bk", "2", "40.690545", "-73.985065", "23"));
		two.add(new Station("337", "Nevins St", "Bk", "2", "40.688246", "-73.980492", "2345"));
		two.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "2", "40.684359", "-73.977666", "23DNRBQ45"));
		two.add(new Station("339", "Bergen St", "Bk", "2", "40.680829", "-73.975098", "23"));
		two.add(new Station("340", "Grand Army Plaza", "Bk", "2", "40.675235", "-73.971046", "23"));
		two.add(new Station("341", "Eastern Pkwy - Brooklyn Museum", "Bk", "2", "40.671987", "-73.964375", "23"));
		two.add(new Station("626", "Franklin Av", "Bk", "2", "40.670682", "-73.958131", "2345S"));
		two.add(new Station("353", "President St", "Bk", "2", "40.667883", "-73.950683", "25"));
		two.add(new Station("354", "Sterling St", "Bk", "2", "40.662742", "-73.95085", "25"));
		two.add(new Station("355", "Winthrop St", "Bk", "2", "40.656652", "-73.9502", "25"));
		two.add(new Station("356", "Church Av", "Bk", "2", "40.650843", "-73.949575", "25"));
		two.add(new Station("357", "Beverly Rd", "Bk", "2", "40.645098", "-73.948959", "25"));
		two.add(new Station("358", "Newkirk Av", "Bk", "2", "40.639967", "-73.948411", "25"));
		two.add(new Station("359", "Flatbush Av - Brooklyn College", "Bk", "2", "40.632836", "-73.947642", "25"));
		
		//the three line:
		//two sections of the three were out of order, had to swap these two sections
		three = new SubwayLine();
		three.add(new Station("436", "Harlem - 148 St", "M", "3", "40.82388", "-73.93647", "3"));
		three.add(new Station("437", "145 St", "M", "3", "40.820421", "-73.936245", "3"));
		three.add(new Station("438", "135 St", "M", "3", "40.814229", "-73.94077", "23"));
		three.add(new Station("439", "125 St", "M", "3", "40.807754", "-73.945495", "23"));
		three.add(new Station("440", "116 St", "M", "3", "40.802098", "-73.949625", "23"));
		three.add(new Station("441", "Central Park North (110 St)", "M", "3", "40.799075", "-73.951822", "23"));
		three.add(new Station("310", "96 St", "M", "3", "40.793919", "-73.972323", "123"));
		three.add(new Station("313", "72 St", "M", "3", "40.778453", "-73.98197", "123"));
		three.add(new Station("611", "Times Sq - 42 St", "M", "3", "40.75529", "-73.987495", "123NQRWACE7S"));
		three.add(new Station("318", "34 St - Penn Station", "M", "3", "40.750373", "-73.991057", "123"));
		three.add(new Station("601", "14 St", "M", "3", "40.737826", "-74.000201", "123LFM"));
		three.add(new Station("327", "Chambers St", "M", "3", "40.715478", "-74.009266", "123"));
		three.add(new Station("624", "Park Pl", "M", "3", "40.713051", "-74.008811", "23ACE"));
		three.add(new Station("628", "Fulton St", "M", "3", "40.709416", "-74.006571", "23JZAC45"));
		three.add(new Station("333", "Wall St", "M", "3", "40.706821", "-74.0091", "23"));
		three.add(new Station("334", "Clark St", "Bk", "3", "40.697466", "-73.993086", "23"));
		three.add(new Station("620", "Borough Hall", "Bk", "3", "40.693219", "-73.989998", "23R45"));
		three.add(new Station("336", "Hoyt St", "Bk", "3", "40.690545", "-73.985065", "23"));
		three.add(new Station("337", "Nevins St", "Bk", "3", "40.688246", "-73.980492", "2345"));
		three.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "3", "40.684359", "-73.977666", "23DNRBQ45"));
		three.add(new Station("339", "Bergen St", "Bk", "3", "40.680829", "-73.975098", "23"));
		three.add(new Station("340", "Grand Army Plaza", "Bk", "3", "40.675235", "-73.971046", "23"));
		three.add(new Station("341", "Eastern Pkwy - Brooklyn Museum", "Bk", "3", "40.671987", "-73.964375", "23"));
		three.add(new Station("626", "Franklin Av", "Bk", "3", "40.670682", "-73.958131", "2345S"));
		three.add(new Station("343", "Nostrand Av", "Bk", "3", "40.669847", "-73.950466", "3"));
		three.add(new Station("344", "Kingston Av", "Bk", "3", "40.669399", "-73.942161", "3"));
		three.add(new Station("345", "Crown Hts - Utica Av", "Bk", "3", "40.668897", "-73.932942", "34"));
		three.add(new Station("346", "Sutter Av - Rutland Rd", "Bk", "3", "40.664717", "-73.92261", "3"));
		three.add(new Station("347", "Saratoga Av", "Bk", "3", "40.661453", "-73.916327", "3"));
		three.add(new Station("348", "Rockaway Av", "Bk", "3", "40.662549", "-73.908946", "3"));
		three.add(new Station("349", "Junius St", "Bk", "3", "40.663515", "-73.902447", "3"));
		three.add(new Station("350", "Pennsylvania Av", "Bk", "3", "40.664635", "-73.894895", "3"));
		three.add(new Station("351", "Van Siclen Av", "Bk", "3", "40.665449", "-73.889395", "3"));
		three.add(new Station("352", "New Lots Av", "Bk", "3", "40.666235", "-73.884079", "3"));

		//the four line:
		//last two stations were at front, and barclays had to be added.
		four = new SubwayLine();
		four.add(new Station("378", "Woodlawn", "Bx", "4", "40.886037", "-73.878751", "4"));
		four.add(new Station("379", "Mosholu Pkwy", "Bx", "4", "40.87975", "-73.884655", "4"));
		four.add(new Station("380", "Bedford Park Blvd - Lehman College", "Bx", "4", "40.873412", "-73.890064", "4"));
		four.add(new Station("381", "Kingsbridge Rd", "Bx", "4", "40.86776", "-73.897174", "4"));
		four.add(new Station("382", "Fordham Rd", "Bx", "4", "40.862803", "-73.901034", "4"));
		four.add(new Station("383", "183 St", "Bx", "4", "40.858407", "-73.903879", "4"));
		four.add(new Station("384", "Burnside Av", "Bx", "4", "40.853453", "-73.907684", "4"));
		four.add(new Station("385", "176 St", "Bx", "4", "40.84848", "-73.911794", "4"));
		four.add(new Station("386", "Mt Eden Av", "Bx", "4", "40.844434", "-73.914685", "4"));
		four.add(new Station("387", "170 St", "Bx", "4", "40.840075", "-73.917791", "4"));
		four.add(new Station("388", "167 St", "Bx", "4", "40.835537", "-73.9214", "4"));
		four.add(new Station("604", "161 St - Yankee Stadium", "Bx", "4", "40.827994", "-73.925831", "4BD"));
		four.add(new Station("603", "149 St - Grand Concourse", "Bx", "4", "40.818375", "-73.927351", "425"));
		four.add(new Station("391", "138 St - Grand Concourse", "Bx", "4", "40.813224", "-73.929849", "45"));
		four.add(new Station("392", "125 St", "M", "4", "40.804138", "-73.937594", "456"));
		four.add(new Station("397", "86 St", "M", "4", "40.779492", "-73.955589", "456"));
		four.add(new Station("613", "59 St", "M", "4", "40.762526", "-73.967967", "456NWR"));
		four.add(new Station("610", "Grand Central - 42 St", "M", "4", "40.751776", "-73.976848", "4567S"));
		four.add(new Station("602", "14 St - Union Sq", "M", "4", "40.734673", "-73.989951", "456NQRWL"));
		four.add(new Station("622", "Brooklyn Bridge - City Hall", "M", "4", "40.713065", "-74.004131", "456JZ"));
		four.add(new Station("628", "Fulton St", "M", "4", "40.710368", "-74.009509", "45JZAC23"));
		four.add(new Station("413", "Wall St", "M", "4", "40.707557", "-74.011862", "45"));
		four.add(new Station("414", "Bowling Green", "M", "4", "40.704817", "-74.014065", "45"));
		four.add(new Station("620", "Borough Hall", "Bk", "4", "40.692404", "-73.990151", "45R23"));
		four.add(new Station("337", "Nevins St", "Bk", "4", "40.688246", "-73.980492", "2345"));
		//barclays had to be added here manually with complex ID 617
		four.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "4", "40.68446", "-73.97689", "45DNRBQ23"));
		four.add(new Station("626", "Franklin Av", "Bk", "4", "40.670682", "-73.958131", "2345S"));
		four.add(new Station("345", "Crown Hts - Utica Av", "Bk", "4", "40.668897", "-73.932942", "34"));

		//the five line:
		//Atlantic Avenue is missing on four and five
		five = new SubwayLine();
		five.add(new Station("442", "Eastchester - Dyre Av", "Bx", "5", "40.8883", "-73.830834", "5"));
		five.add(new Station("443", "Baychester Av", "Bx", "5", "40.878663", "-73.838591", "5"));
		five.add(new Station("444", "Gun Hill Rd", "Bx", "5", "40.869526", "-73.846384", "5"));
		five.add(new Station("445", "Pelham Pkwy", "Bx", "5", "40.858985", "-73.855359", "5"));
		five.add(new Station("446", "Morris Park", "Bx", "5", "40.854364", "-73.860495", "5"));
		five.add(new Station("426", "E 180 St", "Bx", "5", "40.841894", "-73.873488", "25"));
		five.add(new Station("427", "West Farms Sq - E Tremont Av", "Bx", "5", "40.840295", "-73.880049", "25"));
		five.add(new Station("428", "174 St", "Bx", "5", "40.837288", "-73.887734", "25"));
		five.add(new Station("429", "Freeman St", "Bx", "5", "40.829993", "-73.891865", "25"));
		five.add(new Station("430", "Simpson St", "Bx", "5", "40.824073", "-73.893064", "25"));
		five.add(new Station("431", "Intervale Av", "Bx", "5", "40.822181", "-73.896736", "25"));
		five.add(new Station("432", "Prospect Av", "Bx", "5", "40.819585", "-73.90177", "25"));
		five.add(new Station("433", "Jackson Av", "Bx", "5", "40.81649", "-73.907807", "25"));
		five.add(new Station("434", "3 Av - 149 St", "Bx", "5", "40.816109", "-73.917757", "25"));
		five.add(new Station("603", "149 St - Grand Concourse", "Bx", "5", "40.81841", "-73.926718", "254"));
		five.add(new Station("391", "138 St - Grand Concourse", "Bx", "5", "40.813224", "-73.929849", "45"));
		five.add(new Station("392", "125 St", "M", "5", "40.804138", "-73.937594", "456"));
		five.add(new Station("397", "86 St", "M", "5", "40.779492", "-73.955589", "456"));
		five.add(new Station("613", "59 St", "M", "5", "40.762526", "-73.967967", "456NWR"));
		five.add(new Station("610", "Grand Central - 42 St", "M", "5", "40.751776", "-73.976848", "4567S"));
		five.add(new Station("602", "14 St - Union Sq", "M", "5", "40.734673", "-73.989951", "456NQRWL"));
		five.add(new Station("622", "Brooklyn Bridge - City Hall", "M", "5", "40.713065", "-74.004131", "456JZ"));
		five.add(new Station("628", "Fulton St", "M", "5", "40.710368", "-74.009509", "45JZAC23"));
		five.add(new Station("413", "Wall St", "M", "5", "40.707557", "-74.011862", "45"));
		five.add(new Station("414", "Bowling Green", "M", "5", "40.704817", "-74.014065", "45"));
		five.add(new Station("620", "Borough Hall", "Bk", "5", "40.692404", "-73.990151", "45R23"));
		five.add(new Station("337", "Nevins St", "Bk", "5", "40.688246", "-73.980492", "2345"));
		five.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "5", "40.68446", "-73.97689", "45DNRBQ23"));
		five.add(new Station("626", "Franklin Av", "Bk", "5", "40.670682", "-73.958131", "2345S"));
		five.add(new Station("353", "President St", "Bk", "5", "40.667883", "-73.950683", "25"));
		five.add(new Station("354", "Sterling St", "Bk", "5", "40.662742", "-73.95085", "25"));
		five.add(new Station("355", "Winthrop St", "Bk", "5", "40.656652", "-73.9502", "25"));
		five.add(new Station("356", "Church Av", "Bk", "5", "40.650843", "-73.949575", "25"));
		five.add(new Station("357", "Beverly Rd", "Bk", "5", "40.645098", "-73.948959", "25"));
		five.add(new Station("358", "Newkirk Av", "Bk", "5", "40.639967", "-73.948411", "25"));
		five.add(new Station("359", "Flatbush Av - Brooklyn College", "Bk", "5", "40.632836", "-73.947642", "25"));
		/*
		  This is an alternative line that only runs during AM rush hour towards Manhattan, and during PM rush hour from Manhattan.
		  For the sake of simplicity, we have decided to omit these stops.
		five.add(new Station("417", "Nereid Av", "Bx", "5", "40.898379", "-73.854376", "25"));
		five.add(new Station("418", "233 St", "Bx", "5", "40.893193", "-73.857473", "25"));
		five.add(new Station("419", "225 St", "Bx", "5", "40.888022", "-73.860341", "25"));
		five.add(new Station("420", "219 St", "Bx", "5", "40.883895", "-73.862633", "25"));
		five.add(new Station("421", "Gun Hill Rd", "Bx", "5", "40.87785", "-73.866256", "25"));
		five.add(new Station("422", "Burke Av", "Bx", "5", "40.871356", "-73.867164", "25"));
		five.add(new Station("423", "Allerton Av", "Bx", "5", "40.865462", "-73.867352", "25"));
		five.add(new Station("424", "Pelham Pkwy", "Bx", "5", "40.857192", "-73.867615", "25"));
		five.add(new Station("425", "Bronx Park East", "Bx", "5", "40.848828", "-73.868457", "25"));*/

		//the six line:
		//in order thanks to process.py
		six = new SubwayLine();
		six.add(new Station("360", "Pelham Bay Park", "Bx", "6", "40.852462", "-73.828121", "6"));
		six.add(new Station("361", "Buhre Av", "Bx", "6", "40.84681", "-73.832569", "6"));
		six.add(new Station("362", "Middletown Rd", "Bx", "6", "40.843863", "-73.836322", "6"));
		six.add(new Station("363", "Westchester Sq - E Tremont Av", "Bx", "6", "40.839892", "-73.842952", "6"));
		six.add(new Station("364", "Zerega Av", "Bx", "6", "40.836488", "-73.847036", "6"));
		six.add(new Station("365", "Castle Hill Av", "Bx", "6", "40.834255", "-73.851222", "6"));
		six.add(new Station("366", "Parkchester", "Bx", "6", "40.833226", "-73.860816", "6"));
		six.add(new Station("367", "St Lawrence Av", "Bx", "6", "40.831509", "-73.867618", "6"));
		six.add(new Station("368", "Morrison Av- Sound View", "Bx", "6", "40.829521", "-73.874516", "6"));
		six.add(new Station("369", "Elder Av", "Bx", "6", "40.828584", "-73.879159", "6"));
		six.add(new Station("370", "Whitlock Av", "Bx", "6", "40.826525", "-73.886283", "6"));
		six.add(new Station("371", "Hunts Point Av", "Bx", "6", "40.820948", "-73.890549", "6"));
		six.add(new Station("372", "Longwood Av", "Bx", "6", "40.816104", "-73.896435", "6"));
		six.add(new Station("373", "E 149 St", "Bx", "6", "40.812118", "-73.904098", "6"));
		six.add(new Station("374", "E 143 St - St Mary's St", "Bx", "6", "40.808719", "-73.907657", "6"));
		six.add(new Station("375", "Cypress Av", "Bx", "6", "40.805368", "-73.914042", "6"));
		six.add(new Station("376", "Brook Av", "Bx", "6", "40.807566", "-73.91924", "6"));
		six.add(new Station("377", "3 Av - 138 St", "Bx", "6", "40.810476", "-73.926138", "6"));
		six.add(new Station("392", "125 St", "M", "6", "40.804138", "-73.937594", "456"));
		six.add(new Station("393", "116 St", "M", "6", "40.798629", "-73.941617", "6"));
		six.add(new Station("394", "110 St", "M", "6", "40.79502", "-73.94425", "6"));
		six.add(new Station("395", "103 St", "M", "6", "40.7906", "-73.947478", "6"));
		six.add(new Station("396", "96 St", "M", "6", "40.785672", "-73.95107", "6"));
		six.add(new Station("397", "86 St", "M", "6", "40.779492", "-73.955589", "456"));
		six.add(new Station("398", "77 St", "M", "6", "40.77362", "-73.959874", "6"));
		six.add(new Station("399", "68 St - Hunter College", "M", "6", "40.768141", "-73.96387", "6"));
		six.add(new Station("613", "59 St", "M", "6", "40.762526", "-73.967967", "456NWR"));
		six.add(new Station("612", "51 St", "M", "6", "40.757107", "-73.97192", "6EM"));
		six.add(new Station("610", "Grand Central - 42 St", "M", "6", "40.751776", "-73.976848", "4567S"));
		six.add(new Station("403", "33 St", "M", "6", "40.746081", "-73.982076", "6"));
		six.add(new Station("404", "28 St", "M", "6", "40.74307", "-73.984264", "6"));
		six.add(new Station("405", "23 St", "M", "6", "40.739864", "-73.986599", "6"));
		six.add(new Station("602", "14 St - Union Sq", "M", "6", "40.734673", "-73.989951", "456NQRWL"));
		six.add(new Station("407", "Astor Pl", "M", "6", "40.730054", "-73.99107", "6"));
		six.add(new Station("619", "Bleecker St", "M", "6", "40.725915", "-73.994659", "6BDFM"));
		six.add(new Station("409", "Spring St", "M", "6", "40.722301", "-73.997141", "6"));
		six.add(new Station("623", "Canal St", "M", "6", "40.718803", "-74.000193", "6RWNQJZ"));
		six.add(new Station("622", "Brooklyn Bridge - City Hall", "M", "6", "40.713065", "-74.004131", "456JZ"));

		//the seven line:
		//in order thanks to process.py
		seven = new SubwayLine();
		seven.add(new Station("447", "Flushing - Main St", "Q", "7", "40.7596", "-73.83003", "7"));
		seven.add(new Station("448", "Mets - Willets Point", "Q", "7", "40.754622", "-73.845625", "7"));
		seven.add(new Station("449", "111 St", "Q", "7", "40.75173", "-73.855334", "7"));
		seven.add(new Station("450", "103 St - Corona Plaza", "Q", "7", "40.749865", "-73.8627", "7"));
		seven.add(new Station("451", "Junction Blvd", "Q", "7", "40.749145", "-73.869527", "7"));
		seven.add(new Station("452", "90 St - Elmhurst Av", "Q", "7", "40.748408", "-73.876613", "7"));
		seven.add(new Station("453", "82 St - Jackson Hts", "Q", "7", "40.747659", "-73.883697", "7"));
		seven.add(new Station("616", "74 St - Broadway", "Q", "7", "40.746848", "-73.891394", "7EFMR"));
		seven.add(new Station("455", "69 St", "Q", "7", "40.746325", "-73.896403", "7"));
		seven.add(new Station("456", "Woodside - 61 St", "Q", "7", "40.74563", "-73.902984", "7"));
		seven.add(new Station("457", "52 St", "Q", "7", "40.744149", "-73.912549", "7"));
		seven.add(new Station("458", "46 St", "Q", "7", "40.743132", "-73.918435", "7"));
		seven.add(new Station("459", "40 St", "Q", "7", "40.743781", "-73.924016", "7"));
		seven.add(new Station("460", "33 St", "Q", "7", "40.744587", "-73.930997", "7"));
		seven.add(new Station("461", "Queensboro Plaza", "Q", "7", "40.750582", "-73.940202", "7NW"));
		seven.add(new Station("606", "Court Sq", "Q", "7", "40.747023", "-73.945264", "7EMG"));
		seven.add(new Station("463", "Hunters Point Av", "Q", "7", "40.742216", "-73.948916", "7"));
		seven.add(new Station("464", "Vernon Blvd - Jackson Av", "Q", "7", "40.742626", "-73.953581", "7"));
		seven.add(new Station("610", "Grand Central - 42 St", "M", "7", "40.751431", "-73.976041", "7456S"));
		seven.add(new Station("609", "5 Av", "M", "7", "40.753821", "-73.981963", "7BDFM"));
		seven.add(new Station("611", "Times Sq - 42 St", "M", "7", "40.755477", "-73.987691", "7NQRWACE123S"));
		seven.add(new Station("471", "34 St - 11 Av", "M", "7", "40.755882", "-74.00191", "7"));

		//the a line:
		//in order thanks to process.py
		a = new SubwayLine();
		a.add(new Station("143", "Inwood - 207 St", "M", "A", "40.868072", "-73.919899", "A"));
		a.add(new Station("144", "Dyckman St", "M", "A", "40.865491", "-73.927271", "A"));
		a.add(new Station("145", "190 St", "M", "A", "40.859022", "-73.93418", "A"));
		a.add(new Station("146", "181 St", "M", "A", "40.851695", "-73.937969", "A"));
		a.add(new Station("147", "175 St", "M", "A", "40.847391", "-73.939704", "A"));
		a.add(new Station("605", "168 St", "M", "A", "40.840719", "-73.939561", "AC1"));
		a.add(new Station("151", "145 St", "M", "A", "40.824783", "-73.944216", "ACBD"));
		a.add(new Station("153", "125 St", "M", "A", "40.811109", "-73.952343", "ABCD"));
		a.add(new Station("614", "59 St - Columbus Circle", "M", "A", "40.768296", "-73.981736", "ABCD1"));
		a.add(new Station("611", "42 St - Port Authority Bus Terminal", "M", "A", "40.757308", "-73.989735", "ACENQRW1237S"));
		a.add(new Station("164", "34 St - Penn Station", "M", "A", "40.752287", "-73.993391", "ACE"));
		a.add(new Station("618", "14 St", "M", "A", "40.740893", "-74.00169", "ACEL"));
		a.add(new Station("167", "W 4 St", "M", "A", "40.732338", "-74.000495", "ACEBDFM"));
		a.add(new Station("169", "Canal St", "M", "A", "40.720824", "-74.005229", "ACE"));
		a.add(new Station("624", "Chambers St", "M", "A", "40.714111", "-74.008585", "ACE23"));
		a.add(new Station("628", "Fulton St", "M", "A", "40.710197", "-74.007691", "ACJZ2345"));
		a.add(new Station("173", "High St", "Bk", "A", "40.699337", "-73.990531", "AC"));
		a.add(new Station("636", "Jay St - MetroTech", "Bk", "A", "40.692338", "-73.987342", "ACFR"));
		a.add(new Station("175", "Hoyt - Schermerhorn Sts", "Bk", "A", "40.688484", "-73.985001", "ACG"));
		a.add(new Station("179", "Nostrand Av", "Bk", "A", "40.680438", "-73.950426", "AC"));
		a.add(new Station("181", "Utica Av", "Bk", "A", "40.679364", "-73.930729", "AC"));
		a.add(new Station("621", "Broadway Jct", "Bk", "A", "40.678334", "-73.905316", "ACJZL"));
		a.add(new Station("188", "Euclid Av", "Bk", "A", "40.675377", "-73.872106", "AC"));
		a.add(new Station("189", "Grant Av", "Bk", "A", "40.677044", "-73.86505", "A"));
		a.add(new Station("190", "80 St", "Q", "A", "40.679371", "-73.858992", "A"));
		a.add(new Station("191", "88 St", "Q", "A", "40.679843", "-73.85147", "A"));
		a.add(new Station("192", "Rockaway Blvd", "Q", "A", "40.680429", "-73.843853", "A"));

		/*Omitted because this is a less frequently running, shorter different endpoint for the A train
		a.add(new Station("193", "104 St", "Q", "A", "40.681711", "-73.837683", "A"));
		a.add(new Station("194", "111 St", "Q", "A", "40.684331", "-73.832163", "A"));
		a.add(new Station("195", "Ozone Park - Lefferts Blvd", "Q", "A", "40.685951", "-73.825798", "A"));
		*/
		a.add(new Station("196", "Aqueduct Racetrack", "Q", "A", "40.672097", "-73.835919", "A"));
		a.add(new Station("197", "Aqueduct - N Conduit Av", "Q", "A", "40.668234", "-73.834058", "A"));
		a.add(new Station("198", "Howard Beach - JFK Airport", "Q", "A", "40.660476", "-73.830301", "A"));
		a.add(new Station("199", "Broad Channel", "Q", "A", "40.608382", "-73.815925", "AS"));
		/*Omitted because this is a less frequently running, shorter different endpoint for the A train
		a.add(new Station("199", "Broad Channel", "Q", "A", "40.608382", "-73.815925", "ASAS"));
		a.add(new Station("200", "Beach 90 St", "Q", "A", "40.588034", "-73.813641", "AS"));
		a.add(new Station("201", "Beach 98 St", "Q", "A", "40.585307", "-73.820558", "AS"));
		a.add(new Station("202", "Beach 105 St", "Q", "A", "40.583209", "-73.827559", "AS"));
		a.add(new Station("203", "Rockaway Park - Beach 116 St", "Q", "A", "40.580903", "-73.835592", "AS"));*/
		a.add(new Station("204", "Beach 67 St", "Q", "A", "40.590927", "-73.796924", "A"));
		a.add(new Station("205", "Beach 60 St", "Q", "A", "40.592374", "-73.788522", "A"));
		a.add(new Station("206", "Beach 44 St", "Q", "A", "40.592943", "-73.776013", "A"));
		a.add(new Station("207", "Beach 36 St", "Q", "A", "40.595398", "-73.768175", "A"));
		a.add(new Station("208", "Beach 25 St", "Q", "A", "40.600066", "-73.761353", "A"));
		a.add(new Station("209", "Far Rockaway - Mott Av", "Q", "A", "40.603995", "-73.755405", "A"));

		//the c line:
		//in order thanks to process.py
		c = new SubwayLine();
		c.add(new Station("605", "168 St", "M", "C", "40.840719", "-73.939561", "AC1"));
		c.add(new Station("149", "163 St - Amsterdam Av", "M", "C", "40.836013", "-73.939892", "C"));
		c.add(new Station("150", "155 St", "M", "C", "40.830518", "-73.941514", "C"));
		c.add(new Station("151", "145 St", "M", "C", "40.824783", "-73.944216", "ACBD"));
		c.add(new Station("152", "135 St", "M", "C", "40.817894", "-73.947649", "BC"));
		c.add(new Station("153", "125 St", "M", "C", "40.811109", "-73.952343", "ABCD"));
		c.add(new Station("154", "116 St", "M", "C", "40.805085", "-73.954882", "BC"));
		c.add(new Station("155", "Cathedral Pkwy (110 St)", "M", "C", "40.800603", "-73.958161", "BC"));
		c.add(new Station("156", "103 St", "M", "C", "40.796092", "-73.961454", "BC"));
		c.add(new Station("157", "96 St", "M", "C", "40.791642", "-73.964696", "BC"));
		c.add(new Station("158", "86 St", "M", "C", "40.785868", "-73.968916", "BC"));
		c.add(new Station("159", "81 St - Museum of Natural History", "M", "C", "40.781433", "-73.972143", "BC"));
		c.add(new Station("160", "72 St", "M", "C", "40.775594", "-73.97641", "BC"));
		c.add(new Station("614", "59 St - Columbus Circle", "M", "C", "40.768296", "-73.981736", "ABCD1"));
		c.add(new Station("162", "50 St", "M", "C", "40.762456", "-73.985984", "CE"));
		c.add(new Station("611", "42 St - Port Authority Bus Terminal", "M", "C", "40.757308", "-73.989735", "ACENQRW1237S"));
		c.add(new Station("164", "34 St - Penn Station", "M", "C", "40.752287", "-73.993391", "ACE"));
		c.add(new Station("165", "23 St", "M", "C", "40.745906", "-73.998041", "CE"));
		c.add(new Station("618", "14 St", "M", "C", "40.740893", "-74.00169", "ACEL"));
		c.add(new Station("167", "W 4 St", "M", "C", "40.732338", "-74.000495", "ACEBDFM"));
		c.add(new Station("168", "Spring St", "M", "C", "40.726227", "-74.003739", "CE"));
		c.add(new Station("169", "Canal St", "M", "C", "40.720824", "-74.005229", "ACE"));
		c.add(new Station("624", "Chambers St", "M", "C", "40.714111", "-74.008585", "ACE23"));
		c.add(new Station("628", "Fulton St", "M", "C", "40.710197", "-74.007691", "ACJZ2345"));
		c.add(new Station("173", "High St", "Bk", "C", "40.699337", "-73.990531", "AC"));
		c.add(new Station("636", "Jay St - MetroTech", "Bk", "C", "40.692338", "-73.987342", "ACFR"));
		c.add(new Station("175", "Hoyt - Schermerhorn Sts", "Bk", "C", "40.688484", "-73.985001", "ACG"));
		c.add(new Station("176", "Lafayette Av", "Bk", "C", "40.686113", "-73.973946", "C"));
		c.add(new Station("177", "Clinton - Washington Avs", "Bk", "C", "40.683263", "-73.965838", "C"));
		c.add(new Station("627", "Franklin Av", "Bk", "C", "40.68138", "-73.956848", "CS"));
		c.add(new Station("179", "Nostrand Av", "Bk", "C", "40.680438", "-73.950426", "AC"));
		c.add(new Station("180", "Kingston - Throop Avs", "Bk", "C", "40.679921", "-73.940858", "C"));
		c.add(new Station("181", "Utica Av", "Bk", "C", "40.679364", "-73.930729", "AC"));
		c.add(new Station("182", "Ralph Av", "Bk", "C", "40.678822", "-73.920786", "C"));
		c.add(new Station("183", "Rockaway Av", "Bk", "C", "40.67834", "-73.911946", "C"));
		c.add(new Station("621", "Broadway Jct", "Bk", "C", "40.678334", "-73.905316", "ACJZL"));
		c.add(new Station("185", "Liberty Av", "Bk", "C", "40.674542", "-73.896548", "C"));
		c.add(new Station("186", "Van Siclen Av", "Bk", "C", "40.67271", "-73.890358", "C"));
		c.add(new Station("187", "Shepherd Av", "Bk", "C", "40.67413", "-73.88075", "C"));
		c.add(new Station("188", "Euclid Av", "Bk", "C", "40.675377", "-73.872106", "AC"));

		//the e line:
		//somewhat out of order, but now fixed
		e = new SubwayLine();
		e.add(new Station("278", "Jamaica Center - Parsons/Archer", "Q", "E", "40.702147", "-73.801109", "EJZ"));
		e.add(new Station("279", "Sutphin Blvd - Archer Av - JFK Airport", "Q", "E", "40.700486", "-73.807969", "EJZ"));
		e.add(new Station("280", "Jamaica - Van Wyck", "Q", "E", "40.702566", "-73.816859", "E"));
		e.add(new Station("258", "Briarwood - Van Wyck Blvd", "Q", "E", "40.709179", "-73.820574", "EF"));
		e.add(new Station("259", "Kew Gardens - Union Tpke", "Q", "E", "40.714441", "-73.831008", "EF"));
		e.add(new Station("260", "75 Av", "Q", "E", "40.718331", "-73.837324", "EF"));
		e.add(new Station("261", "Forest Hills - 71 Av", "Q", "E", "40.721691", "-73.844521", "EFMR"));
		e.add(new Station("616", "Jackson Hts - Roosevelt Av", "Q", "E", "40.746644", "-73.891338", "EFMR7"));
		e.add(new Station("273", "Queens Plaza", "Q", "E", "40.748973", "-73.937243", "EMR"));
		e.add(new Station("606", "Court Sq", "Q", "E", "40.747846", "-73.946", "EMG7"));
		e.add(new Station("612", "Lexington Av/53 St", "M", "E", "40.757552", "-73.969055", "EM6"));
		e.add(new Station("276", "5 Av/53 St", "M", "E", "40.760167", "-73.975224", "EM"));
		e.add(new Station("277", "7 Av", "M", "E", "40.762862", "-73.981637", "BDE"));
		e.add(new Station("162", "50 St", "M", "E", "40.762456", "-73.985984", "CE"));
		e.add(new Station("611", "42 St - Port Authority Bus Terminal", "M", "E", "40.757308", "-73.989735", "ACENQRW1237S"));
		e.add(new Station("164", "34 St - Penn Station", "M", "E", "40.752287", "-73.993391", "ACE"));
		e.add(new Station("165", "23 St", "M", "E", "40.745906", "-73.998041", "CE"));
		e.add(new Station("618", "14 St", "M", "E", "40.740893", "-74.00169", "ACEL"));
		e.add(new Station("167", "W 4 St", "M", "E", "40.732338", "-74.000495", "ACEBDFM"));
		e.add(new Station("168", "Spring St", "M", "E", "40.726227", "-74.003739", "CE"));
		e.add(new Station("169", "Canal St", "M", "E", "40.720824", "-74.005229", "ACE"));
		e.add(new Station("624", "World Trade Center", "M", "E", "40.712582", "-74.009781", "EAC23"));

		//the b line:
		//order fixed
		//Cathedral Pkwy is closed until Sept 2018
		b = new SubwayLine();
		b.add(new Station("211", "Bedford Park Blvd", "Bx", "B", "40.873244", "-73.887138", "BD"));
		b.add(new Station("212", "Kingsbridge Rd", "Bx", "B", "40.866978", "-73.893509", "BD"));
		b.add(new Station("213", "Fordham Rd", "Bx", "B", "40.861296", "-73.897749", "BD"));
		b.add(new Station("214", "182-183 Sts", "Bx", "B", "40.856093", "-73.900741", "BD"));
		b.add(new Station("215", "Tremont Av", "Bx", "B", "40.85041", "-73.905227", "BD"));
		b.add(new Station("216", "174-175 Sts", "Bx", "B", "40.8459", "-73.910136", "BD"));
		b.add(new Station("217", "170 St", "Bx", "B", "40.839306", "-73.9134", "BD"));
		b.add(new Station("218", "167 St", "Bx", "B", "40.833771", "-73.91844", "BD"));
		b.add(new Station("604", "161 St - Yankee Stadium", "Bx", "B", "40.827905", "-73.925651", "BD4"));
		b.add(new Station("220", "155 St", "M", "B", "40.830135", "-73.938209", "BD"));
		b.add(new Station("151", "145 St", "M", "B", "40.824783", "-73.944216", "BDAC"));
		b.add(new Station("152", "135 St", "M", "B", "40.817894", "-73.947649", "BC"));
		b.add(new Station("153", "125 St", "M", "B", "40.811109", "-73.952343", "ABCD"));
		b.add(new Station("154", "116 St", "M", "B", "40.805085", "-73.954882", "BC"));
		b.add(new Station("155", "Cathedral Pkwy (110 St)", "M", "B", "40.800603", "-73.958161", "BC"));
		b.add(new Station("156", "103 St", "M", "B", "40.796092", "-73.961454", "BC"));
		b.add(new Station("157", "96 St", "M", "B", "40.791642", "-73.964696", "BC"));
		b.add(new Station("158", "86 St", "M", "B", "40.785868", "-73.968916", "BC"));
		b.add(new Station("159", "81 St - Museum of Natural History", "M", "B", "40.781433", "-73.972143", "BC"));
		b.add(new Station("160", "72 St", "M", "B", "40.775594", "-73.97641", "BC"));
		b.add(new Station("614", "59 St - Columbus Circle", "M", "B", "40.768296", "-73.981736", "ABCD1"));
		b.add(new Station("277", "7 Av", "M", "B", "40.762862", "-73.981637", "BDE"));
		b.add(new Station("225", "47-50 Sts - Rockefeller Ctr", "M", "B", "40.758663", "-73.981329", "BDFM"));
		b.add(new Station("609", "42 St - Bryant Pk", "M", "B", "40.754222", "-73.984569", "BDFM7"));
		b.add(new Station("607", "34 St - Herald Sq", "M", "B", "40.749719", "-73.987823", "BDFMNQRW"));
		b.add(new Station("167", "W 4 St", "M", "B", "40.732338", "-74.000495", "BDFMACE"));
		b.add(new Station("619", "Broadway-Lafayette St", "M", "B", "40.725297", "-73.996204", "BDFM6"));
		b.add(new Station("231", "Grand St", "M", "B", "40.718267", "-73.993753", "BD"));
		b.add(new Station("26", "DeKalb Av", "Bk", "B", "40.690635", "-73.981824", "BQR"));
		b.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "B", "40.68446", "-73.97689", "BQDNR2345"));
		b.add(new Station("41", "7 Av", "Bk", "B", "40.67705", "-73.972367", "BQ"));
		b.add(new Station("42", "Prospect Park", "Bk", "B", "40.661614", "-73.962246", "BQ"));
		/*
		   This is a Q station
		b.add(new Station("43", "Parkside Av", "Bk", "B", "40.655292", "-73.961495", "BQ"));
		*/
		b.add(new Station("44", "Church Av", "Bk", "B", "40.650527", "-73.962982", "BQ"));
		b.add(new Station("47", "Newkirk Plaza", "Bk", "B", "40.635082", "-73.962793", "BQ"));
		b.add(new Station("51", "Kings Hwy", "Bk", "B", "40.60867", "-73.957734", "BQ"));
		b.add(new Station("54", "Sheepshead Bay", "Bk", "B", "40.586896", "-73.954155", "BQ"));

		/*
		   These do not exist on the b train:
		b.add(new Station("45", "Beverley Rd", "Bk", "B", "40.644031", "-73.964492", "BQ"));
		b.add(new Station("46", "Cortelyou Rd", "Bk", "B", "40.640927", "-73.963891", "BQ"));

		b.add(new Station("48", "Avenue H", "Bk", "B", "40.62927", "-73.961639", "BQ"));
		b.add(new Station("49", "Avenue J", "Bk", "B", "40.625039", "-73.960803", "BQ"));
		b.add(new Station("50", "Avenue M", "Bk", "B", "40.617618", "-73.959399", "BQ"));

		b.add(new Station("52", "Avenue U", "Bk", "B", "40.5993", "-73.955929", "BQ"));
		b.add(new Station("53", "Neck Rd", "Bk", "B", "40.595246", "-73.955161", "BQ"));
		*/
		b.add(new Station("55", "Brighton Beach", "Bk", "B", "40.577621", "-73.961376", "BQ"));

		//the d line:
		//order fixed
		d = new SubwayLine();
		//d.add(new Station("Complex ID", "Stop Name", "Borough", "D", "GTFS Latitude", "GTFS Longitude", "Transfer Options"));
		d.add(new Station("210", "Norwood - 205 St", "Bx", "D", "40.874811", "-73.878855", "D"));
		d.add(new Station("211", "Bedford Park Blvd", "Bx", "D", "40.873244", "-73.887138", "BD"));
		d.add(new Station("212", "Kingsbridge Rd", "Bx", "D", "40.866978", "-73.893509", "BD"));
		d.add(new Station("213", "Fordham Rd", "Bx", "D", "40.861296", "-73.897749", "BD"));
		d.add(new Station("214", "182-183 Sts", "Bx", "D", "40.856093", "-73.900741", "BD"));
		d.add(new Station("215", "Tremont Av", "Bx", "D", "40.85041", "-73.905227", "BD"));
		d.add(new Station("216", "174-175 Sts", "Bx", "D", "40.8459", "-73.910136", "BD"));
		d.add(new Station("217", "170 St", "Bx", "D", "40.839306", "-73.9134", "BD"));
		d.add(new Station("218", "167 St", "Bx", "D", "40.833771", "-73.91844", "BD"));
		d.add(new Station("604", "161 St - Yankee Stadium", "Bx", "D", "40.827905", "-73.925651", "BD4"));
		d.add(new Station("220", "155 St", "M", "D", "40.830135", "-73.938209", "BD"));
		d.add(new Station("151", "145 St", "M", "D", "40.824783", "-73.944216", "BDAC"));
		d.add(new Station("153", "125 St", "M", "D", "40.811109", "-73.952343", "ABCD"));
		d.add(new Station("614", "59 St - Columbus Circle", "M", "D", "40.768296", "-73.981736", "ABCD1"));
		d.add(new Station("277", "7 Av", "M", "D", "40.762862", "-73.981637", "BDE"));
		d.add(new Station("225", "47-50 Sts - Rockefeller Ctr", "M", "D", "40.758663", "-73.981329", "BDFM"));
		d.add(new Station("609", "42 St - Bryant Pk", "M", "D", "40.754222", "-73.984569", "BDFM7"));
		d.add(new Station("607", "34 St - Herald Sq", "M", "D", "40.749719", "-73.987823", "BDFMNQRW"));
		d.add(new Station("167", "W 4 St", "M", "D", "40.732338", "-74.000495", "BDFMACE"));
		d.add(new Station("619", "Broadway-Lafayette St", "M", "D", "40.725297", "-73.996204", "BDFM6"));
		d.add(new Station("231", "Grand St", "M", "D", "40.718267", "-73.993753", "BD"));
		d.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "D", "40.683666", "-73.97881", "DNRBQ2345"));
		d.add(new Station("32", "36 St", "Bk", "D", "40.655144", "-74.003549", "DNR"));
		d.add(new Station("59", "9 Av", "Bk", "D", "40.646292", "-73.994324", "D"));
		d.add(new Station("60", "Fort Hamilton Pkwy", "Bk", "D", "40.640914", "-73.994304", "D"));
		d.add(new Station("61", "50 St", "Bk", "D", "40.63626", "-73.994791", "D"));
		d.add(new Station("62", "55 St", "Bk", "D", "40.631435", "-73.995476", "D"));
		d.add(new Station("615", "62 St", "Bk", "D", "40.626472", "-73.996895", "DN"));
		d.add(new Station("64", "71 St", "Bk", "D", "40.619589", "-73.998864", "D"));
		d.add(new Station("65", "79 St", "Bk", "D", "40.613501", "-74.00061", "D"));
		d.add(new Station("66", "18 Av", "Bk", "D", "40.607954", "-74.001736", "D"));
		d.add(new Station("67", "20 Av", "Bk", "D", "40.604556", "-73.998168", "D"));
		d.add(new Station("68", "Bay Pkwy", "Bk", "D", "40.601875", "-73.993728", "D"));
		d.add(new Station("69", "25 Av", "Bk", "D", "40.597704", "-73.986829", "D"));
		d.add(new Station("70", "Bay 50 St", "Bk", "D", "40.588841", "-73.983765", "D"));
		d.add(new Station("58", "Coney Island - Stillwell Av", "Bk", "D", "40.577422", "-73.981233", "DFNQ"));

		//the f line:
		//in order now. swaps had to be made.
		f = new SubwayLine();
		f.add(new Station("254", "Jamaica - 179 St", "Q", "F", "40.712646", "-73.783817", "F"));
		f.add(new Station("255", "169 St", "Q", "F", "40.71047", "-73.793604", "F"));
		f.add(new Station("256", "Parsons Blvd", "Q", "F", "40.707564", "-73.803326", "F"));
		f.add(new Station("257", "Sutphin Blvd", "Q", "F", "40.70546", "-73.810708", "F"));
		f.add(new Station("258", "Briarwood - Van Wyck Blvd", "Q", "F", "40.709179", "-73.820574", "EF"));
		f.add(new Station("259", "Kew Gardens - Union Tpke", "Q", "F", "40.714441", "-73.831008", "EF"));
		f.add(new Station("260", "75 Av", "Q", "F", "40.718331", "-73.837324", "EF"));
		f.add(new Station("261", "Forest Hills - 71 Av", "Q", "F", "40.721691", "-73.844521", "EFMR"));
		f.add(new Station("616", "Jackson Hts - Roosevelt Av", "Q", "F", "40.746644", "-73.891338", "EFMR7"));
		f.add(new Station("221", "21 St - Queensbridge", "Q", "F", "40.754203", "-73.942836", "F"));
		f.add(new Station("222", "Roosevelt Island", "M", "F", "40.759145", "-73.95326", "F"));
		f.add(new Station("223", "Lexington Av/63 St", "M", "F", "40.764629", "-73.966113", "FQ"));
		f.add(new Station("224", "57 St", "M", "F", "40.763972", "-73.97745", "F"));
		f.add(new Station("225", "47-50 Sts - Rockefeller Ctr", "M", "F", "40.758663", "-73.981329", "BDFM"));
		f.add(new Station("609", "42 St - Bryant Pk", "M", "F", "40.754222", "-73.984569", "BDFM7"));
		f.add(new Station("607", "34 St - Herald Sq", "M", "F", "40.749719", "-73.987823", "BDFMNQRW"));
		f.add(new Station("228", "23 St", "M", "F", "40.742878", "-73.992821", "FM"));
		f.add(new Station("601", "14 St", "M", "F", "40.738228", "-73.996209", "FML123"));
		f.add(new Station("167", "W 4 St", "M", "F", "40.732338", "-74.000495", "BDFMACE"));
		f.add(new Station("619", "Broadway-Lafayette St", "M", "F", "40.725297", "-73.996204", "BDFM6"));
		f.add(new Station("232", "2 Av", "M", "F", "40.723402", "-73.989938", "F"));
		f.add(new Station("625", "Delancey St", "M", "F", "40.718611", "-73.988114", "FJMZ"));
		f.add(new Station("234", "East Broadway", "M", "F", "40.713715", "-73.990173", "F"));
		f.add(new Station("235", "York St", "Bk", "F", "40.701397", "-73.986751", "F"));
		f.add(new Station("636", "Jay St - MetroTech", "Bk", "F", "40.692338", "-73.987342", "ACFR"));
		f.add(new Station("236", "Bergen St", "Bk", "F", "40.686145", "-73.990862", "FG"));
		f.add(new Station("237", "Carroll St", "Bk", "F", "40.680303", "-73.995048", "FG"));
		f.add(new Station("238", "Smith - 9 Sts", "Bk", "F", "40.67358", "-73.995959", "FG"));
		f.add(new Station("608", "4 Av", "Bk", "F", "40.670272", "-73.989779", "FGR"));
		f.add(new Station("240", "7 Av", "Bk", "F", "40.666271", "-73.980305", "FG"));
		f.add(new Station("241", "15 St - Prospect Park", "Bk", "F", "40.660365", "-73.979493", "FG"));
		f.add(new Station("242", "Fort Hamilton Pkwy", "Bk", "F", "40.650782", "-73.975776", "FG"));
		f.add(new Station("243", "Church Av", "Bk", "F", "40.644041", "-73.979678", "FG"));
		f.add(new Station("244", "Ditmas Av", "Bk", "F", "40.636119", "-73.978172", "F"));
		f.add(new Station("245", "18 Av", "Bk", "F", "40.629755", "-73.976971", "F"));
		f.add(new Station("246", "Avenue I", "Bk", "F", "40.625322", "-73.976127", "F"));
		f.add(new Station("247", "Bay Pkwy", "Bk", "F", "40.620769", "-73.975264", "F"));
		f.add(new Station("248", "Avenue N", "Bk", "F", "40.61514", "-73.974197", "F"));
		f.add(new Station("249", "Avenue P", "Bk", "F", "40.608944", "-73.973022", "F"));
		f.add(new Station("250", "Kings Hwy", "Bk", "F", "40.603217", "-73.972361", "F"));
		f.add(new Station("251", "Avenue U", "Bk", "F", "40.596063", "-73.973357", "F"));
		f.add(new Station("252", "Avenue X", "Bk", "F", "40.58962", "-73.97425", "F"));
		f.add(new Station("253", "Neptune Av", "Bk", "F", "40.581011", "-73.974574", "F"));
		f.add(new Station("57", "W 8 St - NY Aquarium", "Bk", "F", "40.576127", "-73.975939", "FQ"));
		f.add(new Station("58", "Coney Island - Stillwell Av", "Bk", "F", "40.577422", "-73.981233", "DFNQ"));

		//the m line:
		//now in order.
		m = new SubwayLine();
		m.add(new Station("261", "Forest Hills - 71 Av", "Q", "M", "40.721691", "-73.844521", "EFMR"));
		m.add(new Station("262", "67 Av", "Q", "M", "40.726523", "-73.852719", "MR"));
		m.add(new Station("263", "63 Dr - Rego Park", "Q", "M", "40.729846", "-73.861604", "MR"));
		m.add(new Station("264", "Woodhaven Blvd", "Q", "M", "40.733106", "-73.869229", "MR"));
		m.add(new Station("265", "Grand Av - Newtown", "Q", "M", "40.737015", "-73.877223", "MR"));
		m.add(new Station("266", "Elmhurst Av", "Q", "M", "40.742454", "-73.882017", "MR"));
		m.add(new Station("616", "Jackson Hts - Roosevelt Av", "Q", "M", "40.746644", "-73.891338", "EFMR7"));
		m.add(new Station("268", "65 St", "Q", "M", "40.749669", "-73.898453", "MR"));
		m.add(new Station("269", "Northern Blvd", "Q", "M", "40.752885", "-73.906006", "MR"));
		m.add(new Station("270", "46 St", "Q", "M", "40.756312", "-73.913333", "MR"));
		m.add(new Station("271", "Steinway St", "Q", "M", "40.756879", "-73.92074", "MR"));
		m.add(new Station("272", "36 St", "Q", "M", "40.752039", "-73.928781", "MR"));
		m.add(new Station("273", "Queens Plaza", "Q", "M", "40.748973", "-73.937243", "EMR"));
		m.add(new Station("606", "Court Sq", "Q", "M", "40.747846", "-73.946", "EMG7"));
		m.add(new Station("612", "Lexington Av/53 St", "M", "M", "40.757552", "-73.969055", "EM6"));
		m.add(new Station("276", "5 Av/53 St", "M", "M", "40.760167", "-73.975224", "EM"));
		m.add(new Station("225", "47-50 Sts - Rockefeller Ctr", "M", "M", "40.758663", "-73.981329", "BDFM"));
		m.add(new Station("609", "42 St - Bryant Pk", "M", "M", "40.754222", "-73.984569", "BDFM7"));
		m.add(new Station("607", "34 St - Herald Sq", "M", "M", "40.749719", "-73.987823", "BDFMNQRW"));
		m.add(new Station("228", "23 St", "M", "M", "40.742878", "-73.992821", "FM"));
		m.add(new Station("601", "14 St", "M", "M", "40.738228", "-73.996209", "FML123"));
		m.add(new Station("167", "W 4 St", "M", "M", "40.732338", "-74.000495", "BDFMACE"));
		m.add(new Station("619", "Broadway-Lafayette St", "M", "M", "40.725297", "-73.996204", "BDFM6"));
		m.add(new Station("625", "Essex St", "M", "M", "40.718315", "-73.987437", "JMZF"));
		m.add(new Station("101", "Marcy Av", "Bk", "M", "40.708359", "-73.957757", "JMZ"));
		m.add(new Station("100", "Hewes St", "Bk", "M", "40.70687", "-73.953431", "JM"));
		m.add(new Station("99", "Lorimer St", "Bk", "M", "40.703869", "-73.947408", "JM"));
		m.add(new Station("98", "Flushing Av", "Bk", "M", "40.70026", "-73.941126", "JM"));
		m.add(new Station("97", "Myrtle Av", "Bk", "M", "40.697207", "-73.935657", "JMZ"));
		m.add(new Station("114", "Central Av", "Bk", "M", "40.697857", "-73.927397", "M"));
		m.add(new Station("113", "Knickerbocker Av", "Bk", "M", "40.698664", "-73.919711", "M"));
		m.add(new Station("630", "Myrtle - Wyckoff Avs", "Bk", "M", "40.69943", "-73.912385", "ML"));
		m.add(new Station("111", "Seneca Av", "Q", "M", "40.702762", "-73.90774", "M"));
		m.add(new Station("110", "Forest Av", "Q", "M", "40.704423", "-73.903077", "M"));
		m.add(new Station("109", "Fresh Pond Rd", "Q", "M", "40.706186", "-73.895877", "M"));
		m.add(new Station("108", "Middle Village - Metropolitan Av", "Q", "M", "40.711396", "-73.889601", "M"));

		//the j line:
		//in order thanks to process.py
		j = new SubwayLine();
		j.add(new Station("278", "Jamaica Center - Parsons/Archer", "Q", "J", "40.702147", "-73.801109", "EJZ"));
		j.add(new Station("279", "Sutphin Blvd - Archer Av - JFK Airport", "Q", "J", "40.700486", "-73.807969", "EJZ"));
		j.add(new Station("80", "121 St", "Q", "J", "40.700492", "-73.828294", "JZ"));
		j.add(new Station("81", "111 St", "Q", "J", "40.697418", "-73.836345", "J"));
		j.add(new Station("82", "104 St", "Q", "J", "40.695178", "-73.84433", "JZ"));
		j.add(new Station("83", "Woodhaven Blvd", "Q", "J", "40.693879", "-73.851576", "JZ"));
		j.add(new Station("84", "85 St - Forest Pkwy", "Q", "J", "40.692435", "-73.86001", "J"));
		j.add(new Station("85", "75 St", "Q", "J", "40.691324", "-73.867139", "JZ"));
		j.add(new Station("86", "Cypress Hills", "Bk", "J", "40.689941", "-73.87255", "J"));
		j.add(new Station("87", "Crescent St", "Bk", "J", "40.683194", "-73.873785", "JZ"));
		j.add(new Station("88", "Norwood Av", "Bk", "J", "40.68141", "-73.880039", "JZ"));
		j.add(new Station("89", "Cleveland St", "Bk", "J", "40.679947", "-73.884639", "J"));
		j.add(new Station("90", "Van Siclen Av", "Bk", "J", "40.678024", "-73.891688", "JZ"));
		j.add(new Station("91", "Alabama Av", "Bk", "J", "40.676992", "-73.898654", "JZ"));
		j.add(new Station("621", "Broadway Jct", "Bk", "J", "40.679498", "-73.904512", "JZLAC"));
		j.add(new Station("93", "Chauncey St", "Bk", "J", "40.682893", "-73.910456", "J"));//#Changed
		j.add(new Station("94", "Halsey St", "Bk", "J", "40.68637", "-73.916559", "J"));
		j.add(new Station("95", "Gates Av", "Bk", "J", "40.68963", "-73.92227", "JZ"));
		j.add(new Station("96", "Kosciuszko St", "Bk", "J", "40.693342", "-73.928814", "J"));
		j.add(new Station("97", "Myrtle Av", "Bk", "J", "40.697207", "-73.935657", "JMZ"));
		j.add(new Station("98", "Flushing Av", "Bk", "J", "40.70026", "-73.941126", "JM"));
		j.add(new Station("99", "Lorimer St", "Bk", "J", "40.703869", "-73.947408", "JM"));
		j.add(new Station("100", "Hewes St", "Bk", "J", "40.70687", "-73.953431", "JM"));
		j.add(new Station("101", "Marcy Av", "Bk", "J", "40.708359", "-73.957757", "JMZ"));
		j.add(new Station("625", "Essex St", "M", "J", "40.718315", "-73.987437", "JMZF"));
		j.add(new Station("103", "Bowery", "M", "J", "40.72028", "-73.993915", "JZ"));
		j.add(new Station("623", "Canal St", "M", "J", "40.718092", "-73.999892", "JZRWNQ6"));
		j.add(new Station("622", "Chambers St", "M", "J", "40.713243", "-74.003401", "JZ456"));
		j.add(new Station("628", "Fulton St", "M", "J", "40.710374", "-74.007582", "JZAC2345"));
		j.add(new Station("107", "Broad St", "M", "J", "40.706476", "-74.011056", "JZ"));

		//the z line:
		//now complete
		z = new SubwayLine();
		z.add(new Station("278", "Jamaica Center - Parsons/Archer", "Q", "Z", "40.702147", "-73.801109", "EJZ"));
		z.add(new Station("279", "Sutphin Blvd - Archer Av - JFK Airport", "Q", "Z", "40.700486", "-73.807969", "EJZ"));
		z.add(new Station("80", "121 St", "Q", "Z", "40.700492", "-73.828294", "JZ"));
		z.add(new Station("82", "104 St", "Q", "Z", "40.695178", "-73.84433", "JZ"));
		z.add(new Station("83", "Woodhaven Blvd", "Q", "Z", "40.693879", "-73.851576", "JZ"));
		z.add(new Station("85", "75 St", "Q", "Z", "40.691324", "-73.867139", "JZ"));
		z.add(new Station("87", "Crescent St", "Bk", "Z", "40.683194", "-73.873785", "JZ"));
		z.add(new Station("88", "Norwood Av", "Bk", "Z", "40.68141", "-73.880039", "JZ"));
		z.add(new Station("90", "Van Siclen Av", "Bk", "Z", "40.678024", "-73.891688", "JZ"));
		//alabama av was missing, had to add:
		z.add(new Station("91", "Alabama Av", "Bk", "Z", "40.676992", "-73.898654", "JZ"));
		z.add(new Station("621", "Broadway Jct", "Bk", "Z", "40.679498", "-73.904512", "JZLAC"));
		/*not on the Z according to MTA
		  z.add(new Station("93", "Chauncey St", "Bk", "Z", "40.682893", "-73.910456", "JZ"));*/
		z.add(new Station("95", "Gates Av", "Bk", "Z", "40.68963", "-73.92227", "JZ"));
		z.add(new Station("97", "Myrtle Av", "Bk", "Z", "40.697207", "-73.935657", "JMZ"));
		z.add(new Station("101", "Marcy Av", "Bk", "Z", "40.708359", "-73.957757", "JMZ"));
		z.add(new Station("625", "Essex St", "M", "Z", "40.718315", "-73.987437", "JMZF"));
		z.add(new Station("103", "Bowery", "M", "Z", "40.72028", "-73.993915", "JZ"));
		z.add(new Station("623", "Canal St", "M", "Z", "40.718092", "-73.999892", "JZRWNQ6"));
		z.add(new Station("622", "Chambers St", "M", "Z", "40.713243", "-74.003401", "JZ456"));
		z.add(new Station("628", "Fulton St", "M", "Z", "40.710374", "-74.007582", "JZAC2345"));
		z.add(new Station("107", "Broad St", "M", "Z", "40.706476", "-74.011056", "JZ"));

		//the n line:
		//Reflects full-time stops from July 31, 2017
		n = new SubwayLine();
		n.add(new Station("1", "Astoria - Ditmars Blvd", "Q", "N", "40.775036", "-73.912034", "NW"));
		n.add(new Station("2", "Astoria Blvd", "Q", "N", "40.770258", "-73.917843", "NW"));
		//station closed n.add(new Station("3", "30 Av", "Q", "N", "40.766779", "-73.921479", "NW"));
		n.add(new Station("4", "Broadway", "Q", "N", "40.76182", "-73.925508", "NW"));
		//station closed n.add(new Station("5", "36 Av", "Q", "N", "40.756804", "-73.929575", "NW"));
		n.add(new Station("6", "39 Av", "Q", "N", "40.752882", "-73.932755", "NW"));
		n.add(new Station("461", "Queensboro Plaza", "Q", "N", "40.750582", "-73.940202", "NW7"));
		n.add(new Station("613", "Lexington Av/59 St", "M", "N", "40.76266", "-73.967258", "NWR456"));
		n.add(new Station("8", "5 Av/59 St", "M", "N", "40.764811", "-73.973347", "NWR"));
		n.add(new Station("9", "57 St - 7 Av", "M", "N", "40.764664", "-73.980658", "NQRW"));
		n.add(new Station("10", "49 St", "M", "N", "40.759901", "-73.984139", "NRW"));
		n.add(new Station("611", "Times Sq - 42 St", "M", "N", "40.754672", "-73.986754", "NQRWACE1237S"));
		n.add(new Station("607", "34 St - Herald Sq", "M", "N", "40.749567", "-73.98795", "NQRWBDFM"));
		n.add(new Station("602", "14 St - Union Sq", "M", "N", "40.735736", "-73.990568", "NQRWL456"));
		n.add(new Station("623", "Canal St", "M", "N", "40.718383", "-74.00046", "NQRWJZ6"));
		n.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "N", "40.683666", "-73.97881", "DNRBQ2345"));
		n.add(new Station("32", "36 St", "Bk", "N", "40.655144", "-74.003549", "DNR"));
		n.add(new Station("35", "59 St", "Bk", "N", "40.641362", "-74.017881", "NR"));
		n.add(new Station("71", "8 Av", "Bk", "N", "40.635064", "-74.011719", "N"));
		n.add(new Station("72", "Fort Hamilton Pkwy", "Bk", "N", "40.631386", "-74.005351", "N"));
		n.add(new Station("615", "New Utrecht Av", "Bk", "N", "40.624842", "-73.996353", "ND"));
		n.add(new Station("74", "18 Av", "Bk", "N", "40.620671", "-73.990414", "N"));
		n.add(new Station("75", "20 Av", "Bk", "N", "40.61741", "-73.985026", "N"));
		n.add(new Station("76", "Bay Pkwy", "Bk", "N", "40.611815", "-73.981848", "N"));
		n.add(new Station("77", "Kings Hwy", "Bk", "N", "40.603923", "-73.980353", "N"));
		n.add(new Station("78", "Avenue U", "Bk", "N", "40.597473", "-73.979137", "N"));
		n.add(new Station("79", "86 St", "Bk", "N", "40.592721", "-73.97823", "N"));
		n.add(new Station("58", "Coney Island - Stillwell Av", "Bk", "N", "40.577422", "-73.981233", "DFNQ"));

		//the q line:
		//Reflects full-time stops from July 31, 2017
		q = new SubwayLine();
		q.add(new Station("475", "96 St", "M", "Q", "40.784318", "-73.947152", "Q"));
		q.add(new Station("476", "86 St", "M", "Q", "40.777891", "-73.951787", "Q"));
		q.add(new Station("477", "72 St", "M", "Q", "40.768799", "-73.958424", "Q"));
		q.add(new Station("223", "Lexington Av/63 St", "M", "Q", "40.764629", "-73.966113", "FQ"));
		q.add(new Station("9", "57 St - 7 Av", "M", "Q", "40.764664", "-73.980658", "NQRW"));
		q.add(new Station("611", "Times Sq - 42 St", "M", "Q", "40.754672", "-73.986754", "NQRWACE1237S"));
		q.add(new Station("607", "34 St - Herald Sq", "M", "Q", "40.749567", "-73.98795", "NQRWBDFM"));
		q.add(new Station("602", "14 St - Union Sq", "M", "Q", "40.735736", "-73.990568", "NQRWL456"));
		q.add(new Station("623", "Canal St", "M", "Q", "40.718383", "-74.00046", "NQRWJZ6"));
		q.add(new Station("26", "DeKalb Av", "Bk", "Q", "40.690635", "-73.981824", "BQR"));
		q.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "Q", "40.68446", "-73.97689", "BQDNR2345"));
		q.add(new Station("41", "7 Av", "Bk", "Q", "40.67705", "-73.972367", "BQ"));
		q.add(new Station("42", "Prospect Park", "Bk", "Q", "40.661614", "-73.962246", "BQ"));
		q.add(new Station("43", "Parkside Av", "Bk", "Q", "40.655292", "-73.961495", "Q")); //#Changed
		q.add(new Station("44", "Church Av", "Bk", "Q", "40.650527", "-73.962982", "BQ"));
		q.add(new Station("45", "Beverley Rd", "Bk", "Q", "40.644031", "-73.964492", "Q")); //#Changed - B train not a transfer.
		q.add(new Station("46", "Cortelyou Rd", "Bk", "Q", "40.640927", "-73.963891", "Q")); //#Changed
		q.add(new Station("47", "Newkirk Plaza", "Bk", "Q", "40.635082", "-73.962793", "BQ"));
		q.add(new Station("48", "Avenue H", "Bk", "Q", "40.62927", "-73.961639", "Q"));//#Changed
		q.add(new Station("49", "Avenue J", "Bk", "Q", "40.625039", "-73.960803", "Q"));//#Changed
		q.add(new Station("50", "Avenue M", "Bk", "Q", "40.617618", "-73.959399", "Q"));//#Changed
		q.add(new Station("51", "Kings Hwy", "Bk", "Q", "40.60867", "-73.957734", "BQ"));
		q.add(new Station("52", "Avenue U", "Bk", "Q", "40.5993", "-73.955929", "Q")); //#Changed
		q.add(new Station("53", "Neck Rd", "Bk", "Q", "40.595246", "-73.955161", "Q")); //#Changed
		q.add(new Station("54", "Sheepshead Bay", "Bk", "Q", "40.586896", "-73.954155", "BQ"));
		q.add(new Station("55", "Brighton Beach", "Bk", "Q", "40.577621", "-73.961376", "BQ"));
		q.add(new Station("56", "Ocean Pkwy", "Bk", "Q", "40.576312", "-73.968501", "Q"));
		q.add(new Station("57", "W 8 St - NY Aquarium", "Bk", "Q", "40.576127", "-73.975939", "FQ"));
		q.add(new Station("58", "Coney Island - Stillwell Av", "Bk", "Q", "40.577422", "-73.981233", "DFNQ"));

		//the r line:
		r = new SubwayLine();
		//r.add(new Station("Complex ID", "Stop Name", "Borough", "R", "GTFS Latitude", "GTFS Longitude", "Transfer Options"));
		r.add(new Station("261", "Forest Hills - 71 Av", "Q", "R", "40.721691", "-73.844521", "EFMR"));
		r.add(new Station("262", "67 Av", "Q", "R", "40.726523", "-73.852719", "MR"));
		r.add(new Station("263", "63 Dr - Rego Park", "Q", "R", "40.729846", "-73.861604", "MR"));
		r.add(new Station("264", "Woodhaven Blvd", "Q", "R", "40.733106", "-73.869229", "MR"));
		r.add(new Station("265", "Grand Av - Newtown", "Q", "R", "40.737015", "-73.877223", "MR"));
		r.add(new Station("266", "Elmhurst Av", "Q", "R", "40.742454", "-73.882017", "MR"));
		r.add(new Station("616", "Jackson Hts - Roosevelt Av", "Q", "R", "40.746644", "-73.891338", "EFMR7"));
		r.add(new Station("268", "65 St", "Q", "R", "40.749669", "-73.898453", "MR"));
		r.add(new Station("269", "Northern Blvd", "Q", "R", "40.752885", "-73.906006", "MR"));
		r.add(new Station("270", "46 St", "Q", "R", "40.756312", "-73.913333", "MR"));
		r.add(new Station("271", "Steinway St", "Q", "R", "40.756879", "-73.92074", "MR"));
		r.add(new Station("272", "36 St", "Q", "R", "40.752039", "-73.928781", "MR"));
		r.add(new Station("273", "Queens Plaza", "Q", "R", "40.748973", "-73.937243", "EMR"));
		r.add(new Station("613", "Lexington Av/59 St", "M", "R", "40.76266", "-73.967258", "NWR456"));
		r.add(new Station("8", "5 Av/59 St", "M", "R", "40.764811", "-73.973347", "NWR"));
		r.add(new Station("9", "57 St - 7 Av", "M", "R", "40.764664", "-73.980658", "NQRW"));
		r.add(new Station("10", "49 St", "M", "R", "40.759901", "-73.984139", "NRW"));
		r.add(new Station("611", "Times Sq - 42 St", "M", "R", "40.754672", "-73.986754", "NQRWACE1237S"));
		r.add(new Station("607", "34 St - Herald Sq", "M", "R", "40.749567", "-73.98795", "NQRWBDFM"));
		r.add(new Station("13", "28 St", "M", "R", "40.745494", "-73.988691", "RW"));
		r.add(new Station("14", "23 St", "M", "R", "40.741303", "-73.989344", "RW"));
		r.add(new Station("602", "14 St - Union Sq", "M", "R", "40.735736", "-73.990568", "NQRWL456"));
		r.add(new Station("16", "8 St - NYU", "M", "R", "40.730328", "-73.992629", "RW"));
		r.add(new Station("17", "Prince St", "M", "R", "40.724329", "-73.997702", "RW"));
		r.add(new Station("623", "Canal St", "M", "R", "40.719527", "-74.001775", "RWNQJZ6"));
		r.add(new Station("20", "City Hall", "M", "R", "40.713282", "-74.006978", "RW"));
		r.add(new Station("21", "Cortlandt St", "M", "R", "40.710668", "-74.011029", "RW"));
		r.add(new Station("22", "Rector St", "M", "R", "40.70722", "-74.013342", "RW"));
		r.add(new Station("635", "Whitehall St", "M", "R", "40.703087", "-74.012994", "RW1"));
		r.add(new Station("620", "Court St", "Bk", "R", "40.6941", "-73.991777", "R2345"));
		r.add(new Station("636", "Jay St - MetroTech", "Bk", "R", "40.69218", "-73.985942", "RACF"));
		r.add(new Station("26", "DeKalb Av", "Bk", "R", "40.690635", "-73.981824", "BQR"));
		r.add(new Station("617", "Atlantic Av - Barclays Ctr", "Bk", "R", "40.683666", "-73.97881", "DNRBQ2345"));
		r.add(new Station("28", "Union St", "Bk", "R", "40.677316", "-73.98311", "R"));
		r.add(new Station("608", "9 St", "Bk", "R", "40.670847", "-73.988302", "RFG"));
		r.add(new Station("30", "Prospect Av", "Bk", "R", "40.665414", "-73.992872", "R"));
		r.add(new Station("31", "25 St", "Bk", "R", "40.660397", "-73.998091", "R"));
		r.add(new Station("32", "36 St", "Bk", "R", "40.655144", "-74.003549", "DNR"));
		r.add(new Station("33", "45 St", "Bk", "R", "40.648939", "-74.010006", "R"));
		r.add(new Station("34", "53 St", "Bk", "R", "40.645069", "-74.014034", "R"));
		r.add(new Station("35", "59 St", "Bk", "R", "40.641362", "-74.017881", "NR"));
		r.add(new Station("36", "Bay Ridge Av", "Bk", "R", "40.634967", "-74.023377", "R"));
		r.add(new Station("37", "77 St", "Bk", "R", "40.629742", "-74.02551", "R"));
		r.add(new Station("38", "86 St", "Bk", "R", "40.622687", "-74.028398", "R"));
		r.add(new Station("39", "Bay Ridge - 95 St", "Bk", "R", "40.616622", "-74.030876", "R"));
		/* No, the R train does not go into Staten Island...
		r.add(new Station("501", "St George", "SI", "R", "40.643748", "-74.073643", "SIR"));
		r.add(new Station("502", "Tompkinsville", "SI", "R", "40.636949", "-74.074835", "SIR"));
		r.add(new Station("503", "Stapleton", "SI", "R", "40.627915", "-74.075162", "SIR"));
		r.add(new Station("504", "Clifton", "SI", "R", "40.621319", "-74.071402", "SIR"));
		r.add(new Station("505", "Grasmere", "SI", "R", "40.603117", "-74.084087", "SIR"));
		r.add(new Station("506", "Old Town", "SI", "R", "40.596612", "-74.087368", "SIR"));
		r.add(new Station("507", "Dongan Hills", "SI", "R", "40.588849", "-74.09609", "SIR"));
		r.add(new Station("508", "Jefferson Av", "SI", "R", "40.583591", "-74.103338", "SIR"));
		r.add(new Station("509", "Grant City", "SI", "R", "40.578965", "-74.109704", "SIR"));
		r.add(new Station("510", "New Dorp", "SI", "R", "40.57348", "-74.11721", "SIR"));
		r.add(new Station("511", "Oakwood Heights", "SI", "R", "40.56511", "-74.12632", "SIR"));
		r.add(new Station("512", "Bay Terrace", "SI", "R", "40.5564", "-74.136907", "SIR"));
		r.add(new Station("513", "Great Kills", "SI", "R", "40.551231", "-74.151399", "SIR"));
		r.add(new Station("514", "Eltingville", "SI", "R", "40.544601", "-74.16457", "SIR"));
		r.add(new Station("515", "Annadale", "SI", "R", "40.54046", "-74.178217", "SIR"));
		r.add(new Station("516", "Huguenot", "SI", "R", "40.533674", "-74.191794", "SIR"));
		r.add(new Station("517", "Prince's Bay", "SI", "R", "40.525507", "-74.200064", "SIR"));
		r.add(new Station("518", "Pleasant Plains", "SI", "R", "40.52241", "-74.217847", "SIR"));
		r.add(new Station("519", "Richmond Valley", "SI", "R", "40.519631", "-74.229141", "SIR"));
		r.add(new Station("522", "Tottenville", "SI", "R", "40.512764", "-74.251961", "SIR"));
		r.add(new Station("523", "Arthur Kill", "SI", "R", "40.516578", "-74.242096", "SIR"));
		*/

		//the w line:
		//in order thanks to process.py, but some stations are now closed
		w = new SubwayLine();
		w.add(new Station("1", "Astoria - Ditmars Blvd", "Q", "W", "40.775036", "-73.912034", "NW"));
		w.add(new Station("2", "Astoria Blvd", "Q", "W", "40.770258", "-73.917843", "NW"));
		//station closed w.add(new Station("3", "30 Av", "Q", "W", "40.766779", "-73.921479", "NW"));
		w.add(new Station("4", "Broadway", "Q", "W", "40.76182", "-73.925508", "NW"));
		//station closed w.add(new Station("5", "36 Av", "Q", "W", "40.756804", "-73.929575", "NW"));
		w.add(new Station("6", "39 Av", "Q", "W", "40.752882", "-73.932755", "NW"));
		w.add(new Station("461", "Queensboro Plaza", "Q", "W", "40.750582", "-73.940202", "NW7"));
		w.add(new Station("613", "Lexington Av/59 St", "M", "W", "40.76266", "-73.967258", "NWR456"));
		w.add(new Station("8", "5 Av/59 St", "M", "W", "40.764811", "-73.973347", "NWR"));
		w.add(new Station("9", "57 St - 7 Av", "M", "W", "40.764664", "-73.980658", "NQRW"));
		w.add(new Station("10", "49 St", "M", "W", "40.759901", "-73.984139", "NRW"));
		w.add(new Station("611", "Times Sq - 42 St", "M", "W", "40.754672", "-73.986754", "NQRWACE1237S"));
		w.add(new Station("607", "34 St - Herald Sq", "M", "W", "40.749567", "-73.98795", "NQRWBDFM"));
		w.add(new Station("13", "28 St", "M", "W", "40.745494", "-73.988691", "RW"));
		w.add(new Station("14", "23 St", "M", "W", "40.741303", "-73.989344", "RW"));
		w.add(new Station("602", "14 St - Union Sq", "M", "W", "40.735736", "-73.990568", "NQRWL456"));
		w.add(new Station("16", "8 St - NYU", "M", "W", "40.730328", "-73.992629", "RW"));
		w.add(new Station("17", "Prince St", "M", "W", "40.724329", "-73.997702", "RW"));
		w.add(new Station("623", "Canal St", "M", "W", "40.719527", "-74.001775", "RWNQJZ6"));
		w.add(new Station("20", "City Hall", "M", "W", "40.713282", "-74.006978", "RW"));
		w.add(new Station("21", "Cortlandt St", "M", "W", "40.710668", "-74.011029", "RW"));
		w.add(new Station("22", "Rector St", "M", "W", "40.70722", "-74.013342", "RW"));
		w.add(new Station("635", "Whitehall St", "M", "W", "40.703087", "-74.012994", "RW1"));

		//the l line:
		//in order thanks to process.py
		l = new SubwayLine();
		l.add(new Station("618", "8 Av", "M", "L", "40.739777", "-74.002578", "LACE"));
		l.add(new Station("601", "6 Av", "M", "L", "40.737335", "-73.996786", "LFM123"));
		l.add(new Station("602", "Union Sq - 14 St", "M", "L", "40.734789", "-73.99073", "LNQRW456"));
		l.add(new Station("118", "3 Av", "M", "L", "40.732849", "-73.986122", "L"));
		l.add(new Station("119", "1 Av", "M", "L", "40.730953", "-73.981628", "L"));
		l.add(new Station("120", "Bedford Av", "Bk", "L", "40.717304", "-73.956872", "L"));
		l.add(new Station("629", "Lorimer St", "Bk", "L", "40.714063", "-73.950275", "LG"));
		l.add(new Station("122", "Graham Av", "Bk", "L", "40.714565", "-73.944053", "L"));
		l.add(new Station("123", "Grand St", "Bk", "L", "40.711926", "-73.94067", "L"));
		l.add(new Station("124", "Montrose Av", "Bk", "L", "40.707739", "-73.93985", "L"));
		l.add(new Station("125", "Morgan Av", "Bk", "L", "40.706152", "-73.933147", "L"));
		l.add(new Station("126", "Jefferson St", "Bk", "L", "40.706607", "-73.922913", "L"));
		l.add(new Station("127", "DeKalb Av", "Bk", "L", "40.703811", "-73.918425", "L"));
		l.add(new Station("630", "Myrtle - Wyckoff Avs", "Bk", "L", "40.699814", "-73.911586", "LM"));
		l.add(new Station("129", "Halsey St", "Q", "L", "40.695602", "-73.904084", "L"));
		l.add(new Station("130", "Wilson Av", "Bk", "L", "40.688764", "-73.904046", "L"));
		l.add(new Station("131", "Bushwick Av - Aberdeen St", "Bk", "L", "40.682829", "-73.905249", "L"));
		l.add(new Station("621", "Broadway Jct", "Bk", "L", "40.678856", "-73.90324", "LJZAC"));
		l.add(new Station("133", "Atlantic Av", "Bk", "L", "40.675345", "-73.903097", "L"));
		l.add(new Station("134", "Sutter Av", "Bk", "L", "40.669367", "-73.901975", "L"));
		l.add(new Station("135", "Livonia Av", "Bk", "L", "40.664038", "-73.900571", "L"));
		l.add(new Station("136", "New Lots Av", "Bk", "L", "40.658733", "-73.899232", "L"));
		l.add(new Station("137", "E 105 St", "Bk", "L", "40.650573", "-73.899485", "L"));
		l.add(new Station("138", "Canarsie - Rockaway Pkwy", "Bk", "L", "40.646654", "-73.90185", "L"));

		//the g line:
		//had to add Church Av connection at the end
		g = new SubwayLine();
		g.add(new Station("606", "Court Sq", "Q", "G", "40.746554", "-73.943832", "GEM7"));
		g.add(new Station("282", "21 St", "Q", "G", "40.744065", "-73.949724", "G"));
		g.add(new Station("283", "Greenpoint Av", "Bk", "G", "40.731352", "-73.954449", "G"));
		g.add(new Station("284", "Nassau Av", "Bk", "G", "40.724635", "-73.951277", "G"));
		g.add(new Station("629", "Metropolitan Av", "Bk", "G", "40.712792", "-73.951418", "GL"));
		g.add(new Station("286", "Broadway", "Bk", "G", "40.706092", "-73.950308", "G"));
		g.add(new Station("287", "Flushing Av", "Bk", "G", "40.700377", "-73.950234", "G"));
		g.add(new Station("288", "Myrtle - Willoughby Avs", "Bk", "G", "40.694568", "-73.949046", "G"));
		g.add(new Station("289", "Bedford - Nostrand Avs", "Bk", "G", "40.689627", "-73.953522", "G"));
		g.add(new Station("290", "Classon Av", "Bk", "G", "40.688873", "-73.96007", "G"));
		g.add(new Station("291", "Clinton - Washington Avs", "Bk", "G", "40.688089", "-73.966839", "G"));
		g.add(new Station("292", "Fulton St", "Bk", "G", "40.687119", "-73.975375", "G"));
		g.add(new Station("175", "Hoyt - Schermerhorn Sts", "Bk", "G", "40.688484", "-73.985001", "ACG"));
		g.add(new Station("236", "Bergen St", "Bk", "G", "40.686145", "-73.990862", "FG"));
		g.add(new Station("237", "Carroll St", "Bk", "G", "40.680303", "-73.995048", "FG"));
		g.add(new Station("238", "Smith - 9 Sts", "Bk", "G", "40.67358", "-73.995959", "FG"));
		g.add(new Station("608", "4 Av", "Bk", "G", "40.670272", "-73.989779", "FGR"));
		g.add(new Station("240", "7 Av", "Bk", "G", "40.666271", "-73.980305", "FG"));
		g.add(new Station("241", "15 St - Prospect Park", "Bk", "G", "40.660365", "-73.979493", "FG"));
		g.add(new Station("242", "Fort Hamilton Pkwy", "Bk", "G", "40.650782", "-73.975776", "FG"));
		g.add(new Station("243", "Church Av", "Bk", "G", "40.644041", "-73.979678", "FG"));


		//now that all of the SubwayLines have been created…
		createPointers();
		//path = new LinkedList<Station>();
		queue = new ALHeap();
    }

    //iterates through all of the SubwayLines, and creates pointers for every Station in every SubwayLine
    public void createPointers(){
	SubwayLine[] container = {one, two, three, four, five, six, seven, a, c, e, b, d, f, m, n, q, r, w, j, z, l, g};
	for (SubwayLine x: container){
	    createPointersLine(x);
	}
    }

    //creates an array  of pointers to all of the Stations available from one Station 
    //sets this array as an instance variable for every Station
    public void createPointersLine(SubwayLine name){
	Station[][] array;	
	Station x = name.get(0);
	while (x != null){
	    //System.out.println("Current station " +x);
	    String transfers = x.getTransfers();
	    //System.out.println("Available transfers: " + transfers);
	    int rowNum = 0;
	    array = new Station[transfers.length()][2];	    
	    //for every transfer:
	    for (int ctr = 0; ctr < transfers.length(); ctr++){
		//identify line
		String line = x.getTransfers().substring(ctr, ctr + 1);
		//System.out.println(line);
		//search for line
		SubwayLine connection = search(line);
		//System.out.println(connection);
		if (connection != null){
		    //System.out.println(connection.search(x.getID()));		    
		    if (connection.search(x.getID()) != null){
			Station eq = connection.search(x.getID());
			if (eq.getBefore() != null)
			    array[rowNum][0] = eq.getBefore();
			if (eq.getNext() != null)
			    array[rowNum][1] = eq.getNext();
			rowNum += 1;
		    }
		}
	    }
	    x.setTransfPointers(array);
	    x = x.getNext();
	}
    }
		
    
    /**********************
     SubwayLine search(String):
     returns the SubwayLine object that corresponds to the String name.
     Meme link: https://goo.gl/images/V2wUNY
    ***********************/
    public SubwayLine search(String line){
	if (line.equals("1")){
        return one;
      }
      if (line.equals("2")){
        return two;
      }
      if (line.equals("3")){
        return three;
      }
      if (line.equals("4")){
        return four;
      }
      if (line.equals("5")){
        return five;
      }
      if (line.equals("6")){
        return six;
      }
      if (line.equals("7")){
        return seven;
      }
      if (line.equals("A")){
        return a;
      }
      if (line.equals("B")){
        return b;
      }
      if (line.equals("C")){
        return c;
      }
      if (line.equals("D")){
        return d;
      }
      if (line.equals("E")){
        return e;
      }
      if (line.equals("F")){
        return f;
      }
      if (line.equals("G")){
        return g;
      }
      if (line.equals("M")){
        return m;
      }
      if (line.equals("N")){
        return n;
      }
      if (line.equals("Q")){
        return q;
      }
      if (line.equals("R")){
        return r;
      }
      if (line.equals("W")){
        return w;
      }
      if (line.equals("J")){
        return j;
      }
      if (line.equals("Z")){
        return z;
      }
      if (line.equals("L")){
        return l;
      }
      else {
	  return null;
      }
    }
    
    //initializes distance. All other stations have initialized distance at infinityx
    public void initDist(Station source){
	source.setDist(0);	
    }
    
    //Dijkstra's algo takes in source station and destination station
    //Current implementation does not use destination station
    //Later can be optimized to use destination station
    //The algorithm maintains a priority queue (implemented as binary heap).
    //At each round, it extracts the station with the best distance.
    //It then 'relaxes' the outgoing edges of that station.
    //The complexity is O(n log m), with n the no of stations and m number of edges when using binary heaps.
    public void SSShortDist(Station source, Station dest){
	initDist(source);
	SubwayLine[] all = {one, two, three, four, five, six, seven, a, c, e, b, d, f, m, n, q, r, w, j, z, l, g};
	Station head;
	int ctr = 0;
	for (SubwayLine x: all){
	    head = x.get(0);
	    while (head != null){
		queue.add(head);
		head = head.getNext();
	    }	    
	}
	while ( !queue.isEmpty() ){
	    Station u = queue.removeMin();
	    Station[][] transfers = u.getTransArr();
	    for (Station[] i: transfers){
		if (i[0] != null){
		    relax(u, i[0]);
		}
		if (i[1] != null){
		    relax(u, i[1]);
		}
	    }
	    
	}
	
    }

    //Relaxation: checks if shorter path found.
    //If yes, updates tentative shortest distance Dist(v) and antecedent station.
    public Station relax(Station u, Station v){
	// here edge weight is 1.
	// instead edge weight based on Euclidean distance of the stations can be used.
	// this feature can be straightforwardly added.
	// one can also straightforwardly incorporate a transfer cost by checking getLine of u and v
	float w = 1;
	if (v.getDist() > u.getDist() + w){
	    v.setDist(u.getDist() + w);	    	    
	    v.setAnte(u);
	    // heapify needed since tentative distance has been updated.
	    queue.minheapify(0);
	}
	return v;
    }

    // Prints path by using antecedent station of each station, set by relax.
    // Starting from destination station.
    // Path is therefore written in reverse.
    public String printPath(Station source, Station dest){
	String retStr = "";
	Station s = dest;
	while (s != null && s.getID() != source.getID()){
	    retStr = s + "\n" + retStr;
	    s = s.getAnte();
	}
	retStr = source + retStr;
	retStr += "Num stops: " + dest.getDist();
	return retStr;
    }
    
    
}
