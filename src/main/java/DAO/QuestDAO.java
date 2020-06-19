package DAO;

import Model.Quest;
import Exception.*;

import java.util.List;

public interface QuestDAO {
    void insertQuest(Quest quest) throws ConnectionException, ReadException;

    List<Quest> getAllQuests() throws ConnectionException, ReadException;

    void deleteQuest(int id) throws ConnectionException, ReadException;

    Quest getQuestById(int id) throws ConnectionException, ReadException;
}
