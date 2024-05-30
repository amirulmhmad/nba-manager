import java.util.ArrayList;

public class Team {

    private String teamName;
    private int numPlayers;
    private double totalSalary;
    private ArrayList<Player> team;

    public Team() {
        this.team = new ArrayList<>();
        this.numPlayers = 0;
        this.totalSalary = 0.0;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
        public boolean addPlayer(Player player) {
        if (MaxPlayers() && SalaryCap(player.getSalary())) {
            team.add(player);
            numPlayers++;
            totalSalary += player.getSalary();
            return true;
        } else if (!MaxPlayers()) {
            System.out.println("Error: Team cannot exceed 15 players.");
        } else if (!SalaryCap(player.getSalary())) {
            System.out.println("Error: Adding player would exceed salary cap.");
        }
        return false;
    }

    public boolean removePlayer(Player player) {
        if (team.contains(player) && MinPlayers()) {
            team.remove(player);
            numPlayers--;
            totalSalary -= player.getSalary();
            return true;
        } else if (!team.contains(player)) {
            System.out.println("Error: Player not found on roster.");
        } else if (!MinPlayers()) {
            System.out.println("Error: Team cannot have less than 10 players.");
        }
        return false;
    }

    public ArrayList<Player> dynamicSearching(String position, int minHeight, int maxHeight, int minWeight, int maxWeight) {
        ArrayList<Player> matchedPlayers = new ArrayList<>();
        for (Player player : team) {
            if (player.getPosition().equals(position) &&
                    player.getHeight() >= minHeight && player.getHeight() <= maxHeight &&
                    player.getWeight() >= minWeight && player.getWeight() <= maxWeight) {
                matchedPlayers.add(player);
            }
        }
        return matchedPlayers;
    }

    private boolean MaxPlayers() {
        return numPlayers < 15;
    }

    private boolean MinPlayers() {
        return numPlayers > 10;
    }

    private boolean SalaryCap(double salary) {
        return totalSalary + salary <= 20000;
    }

   
}
