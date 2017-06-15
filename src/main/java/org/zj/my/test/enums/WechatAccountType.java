package org.zj.my.test.enums;

public enum WechatAccountType implements EnumEntity<Byte> {

    SERVICE(1), ENTERPRISE(2);

    private final Byte value;

    private WechatAccountType(int value) {
        this.value = (byte) value;
    }

    @Override
    public Byte getValue() {
        return value;
    }
}
