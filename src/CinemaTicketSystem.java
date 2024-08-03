import java.util.ArrayList;

public class CinemaTicketSystem {
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static int movieIdCounter = 0;
    private static ArrayList<User> users = new ArrayList<>();
    private static int userIdCounter = 0;
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    private static int ticketCounter = 0;

    public CinemaTicketSystem() {
    }

    public int addMovie(String movieName) {
        movieIdCounter += 1;
        movies.add(new Movie(movieIdCounter, movieName));
        return movieIdCounter;
    }

    public void showAllMovies() {
        for (Movie m : movies) {
            System.out.println(m.getId() + " - " + m.getName());
        }
    }

    public int addUser(String userName) {
        userIdCounter += 1;
        users.add(new User(userIdCounter, userName));
        return userIdCounter;
    }

    public int buyTicket(int userId, int movieId) {
        boolean bl = false;
        for (Movie m : movies) {
            if (m.getId() == movieId) {
                bl = true;
            }
        }
        if (bl) {
            User user = null;
            ticketCounter += 1;
            for (User u : users) {
                if (u.getId() == userId) {
                    user = u;
                }
            }

            if (user != null) {
                tickets.add(new Ticket(ticketCounter, userId, movieId));
            } else {
                return -1;
            }

        } else {
            return -1;
        }
        return ticketCounter;
    }

    public boolean cancelTicket(int ticketId) {
        boolean bl = false;
        Ticket ticket = null;
        for (Ticket t : tickets) {
            if (t.getId() == ticketId) {
                bl = true;
                ticket = t;
            }
        }
        if (!bl) {
            return false;
        }
        tickets.remove(ticket);
        return true;
    }

    public void showTickets() {
        for (Ticket t : tickets) {
            int userId = t.getUserId();
            int filmId = t.getMovieId();
            String userName = "";
            String movieName = "";
            for (User u : users) {
                if (u.getId() == userId) {
                    userName = u.getUserName();
                }
            }
            for (Movie m : movies) {
                if (m.getId() == filmId) {
                    movieName = m.getName();
                }
            }
            System.out.println(t.getId()+"- Пользаватель :"+userName+", фильм:"+movieName);
        }
    }

    public void showUsers(){
        for (User u : users){
            System.out.println(u.getId()+"-"+u.getUserName());
        }
    }
}
