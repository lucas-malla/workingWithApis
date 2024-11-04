import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        FilmConsultation consultation = new FilmConsultation();
        System.out.println("Type the number of the movie");
        try{
            var numbreMovie = Integer.valueOf(read.nextLine());
            Movie movie = consultation.filmsearch(numbreMovie);
            System.out.println(movie);
            FileGenerator generator = new FileGenerator();
            generator.addJson(movie);
        }catch(NumberFormatException e ){
            System.out.println("Number not found" + e.getMessage());
        }catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("End the Movie");
        }
    }
}
