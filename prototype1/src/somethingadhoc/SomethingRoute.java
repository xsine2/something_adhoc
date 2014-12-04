package somethingadhoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SomethingRoute {
    
    private static SomethingRoute route;
    public static String filename;
    
    private SomethingRoute(){}
    
    // singleton
    public SomethingRoute init(){
        if(route == null){
            SomethingRoute.filename = "/tmp/something_route_"+(((int)(Math.random()*1024)));
            route = new SomethingRoute();
        }
        return route;
    }
    
    public static String getAllRoute(){
        StringBuilder sb = new StringBuilder("");
        try {
            // read route file and get all lines
            Scanner in = new Scanner(new File(SomethingRoute.filename));
            // @TODO: check format of lines in file?
            while(in.hasNextLine()){
                sb.append(in.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error: File not found");
        }
        return sb.toString();
    }
    
    public static String getRoute(String nodeName){
        // read route file and find a line contains nodeNames
        String allRoutes = SomethingRoute.getAllRoute();
        String pattern = ".*"+nodeName+".*";
        Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
	Matcher m = p.matcher(allRoutes);
        
        while (m.find()) {
                return m.group(0); // first match is okay?
	}
        System.err.println("Error: route cannot be found, so reconstruct it");
        return null;
    }
    
    public static void updateNeighbors(){
        // just use the get ad-hoc list from AdhocClient ?
    }
    
    public static boolean checkRoute(String routeRecord){
        return false;
    }
    public static String getNextRelay(String route){
        return null;
    }
    
}
