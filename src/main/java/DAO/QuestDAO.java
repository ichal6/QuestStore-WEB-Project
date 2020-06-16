package DAO;

import Model.Quest;

import java.util.List;

public interface QuestDAO {
    void insertQuest(Quest quest);

    List<Quest> getAllQuests();
}
