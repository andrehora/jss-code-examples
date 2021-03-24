protected void registerAndRefresh(String[] args, Class<?>... annotatedClasses) {
    String[] nullSafeArgs = args == null ? EMPTY_ARGS : Stream.of(args).map(arg -> "--" + arg).toArray(String[]::new);

    assertTrue("Context parameters must use '=' to separate name and value: " + Arrays.toString(args),
        Stream.of(nullSafeArgs).allMatch(arg -> arg.indexOf('=') > 0)
    );

    SpringApplication app = new SpringApplication((Object[])annotatedClasses);
    app.setBannerMode(Banner.Mode.OFF);

    ctx = app.run(nullSafeArgs);

    allCtx.add(ctx);
}