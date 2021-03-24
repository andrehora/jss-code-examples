public void savezhoubao(String content) {
    if (StringUtils.isNotEmpty(content)) {
        content = StringUtils.trimToNull(content);
    }
    redisTemplate.opsForValue().set("zhoubao", content);
}