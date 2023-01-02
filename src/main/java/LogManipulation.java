import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogManipulation {
	
	class Profile {
		public int userId;
		public String useremail;
        public int readOperations;
        public int writeOperations;
        public boolean searchedExpensiv;
        
        
        
		public Profile(int userId, String useremail) {
			super();
			this.userId = userId;
			this.useremail = useremail;
			this.readOperations=0;
			this.writeOperations=0;
			this.searchedExpensiv=false;
			
		}



		@Override
		public boolean equals(Object obj) {
			
			// TODO Auto-generated method stub
			  if (!(obj instanceof Profile)) {
		            return false;
		        }
			return (userId==((Profile)obj).userId);
		}
        
        }
		
	
	public void updateProfile() {
		Set<Profile> userProfiles = new HashSet<Profile>();
		Set<Profile> readProfiles = new HashSet<Profile>();
		Set<Profile> writeProfiles = new HashSet<Profile>();
		Set<Profile> expensiveProfiles = new HashSet<Profile>();
		try{
			   FileInputStream fstream = new FileInputStream("../tp5_logging/logs/logfile.log");
			   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			   String strLine;
			   
			   /* read log line by line */
			   while ((strLine = br.readLine()) != null)   {
			     /* parse strLine to obtain what you want */
			     String[]output=strLine.split("/");
		    	 String[]output2=strLine.split("\\*");
		    	 Profile p = new Profile(Integer.parseInt(output[1]),output2[1]);
		    	 
			     if(strLine.contains("did a reading operation")) {
			    	 if(!userProfiles.contains(p)) {
			    		 p.readOperations++;
			    		 userProfiles.add(p);
			    	 }else {
			    		 for(Profile prof:userProfiles) {
			    			 if(p.equals(prof)) {
			    				 prof.readOperations++;
			    			 }
			    		 }
			    	 }
			     }else {
			    	 if(strLine.contains("did a writing operation")) {
			    		 if(!userProfiles.contains(p)) {
				    		 p.writeOperations++;
				    		 userProfiles.add(p);
				    	 }else {
				    		 for(Profile prof:userProfiles) {
				    			 if(p.equals(prof)) {
				    				 prof.writeOperations++;
				    			 }
				    		 }
				    	 }
			    		 
			    	 }else {
			    		 if(strLine.contains("searched expensive product")) {
			    			 if(!userProfiles.contains(p)) {
					    		 p.searchedExpensiv=true;
					    		 userProfiles.add(p);
					    	 }else {
					    		 for(Profile prof:userProfiles) {
					    			 if(p.equals(prof)) {
					    				 prof.searchedExpensiv=true;
					    			 }
					    		 }
					    	 }
			    		 }
			    	 }
			     }
			   }
			   fstream.close();
			} catch (Exception e) {
			     System.err.println("Error: " + e.getMessage());
			}
		
		String pathRead = "../tp5_logging/logs/readProfile.json";
		String pathWrite = "../tp5_logging/logs/writeProfile.json";
		String pathExpensive = "../tp5_logging/logs/expensiveProfile.json";
		File readFile=new File(pathRead);
		File writeFile=new File(pathWrite);
		File expensiveFile= new File(pathExpensive);
		ObjectMapper mapper = new ObjectMapper();
		
		for(Profile prof:userProfiles) {
			if(prof.readOperations>=prof.writeOperations) {
				readProfiles.add(prof);
			}else {
				writeProfiles.add(prof);
			}
			if(prof.searchedExpensiv) {
				expensiveProfiles.add(prof);
			}
		}
		
		try { 
            mapper.writeValue(readFile,readProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

try { 
            mapper.writeValue(writeFile, writeProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }


try { 
            mapper.writeValue(expensiveFile, expensiveProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}
