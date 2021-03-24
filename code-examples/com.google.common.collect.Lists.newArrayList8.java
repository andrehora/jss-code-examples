public ServerResponse getOrderCartProduct(Integer userId) {
    OrderProductVo orderProductVo = new OrderProductVo();

    List<Cart> cartList = cartMapper.selectCheckedCartByUserId(userId);
    ServerResponse serverResponse = this.getCartOrderItem(userId, cartList);

    if (!serverResponse.isSuccess()) {
        return serverResponse;
    }
    List<OrderItem> orderItemList = (List<OrderItem>) serverResponse.getData();

    List<OrderItemVo> orderItemVoList = Lists.newArrayList();

    BigDecimal payment = new BigDecimal("0");
    for (OrderItem orderItem : orderItemList) {
        payment = BigDecimalUtil.add(payment.doubleValue(), orderItem.getTotalPrice().doubleValue());
        orderItemVoList.add(assembleOrderItemVo(orderItem));
    }
    orderProductVo.setProductTotalPrice(payment);
    orderProductVo.setOrderItemVoList(orderItemVoList);
    orderProductVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

    return ServerResponse.createBySuccess(orderProductVo);
}