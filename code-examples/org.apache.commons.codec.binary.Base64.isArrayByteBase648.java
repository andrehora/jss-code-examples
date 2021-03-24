protected void operateOnChildNode(Content node, InstallContext ctx) throws RepositoryException, TaskExecutionException {
    if (NodeTypes.User.NAME.equals(node.getNodeTypeName())) {
      String encodedPassword = node.getNodeData("pswd").getString();

      if (StringUtils.isNotBlank(encodedPassword)) {
        byte[] pwdBytes;
        try {
          pwdBytes = encodedPassword.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
          String message = node.getName() + " password could not be hashed. User might need to reset the password before logging again.";
          log.warn(message);
          ctx.warn(message);
          pwdBytes = encodedPassword.getBytes();
        }
        if (Base64.isArrayByteBase64(pwdBytes)) {
          String pwd = new String(Base64.decodeBase64(pwdBytes));
          String hashedPwd = SecurityUtil.getBCrypt(pwd);
          node.setNodeData("pswd", hashedPwd);
        }
      }
    } else {
      // AllChildrennodeOp is not recursive!
      for (Content child : node.getChildren(filter)) {
        operateOnChildNode(child, ctx);
      }
    }
  }
}