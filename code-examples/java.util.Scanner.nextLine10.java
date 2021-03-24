public static ArrayList<String[]> secondList(){

        try{
            Scanner scannerSongs = new Scanner(new File("Recommended_db.csv"));
            ArrayList<String[]> allSongs = new ArrayList<>();
            scannerSongs.nextLine();
            while (scannerSongs.hasNextLine()) {
                String line = scannerSongs.nextLine();
                String[] columns = line.split(",");
                String[] songInfo = {columns[3],columns[4],null};
                allSongs.add(songInfo);
            }
            return allSongs;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }