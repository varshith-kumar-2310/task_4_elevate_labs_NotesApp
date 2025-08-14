package Task_4;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class NotesApp {

    private static Scanner input = new Scanner(System.in);

    private static void createNewNotes() {

        System.out.println("Enter the note name to create: ");
        String noteName = input.nextLine();

        //create a file object
        File myFile = new File(noteName);
        
        try{
            //to create the file note.txt we need to call createFile()
            if( myFile.createNewFile())
            {
                System.out.println("File created: " + myFile.getName());

                try(FileWriter fw = new FileWriter(myFile)){
                    System.out.println("Enter the content you want to write to the note: ");
                    String content = input.nextLine();
                    fw.write(content + "\n");
                    System.out.println("Content written successfully into the file "+myFile.getName());
                    fw.close();
                }catch(IOException e)
                {
                    System.out.println("Failed to write into the file "+myFile.getName());
                    System.out.println("Make sure that the note with name "+myFile.getName()+" exists.");
                    e.getStackTrace();
                }
            }
            else
            {
                System.out.println("File already exists!!!!.");
            }
        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private static void writeToExistingNote() {

        System.out.println("enter the note name to write to: ");
        String noteName = input.nextLine();
        File file = new File(noteName);

        if(file.exists() == false) {
            System.out.println("The note with name " + file.getName() + " does not exist!!!!");
            return;
        }

        try(FileWriter fw = new FileWriter(noteName, true);){
            System.out.println("Enter the content you want to write to the note: ");
            String content = input.nextLine();
            fw.write(content + "\n");
            System.out.println("Content written successfully into the file "+file.getName());
            fw.close();
        }catch(IOException e)
        {
            System.out.println("Failed to write into the file "+file.getName());
            System.out.println("Make sure that the note with name "+file.getName()+" exists.");
            e.getStackTrace();
        }
    }

    private static void readFromExisitingNote()
    {
        System.out.println("enter the note name to read : ");
        String noteName = input.nextLine();
        File file = new File(noteName);
         
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine())!=null) {
                System.out.println(line);
            }
        }catch(IOException e) {
            System.out.println("Failed to read from the file "+file.getName());
            System.out.println("Make sure that the note with name "+file.getName()+" exists.");
            e.printStackTrace();
        }
    }
    
    private static void deleteNote() {

        System.out.println("enter the note name to delete: ");
        String noteName = input.nextLine();
        File file = new File(noteName);
        if(file.delete()) {
            System.out.println("File deleted successfully: " + file.getName());
        }
        else {
            System.out.println("Failed to delete the file: " + file.getName());
            System.out.println("Make sure that the note with name "+file.getName()+" exists.");
        }
    }

    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("==========================================");
            System.out.println("Welcome to the Notes App!!!");
            System.out.println("================= MENU ===================");
            System.out.println("1. Create a new note");
            System.out.println("2. write to an existing note");
            System.out.println("3. Read a note");
            System.out.println("4. Delete a note");
            System.out.println("5. Exit");
            System.out.println("============================================");
            System.out.print("Please select an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    createNewNotes();
                    break;
                case 2:
                    writeToExistingNote();
                    break;
                case 3:
                    readFromExisitingNote();
                    break;  
                case 4:
                    deleteNote();
                    break;
                case 5:
                    System.exit(0);
                    break;
                    
            }
        }
    }
}

