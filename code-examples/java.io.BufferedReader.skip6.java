private boolean loadRequestsFromFile(int numbersToLoad, long startOffset, int firstID) {

    int id = firstID;
    long offset = startOffset < 0 ? 0 : startOffset;

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(mRequestStoreFile), "UTF-8"));
        reader.skip(offset);
        try {
            String line;
            int ind = 0;
            //set offset for first id
            mIDs.put(id, offset);
            while ((line = reader.readLine()) != null && ind++ < numbersToLoad && mURLCache.get(id) == null) {
                if (mIDs.get(id) == null)
                    WebtrekkLogging.log("File is more then existed keys. Error. Key:" + id + " offset:" + offset);
                //put URL and increment id
                mLoaddedIDs.put(id++, line);
                offset += (line.length() + System.getProperty("line.separator").length());
               //set offset of next id if exists
                if (mIDs.get(id) != null && (mLatestSavedURLID >= id || mLatestSavedURLID == -1) )
                    mIDs.put(id, offset);
            }
        } finally {
            reader.close();
        }

    } catch (Exception e) {
        WebtrekkLogging.log("cannot load backup file '" + mRequestStoreFile.getAbsolutePath() + "'", e);
        return false;
    }

    return true;
}