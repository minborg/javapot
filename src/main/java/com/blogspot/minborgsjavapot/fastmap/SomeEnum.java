package com.blogspot.minborgsjavapot.fastmap;

/**
 *
 * @author pemi
 */
public enum SomeEnum {

    ADAM(0, 4), BERT(1, 42), CHARLIE(2, 134), SOME_DUDE(10, 13);

    private SomeEnum(int value, int luckyNumber) {
        this.value = value;
        this.luckyNumber = luckyNumber;
    }

    private final int value;
    private final int luckyNumber;

    private final static IntEnumArrayMap<SomeEnum> valueMap = IntEnumArrayMap.fromEnums(values(), SomeEnum::getValue);
    private final static IntEnumArrayMap<SomeEnum> luckyNumberMap = IntEnumArrayMap.fromEnums(values(), SomeEnum::getLuckyNumber);

    public static SomeEnum findByValue(int value) {
        return valueMap.get(value);
    }

    public static SomeEnum findByLuckyNumber(int value) {
        return luckyNumberMap.get(value);
    }

    public int getValue() {
        return value;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

}
