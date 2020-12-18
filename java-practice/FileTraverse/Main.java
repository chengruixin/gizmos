package FileTraverse;

import java.io.File;
// import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Hashtable;
// import java.util.Hashtable;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Main {
    public static ArrayList<File> fileCollections = new ArrayList<File>();
    public static ArrayList<FileInfo> informations = new ArrayList<FileInfo>();
    public static Hashtable<String, Integer> hashMap = new Hashtable<String, Integer>();  
    public static void main(String[] args) {
        String search = "avsa";
        String[] searchingDirs = {
            "D:\\intermediate",
            "D:\\movies",
            "E:\\Theatre\\wifes",
            "F:\\Downloads",
            "G:\\迅雷下载",
            "G:\\MoviesFromDrive"
        };
        
        for(String entryPoint : searchingDirs){
            File file = new File(entryPoint);
            exploreFiles(file);
            // break;
        }
        
        // String[] suffix = new String[fileCollections.size()];

        for(int i = 0; i<fileCollections.size(); i++){
            String name = fileCollections.get(i).getName().toLowerCase();
            String pathUrl = fileCollections.get(i).getPath();
            if(getFileNameNoEx(name).contains(search)){
                informations.add(new FileInfo(name, pathUrl));
            }
            // if(hashMap.get(name) == null){
            //     hashMap.put(name, 1);
            // }
            // else{
            //     hashMap.put(name, hashMap.get(name) + 1);
            //     System.out.println("Replicated " +  pathUrl + " " + name);
            // }
           
        }

        /**
         * Write info into txt file
         */
        try{
            File file = new File("Output.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            BufferedWriter myWriter = new BufferedWriter(fileWriter);
            myWriter.flush();
            // myWriter.write("Total " + "'" + search + "'" + "found : " + informations.size());
            for(FileInfo info : informations){
                myWriter.write(info.getFileName() + "\n" + info.getFilePath() + "\n\n");
            }
            myWriter.close();
            System.out.println("done");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    
    public static void exploreFiles(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                exploreFiles(f);
            }
            if(f.isFile()){
                fileCollections.add(f);
            }
        }
    }

    public static String getFileNameNoEx(String filename) { 
        if ((filename != null) && (filename.length() > 0)) { 
            int dot = filename.lastIndexOf('.'); 
            if ((dot >-1) && (dot < (filename.length()))) { 
                return filename.substring(0, dot); 
            } 
        } 
        return filename; 
    } 
}

class FileInfo {
    private String fileName;
    private String filePath;

    FileInfo(File file){
        fileName = file.getName();
        filePath = file.getPath();
    }
    FileInfo(String n, String p){
        fileName = n;
        filePath = p;
    }
    public String getFileName(){
        return fileName;
    }

    public String getFilePath(){
        return filePath;
    }
}