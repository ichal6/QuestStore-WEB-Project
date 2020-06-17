package Model;

import java.sql.Date;

public class Quest {
    private int ID;
    private String name;
    private String description;
    private int value;
    private QuestType type;
    private Date dateOfAdding;
    private String pictureUrl;

    public Quest(int ID, String name, String description, int value, int type, Date dateOfAdding, String pictureUrl) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.value = value;
        this.type = QuestType.getTypeByNumber(type);
        this.dateOfAdding = dateOfAdding;
        this.pictureUrl = pictureUrl;
    }

    public Quest(String name, String description, int value, int type, Date dateOfAdding, String pictureUrl) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.type = QuestType.getTypeByNumber(type);
        this.dateOfAdding = dateOfAdding;
        this.pictureUrl = pictureUrl;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public QuestType getType() {
        return type;
    }

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
