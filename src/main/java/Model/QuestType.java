package Model;

public enum QuestType {
    BASIC,
    EXTRA;

    public static QuestType getTypeByNumber(int number) {
        if (number == 0) {
            return QuestType.BASIC;
        } else {
            return QuestType.EXTRA;
        }
    }
}
