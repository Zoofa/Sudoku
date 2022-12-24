public class TestPlayersCSV {

    public static void main(String[] args) {
        PlayersCSV p = new PlayersCSV();
        p.putIntoHashmap();
        p.searchPlayer("Arne", "2100");
        p.writeToFile();
    }
}
