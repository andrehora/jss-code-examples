public VideoCodecFactory getVideoCodecFactory(){
  final IContext context=scope.getContext();
  ApplicationContext appCtx=context.getApplicationContext();
  if (!appCtx.containsBean(VIDEO_CODEC_FACTORY)) {
    return null;
  }
  return (VideoCodecFactory)appCtx.getBean(VIDEO_CODEC_FACTORY);
}