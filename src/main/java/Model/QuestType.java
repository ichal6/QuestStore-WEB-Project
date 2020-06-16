package Model;

public enum QuestType {
    BASIC(0),
    EXTRA(1);

    private int value;

    QuestType(int value) {
        this.value = value;
    }

    public static QuestType getTypeByNumber(int number) {
        if (number == 0) {
            return QuestType.BASIC;
        } else {
            return QuestType.EXTRA;
        }
    }

    public int getValue() {
        return value;
    }
}
