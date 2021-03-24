public int onStartCommand(Intent intent, int flags, int startId) {
    if (intent.getBooleanExtra(PAUSE_DOWNLOAD, false)) {
        queue.pause();
        return START_REDELIVER_INTENT;
    }
    VideoDownLoadInfo video = (VideoDownLoadInfo) intent.getSerializableExtra(VIDEOS_INFO);
    EventBus.getDefault().postSticky(video,EventBusTags.CACHE_DOWNLOAD_BEGIN);
    videos.put(video.getId()+"",video);
    File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Sunny_Videos");
    if (!dir.exists()) {
        dir.mkdirs();
    }
    DaoMaster master = GreenDaoHelper.getInstance().create(video.getDbName()).getMaster();
    master.newSession().startAsyncSession().insertOrReplace(video);
    File file = new File(dir.getAbsolutePath(), video.getId() + ".mp4");
    BaseDownloadTask task = (FileDownloader.getImpl().create(video.getVideo().getPlayUrl()).setPath(file.getAbsolutePath()).setTag(video.getId()+""));
    task.setListener(new CommonDownloadListener());
    queue.enqueue(task);
    if (isInit){
        queue.resume();
        isInit = false;
    }
    return START_NOT_STICKY;
}