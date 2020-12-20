package FileTraverse;

import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Main {
    
    public static void main(String[] args) {
        // String[] searchingDirs = {
        //     "D:\\intermediate",
        //     "D:\\movies",
        //     "E:\\Theatre\\wifes",
        //     "F:\\Downloads",
        //     "G:\\迅雷下载",
        //     "G:\\MoviesFromDrive"
        // };
        // String[] searchQueries = {"135", "133"};
        
        String[] searchingDirs = {
            "E:\\Theatre\\wifes"
        };
        String[] searchQueries = {"as"};
        
        FileWorker fileWer = new FileWorker();
        fileWer.writeFoundFileInfo(searchingDirs, searchQueries, "./all.txt");
        

    }
    
    
}

class FileInfo {
    private String name;
    private String path;
    private long size;

    FileInfo(File file){
        name = file.getName();
        path = file.getPath();
        size = file.length();
    }

    FileInfo(String n, String p){
        name = n;
        path = p;
    }

    FileInfo(String n, String p, long s){
        name = n;
        path = p;
        size = s;
    }
    public String getFileName(){
        return name;
    }

    public String getFilePath(){
        return path;
    }

    public double getSizeInGigabytes(){
        // return size;
        double raw = (double) size / 1024 / 1024 / 1024;
        return Double.parseDouble(String.format("%.2f", raw));
        // double c=Double.parseDouble(String.format("%.2f", a));
    }

    public String concreteInfo(){
        return getFileName() + " SIZE: " + getSizeInGigabytes() + "G" + "\n" + getFilePath() + "\n\n";
    }
}

class FileExplorer {

    public ArrayList<File> getAllFiles(String[] dirs){
        ArrayList<File> allFiles = new ArrayList<File>();
        
        for(String dir : dirs){
            File file = new File(dir);
            exploreAndAddFiles(file, allFiles);
        }

        return allFiles;
    }
    public ArrayList<FileInfo> getMatchedFileInfo(ArrayList<File> readFrom, String[] searchQuery){
        ArrayList<FileInfo> ans = new ArrayList<FileInfo>();

        for(int i = 0; i<readFrom.size(); i++){
            File f = readFrom.get(i);
            String name = f.getName().toLowerCase();
            
            for(int j = 0; j < searchQuery.length; j++){
                if(getFileNameNoEx(name).contains(searchQuery[j])){
                    ans.add(new FileInfo(f));
                    break;
                }
            }
           
        }

        return ans;
    }
    public void exploreAndAddFiles(File file, ArrayList<File> ans){
        File[] files = file.listFiles();
        if(files == null) return;
        for(File f : files){
            if(f.isDirectory()){
                exploreAndAddFiles(f, ans);
            }
            if(f.isFile()){
                ans.add(f);
            }
        }
    }

    public String getFileNameNoEx(String filename) { 
        if ((filename != null) && (filename.length() > 0)) { 
            int dot = filename.lastIndexOf('.'); 
            if ((dot >-1) && (dot < (filename.length()))) { 
                return filename.substring(0, dot); 
            } 
        } 
        return filename; 
    } 
}

class FileWorker {
    public void writeFoundFileInfo(String[] searchingDirs, String[] searchQueries, String writeToPath){
        try{
            FileExplorer filex = new FileExplorer();
            ArrayList<File> extractedFiles = filex.getAllFiles(searchingDirs);//produce all files given the array of directories that need to be searched
            ArrayList<FileInfo> informations = filex.getMatchedFileInfo(extractedFiles, searchQueries);//produce all files that contain given string in array called searchQueries
            File file = new File(writeToPath);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(),true);
            BufferedWriter myWriter = new BufferedWriter(fileWriter);
            // myWriter.write("Total " + "'" + search + "'" + "found : " + informations.size());
            for(FileInfo info : informations){
                myWriter.write(info.concreteInfo());
            }
            myWriter.close();
            System.out.println("done");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}