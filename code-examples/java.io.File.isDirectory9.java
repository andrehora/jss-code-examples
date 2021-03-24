private List<Song> listSongs(File directory) {
    ArrayList<Song> ret = new ArrayList<>();

    if (!directory.exists()) {
        System.out.println("Directory does not exist: " + directory);
        return ret;
    }

    File[] files = directory.listFiles();
    if (files == null) return ret;

    for (File file : files) {
        if (file.isDirectory()) {
            ret.addAll(listSongs(file));
        } else {
            Song song = tryToReadSong(file);
            if (song == null) continue;
            ret.add(song);
        }
    }
    return ret;
}