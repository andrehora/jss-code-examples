public int update(long id, ReviewStatus reviewStatus, String reviewer, long zkMtime) throws ShepherException {
    if (StringUtils.isBlank(reviewer) || reviewStatus == null) {
        throw ShepherException.createIllegalParameterException();
    }
    try {
        return snapshotMapper.update(id, reviewStatus.getValue(), reviewer, new Date(zkMtime));
    } catch (Exception e) {
        throw ShepherException.createDBUpdateErrorException();
    }
}