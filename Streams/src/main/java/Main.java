import java.io.*;
/* 1. Написать программу, в котором будут создаваться/перезаписываться два файла. Записать в первый файл некоторый текст,
* считать этот текст, перевернуть и записать результат во второй файл.
* 2. Добавить с консоли текст к первоначальному тексту
* 3. Разбить на три части и вставить дополнительную строку в середину*/


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputOne = bufferedReader.readLine();
        String inputTwo = bufferedReader.readLine();
        StringBuilder someString = new StringBuilder("Epam");
        File fileOne = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\Creation.txt");
        File fileTwo = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\Written.txt");

        try{
            boolean createdOne = fileOne.createNewFile();
            boolean createdTwo = fileTwo.createNewFile();
            if ( createdOne ){
                System.out.println("FileOne has been created");
            }
            if ( createdTwo ){
                System.out.println("FileTwo has been created");
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try ( FileWriter writerOne = new FileWriter(fileOne) ){
            writerOne.write(someString.toString());
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try ( FileReader readerOne = new FileReader(fileOne);
            FileWriter writerTwo = new FileWriter(fileTwo) ){
            BufferedReader reader = new BufferedReader(readerOne);
            String readString = reader.readLine();
            StringBuilder convertedString = new StringBuilder();

            while ( readString != null ){
                convertedString.append(readString).append(" ");
                readString = reader.readLine();
            }

            int i = convertedString.length();

            convertedString = convertedString.append(inputOne);

            convertedString = convertedString.insert(i, inputTwo + " ");

            convertedString = convertedString.reverse();
            System.out.println(convertedString.toString());
            writerTwo.write(convertedString.toString());
            
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
