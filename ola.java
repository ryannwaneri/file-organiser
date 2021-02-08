import java.util.*;
import java.io.File;


public class organiser{
	public static void main(String[] args){
		try{

			Vector <String> extensions=new Vector <String> ();
			organiser sort=new organiser();
			Scanner scan=new Scanner(System.in);
			System.out.print("please enter the file path:");
			String filepath=scan.nextLine();
			File dir=new File(filepath);
			File[] files=dir.listFiles();

			for(File file:files){
				String extension=sort.extractExt(file.toString());

				if(!extensions.contains(extension) && !extension.equals(""))
					extensions.add(extension);
				
				
				
			}
			for(String extension:extensions){
				File extensionDir=new File(filepath+File.separator+extension);
				extensionDir.mkdir();
				
			}

			for(File file:files){
				String extension=sort.extractExt(file.toString());
				if(extension!=""){
					File new_location=new File(filepath+File.separator+extension+File.separator+file.getName());
					file.renameTo(new_location);
				}
			}
			
		}
		
		catch(Exception e){
			System.out.println("your file path was not found");
		}
		
	}
	
	public String extractExt(String fileName){
		
		int index = fileName.lastIndexOf('.');
		
		if(index > 0) {
			String extension = fileName.substring(index + 1);
			return fileName.substring(index + 1);
		}	
		
		else 
			return "";
	}
	
}

