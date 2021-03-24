public static void init() throws FileNotFoundException, IOException {

        Scanner scanner = new Scanner(file);
        scanner.nextLine(); //Skip the first (Title) line

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("*") || line.split(",").length < 3) { //To prevent reading the same line twice AND prevent reading a corrupted line
                break;
            }
            scores.put(Integer.parseInt(line.split(",")[1]), line.split(",")[0]); //Only looks at the first two columns (name and highscore)
        }

        sortScores();
        //printScores();
    }