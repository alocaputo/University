import java.io.*;

public class YTParser {

	    public static void main(String[] args) {
	    	
	        youtubeSubsExporter("/path/to/subscription_manager","/path/to/output.txt");
	    }
	    
	    /* This method creates a new .txt containing a numbered list of YouTube subscriptions
	     * @param file is the path of your subscription_manager file (you can download it at 
	     * https://www.youtube.com/subscription_manager?action_takeout=1)
	     * @param path is the where the file will be saved
	     */
	    public static String youtubeSubsExporter(String file, String path){
	        try{
	        	FileReader f =new FileReader(file);
		        PrintWriter writer = new PrintWriter(path, "UTF-8");
	            BufferedReader in = new BufferedReader(f);
	            String sourceCode = "";
	            String line;
	            line=in.readLine();
	            line=in.readLine();
	            line=in.readLine();
	            int i=0;
	            while((line=in.readLine())!=null){
	                if(line.contains("title=")){
	                	i++;
	                   int firstPos = line.indexOf("title=");
	                    String temp = line.substring(firstPos);
	                    temp=temp.replace("title=","");
	                    temp=temp.replace("&quot;","'");
	                    temp=temp.replace("&amp;","&");
	                    int lastPos = temp.indexOf("type");
	                    temp = temp.substring(0,lastPos);
	                    writer.format("%3d- %s\n", i,temp);
	                }
	            }
	            in.close();
	            writer.close();
	            return sourceCode;
	        } catch (IOException ioe){
	            System.out.println("Something went wrong reading the file");
	        }
	        return null;
	    }
}