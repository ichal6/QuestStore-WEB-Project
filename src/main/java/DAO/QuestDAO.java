package DAO;

import Model.Quest;
import Exception.*;

import java.util.List;

public interface QuestDAO {
    void insertQuest(Quest quest) throws ConnectionException;

    List<Quest> getAllQuests() throws ConnectionException, ReadException;
}
